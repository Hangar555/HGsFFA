package eu.hangar.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import net.minecraft.server.v1_12_R1.NBTTagCompound;

@CommandInfo(description = "SU", usage = "<SU>", aliases = { "SUupgrader", "su" }, op=true)
public class SU extends GameCommand{

	@Override
	public void onCommand(Player p, String[] args) {
        Location location = p.getLocation();
 //       spawnEntity(location, ChatColor.GREEN+ "HELP", PigZombie.class);
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomName(ChatColor.GOLD + "KIT UPGRADER");
        entity.setCustomNameVisible(true);
        entity.setAI(false);
			return;
		}
	
	
	
	}


