package eu.hangar.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class NoDrops implements Listener{
@EventHandler
public void onItemDrop(PlayerDropItemEvent e){
e.setCancelled(true);
}
}
