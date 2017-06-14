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

@CommandInfo(description = "SP", usage = "<SP>", aliases = { "sps", "sp" }, op=true)
public class sps extends GameCommand{

	private void spawnEntity(Location location, String name, Class someEntity) {
		 LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomName(name);
        entity.setCustomNameVisible(true);
      //  entity.setGravity(false);
        entity.setInvulnerable(true);
    //    ((Object) entity).setSilent(true);
        entity.setVelocity(new Vector(0, 0, 0));
        entity.setAI(false);
        entity.setCollidable(false);


        if (entity instanceof Ageable) {
            Ageable ageable = (Ageable) entity;

            ageable.setAgeLock(true);
        }


        
    }
	@Override
	public void onCommand(Player p, String[] args) {
        Location location = p.getLocation();
 //       spawnEntity(location, ChatColor.GREEN+ "HELP", PigZombie.class);
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomName(ChatColor.GREEN + "SPAWN");
        entity.setCustomNameVisible(true);
       // entity.setGravity(false);
        entity.setInvulnerable(true);
        //entity.setSilent(true);
        entity.setVelocity(new Vector(0, 0, 0));
        entity.setAI(false);
        entity.setCollidable(false);
        p.setCollidable(false);

			return;
		}
	
	
	
	}

