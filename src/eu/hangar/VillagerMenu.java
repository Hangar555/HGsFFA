package eu.hangar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class VillagerMenu implements Listener{
	 public static List<String> KitPlayer = new ArrayList<String>();
    private Inventory inv;

    public VillagerMenu(Plugin p) {


            inv = Bukkit.getServer().createInventory(null, 54, ChatColor.GREEN+"Kit Selector");
           
            ItemStack t =new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta tmeta = t.getItemMeta();
            tmeta.setDisplayName(ChatColor.AQUA + "TANK");
            t.setItemMeta(tmeta);
            
            ItemStack n =new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta nmeta = n.getItemMeta();
            nmeta.setDisplayName(ChatColor.RED + "NINJA");
            n.setItemMeta(nmeta);
            
            ItemStack a =new ItemStack(Material.ARROW);
            ItemMeta ameta = a.getItemMeta();
            ameta.setDisplayName(ChatColor.DARK_PURPLE + "ARCHER");
            a.setItemMeta(ameta);
            
            ItemStack b =new ItemStack(Material.IRON_SWORD);
			  b.addEnchantment(Enchantment.DAMAGE_ALL, 2);
            ItemMeta bmeta = b.getItemMeta();
            bmeta.setDisplayName(ChatColor.GOLD + "BRUTE");
            b.setItemMeta(bmeta);
           
           
            inv.setItem(29, t);
            inv.setItem(33, n);
            inv.setItem(23, b);
            inv.setItem(21, a);
           
            Bukkit.getServer().getPluginManager().registerEvents(this, p);
    }
   
   
   
    public void show(Player p) {
            p.openInventory(inv);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	Player p = (Player)e.getWhoClicked();

            if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
            if (e.getCurrentItem().getItemMeta() == null) return;
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("TANK")) {
                    e.setCancelled(true);
     			   p.getInventory().clear();
    			   p.setGameMode(GameMode.SURVIVAL);
    			//   p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" tank." );
    			   p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET,1));
    			   p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE,1));
    			   p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS,1));
    			   p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS,1));
    			   p.getInventory().addItem(new ItemStack(Material.STONE_AXE));
    			   KitPlayer.add(p.getName());
    			   
                    p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("ARCHER")) {
                    e.setCancelled(true);
         		   p.getInventory().clear();
        		   p.setGameMode(GameMode.SURVIVAL);
        		//   p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" archer." );

        		   p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE,1));
        		   p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS,1));
        		   p.getInventory().setLeggings(new ItemStack(Material.IRON_BOOTS,1));
        		   
        		   p.getInventory().addItem(new ItemStack(Material.IRON_SPADE,1));
        		   p.getInventory().addItem(new ItemStack(Material.BOW,1));
        		   p.getInventory().addItem(new ItemStack(Material.ARROW,64));
        		   p.getInventory().addItem(new ItemStack(Material.ARROW,32));
        		   KitPlayer.add(p.getName());
                    e.getWhoClicked().closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("NINJA")) {
                    e.setCancelled(true);
     			   p.getInventory().clear();
    			   p.setGameMode(GameMode.SURVIVAL);
    			 //  p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" ninja." );
    			   p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET,1));
    			   p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE,1));
    			   p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS,1));
    			   p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS,1));
    			   ItemStack NS = new ItemStack(Material.DIAMOND_SWORD);
    			 // NS.addEnchantment(Enchantment.DAMAGE_ALL, 1);
    			  p.getInventory().addItem(NS);
    			  KitPlayer.add(p.getName());
                   e.getWhoClicked().closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("BRUTE")) {
                e.setCancelled(true);
 			   p.getInventory().clear();
			   p.setGameMode(GameMode.SURVIVAL);
			   
			 //  p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" ninja." );
			   p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET,1));
			   p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE,1));
			   p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS,1));
			   p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS,1));
			   ItemStack NS1 = new ItemStack(Material.IRON_SWORD);
			   KitPlayer.add(p.getName());
			//  NS1.addEnchantment(Enchantment.DAMAGE_ALL, 2);
			  p.getInventory().addItem(NS1);
                e.getWhoClicked().closeInventory();
            }
	}
}
