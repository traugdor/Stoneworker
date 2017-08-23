package com.joeltrauger.stoneworker.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.*;

import com.joeltrauger.stoneworker.*;

public abstract class Commands extends JavaPlugin{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pulverizer") || cmd.getName().equalsIgnoreCase("pz")) {
			
			return true;
		}
		
		return false;
	}
}
