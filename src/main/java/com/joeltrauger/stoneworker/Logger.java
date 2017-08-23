package com.joeltrauger.stoneworker;

import org.bukkit.Bukkit;

public class Logger {
	public static enum LOGGERLEVELS {
		INFO,
		SEVERE;
	}
	
	public void logger(String message, LOGGERLEVELS level) {
		switch (level) {
		case INFO:
			Bukkit.getLogger().info(message);
			break;
		case SEVERE:
			Bukkit.getLogger().severe(message);
		}
	}
}
