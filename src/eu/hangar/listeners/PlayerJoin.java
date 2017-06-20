package eu.hangar.listeners;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.hangar.Main;
import eu.hangar.Utils;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setHealth(0);
           e.setJoinMessage(null);
           e.getPlayer().setCollidable(false);
           try {
               HttpURLConnection c = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
               c.setDoOutput(true);
               c.setRequestMethod("POST");
               c.getOutputStream().write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=42425").getBytes("UTF-8"));
               String oldVersion = Main.getInstance().getDescription().getVersion();
               String newVersion = new BufferedReader(new InputStreamReader(c.getInputStream())).readLine().replaceAll("[a-zA-Z ]", "");
               if(!newVersion.equals(oldVersion)) {
            	   if(e.getPlayer().hasPermission("ffa.admin")){
                 e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "****"+ ChatColor.GREEN + "HGFFA has been updated! Download the latest version" + ChatColor.DARK_GREEN + "****");
                 e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "****"+ ChatColor.GREEN + "Resource link: https://tinyurl.com/HGupdate" + ChatColor.DARK_GREEN + "****");
                
               }
               }
           } catch (Exception ex) {
                	e.getPlayer().sendMessage(ChatColor.DARK_RED + "[FATAL] " + ChatColor.RED  + "Couldn't check for updates!"); 
                 }
               
           

        }
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
           e.setQuitMessage(null);
	}
	
}

