package nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class PluginList implements SubCommand {

    private Map<Plugin, String> plugins;

    public PluginList() {
        this.plugins = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (Plugin pl : Bukkit.getPluginManager().getPlugins()) {
            plugins.put(pl, pl.getName());
        }

        sender.sendMessage(Utils.colorize("&aPlugins (" + plugins.size() + "): &f" + plugins.values().toString().replace("[", "").replace("]", "")));
    }

    @Override
    public String getName() {
        return "pluginlist";
    }
}