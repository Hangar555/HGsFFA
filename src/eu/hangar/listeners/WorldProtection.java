package eu.hangar.listeners;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class WorldProtection implements Listener {
	

	
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		if(!event.getPlayer().hasPermission("ffa.admin")){

			event.setCancelled(true);

		}
		event.setCancelled(false);
		}
		
		}
	




	