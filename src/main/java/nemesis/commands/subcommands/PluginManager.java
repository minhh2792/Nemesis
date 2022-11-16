package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

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
            if (Bukkit.getPluginManager().getPlugin(args[2]) != null) {
                sender.sendMessage("&cThat plugin is already loaded!");
                return;
            }
            Bukkit.getServer().getPluginManager().enablePlugin(Utils.getFromString(args[2]));
            sender.sendMessage("&aYou have successfully loaded " + args[2]);
        } else if (args[1].equalsIgnoreCase("unload")) {
            if (Bukkit.getPluginManager().getPlugin(args[2]) == null) {
                sender.sendMessage("&cThat plugin is not loaded!");
                return;
            }
            Bukkit.getServer().getPluginManager()
                    .disablePlugin(Bukkit.getServer().getPluginManager().getPlugin(args[2]));
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