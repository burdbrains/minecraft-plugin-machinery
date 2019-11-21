package me.burdbrains.machinery;

import org.bukkit.plugin.java.JavaPlugin;

public class Machinery extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        //Plugin startup logic
        getLogger().info("v0.0.4.3 - Machinery by burdbrains has been enabled.");
        getServer().getPluginManager().registerEvents(new DrillEvents(), this);
    }

    @Override
    public void onDisable()
    {
        //Plugin closing logic
        getLogger().info("v0.0.4.3 - Machinery by burdbrains had been disabled.");
    }
}

