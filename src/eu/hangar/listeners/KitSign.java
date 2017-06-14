package eu.hangar.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import eu.hangar.Utils;



public class KitSign implements Listener{
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e){
	Player p = e.getPlayer();
	if(e.getClickedBlock().getType() == Material.SIGN ||e.getClickedBlock().getType() == Material.WALL_SIGN){
	Block sign = e.getClickedBlock();
	Sign s = (Sign)sign.getState();
	if(s.getLine(0).equalsIgnoreCase("[Kit]")){
		if(Utils.kits.contains(s.getLine(1))){
			s.getLine(1).replace(s.getLine(1), ChatColor.GOLD + "KIT");
			Utils.kitPlayer(p, s.getLine(1));
			p.sendMessage(ChatColor.GRAY + "Playing with the kit:  "+ ChatColor.GOLD+ s.getLine(1));

			return;
		}
		p.sendMessage(ChatColor.DARK_RED + "[ERROR]" + ChatColor.RED + " The kit defined on the sign is inexistant!");

	}
	}
	
	}

}
