package com.yerti.cachedconfig.cachedconfig;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ExampleUsage implements Listener {

    private CachedConfig instance;

    public ExampleUsage(CachedConfig instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.getPlayer().sendMessage(ChatColor.GREEN + instance.getMainConfig().getString("block-break-message"));
    }


}
