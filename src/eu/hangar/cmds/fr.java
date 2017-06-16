package eu.hangar.cmds;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import eu.hangar.VillagerMenu;

@CommandInfo(description = "fr", usage = "<fr>", aliases = { "frandom", "fr" }, op=true)
public class fr extends GameCommand{

	@Override
	public void onCommand(Player p, String[] args) {
	
	
	
	
    	Random random = new Random();
    	int Chance = random.nextInt(100);
    	 
    
    	     if(p.hasPermission("ffa.admin"))  {
    	    	 
    	     
    	if(Chance > 55) {
    	
    	 
    	p.getInventory().addItem(new ItemStack(Material.EMERALD));
    	}else{
    		p.sendMessage("Nothing!");
    	}
	 
}else{
	p.sendMessage(ChatColor.DARK_RED + "[ERROR]" + ChatColor.RED + " Not enough permissions!");
}
}
}
	 
}else{
	p.sendMessage(ChatColor.DARK_RED + "[ERROR]" + ChatColor.RED + " Not enough permissions!");
}
}
}
