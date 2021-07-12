package com.github.sbroadcast;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandBroadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) return false;

        String broadcastString = "";

        for(String loopValue : args) {
            broadcastString = broadcastString + loopValue + " ";
        }

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lAlert &8&l»&7 " + broadcastString));

        for(Player loopPlayer : Bukkit.getOnlinePlayers()) {
            loopPlayer.getWorld().playSound(loopPlayer.getLocation(), Sound.ENTITY_GHAST_SCREAM, 3.0F, 1.0F);
        }

        return true;

    }
}
