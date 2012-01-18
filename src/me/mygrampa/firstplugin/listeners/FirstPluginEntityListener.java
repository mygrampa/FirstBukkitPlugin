package me.mygrampa.firstplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

import me.mygrampa.firstplugin.FirstPlugin;

public class FirstPluginEntityListener extends EntityListener {
	FirstPlugin plugin;

	public FirstPluginEntityListener(FirstPlugin instance) {
		plugin = instance;
	}

	@Override
	public void onEntityDamage(EntityDamageEvent e) {
		Bukkit.broadcastMessage("In EntityListener");
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