package eu.hangar.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;

@CommandInfo(description = "Spectate for donors .", usage = "<s>", aliases = { "s", "spectate" }, op=false)
public class Spectate extends GameCommand {
	  public static List<String> Spectate = new ArrayList();
@Override
	public void onCommand(Player p, String[] args) {
	if(p.hasPermission("hatrex.ffa.spectate")){
		if(p.getHealth() == 20){
			if(!Spectate.contains(p.getName())){
				p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_TOUCH, 30, 39);
		p.sendMessage(ChatColor.DARK_GREEN+"You're now on Spectator mode!");
		p.setGameMode(GameMode.SPECTATOR);
		Spectate.add(p.getName());
		}else{
			p.setGameMode(GameMode.SURVIVAL);
			Spectate.remove(p.getName());
			p.playSound(p.getLocation(), Sound.BLOCK_WOOD_BREAK, 30, 39);
			p.sendMessage(ChatColor.DARK_GREEN+"Spectator mode disabled!");
			
		}
		}else{
			p.sendMessage(ChatColor.RED + "You're combat tagged. You must have full health to enter this mode!");
		}
	}else{ 
		p.sendMessage(ChatColor.RED +"Only [VIP] can use this command!");
	}

	}
}

