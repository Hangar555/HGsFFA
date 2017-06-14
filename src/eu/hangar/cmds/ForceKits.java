package eu.hangar.cmds;


import org.bukkit.entity.Player;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import eu.hangar.Utils;
import net.md_5.bungee.api.ChatColor;

@CommandInfo(description = "Force Kits.", usage = "<fkit>", aliases = { "fkit", "fki" }, op=true)
public class ForceKits extends GameCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		
			  
			   p.sendMessage(ChatColor.GREEN + "Done!");
			   Utils.kits.add("tank");
			   Utils.kits.add("archer");
			//   kits.add("magician");
			   Utils.kits.add("ninja");
			   Utils.kits.add("brute");
		   
		
	}
	
}

