package com.oblivionghoul;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlock implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Material block = event.getBlock().getType();
        if (block == Material.DIRT) {
            Player player = event.getPlayer();
            player.sendMessage("Why you break me?");
        }
    }
}