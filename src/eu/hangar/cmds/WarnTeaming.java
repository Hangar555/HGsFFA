package eu.hangar.cmds;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import net.md_5.bungee.api.ChatColor;

@CommandInfo(description = "Warn players that are teaming .", usage = "<w>", aliases = { "w", "warn" }, op=false)
public class WarnTeaming extends GameCommand {
	HashMap<String, Integer> Warned = new HashMap<String, Integer>();
@Override
	public void onCommand(Player p, String[] args) {
	 Player t = Bukkit.getPlayer(args[0]);
	if(p.hasPermission("hatrex.ffa.warn")){
		if(args.length==1){
		 if(this.Warned.containsKey(t.getName())){
			 p.sendMessage(ChatColor.GREEN + "Player warned & kicked!");
			 t.kickPlayer(ChatColor.DARK_RED+""+ChatColor.BOLD +"[KICKED] " + ChatColor.RED + "Teaming is not allowed on Free For All!");
			 
		 }else{
			 p.sendMessage(ChatColor.GREEN + "Player warned!");
t.sendMessage(ChatColor.RED +""+ ChatColor.BOLD+ "You've been warned by " +p.getName() + " for teaming");
t.playSound(t.getLocation(), Sound.BLOCK_ANVIL_LAND, 30, 39);
this.Warned.put(t.getName().toString(), 1);
		 }
		}else{p.sendMessage(ChatColor.RED + "Not enough or too much arguments!");
		
		}
	}else{p.sendMessage(ChatColor.RED + "Not enough permissions!");
	
	}
	}
}

