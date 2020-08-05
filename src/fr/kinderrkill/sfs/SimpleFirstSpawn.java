package fr.kinderrkill.sfs;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleFirstSpawn extends JavaPlugin {

	private static SimpleFirstSpawn instance;
	public SFSManager manager;
	
	private File configFile = null;
	private YamlConfiguration config = new YamlConfiguration();
	
	public void onEnable() {
		instance = this;
		
		getServer().getPluginManager().registerEvents(new SFSListeners(), this);
		getCommand("simpleFirstSpawn").setExecutor(new SFSCommands());
		
		setupConfiguration();

		manager = new SFSManager();
		manager.initSpawn();
		
		Bukkit.getConsoleSender().sendMessage("[SimpleFirstSpawn] Enabled with success !");
	}
	
	public void onDisable() {}
	
	private void setupConfiguration() {
		this.configFile = new File(getDataFolder(), "config.yml");
		if(!this.configFile.exists()) {
			saveResource("config.yml", false);
		}
		
		try {
			this.config.load(this.configFile);
		} catch (Exception e) {}
	}
	
	private String format(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public YamlConfiguration getConfig() {
		return this.config;
	}
	
	public static SimpleFirstSpawn getInstance() {
		return instance;
	}
 }
