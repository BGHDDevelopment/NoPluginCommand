package net.noodles.pl.nopluginscommand.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.HashSet;

public class CommandListener implements Listener {

    private static final HashSet<String> set = new HashSet<>(Arrays.asList("?", "pl", "about", "version", "ver", "plugins", "bukkit:?", "bukkit:pl", "bukkit:about", "bukkit:version", "bukkit:ver", "bukkit:plugins", "minecraft:pl", "minecraft:plugins", "minecraft:about", "minecraft:version", "minecraft:ver"));

    @EventHandler
    public void onCommandUse(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().hasPermission("nopluginscommand.bypass"))
            return;

        String command = event.getMessage().split(" ", 2)[0].substring(1).toLowerCase();
        if (set.contains(command))
            event.setCancelled(true);
    }

}
