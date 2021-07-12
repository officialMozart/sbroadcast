package com.github.sbroadcast;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class sBroadcast extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() { // Startup Things

        //config stuff
        config.addDefault("broadcastMessage", "&e&lAlert &8&l»&7 ");
        config.addDefault("playSound", true);
        config.options().copyDefaults(true);
        saveConfig();
        //config stuff

        Bukkit.getLogger().info("S Broadcasts Loaded");
        this.getCommand("broadcast").setExecutor(new commandBroadcast());
    }

    @Override
    public void onDisable() { // Shutdown Stuff

        Bukkit.getLogger().info("S Broadcasts Unloaded");
    }

}

