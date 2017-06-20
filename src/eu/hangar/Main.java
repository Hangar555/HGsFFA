package eu.hangar;

import java.io.File;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import eu.hangar.listeners.KillListener;
import eu.hangar.listeners.KitSign;
import eu.hangar.listeners.NoDrops;
import eu.hangar.listeners.NoHunger;
import eu.hangar.listeners.PlayerJoin;
import eu.hangar.listeners.Scoreboards;
import eu.hangar.listeners.SpawnProtectListener;
import eu.hangar.listeners.WeatherManager;
import eu.hangar.listeners.WorldProtection;

import eu.hangar.noteams.TeamWarn;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_12_R1.PlayerConnection;






public class Main extends JavaPlugin implements Listener {

	public  Main pl;
	
   public  Main getPL(){
	   return pl;
   }
	

    private VillagerMenu menu;
    @SuppressWarnings("unused")
	private SpawnMenu menu1;
    private static Main instance;
	private static WorldProtection WorldProtection;
	 public static World world = Bukkit.getWorld("world");
     ItemStack b =new ItemStack(Material.IRON_SWORD);
     ItemStack a =new ItemStack(Material.DIAMOND_SWORD);    
     ItemStack c =new ItemStack(Material.STONE_AXE);
	public void onEnable(){
	
getCommand("FFA").setExecutor(new CommandManager());
menu = new VillagerMenu(this);
menu1 = new SpawnMenu(this);
		
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new WorldProtection(), this) ;	
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new KillListener(), this);
		pm.registerEvents(new SpawnProtectListener(), this);
		pm.registerEvents(new NoDrops(), this);
		pm.registerEvents(new KitSign(), this);
		pm.registerEvents(new Scoreboards(), this);
		pm.registerEvents(new TeamWarn(), this);
		pm.registerEvents(new NoHunger(), this);
		pm.registerEvents(new WeatherManager(), this);
		   pl = this;
		   instance = pl;
		  
		   SettingsManager.instance.setup(pl);

		//pm.registerEvents(new VillagerMenu(), this);
	        for(Player player : Bukkit.getWorld("world").getPlayers() ){
	            player.setCollidable(false);

	        }
		   Utils.kits.add("tank");
		   Utils.kits.add("archer");
		//   kits.add("magician");
		   Utils.kits.add("ninja");
		   Utils.kits.add("brute");
		   
	        try {
	            if (!getDataFolder().exists()) {
	                getDataFolder().mkdirs();
	            }
	            File file = new File(getDataFolder(), "config.yml");
	            if (!file.exists()) {
	                getLogger().info("Config.yml wasn't found :(");
	                getLogger().info("Now worries, creating it!");
	                saveDefaultConfig();
	            } else {
	                getLogger().info("Good news! The mouse searching config.yml found it! :)!");
	            }
	        } catch (Exception e) {
                getLogger().info("Ouch, something went wrong!");
	            e.printStackTrace();
                getLogger().info("#BlameHangar");

	        }
	}

/*

	   private void createConfig() {
	        try {
	            if (!getDataFolder().exists()) {
	                getDataFolder().mkdirs();
	            }
	            File file = new File(getDataFolder(), "config.yml");
	            if (!file.exists()) {
	                getLogger().info("Config.yml wasn't found :(");
	                getLogger().info("Now worries, creating it!");
	                saveDefaultConfig();
	            } else {
	                getLogger().info("Good news! The mouse searching config.yml found it! :)!");
	            }
	        } catch (Exception e) {
                getLogger().info("Ouch, something went wrong!");
	            e.printStackTrace();
                getLogger().info("#BlameHangar");

	        }

	    }
*/
	public static Plugin getPlugin(){
		return Bukkit.getServer().getPluginManager().getPlugin("FFA");
	}
	public static WorldProtection getWorldPRotection(){
		return WorldProtection;
	}  

	@EventHandler
	public void entityCollideEvent(PlayerItemDamageEvent e) {
		
	 e.setCancelled(true);
	    	}
	    
	
	
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		
	    Entity v = (Entity) e.getRightClicked();
      //  e.setCancelled(true);

	    	if(v.getCustomName().equals(ChatColor.GREEN+"KITS")) {
                menu.show(e.getPlayer());
	    	}//	v.setCustomName( "KITS");
	    }
	@EventHandler
	public void onPlayerInteractEntity7(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
	    Entity v = (Entity) e.getRightClicked();
      //  e.setCancelled(true);

	   	if(v.getCustomName().equals(ChatColor.GREEN + "SPAWN")) {
	    	//	menu1.show(e.getPlayer());
	    
	    
	    
	    	   Location originalLocation = p.getLocation();
	    	   if(VillagerMenu.KitPlayer.contains(p.getName())){ 
               Random random = new Random();
              
               Location teleportLocation = null;
              
               int x = random.nextInt(100) + 1;
               int y = 150;
               int z = random.nextInt(100) + 1;
              
               boolean isOnLand = false;
              
               while (isOnLand == false) {

                       teleportLocation = new Location(p.getWorld(), x, y, z);
                      
                       if (teleportLocation.getBlock().getType() != Material.AIR) {
                               isOnLand = true;
                       } else y--;
              
               }
              
               p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
              
               p.sendMessage(ChatColor.GREEN + "Teleporting....!");
       
	    }else{
	    	p.sendMessage(ChatColor.RED + "You haven't selected a kit!");
	    	 p.teleport(new Location(p.getWorld(), originalLocation.getX(), originalLocation.getY() + 1, originalLocation.getZ()));
	    }
	   	}
	    	}//	v.setCustomName( "KITS");
	    
	@EventHandler
	public void onPlayerInteractEntity1(PlayerInteractEntityEvent e) {
		
	    Entity v = (Entity) e.getRightClicked();
      //  e.setCancelled(true);
	    

	    	if(v.getCustomName().equals(ChatColor.GREEN+"DUELS")) {
                e.getPlayer().sendMessage(ChatColor.GOLD + "Coming Soon! Stay Tuned!");
	    	}//	v.setCustomName( "KITS");
	    }
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEntity2(PlayerInteractEntityEvent e) {
		
		Player p = e.getPlayer();
	    Entity v = (Entity) e.getRightClicked();
      //  e.setCancelled(true);

	    	if(v.getCustomName().equals(ChatColor.GOLD+"KIT UPGRADER")) {
	    		
	    		 if(VillagerMenu.KitPlayer.contains(p.getName())){
	    			 
                if((e.getPlayer().getItemInHand().equals(c)) ||(e.getPlayer().getItemInHand().equals(a))||(e.getPlayer().getItemInHand().equals(b)) ){
                	 if(p.getInventory().contains(Material.EMERALD)){
                		 p.getInventory().remove(Material.EMERALD);
                		 if((e.getPlayer().getItemInHand().equals(c))){
                   			p.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
                  			p.getInventory().addItem(c);
                  			
                		 }else                 		 if((e.getPlayer().getItemInHand().equals(a))){
                   			p.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
                		 
                 			
                		 }else                 		if((e.getPlayer().getItemInHand().equals(b))){
                  			p.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
                		 
                	 }
                }else{p.sendMessage(ChatColor.RED + "You don't have an emerald! ");
                
                }
                }else{
                p.sendMessage(ChatColor.RED + "You don't have the proper item in your hand! ");
                }
	    		 }else{
	    			 p.sendMessage(ChatColor.RED + "You haven't selected a kit! ");
	    		 }
	    	}//	v.setCustomName( "KITS");
	    }
	public static Main getInstance() {
		return instance;

	}

    	
    	
	@EventHandler
	public void onPlayerInteractWHEntity1(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
	    Entity v = (Entity)e.getRightClicked();
        e.setCancelled(true);

    	if(v.getCustomName().equals(ChatColor.GREEN+"DUELS HELP")) {
    		
    		
                    	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                      	PacketPlayOutTitle HF1 = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      			
                          		ChatSerializer.a("{\"text\":\"DUEL PLAYERS!!\",\"color\":\"gold\",\"bold\":true}"), 20,40 ,30);
                    //  	p.sendMessage(ChatColor.GOLD +""+ChatColor.BOLD+ "Surive!");
                     	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                     	 connection.sendPacket(HF1);
                     	 
	//
             
           
	    //	}
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                	PacketPlayOutTitle Hf3 = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      		ChatSerializer.a("{\"text\":\"Kill Them!\",\"color\":\"gold\",\"bold\":true}"), 20,40 ,30);
                 	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                 	 connection.sendPacket(Hf3);
               //  	 p.sendMessage(ChatColor.GOLD +""+ChatColor.BOLD+ "Kill Players!");
                }
            }, 35); //7seconds           
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                	PacketPlayOutTitle NoTeam = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      		ChatSerializer.a("{\"text\":\"Don't get killed!\",\"color\":\"gold\",\"bold\":true}"), 20,40 ,30);
                 	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                 	 connection.sendPacket(NoTeam);
                //  	p.sendMessage(ChatColor.RED +""+ChatColor.BOLD+ "Teaming is not allowed!");
                }
            }, 70); //10,5 seconds
           
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                	PacketPlayOutTitle HF = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      		ChatSerializer.a("{\"text\":\"Have Fun!\",\"color\":\"green\",\"bold\":true}"), 20,40 ,30);
                	PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                 	 connection.sendPacket(HF);
                // 	 p.sendMessage(ChatColor.GREEN +""+ChatColor.BOLD+ "Have fun!");
                }
            }, 105); //14 seconds
    	}
	}

	@EventHandler
	public void onPlayerInteractWHEntity(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
	    Entity v = (Entity)e.getRightClicked();
        e.setCancelled(true);
/*
	    	if(v.getCustomName().equals(ChatColor.GREEN+"HELP")) {
            	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
            	PacketPlayOutTitle HF2 = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                  		ChatSerializer.a("{\"text\":\"Your objectives in FFA:\",\"color\":\"gold\",\"bold\":false}"), 20,40 ,30);
             	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
             	 connection.sendPacket(HF2);
             	p.sendMessage(ChatColor.GOLD + "Your objectives in FFA: ");

*/
             //   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
               //     @Override
                  //  public void run() {
    	if(v.getCustomName().equals(ChatColor.GREEN+"HELP")) {
    		
    		
                    	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                      	PacketPlayOutTitle HF1 = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      			
                          		ChatSerializer.a("{\"text\":\"Survive!\",\"color\":\"gold\",\"bold\":true}"), 20,40 ,30);
                    //  	p.sendMessage(ChatColor.GOLD +""+ChatColor.BOLD+ "Surive!");
                     	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                     	 connection.sendPacket(HF1);
                     	 
	//
             
           
	    //	}
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                	PacketPlayOutTitle Hf3 = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      		ChatSerializer.a("{\"text\":\"Kill Players!\",\"color\":\"gold\",\"bold\":true}"), 20,40 ,30);
                 	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                 	 connection.sendPacket(Hf3);
               //  	 p.sendMessage(ChatColor.GOLD +""+ChatColor.BOLD+ "Kill Players!");
                }
            }, 35); //7seconds
           
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                	PacketPlayOutTitle NoTeam = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      		ChatSerializer.a("{\"text\":\"Teaming is not allowed!\",\"color\":\"red\",\"bold\":true}"), 20,40 ,30);
                 	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                 	 connection.sendPacket(NoTeam);
                //  	p.sendMessage(ChatColor.RED +""+ChatColor.BOLD+ "Teaming is not allowed!");
                }
            }, 70); //10,5 seconds
           
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                	PacketPlayOutTitle HF = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                      		ChatSerializer.a("{\"text\":\"Have Fun!\",\"color\":\"green\",\"bold\":true}"), 20,40 ,30);
                	PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                 	 connection.sendPacket(HF);
                // 	 p.sendMessage(ChatColor.GREEN +""+ChatColor.BOLD+ "Have fun!");
                }
            }, 105); //14 seconds
           
	 }
	}
	}




	


	
	

		
	




