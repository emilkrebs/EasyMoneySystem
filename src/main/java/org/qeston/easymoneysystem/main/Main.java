package org.qeston.easymoneysystem.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.qeston.easymoneysystem.commands.BalanceCommand;
import org.qeston.easymoneysystem.commands.PayCommand;
import org.qeston.easymoneysystem.listeners.PlayerListeners;
import org.qeston.playerprefs.utils.PlayerPrefs;

public final class Main extends JavaPlugin {

    public static FileConfiguration config;
    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        Bukkit.getPluginManager().registerEvents(new PlayerListeners(), this);
        PlayerPrefs.directoryName = "MoneySystem";

        config = this.getConfig();
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){
        this.getCommand("pay").setExecutor(new PayCommand());
        this.getCommand("bal").setExecutor(new BalanceCommand());
    }

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
