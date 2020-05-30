package com.yerti.cachedconfig.cachedconfig;

import com.sun.activation.registries.MailcapParseException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Config {

    private Map<String, Object> values;
    private FileConfiguration configuration;


    public Config(String fileName, Plugin plugin) {
        this.values = new HashMap<>();
        this.configuration = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + fileName));

    }

    public void update() {
        for (String key : Objects.requireNonNull(configuration.getConfigurationSection("")).getKeys(true)) {
            values.put(key, configuration.get(key));
        }
    }

    public void save() {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            configuration.set(entry.getKey(), entry.getValue());
        }
    }

    public Object get(String key) {
        return values.get(key);
    }

    public String getString(String key) {
        return String.valueOf(values.get(key));
    }

    public int getInt(String key) {
        return (int) values.get(key);
    }

    public float getFloat(String key) {
        return (float) values.get(key);
    }

    public double getDouble(String key) {
        return (double) values.get(key);
    }

    public Location getLocation(String key) {
        return new Location(Bukkit.getWorld(getString(key + ".world")), getDouble(key + ".x"), getDouble(key + ".y"), getDouble(key + ".z"));
    }


}
