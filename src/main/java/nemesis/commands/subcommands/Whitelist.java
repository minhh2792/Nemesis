package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Whitelist implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc whitelist <add|remove> <player>"));
            return;
        }

        if (args.length == 2) {
            sender.sendMessage(Utils.colorize("&cPlease specify a player!"));
            return;
        }

        Player player = Utils.getPlayerExact(args[2]);

        if (args[1].equalsIgnoreCase("add")) {
            player.setWhitelisted(true);
            sender.sendMessage(Utils.colorize("&aYou have successfully added " + player.getName() + " to the whitelist!"));
        } else if (args[1].equalsIgnoreCase("remove")) {
            player.setWhitelisted(false);
            sender.sendMessage(Utils.colorize("&aYou have successfully removed " + player.getName() + " from the whitelist!"));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc whitelist <add|remove> <player>"));
        }
    }

    @Override
    public String getName() {
        return "whitelist";
    }
}