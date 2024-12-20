package net.noodles.pl.nopluginscommand;

import net.noodles.pl.nopluginscommand.listener.CommandListener;
import net.noodles.pl.nopluginscommand.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoPluginsCommand extends JavaPlugin implements Listener {

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        UpdateChecker.updateCheck(Bukkit.getConsoleSender());
    }

}
