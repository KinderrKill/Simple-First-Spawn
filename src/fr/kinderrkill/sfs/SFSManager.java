package fr.kinderrkill.sfs;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SFSManager {

	private Location firstSpawn;

	public void initSpawn() {
		File file = new File("plugins/SimpleFirstSpawn/firstSpawn.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

		if(file.exists()) {
			Location loc = new Location( Bukkit.getWorld(config.getString("Spawn.world")), 
					config.getInt("Spawn.x"),
					config.getInt("Spawn.y"),
					config.getInt("Spawn.z"),
					Float.parseFloat(config.getString("Spawn.yaw")),
					Float.parseFloat(config.getString("Spawn.pitch")));
			firstSpawn = loc;
		}
	}

	public void defineSpawn(Player op) {
		File file = new File("plugins/SimpleFirstSpawn/firstSpawn.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

		config.set("Spawn.world", op.getWorld().getName());
		config.set("Spawn.x", op.getLocation().getX());
		config.set("Spawn.y", op.getLocation().getY() + 1);
		config.set("Spawn.z", op.getLocation().getZ());
		config.set("Spawn.yaw", op.getLocation().getYaw());
		config.set("Spawn.pitch", op.getLocation().getPitch());
		
		try {
			config.save(file);
			firstSpawn = new Location(op.getWorld(), op.getLocation().getX(), op.getLocation().getY() + 1, op.getLocation().getZ());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void teleportToSpawn(Player target) {
		if(firstSpawn != null) {
			target.teleport(firstSpawn);
		}
	}

}
