package com.joeltrauger.stoneworker.recipes;

import java.lang.reflect.*;
import java.util.*;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.*;

import com.joeltrauger.stoneworker.*;
import static com.joeltrauger.stoneworker.Logger.LOGGERLEVELS;

public class Recipes{
	//Stoneworker s = new Stoneworker();
	Logger log = new Logger();
	//combining different types of stone and cobblestone blocks with a catalyst will reduce the input material to cobblestone.
	ShapelessRecipe cobbleRecipe = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE, 2)).addIngredient(1, Material.STONE).addIngredient(1, Material.COBBLESTONE);
	ShapelessRecipe cobbleRecipe2 = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE, 2)).addIngredient(1, Material.SMOOTH_BRICK).addIngredient(1, Material.COBBLESTONE);
	ShapelessRecipe cobbleRecipe3 = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE, 7)).addIngredient(1, Material.COBBLE_WALL).addIngredient(1, Material.COBBLESTONE);
	ShapelessRecipe cobbleRecipe4 = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE, 7)).addIngredient(1, Material.COBBLESTONE_STAIRS).addIngredient(1, Material.COBBLESTONE);
	ShapelessRecipe cobbleRecipe5 = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE, 2)).addIngredient(1, Material.MOSSY_COBBLESTONE).addIngredient(1, Material.COBBLESTONE);
	
	//Combining Cobblestone with a gravel catalyst will reduce the cobblestone to gravel.
	ShapelessRecipe gravelRecipe = new ShapelessRecipe(new ItemStack(Material.GRAVEL, 1)).addIngredient(1, Material.COBBLESTONE).addIngredient(1, Material.GRAVEL);
	
	//Combining Gravel with a sand catalyst will reduce the gravel to sand.
	ShapelessRecipe sandRecipe = new ShapelessRecipe(new ItemStack(Material.SAND, 1)).addIngredient(1, Material.GRAVEL).addIngredient(1, Material.SAND);
	
	int RECIPESMAX = 7;
	ShapelessRecipe[] recipes = {cobbleRecipe, cobbleRecipe2, cobbleRecipe3, cobbleRecipe4, cobbleRecipe5, gravelRecipe, sandRecipe};
	
	public boolean RegisterRecipes() {
		try {
			//try to register the recipes
			Bukkit.getServer().addRecipe(cobbleRecipe);
			Bukkit.getServer().addRecipe(cobbleRecipe2);
			Bukkit.getServer().addRecipe(cobbleRecipe3);
			Bukkit.getServer().addRecipe(cobbleRecipe4);
			Bukkit.getServer().addRecipe(cobbleRecipe5);
			Bukkit.getServer().addRecipe(gravelRecipe);
			Bukkit.getServer().addRecipe(sandRecipe);
			log.logger("Stoneworker added all recipes", LOGGERLEVELS.INFO);
			return true;
		}
		catch (Exception e) {
			log.logger(e.getMessage(), LOGGERLEVELS.SEVERE);
			return false;
		}
	}
	
	public boolean DeleteRecipes() {
		try {
			//try to delete the recipes
			for(int i = 0; i < RECIPESMAX; i++) {
				Iterator<Recipe> itr = Bukkit.getServer().recipeIterator();
				while (itr.hasNext()) {
					Recipe r = itr.next();
					if (r.equals((Recipe)recipes[i])) {
						itr.remove();
						//Bukkit.getLogger().info("Stoneworker removed " + recipes[i].getResult().getType().toString());
						log.logger("Stoneworker remove " + recipes[i].getResult().getType().toString(), LOGGERLEVELS.INFO);
					}
				}
			}
			//getLogger().info("Stoneworker removed all recipes successfully");
			log.logger("Stoneworker removed all recipes successfully", LOGGERLEVELS.INFO);
			
			return true;
		}
		catch (Exception e) {
			//getLogger().severe(e.getMessage());
			log.logger(e.getMessage(), LOGGERLEVELS.SEVERE);
			return false;
		}
	}
}
