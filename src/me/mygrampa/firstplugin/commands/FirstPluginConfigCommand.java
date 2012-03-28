package me.mygrampa.firstplugin.commands;

import me.mygrampa.firstplugin.FirstPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FirstPluginConfigCommand implements CommandExecutor {

	private FirstPlugin plugin;

	public FirstPluginConfigCommand(FirstPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setmessage")) {
			if (sender instanceof Player) {
				if (args.length == 0) {
					return false;
				}
				String msg;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					if (i != 0)
						sb.append(' ');
					sb.append(args);
				}
				msg = sb.toString();
				sender.sendMessage("The message has been changed to: " + msg.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				plugin.getConfig().set("Message.to.send", msg.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
				plugin.saveConfig();
				return true;
			}
		}
		return false;
	}
}