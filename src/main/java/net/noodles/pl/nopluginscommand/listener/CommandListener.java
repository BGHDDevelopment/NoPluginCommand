package net.noodles.pl.nopluginscommand.listener;

import net.noodles.pl.nopluginscommand.util.CommandSet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommandUse(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().hasPermission("nopluginscommand.bypass"))
            return;

        String command = event.getMessage().split(" ", 2)[0].substring(1).toLowerCase();
        if (CommandSet.set.contains(command))
            event.setCancelled(true);
    }

}
