package com.yerti.cachedconfig.cachedconfig;

import org.bukkit.plugin.java.JavaPlugin;

public final class CachedConfig extends JavaPlugin {

    private Config configYml;

    @Override
    public void onEnable() {
        configYml = new Config("config.yml", this); //Initializes the config and starts grabbing the info

        configYml.enableAutoSave(60 * 10); //will automatically save every 10 minutes
    }

    @Override
    public void onDisable() {
        configYml.save(); //Optionally you can set it to not save
    }

    public Config getMainConfig() {
        return configYml;
    }
}
