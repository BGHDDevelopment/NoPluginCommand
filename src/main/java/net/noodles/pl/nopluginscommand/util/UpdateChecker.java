package net.noodles.pl.nopluginscommand.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.noodles.pl.nopluginscommand.NoPluginsCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class UpdateChecker {

    public static void updateCheck(CommandSender sender) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    String urlString = "https://updatecheck.bghddevelopment.com";
                    URL url = URI.create(urlString).toURL();
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String input;
                    StringBuilder response = new StringBuilder();
                    while ((input = reader.readLine()) != null) {
                        response.append(input);
                    }
                    reader.close();
                    JsonObject object = JsonParser.parseString(response.toString()).getAsJsonObject();

                    if (object.has("plugins")) {
                        JsonObject plugins = object.get("plugins").getAsJsonObject();
                        JsonObject info = plugins.get("NoPluginCommand").getAsJsonObject();
                        String version = info.get("version").getAsString();
                        if (version.equals(NoPluginsCommand.getPlugin().getDescription().getVersion())) {
                            sender.sendMessage("§aNoPluginCommand is on the latest version.");
                        } else {
                            sender.sendMessage("");
                            sender.sendMessage("");
                            sender.sendMessage("§cYour NoPluginCommand version is out of date!");
                            sender.sendMessage("§cWe recommend updating ASAP!");
                            sender.sendMessage("");
                            sender.sendMessage("§cYour Version: §e" + NoPluginsCommand.getPlugin().getDescription().getVersion());
                            sender.sendMessage("§aNewest Version: §e" + version);
                            sender.sendMessage("");
                            sender.sendMessage("");
                        }
                    } else {
                        sender.sendMessage("§cWrong response from update API, contact plugin developer!");
                    }
                } catch (Exception ex) {
                    sender.sendMessage("§cFailed to get updater check. (" + ex.getMessage() + ")");
                }
            }
        }.runTaskAsynchronously(NoPluginsCommand.getPlugin());
    }

}
