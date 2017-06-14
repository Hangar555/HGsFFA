package eu.hangar.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;



@CommandInfo(description = "Add the main spawn .", usage = "<as>", aliases = { "addspawn", "as" }, op=true)
public class AddSpawn extends GameCommand {

	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length == 0) {


			World world = p.getWorld();
			Location loc = p.getLocation();
			world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
			
			p.sendMessage(ChatColor.GREEN + "Main spawn for this sub-server was set in " );
			p.sendMessage(ChatColor.GREEN +""+ loc.getBlockX());
			p.sendMessage(ChatColor.GREEN +""+ loc.getBlockY());
			p.sendMessage(ChatColor.GREEN +""+ loc.getBlockZ());
		/*	p.getStatistic (Statistic.PLAYER_KILLS);
			p.sendMessage(ChatColor.GREEN +""+ Statistic.PLAYER_KILLS);
			p.getStatistic (Statistic.DEATHS);
			p.sendMessage(ChatColor.GREEN +""+ Statistic.DEATHS);
			*/
		}
	}
}