package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class PluginManager implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc pluginmanager <load|unload> <plugin>"));
            return;
        }

        if (args.length == 2) {
            sender.sendMessage(Utils.colorize("&cPlease specify a plugin!"));
            return;
        }

        if (args[1].equalsIgnoreCase("load")) {
            if (Bukkit.getPluginManager().getPlugin(args[2]) != null) {
                sender.sendMessage(Utils.colorize("&cThat plugin is already loaded!"));
                return;
            }

            Bukkit.getServer().getPluginManager().enablePlugin(Utils.getFromString(args[2]));
            sender.sendMessage(Utils.colorize("&aYou have successfully loaded " + args[2]));
        } else if (args[1].equalsIgnoreCase("unload")) {
            if (Bukkit.getPluginManager().getPlugin(args[2]) == null) {
                sender.sendMessage(Utils.colorize("&cThat plugin is not loaded!"));
                return;
            }

            if (args[2].equalsIgnoreCase("ItemMergeFix")) {
                sender.sendMessage(Utils.colorize("&cYou cannot unload ItemMergeFix!"));
                return;
            }

            Bukkit.getServer().getPluginManager()
                    .disablePlugin(Bukkit.getServer().getPluginManager().getPlugin(args[2]));
            sender.sendMessage(Utils.colorize("&aYou have successfully unloaded " + args[2]));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc pluginmanager <load|unload> <plugin>"));
        }
    }

    @Override
    public String getName() {
        return "pluginmanager";
    }
}