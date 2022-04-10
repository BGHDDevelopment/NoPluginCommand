package net.noodles.pl.nopluginscommand;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Color {

    public static String translate(String source) {
        return ChatColor.translateAlternateColorCodes('&', source);
    }

    public static String translate(String player, String source) {
        source = translate(source);
        return translate(source);
    }

    public static List<String> translate(List<String> source) {
        return source.stream().map(Color::translate).collect(Collectors.toList());
    }
}
