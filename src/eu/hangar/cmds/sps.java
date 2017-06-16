package eu.hangar.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import net.minecraft.server.v1_9_R2.NBTTagCompound;

@CommandInfo(description = "SP", usage = "<SP>", aliases = { "sps", "sp" }, op=true)
public class sps extends GameCommand{


	@Override
	public void onCommand(Player p, String[] args) {
        Location location = p.getLocation();
 //       spawnEntity(location, ChatColor.GREEN+ "HELP", PigZombie.class);
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomName(ChatColor.GREEN + "SPAWN");
        entity.setCustomNameVisible(true);
        NBTTagCompound tag = new NBTTagCompound();
        ((NBTTagCompound) entity).c();
        tag.setInt("NoAI", 1);
        ((NBTTagCompound) entity).a(tag);

			return;
		}
	
	
	
	}

