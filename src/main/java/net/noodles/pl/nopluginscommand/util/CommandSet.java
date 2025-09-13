package net.noodles.pl.nopluginscommand.util;

import net.noodles.pl.nopluginscommand.NoPluginsCommand;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CommandSet {

    public static final HashSet<String> set = new HashSet<>(NoPluginsCommand.getPlugin().getConfig().getStringList("commands"));

}
