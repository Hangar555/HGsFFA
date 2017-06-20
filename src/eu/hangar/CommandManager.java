package eu.hangar;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import eu.hangar.cmds.AddSpawn;

import eu.hangar.cmds.ForceKits;
import eu.hangar.cmds.Kit;
import eu.hangar.cmds.SD;
import eu.hangar.cmds.SDH;
import eu.hangar.cmds.SH;
import eu.hangar.cmds.SM;
import eu.hangar.cmds.SU;
import eu.hangar.cmds.Spectate;
import eu.hangar.cmds.WarnTeaming;
import eu.hangar.cmds.fr;
import eu.hangar.cmds.sps;






public class CommandManager implements CommandExecutor{
	private ArrayList<GameCommand> cmds;
	
	protected CommandManager(){
		cmds = new ArrayList<>();
		cmds.add(new AddSpawn());
		cmds.add(new Spectate());
		cmds.add(new Kit());
		cmds.add(new ForceKits());
		cmds.add(new SM());
		cmds.add(new SH());
		cmds.add(new SDH());
		cmds.add(new SD());
		cmds.add(new SU());
		cmds.add(new fr());
		cmds.add(new sps());
		cmds.add(new WarnTeaming());






		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.DARK_RED+ "[Error] "+ ChatColor.RED + "You are not a player!");
			return true;
		}
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("ffa")){
			if(args.length==0){
				if(p.hasPermission("ffa.staff")){
				for (GameCommand gcmd : cmds){
					CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);

					p.sendMessage(ChatColor.GOLD + "/ffa"+ ChatColor.GREEN+" Usage: /ffa " + info.usage() +ChatColor.RESET +" - "+ ChatColor.GREEN + "Command Info: " + info.description() );
					}
				}else{p.sendMessage(ChatColor.GREEN + "/ffa "+ChatColor.GOLD+" spectate " +ChatColor.GREEN+"[Spectate your friends! (Only for [" +Main.getInstance().getConfig().getString("Rank")+ "]  and higher)]");
	

				}return true;
			}
			GameCommand wanted = null;
			for (GameCommand gcmd : cmds){
				CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);
				for (String alias : info.aliases()){
					if(alias.equals(args[0])){
						wanted = gcmd;
					}
				}
					
				}
			if (wanted ==  null){
				p.sendMessage(ChatColor.DARK_RED+ "[Error] "+  ChatColor.RED+ "Could not find command!");
				return true;
			};	
			if (wanted.getClass().getAnnotation(CommandInfo.class).op() && !p.isOp()) {
				p.sendMessage(ChatColor.DARK_RED+ "[Error] "+ChatColor.RED + "You don't have permission to use this command.");
				return true;
			}

			ArrayList<String> newArgs = new ArrayList<String>();
			Collections.addAll(newArgs, args);
			newArgs.remove(0);
			args = newArgs.toArray(new String[newArgs.size()]);
			
			wanted.onCommand(p, args);
		}

		return true;
	}

}
