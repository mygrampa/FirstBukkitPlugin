package me.mygrampa.firstplugin.commands;

import me.mygrampa.firstplugin.FirstPlugin;
import me.mygrampa.firstplugin.util.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerDamageValue implements CommandExecutor {

	private FirstPlugin plugin;

	public PlayerDamageValue(FirstPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("player")) {
			if (args[0].equals("damage")) {
				if (args[1].equals("on")) {
					plugin.getConfig().set("Toggle.Damage.PlayerDamage", true);
					sender.sendMessage(ChatColor.RED + "[FirstPlugin] " + ChatColor.YELLOW + "Player damage is now on");
					plugin.saveConfig();
					return true;
				}
				if (args[1].equals("off")) {
					plugin.getConfig().set("Toggle.Damage.PlayerDamage", false);
					sender.sendMessage(ChatColor.RED + "[FirstPlugin] " + ChatColor.YELLOW + "Player damage is now off");
					plugin.saveConfig();
					return true;
				}
				else if (Util.isInt(args[1])) {
					plugin.getConfig().set("Value.PlayerDamage", Util.getInt(args[1]));
					sender.sendMessage(ChatColor.RED + "[FirstPlugin] " + ChatColor.YELLOW + "Player damage is now set to " + Util.getInt(args[1]));
					plugin.saveConfig();
					return true;
				}
				else {
					sender.sendMessage(cmd.getUsage());
				}
			}
		}
		return false;
	}
}