package eu.hangar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import eu.hangar.Main;
import net.md_5.bungee.api.ChatColor;



public class Scoreboards implements Listener {
	private Scoreboard pb;

	   public Scoreboard getScoreboard(){
	     return this.pb;
	   }
	   
	   @EventHandler
	   public void onJoin(PlayerJoinEvent event){
	     Player p = event.getPlayer();

	     p.setScoreboard(setupScoreboard());
	   
	     
	   }
	  public Scoreboard setupScoreboard(){

	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard pb = manager.getNewScoreboard();
	     String blank2 = " ";
	     String blank3 = "  ";
	     String blank4= "    ";
	     String blank5= "      ";
	     String blank6= "       ";
	     String onenine= ChatColor.GREEN + ""+ChatColor.BOLD + "Playing on 1.9 PVP";
	     String FFA= ChatColor.RESET + ""+ChatColor.BOLD + "SERVER: " + ChatColor.RESET+""+ChatColor.YELLOW + " FFA";
	     String t1= ChatColor.RESET + ""+ChatColor.BOLD + "TEAMING:";
	     String t2= ChatColor.RED + ""+ChatColor.BOLD + "NOT ALLOWED";
	     String ip = ChatColor.YELLOW +""+ChatColor.BOLD + "Placeholder";

	     Objective objective = pb.registerNewObjective("dummy", "title");
	     objective.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD +  "Placeholder");
	     
	     
	     
	     Score blanktd6 = objective.getScore(blank6);
	     blanktd6.setScore(10);
	     Score FFAT = objective.getScore(FFA);
		    FFAT.setScore(9);

	     Score blanktd = objective.getScore(blank4);
	     blanktd.setScore(7);
	     Score blanktd2 = objective.getScore(blank3);
	     blanktd2.setScore(4);
	     Score blanktd3 = objective.getScore(blank2);
	     blanktd3.setScore(2);
	     Score td1 = objective.getScore(t1);
		    td1.setScore(6);
	     Score td2 = objective.getScore(t2);
		    td2.setScore(5);
	     Score one = objective.getScore(onenine);
		    one.setScore(3);

	    Score ipd = objective.getScore(ip);
	   ipd.setScore(1);

	     objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	     return pb;
	     
	
	     }
	   }

