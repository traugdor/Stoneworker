package com.joeltrauger.stoneworker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.joeltrauger.stoneworker.recipes.Recipes;

public class Stoneworker extends JavaPlugin{
	Recipes r = new Recipes();
	
	@Override
	public void onEnable() {
		r.RegisterRecipes();
		getLogger().info("Pulverize is enabled!");
	}
	@Override
	public void onDisable() {
		r.DeleteRecipes();
		getLogger().info("Pulverize is disabled");
	}
}
