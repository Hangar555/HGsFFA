package eu.hangar.listeners;

import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

import eu.hangar.Utils;
import net.md_5.bungee.api.ChatColor;

public class SpawnProtectListener implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){

			Player p =(Player)e.getEntity();
			if(Utils.isCloseToSpawn(p.getLocation())){
				e.setCancelled(true);
				return;
				
			}else{
				e.setCancelled(false);
			}
		}
	
	@EventHandler
	public void BowShoot(EntityShootBowEvent e){
		if(e.getEntity() instanceof Player){
			Player s = (Player)e.getEntity();
			if(Utils.isCloseToSpawn(s.getLocation())){
				e.setCancelled(true);

			}else{		
				e.setCancelled(false);
		}
		}
	}
	@EventHandler
	public void onVDamage(EntityDamageByEntityEvent e){

			Villager v =(Villager)e.getEntity();
			if(Utils.isCloseToSpawn(v.getLocation())){
				e.setCancelled(true);
				return;
				
			}else{
				e.setCancelled(true);
			}
		}
	@EventHandler
	public void onZDamage(EntityDamageByEntityEvent e){

			PigZombie Z =(PigZombie)e.getEntity();
			if(Utils.isCloseToSpawn(Z.getLocation())){
				e.setCancelled(true);
				return;
				
			}else{
				e.setCancelled(true);
			}
		}

}
