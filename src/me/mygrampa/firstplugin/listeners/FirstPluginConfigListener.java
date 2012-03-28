package me.mygrampa.firstplugin.listeners;

import me.mygrampa.firstplugin.FirstPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class FirstPluginConfigListener implements Listener {
	private FirstPlugin plugin;
	public FirstPluginConfigListener(FirstPlugin instance) {
		plugin=instance;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		plugin.getConfig(); // load config
		Player player = e.getPlayer();

		player.sendMessage(plugin.getConfig().getString("Message.to.send").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	}
}
