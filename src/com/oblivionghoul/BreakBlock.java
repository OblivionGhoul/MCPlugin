package com.oblivionghoul;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BreakBlock implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (block.getType() == Material.DIAMOND_ORE) {
            event.setCancelled(true);
            block.setType(Material.AIR);

            ItemStack itemDropped = new ItemStack(Material.DIRT, 64);
            block.getWorld().dropItemNaturally(block.getLocation(), itemDropped);
        }
    }
}
