package me.burdbrains.machinery;

import org.bukkit.plugin.java.JavaPlugin;

public class Machinery extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        //Plugin startup logic
        getLogger().info("[Machinery-v0.0.1] Machinery by burdbrains has been enabled.");
    }

    @Override
    public void onDisable()
    {
        //Plugin closing logic
        getLogger().info("[Machinery-v0.0.1] Machinery by burdbrains had been disabled.");
    }
}
