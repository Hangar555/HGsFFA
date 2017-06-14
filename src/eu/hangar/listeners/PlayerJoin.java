package eu.hangar.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.hangar.Utils;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setHealth(0);
           e.setJoinMessage(null);
           e.getPlayer().setCollidable(false);
           

        }
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
           e.setQuitMessage(null);
	}
	
}

