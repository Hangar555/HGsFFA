package eu.hangar;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class SpawnMenu implements Listener{
	  SettingsManager settings = SettingsManager.getInstance();
    private Inventory inv;

    public SpawnMenu(Plugin p) {


            inv = Bukkit.getServer().createInventory(null,9, ChatColor.GREEN+"Spawn Selector");
           
            ItemStack t =new ItemStack(Material.DIRT);
            ItemMeta tmeta = t.getItemMeta();
            tmeta.setDisplayName(ChatColor.AQUA + "Spawn 1");
            t.setItemMeta(tmeta);
            
            ItemStack n =new ItemStack(Material.ICE);
            ItemMeta nmeta = n.getItemMeta();
            nmeta.setDisplayName(ChatColor.RED + "Spawn 2");
            n.setItemMeta(nmeta);
            
            ItemStack a =new ItemStack(Material.GLASS);
            ItemMeta ameta = a.getItemMeta();
            ameta.setDisplayName(ChatColor.DARK_PURPLE + "Spawn 3");
            a.setItemMeta(ameta);
            

           
           
            inv.setItem(0, t);
            inv.setItem(1, n);
            inv.setItem(2, a);

           
            Bukkit.getServer().getPluginManager().registerEvents(this, p);
    }
   
   
   
    public void show(Player p) {
            p.openInventory(inv);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	Player p = (Player)e.getWhoClicked();

            if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
            if (e.getCurrentItem().getItemMeta() == null) return;
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spawn 1")) {
                    e.setCancelled(true);
                    
                    Location originalLocation = p.getLocation();
                    
                    Random random = new Random();
                   
                    Location teleportLocation = null;
                   
                    int x = random.nextInt(100) + 1;
                    int y = 150;
                    int z = random.nextInt(100) + 1;
                   
                    boolean isOnLand = false;
                   
                    while (isOnLand == false) {

                            teleportLocation = new Location(p.getWorld(), x, y, z);
                           
                            if (teleportLocation.getBlock().getType() != Material.AIR) {
                                    isOnLand = true;
                            } else y--;
                   
                    }
                   
                    p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
                   
                    p.sendMessage(ChatColor.GREEN + "Teleporting....!");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spawn 2")) {
                    e.setCancelled(true);
                    
                    Location originalLocation = p.getLocation();
                    
                    Random random = new Random();
                   
                    Location teleportLocation = null;
                   
                    int x = random.nextInt(100) + 1;
                    int y = 150;
                    int z = random.nextInt(100) + 1;
                   
                    boolean isOnLand = false;
                   
                    while (isOnLand == false) {

                            teleportLocation = new Location(p.getWorld(), x, y, z);
                           
                            if (teleportLocation.getBlock().getType() != Material.AIR) {
                                    isOnLand = true;
                            } else y--;
                   
                    }
                   
                    p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
                   
                    p.sendMessage(ChatColor.GREEN + "Teleporting....!");
            

            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spawn 3")) {
                    e.setCancelled(true);
                    
                    Location originalLocation = p.getLocation();
                    
                    Random random = new Random();
                   
                    Location teleportLocation = null;
                   
                    int x = random.nextInt(100) + 1;
                    int y = 150;
                    int z = random.nextInt(100) + 1;
                   
                    boolean isOnLand = false;
                   
                    while (isOnLand == false) {

                            teleportLocation = new Location(p.getWorld(), x, y, z);
                           
                            if (teleportLocation.getBlock().getType() != Material.AIR) {
                                    isOnLand = true;
                            } else y--;
                   
                    }
                   
                    p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
                   
                    p.sendMessage(ChatColor.GREEN + "Teleporting....!");
            }

                
 		
            }
	}
