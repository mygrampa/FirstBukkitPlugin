package me.mygrampa.firstplugin.listeners;

import me.mygrampa.firstplugin.FirstPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class FirstPluginBlockListener implements Listener {
	public FirstPluginBlockListener(FirstPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player eplayer = e.getPlayer();
		Material epiih = eplayer.getItemInHand().getType();
		Block b = e.getBlock();

		if (b == null) {
			return;
		}
		if (!(e.isCancelled())) {
			Bukkit.broadcastMessage("From BlockListener: Player " + eplayer + " broke a block of " + b + " while holding" + epiih + "!!!");
		}
		if (e.isCancelled()) {
			return;
		}
	}
}
