package fr.kinderrkill.sfs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SFSListeners implements Listener {

	private SimpleFirstSpawn sfs = SimpleFirstSpawn.getInstance();

	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(!player.hasPlayedBefore()) {
			SimpleFirstSpawn.getInstance().manager.teleportToSpawn(player);
			if(sfs.getConfig().getBoolean("active_first_join_message")) {
				event.setJoinMessage(null);
				String finalMessage = format(sfs.getConfig().getString("player_first_join_message"));
				if(finalMessage.contains("%player%")) {
					finalMessage = finalMessage.replaceAll("%player%", player.getName());
				}
				for(Player p : Bukkit.getOnlinePlayers()) {
					p.sendMessage(finalMessage);
				}
			}
			if(sfs.getConfig().getBoolean("first_join_sound")) {
				for(Player p : Bukkit.getOnlinePlayers()) {
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
				}
			}
		} else {
			if(sfs.getConfig().getBoolean("active_player_join_message")) {
				event.setJoinMessage(null);
				for(Player p : Bukkit.getOnlinePlayers()) {
					String finalMessage = format(sfs.getConfig().getString("player_join_message"));
					if(finalMessage.contains("%player%")) {
						finalMessage = finalMessage.replaceAll("%player%", player.getName());
					}
					p.sendMessage(finalMessage);
				}
			}
		}
	}

	@EventHandler
	public void playerLeave(PlayerQuitEvent event) {
		if(sfs.getConfig().getBoolean("active_player_quit_message")) {
			event.setQuitMessage(null);
			for(Player p : Bukkit.getOnlinePlayers()) {
				String finalMessage = format(sfs.getConfig().getString("player_quit_message"));
				finalMessage = finalMessage.replaceAll("%player%", event.getPlayer().getName());
				p.sendMessage(finalMessage);
			}
		}
	}

	private String format(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
