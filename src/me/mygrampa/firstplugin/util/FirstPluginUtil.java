package me.mygrampa.firstplugin.util;

import java.text.DecimalFormat;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Util {

	public static int getInt(String string) {
		if (isInt(string)) {
			return Integer.parseInt(string);
		}
		else {
			return 0;
		}
	}

	public static boolean hasSnowballs(Player player) {
		ItemStack[] inventory = player.getInventory().getContents();
		for (ItemStack x : inventory) {
			if (x != null && x.getTypeId() == 332) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInt(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException nFE) {
			return false;
		}
		return true;
	}

	double roundTwoDecimals(double d) {

		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}
}
