package com.oblivionghoul;

import com.oblivionghoul.commands.Clear;
import com.oblivionghoul.commands.Heal;
import com.oblivionghoul.gui.GuiMain;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        System.out.println("Starting OblivionGhoul's Test MCPlugin...");

        Bukkit.getPluginManager().registerEvents(new PlaceBlock(), this);
        Bukkit.getPluginManager().registerEvents(new BreakBlock(), this);
        Bukkit.getPluginManager().registerEvents(new GuiMain(), this);
        Objects.requireNonNull(Bukkit.getPluginCommand("clear")).setExecutor(new Clear(this));
        Objects.requireNonNull(Bukkit.getPluginCommand("heal")).setExecutor(new Heal());

        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getLogger().info("Hello " + config.getString("name") + "!");
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting Down OblivionGhoul's Test MCPlugin...");
    }
}