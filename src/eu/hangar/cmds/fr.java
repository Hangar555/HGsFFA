package eu.hangar.cmds;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;

@CommandInfo(description = "fr", usage = "<fr>", aliases = { "frandom", "fr" }, op=true)
public class fr extends GameCommand{

	@Override
	public void onCommand(Player p, String[] args) {
	
	
	
	
	Random random = new Random();
	int Chance = random.nextInt(200);
	if(p.hasPermission("ffa.admin")){ 
	if(!p.hasPermission("ffa.forceem")){
	
	if(Chance == 400 || Chance == 200 || Chance == 100 || Chance == 50 || Chance == 25 || Chance == 500) {
	
	 
	p.getInventory().addItem(new ItemStack(Material.EMERALD));
	
	} else {
	   p.sendMessage(ChatColor.RED+"Bad luck! No emerald for you!");
	}
	 }else{
		 
		 p.sendMessage(ChatColor.GREEN + "Good News! You got an emerald!");
		 p.getInventory().addItem(new ItemStack(Material.EMERALD)); 
	 }
	 
}else{
	p.sendMessage(ChatColor.DARK_RED + "[ERROR]" + ChatColor.RED + " Not enough permissions!");
}
}
}