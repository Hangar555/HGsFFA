package eu.hangar;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;



public class CommandGUI implements Listener{

    private Inventory inv;

    public CommandGUI(Plugin p) {


            inv = Bukkit.getServer().createInventory(null, 9, ChatColor.GREEN+"NPC Spawner");
           
            ItemStack t =new ItemStack(Material.NAME_TAG);
            ItemMeta tmeta = t.getItemMeta();
            tmeta.setDisplayName(ChatColor.AQUA + "Help");
            t.setItemMeta(tmeta);
            
            ItemStack n =new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta nmeta = n.getItemMeta();
            nmeta.setDisplayName(ChatColor.AQUA + "Kits");
            n.setItemMeta(nmeta);
            
            ItemStack a =new ItemStack(Material.ARROW);
            ItemMeta ameta = a.getItemMeta();
            ameta.setDisplayName(ChatColor.DARK_PURPLE + "Spawn NPC");
            a.setItemMeta(ameta);
            
            ItemStack b =new ItemStack(Material.IRON_SWORD);
			  b.addEnchantment(Enchantment.DAMAGE_ALL, 2);
            ItemMeta bmeta = b.getItemMeta();
            bmeta.setDisplayName(ChatColor.GOLD + "Kit Upgrader");
            b.setItemMeta(bmeta);
           
           
            inv.setItem(0, t);
            inv.setItem(1, n);
            inv.setItem(2, b);
            inv.setItem(3, a);
           
            Bukkit.getServer().getPluginManager().registerEvents(this, p);
    }
   
   
   
    public void show(Player p1) {
            p1.openInventory(inv);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	Player p = (Player)e.getWhoClicked();
    	 if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Help")) {
            p.performCommand("ffa sh");
            e.getWhoClicked().closeInventory();
    
    	 }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Kits")) {
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
         		 
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spawn NPC")) {
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
     			  
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Kit Upgrader")) {
                e.setCancelled(true);
 			  
                e.getWhoClicked().closeInventory();
            }
	}
}
