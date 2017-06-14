package eu.hangar.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHunger implements Listener{
	
	  
	  @EventHandler
	  public void foodChangeEvent(FoodLevelChangeEvent event)
	  {
	    if (event.getEntityType() == EntityType.PLAYER)
	    {
	      Player player = (Player)event.getEntity();
	   
	          event.setCancelled(true);
	          if (player.getFoodLevel() < 19.0D) {
	            player.setFoodLevel(20);
	          }  
          }
	  }
}