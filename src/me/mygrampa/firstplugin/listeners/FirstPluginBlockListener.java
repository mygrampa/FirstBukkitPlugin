package me.mygrampa.firstplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

import me.mygrampa.firstplugin.FirstPlugin;

public class FirstPluginBlockListener extends BlockListener {
	FirstPlugin plugin;

	public FirstPluginBlockListener(FirstPlugin instance) {
		plugin = instance;
	}

	@Override
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
