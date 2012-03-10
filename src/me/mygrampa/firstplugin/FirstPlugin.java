package me.mygrampa.firstplugin;


import java.util.logging.Logger;

//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.plugin.PluginManager;

import me.mygrampa.firstplugin.commands.MobDamageValue;
import me.mygrampa.firstplugin.commands.PlayerDamageValue;
//import me.mygrampa.firstplugin.listeners.FirstPluginBlockListener;
//import me.mygrampa.firstplugin.listeners.FirstPluginPlayerListener;

public class FirstPlugin extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
		 
	public void onDisable(){ 
		log.info(this.getDescription().getName() + " has been disabled");
	} // End of onDisable

	public void onEnable(){
		this.getConfig().addDefault("Value.PlayerDamage", 2);
		this.getConfig().addDefault("Value.MobDamage", 2);

		this.getConfig().addDefault("Toggle.Damage.MobDamage", true );
		this.getConfig().addDefault("Toggle.Damage.PlayerDamage", true );

		this.getConfig().addDefault("Debug.Damage.Messages", false );
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		getCommand("player").setExecutor(new PlayerDamageValue(this));
		getCommand("mob").setExecutor(new MobDamageValue(this));
		log.info(this.getDescription().getName() + " has been enabled");
	} // End of onEnable

} // End of FirstPlugin