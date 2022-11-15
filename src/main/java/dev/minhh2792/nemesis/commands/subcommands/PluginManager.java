package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class PluginManager implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc pluginmanager <load|unload> <plugin>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a plugin!");
            return;
        }

        if (args[1].equalsIgnoreCase("load")) {
            sender.getServer().getPluginManager().enablePlugin(Utils.getFromString(args[2]));
            sender.sendMessage("&aYou have successfully loaded " + args[2]);
        } else if (args[1].equalsIgnoreCase("unload")) {
            sender.getServer().getPluginManager()
                    .disablePlugin(sender.getServer().getPluginManager().getPlugin(args[2]));
            sender.sendMessage("&aYou have successfully unloaded " + args[2]);
        } else {
            sender.sendMessage("&cUsage: /papermc pluginmanager <load|unload> <plugin>");
        }
    }

    @Override
    public String getName() {
        return "PluginManager";
    }
}