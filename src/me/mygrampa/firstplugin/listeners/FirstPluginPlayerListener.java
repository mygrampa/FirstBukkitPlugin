package me.mygrampa.firstplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

import me.mygrampa.firstplugin.FirstPlugin;

public class FirstPluginPlayerListener extends PlayerListener {
	FirstPlugin plugin;

	public FirstPluginPlayerListener(FirstPlugin instance) {
		plugin = instance;
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent e) {
		final Player eplayer = e.getPlayer();
		Block blockB = e.getClickedBlock();
		final Material iih = e.getPlayer().getItemInHand().getType();

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (blockB.isLiquid()) {
				return;
			}
			Bukkit.broadcastMessage("From PlayerListener:Player " + eplayer + " right clicked a block of " + blockB + " while holding" + iih + "!!!");
		}
	}// End of onPlayerInteract
} // End of Player Listener