package me.mygrampa.firstplugin;


import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;


import me.mygrampa.firstplugin.listeners.FirstPluginEntityListener;
import me.mygrampa.firstplugin.listeners.FirstPluginPlayerListener;
import me.mygrampa.firstplugin.listeners.FirstPluginBlockListener;
import me.mygrampa.firstplugin.commands.MobDamageValue;
import me.mygrampa.firstplugin.commands.PlayerDamageValue;

public class FirstPlugin extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
	private final FirstPluginEntityListener entityListener = new FirstPluginEntityListener(this);
	private final FirstPluginPlayerListener playerListener = new FirstPluginPlayerListener(this);
	private final FirstPluginBlockListener blockListener = new FirstPluginBlockListener(this);
	
	 
	public void onDisable(){ 
		log.info(this.getDescription().getName() + " has been disabled");	 
	} // End of onDisable

	public void onEnable(){
		log.info(this.getDescription().getName() + " has been enabled");		 
		
		final FileConfiguration config = this.getConfig();
		
		config.addDefault("Value.PlayerDamage", 2);
		config.addDefault("Value.MobDamage", 2);

		config.addDefault("Toggle.Damage.MobDamage", true );
		config.addDefault("Toggle.Damage.PlayerDamage", true );

		config.addDefault("Debug.Damage.Messages", false );
		
		config.options().copyDefaults(true);
		saveConfig();
		
		PluginManager pm = this.getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PROJECTILE_HIT, entityListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.Normal, this);

		getCommand("player").setExecutor(new PlayerDamageValue(this));
		getCommand("mob").setExecutor(new MobDamageValue(this));

	} // End of onEnable

} // End of FirstPlugin