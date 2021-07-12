package com.github.sbroadcast;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class sBroadcast extends JavaPlugin {

    @Override
    public void onEnable() { // Startup Things

        Bukkit.getLogger().info("hey");
        this.getCommand("broadcast").setExecutor(new commandBroadcast());
    }

    @Override
    public void onDisable() { // Shutdown Stuff

        Bukkit.getLogger().info("bye");
    }

}

