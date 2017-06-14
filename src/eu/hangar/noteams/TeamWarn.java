package eu.hangar.noteams;



import org.bukkit.WorldBorder;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_9_R2.EntityPlayer;
import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_9_R2.PlayerConnection;


public class TeamWarn implements Listener {
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerJoinEvent e){
		Player p=e.getPlayer();
		PacketPlayOutTitle NoTeam = new PacketPlayOutTitle(EnumTitleAction.TITLE,
          		ChatSerializer.a("{\"text\":\"TEAMING IS NOT ALLOWED!\",\"color\":\"red\",\"bold\":true}"), 20,40 ,30);
     	 PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
     	 connection.sendPacket(NoTeam);
     	
	}

}


