package me.mygrampa.firstplugin.listeners;

import me.mygrampa.firstplugin.FirstPlugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;


public class FirstPluginPlayerListener implements Listener {
	private FirstPlugin plugin;
	public FirstPluginPlayerListener(FirstPlugin instance) {
		plugin = instance;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		plugin.getConfig();
		final Player player = e.getPlayer();
		Block blockB = e.getClickedBlock();
		final Material iih = e.getPlayer().getItemInHand().getType();

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (blockB.isLiquid()) {
				return;
			}
			player.sendMessage(plugin.getConfig().getString("Message.PlayerListener").replaceAll("(&([a-f0-9]))", "\u00A7$2") + player + " right clicked a block of " + blockB + " while holding" + iih + "!!!");
		}
	}// End of onPlayerInteract
} // End of Player Listener