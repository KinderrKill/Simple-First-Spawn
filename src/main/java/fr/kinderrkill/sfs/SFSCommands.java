package fr.kinderrkill.sfs;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SFSCommands implements CommandExecutor {

	private SimpleFirstSpawn sfs = SimpleFirstSpawn.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		/** COMMAND : /sfs define || Need permission 'sfs.define' **/
		if(sender instanceof Player && sender.hasPermission("sfs.define")) {
			if(args[0].equalsIgnoreCase("define")) {
				Player player = (Player)sender;
				SimpleFirstSpawn.getInstance().manager.defineSpawn(player);
				player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
				return sendMessage(sender, format(sfs.getConfig().getString("command_define")), true);
			}
			return sendMessage(sender, format(sfs.getConfig().getString("command_echec")), true);
		}
		return true;
	}

	private boolean sendMessage(CommandSender sender, String msg, boolean ret) {
		sender.sendMessage(msg);
		return ret;
	}
	
	private String format(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
