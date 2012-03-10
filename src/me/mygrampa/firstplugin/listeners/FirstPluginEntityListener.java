package me.mygrampa.firstplugin.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.mygrampa.firstplugin.FirstPlugin;

public class FirstPluginEntityListener implements Listener {
	private FirstPlugin plugin;
	public FirstPluginEntityListener(FirstPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		
		if (e instanceof EntityDamageByEntityEvent) {
			Entity attacker = ((EntityDamageByEntityEvent) e).getDamager();

			int damage = 0;

			if (attacker instanceof Egg) {
				Entity damaged = e.getEntity();

				if (damaged == null) {
					return;
				}
				if (damaged instanceof LivingEntity && !(damaged instanceof Player)) {
					damage = plugin.getConfig().getInt("Value.MobDamage");
					Bukkit.broadcastMessage("Entity " + damaged + " will receive " + damage + "points of damage by " + attacker);
					if (plugin.getConfig().getBoolean("Debug.Damage.Messages")) {
						Bukkit.broadcastMessage("Mob damage: " + damage);
					}
				}

				if (damaged.getFireTicks() > 0) {
					damaged.setFireTicks(0);
				}
			e.setDamage(damage); // This sets the damage to the computed value
			}
		}
	}
}