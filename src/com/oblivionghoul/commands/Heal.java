package com.oblivionghoul.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                player.setHealth(20);
                player.sendMessage(ChatColor.GREEN + "Healed!");
            } else {
                Bukkit.getLogger().info("You have to be a player to use this command!");
            }
        } else {
            if (Bukkit.getPlayerExact(strings[0]) != null) {
                Player player = (Player) Bukkit.getPlayerExact(strings[0]);
                player.setHealth(20);
                player.sendMessage(ChatColor.GREEN + "Healed!");
                if (commandSender instanceof Player) {
                    Player p = (Player) commandSender;
                    p.sendMessage(ChatColor.GREEN + "Player \"" + strings[0]+ "\" was healed!");
                } else {
                    Bukkit.getLogger().info("Player \"" + strings[0]+ "\" was healed!");
                }
            } else {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    player.sendMessage(ChatColor.RED + "Player \"" + strings[0]+ "\" was not found.");
                } else {
                    Bukkit.getLogger().info("Player \"" + strings[0]+ "\" was not found.");
                }
            }
        }
        return true;
    }
}
