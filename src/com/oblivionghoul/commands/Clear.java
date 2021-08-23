package com.oblivionghoul.commands;

import com.oblivionghoul.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("NullableProblems")
public record Clear(Main main) implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {

            if (player.isOp() || player.hasPermission("clearinventory")) {
                Inventory inventory = player.getInventory();
                inventory.clear();
                player.sendMessage(ChatColor.GREEN + "Cleared your inventory!");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            main.getLogger().info("You have to be a player to clear your inventory!");
        }
        return true;
    }
}
