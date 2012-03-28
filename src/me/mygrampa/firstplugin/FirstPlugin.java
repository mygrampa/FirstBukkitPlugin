package me.mygrampa.firstplugin;


import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.mygrampa.firstplugin.commands.*;
import me.mygrampa.firstplugin.listeners.*;

public class FirstPlugin extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
		 
	public void onDisable(){ 
		log.info(this.getDescription().getName() + " has been disabled");
	} // End of onDisable

	public void onEnable(){
		getConfig();
		getConfig().addDefault("Value.PlayerDamage", 2);
		getConfig().addDefault("Value.MobDamage", 2);

		getConfig().addDefault("Toggle.Damage.MobDamage", true );
		getConfig().addDefault("Toggle.Damage.PlayerDamage", true );

		getConfig().addDefault("Debug.Damage.Messages", false );

		getConfig().addDefault("Message.Welcome", "Hello, welcome to First Plugin");
		getConfig().addDefault("Message.EntityListener", "From Entity Listener: ");
		getConfig().addDefault("Message.BlockListener", "From Block Listener: ");
		getConfig().addDefault("Message.PlayerListener", "From Player Listener: ");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		//Set up a PluginManager to regeter events
		PluginManager pm = getServer().getPluginManager();
		//register the listeners
		pm.registerEvents(new FirstPluginBlockListener(this), this);
		pm.registerEvents(new FirstPluginPlayerListener(this), this);
		pm.registerEvents(new FirstPluginEntityListener(this), this);
		pm.registerEvents(new FirstPluginConfigListener(this), this);
		//register the commands
		getCommand("player").setExecutor(new PlayerDamageValue(this));
		getCommand("mob").setExecutor(new MobDamageValue(this));
		getCommand("setmessage").setExecutor(new FirstPluginConfigCommand(this));
		
		log.info(this.getDescription().getName() + " has been enabled");
	} // End of onEnable


} // End of FirstPlugin