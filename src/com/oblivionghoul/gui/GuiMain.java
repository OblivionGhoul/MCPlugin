package com.oblivionghoul.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiMain implements Listener {
    private Inventory gui;

    public void openGui(Player player) {
        gui = Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.AQUA + "Menu");

        ItemStack item1 = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemStack item2 = new ItemStack(Material.BLUE_CONCRETE, 1);
        ItemStack item3 = new ItemStack(Material.RED_CONCRETE, 1);

        ItemMeta meta1 = item1.getItemMeta();
        assert meta1 != null;
        meta1.setDisplayName(ChatColor.GREEN + "Click Me!");
        item1.setItemMeta(meta1);
        gui.setItem(0, item1);

        ItemMeta meta2 = item2.getItemMeta();
        assert meta2 != null;
        meta2.setDisplayName(ChatColor.BLUE + "Click Me!");
        item2.setItemMeta(meta2);
        gui.setItem(2, item2);

        ItemMeta meta3 = item3.getItemMeta();
        assert meta3 != null;
        meta3.setDisplayName(ChatColor.RED + "Click Me!");
        item3.setItemMeta(meta3);
        gui.setItem(4, item3);

        player.openInventory(gui);
    }

    @EventHandler
    public void guiClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(gui)) return;
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        switch (event.getSlot()) {
            case 0 -> {
                player.closeInventory();
                player.sendMessage(ChatColor.GREEN + "Thanks for clicking me!");
            }

            case 2 -> {
                player.closeInventory();
                player.sendMessage(ChatColor.BLUE + "Thanks for clicking me!");
            }

            case 4 -> {
                player.closeInventory();
                player.sendMessage(ChatColor.RED + "Thanks for clicking me!");
            }
        }
    }

    @EventHandler
    public void openGuiEvent(PlayerDropItemEvent event) {
        openGui(event.getPlayer());
    }
}
