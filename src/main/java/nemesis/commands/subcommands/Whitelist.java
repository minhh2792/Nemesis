package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Whitelist implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[1] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a option!"));
                return;
            }

            Player player = Utils.getPlayerExact(args[2]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            if (args[1].equalsIgnoreCase("add")) {
                if (player.isWhitelisted()) {
                    sender.sendMessage(Utils.colorize("&cThat player is already whitelisted!"));
                }
            } else if (args[1].equalsIgnoreCase("remove")) {
                if (!player.isWhitelisted()) {
                    sender.sendMessage(Utils.colorize("&cThat player is not whitelisted!"));
                }
            } else {
                sender.sendMessage(Utils.colorize("&cPlease specify a option!"));
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc whitelist <add/remove> <player>"));
        }
    }

    @Override
    public String getName() {
        return "whitelist";
    }
}