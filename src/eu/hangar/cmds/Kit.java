package eu.hangar.cmds;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import eu.hangar.Utils;

@CommandInfo(description = "Kit.", usage = "<kit>", aliases = { "kit", "k" }, op=true)
public class Kit extends GameCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		if(args.length==1){
			if(Utils.kits.contains(args[0].toLowerCase())){
			Utils.kitPlayer(p, args[0]);
			return;
		}
		p.sendMessage(ChatColor.GRAY + "The kit " + ChatColor.GOLD +args[0] +ChatColor.GRAY+ " doesn't exist!");
		
	}
	}
}
