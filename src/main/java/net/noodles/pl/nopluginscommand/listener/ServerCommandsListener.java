package net.noodles.pl.nopluginscommand.listener;

import net.noodles.pl.nopluginscommand.util.CommandSet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class ServerCommandsListener implements Listener {

    @EventHandler
    public void onServerCommandSend(PlayerCommandSendEvent event) {
        if (event.getPlayer().hasPermission("nopluginscommand.bypass"))
            return;

        event.getCommands().removeAll(CommandSet.set);
    }

}
