package eu.hangar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Utils {

		   public static World world = Bukkit.getWorld("world");
		   public static Location spawn =  new Location(Bukkit.getWorld("world"),7,66,-17);
		   
		   
		   
		   public static List<String> kits = new ArrayList<String>();

		   public static void kitPlayer(Player p, String kit) {
			   if(kit.equals("tank")){
			   p.getInventory().clear();
			   p.setGameMode(GameMode.SURVIVAL);
			//   p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" tank." );
			   p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET,1));
			   p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE,1));
			   p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS,1));
			   p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS,1));
			   p.getInventory().addItem(new ItemStack(Material.STONE_AXE));
			   
			   
		}
		   if(kit.equals("archer")){
		   p.getInventory().clear();
		   p.setGameMode(GameMode.SURVIVAL);
		//   p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" archer." );
		   p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET,1));
		   p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE,1));
		   p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS,1));
		   p.getInventory().addItem(new ItemStack(Material.IRON_SPADE,1));
		   p.getInventory().addItem(new ItemStack(Material.BOW,1));
		   p.getInventory().addItem(new ItemStack(Material.ARROW,64));
		   p.getInventory().addItem(new ItemStack(Material.ARROW,32));
		   }
		   if(kit.equals("ninja")){
			   p.getInventory().clear();
			   p.setGameMode(GameMode.SURVIVAL);
			 //  p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" ninja." );
			   p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET,1));
			   p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE,1));
			   p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS,1));
			   p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS,1));
			   ItemStack NS = new ItemStack(Material.DIAMOND_SWORD);
			  NS.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			  p.getInventory().addItem(NS);
		   }
		   if(kit.equals("brute")){
			   p.getInventory().clear();
		   p.setGameMode(GameMode.SURVIVAL);
		   
		 //  p.sendMessage(ChatColor.GRAY +"You're playing with " + ChatColor.GOLD+" ninja." );
		   p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET,1));
		   p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE,1));
		   p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS,1));
		   p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS,1));
		   ItemStack NS1 = new ItemStack(Material.IRON_SWORD);
		  NS1.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		  p.getInventory().addItem(NS1);
		   }
}


	public static boolean isCloseToSpawn(Location loc){
	return isCloseToSpawn(loc, 25);	
	}
	public static boolean isCloseToSpawn(Location loc, int radious){
		if(loc == null){
			return false;
		}
		int x= Math.abs(loc.getBlockX() - spawn.getBlockX());
		int z= Math.abs(loc.getBlockZ() - spawn.getBlockZ());
		
		
		return (x<radious ) && (z<radious);
	}
}

