package me.mygrampa.firstplugin.listeners;

import me.mygrampa.firstplugin.FirstPlugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class FirstPluginBlockListener implements Listener {
	private FirstPlugin plugin;
	public FirstPluginBlockListener(FirstPlugin instance) {
		plugin=instance;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		plugin.getConfig(); // load config
		Player player = e.getPlayer();
		Material m = player.getItemInHand().getType();
		Block b = e.getBlock();

		if (b == null) {
			return;
		}
		if (!(e.isCancelled())) {
			player.sendMessage("From BlockListener: " + player + " broke a block of " + b + " while holding" + m + "!!!");
		}
		if (e.isCancelled()) {
			return;
		}
	}
}
