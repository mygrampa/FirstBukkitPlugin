package me.mygrampa.firstplugin.commands;


import me.mygrampa.firstplugin.FirstPlugin;
import me.mygrampa.firstplugin.util.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MobDamageValue implements CommandExecutor {
	private FirstPlugin plugin;
	public MobDamageValue(FirstPlugin instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("mob")) {
			if (args[0].equals("damage")) {
				if (args[1].equals("on")) {
					plugin.getConfig().set("Toggle.Damage.MobDamage", true);
					sender.sendMessage(ChatColor.RED + "[FirstPlugin] " + ChatColor.YELLOW + "Mob damage is now on");
					return true;
				}
				if (args[1].equals("off")) {
					plugin.getConfig().set("Toggle.Damage.MobDamage", false);
					sender.sendMessage(ChatColor.RED + "[FirstPlugin] " + ChatColor.YELLOW + "Mob damage is now off");
					return true;
				}
				else if (FirstPluginUtil.isInt(args[1])) {
					plugin.getConfig().set("Value.MobDamage", FirstPluginUtil.getInt(args[1]));
					sender.sendMessage(ChatColor.RED + "[FirstPlugin] " + ChatColor.YELLOW + "Mob damage is now set to " + FirstPluginUtil.getInt(args[1]));
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