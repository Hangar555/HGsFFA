package eu.hangar.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import eu.hangar.Main;
import eu.hangar.SettingsManager;

@CommandInfo(description = "Add the AddSubSpawn .", usage = "<asus>", aliases = { "addsubspawn", "asus" }, op=true)
public class AddSubSpawn extends GameCommand {
	  SettingsManager settings = SettingsManager.getInstance();
	@Override
	public void onCommand(Player p, String[] args) {
		if (args.length == 2) {
			if(args[1].equals("1")) {
				
			
			World world = p.getWorld();
			Location loc = p.getLocation();

		    this.settings.getData().set("Spawn1.world", p.getLocation().getWorld().getName());
		    this.settings.getData().set("Spawn1.x", Double.valueOf(p.getLocation().getX()));
		    this.settings.getData().set("Spawn1.y", Double.valueOf(p.getLocation().getY()));
		    this.settings.getData().set("Spawn1.z", Double.valueOf(p.getLocation().getZ()));
		    this.settings.saveData();
			
			p.sendMessage(ChatColor.GREEN + "Spawn 1 was set in:" );
			p.sendMessage(ChatColor.GREEN +""+ loc.getBlockX());
			p.sendMessage(ChatColor.GREEN +""+ loc.getBlockY());
			p.sendMessage(ChatColor.GREEN +""+ loc.getBlockZ());
		
			
			}
		
			else	if(args[0].equals("2")) {
		Location loc = p.getLocation();

	    this.settings.getData().set("Spawn2.world", p.getLocation().getWorld().getName());
	    this.settings.getData().set("Spawn2.x", Double.valueOf(p.getLocation().getX()));
	    this.settings.getData().set("Spawn2.y", Double.valueOf(p.getLocation().getY()));
	    this.settings.getData().set("Spawn2.z", Double.valueOf(p.getLocation().getZ()));
	    this.settings.saveData();
		
		p.sendMessage(ChatColor.GREEN + "Spawn 2 was set in:" );
		p.sendMessage(ChatColor.GREEN +""+ loc.getBlockX());
		p.sendMessage(ChatColor.GREEN +""+ loc.getBlockY());
		p.sendMessage(ChatColor.GREEN +""+ loc.getBlockZ());
	}
			else	if(args[0].equals("3")) {
		Location loc = p.getLocation();

	    this.settings.getData().set("Spawn3.world", p.getLocation().getWorld().getName());
	    this.settings.getData().set("Spawn3.x", Double.valueOf(p.getLocation().getX()));
	    this.settings.getData().set("Spawn3.y", Double.valueOf(p.getLocation().getY()));
	    this.settings.getData().set("Spawn3.z", Double.valueOf(p.getLocation().getZ()));
	    this.settings.saveData();
		
		p.sendMessage(ChatColor.GREEN + "Spawn 3 was set in:" );
		p.sendMessage(ChatColor.GREEN +""+ loc.getBlockX());
		p.sendMessage(ChatColor.GREEN +""+ loc.getBlockY());
		p.sendMessage(ChatColor.GREEN +""+ loc.getBlockZ());
	}
		}
}
}