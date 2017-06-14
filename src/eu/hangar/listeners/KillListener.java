package eu.hangar.listeners;



import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import eu.hangar.VillagerMenu;




public class KillListener implements Listener{
	
	HashMap<UUID, Integer> deathsMap = new HashMap<UUID, Integer>();
	

        
       
        @EventHandler
        
        public void onPlayerDeath(PlayerDeathEvent event) {
        	
        	Random random = new Random();
        	int Chance = random.nextInt(200);
        	 
        	if(event.getEntity().getPlayer().getKiller() != null){ 
        	event.setDeathMessage(ChatColor.GOLD + ""+ event.getEntity().getPlayer().getKiller().getName() + " killed " + event.getEntity().getPlayer().getName() + "!");
        	event.getEntity().getKiller().sendMessage(ChatColor.GREEN + "+1 Kill!");
        	VillagerMenu.KitPlayer.remove(event.getEntity().getPlayer());
      
        	
        	        
        	event.getDrops().clear();
        	if(Chance >= 300) {
        	
        	 
        	event.getEntity().getPlayer().getKiller().getInventory().addItem(new ItemStack(Material.EMERALD));
        	} else {
        	    event.getEntity().getPlayer().sendMessage(ChatColor.RED+"Bad luck!");
        	}
        	 
        	 
        	 
               
        	
            	}else{
            		
            		event.setDeathMessage(ChatColor.GOLD  + event.getEntity().getPlayer().getName().toLowerCase() + " decided to kill himself!");

            		event.getDrops().clear();
            		 
                 	}
            	
        }
        }


        
