package com.github.sbroadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class commandBroadcast extends JavaPlugin implements CommandExecutor, Listener {
    FileConfiguration config = getConfig();
    String prefix = config.getString("broadcastMessage");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) return false;


        String broadcastString = "";

        for(String loopValue : args) {
            broadcastString = broadcastString + loopValue + " ";
        }
        if(config.getString("broadcastMessage") != "") {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + broadcastString));
            if(config.getBoolean("playSound")) {
                for(Player loopPlayer : Bukkit.getOnlinePlayers()) {
                    loopPlayer.getWorld().playSound(loopPlayer.getLocation(), Sound.ENTITY_GHAST_SCREAM, 4.0F, 1.0F);
                }
            } else {
                Bukkit.getLogger().info("Broadcast command was used without sound");
            }

        }

        return true;

    }
}
