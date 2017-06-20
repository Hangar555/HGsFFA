package eu.hangar.cmds;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.util.Vector;

import eu.hangar.CommandInfo;
import eu.hangar.GameCommand;
import net.minecraft.server.v1_12_R1.NBTTagCompound;


@CommandInfo(description = "SM", usage = "<SM>", aliases = { "sm", "smon" }, op=true)
public class SM extends GameCommand{



	@Override
	public void onCommand(Player p, String[] args) {
        Location location = p.getLocation();
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomName(ChatColor.GREEN+ "KITS");
        entity.setCustomNameVisible(true);
        entity.setAI(false);
			return;
		}
	
	
	}

