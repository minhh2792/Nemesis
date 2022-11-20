package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class SetFlying implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            if (args[2] == null && args[2].isEmpty()) {
                sender.sendMessage(Utils.colorize("&cPlease specify a true/false!"));
                return;
            }

            if (args[2].equalsIgnoreCase("true")) {
                player.setAllowFlight(true);
                sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s flying to true!"));
            } else if (args[2].equalsIgnoreCase("false")) {
                player.setAllowFlight(false);
                sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s flying to false!"));
            } else {
                sender.sendMessage(Utils.colorize("&cPlease specify a true/false!"));
                return;
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc setflying <player> <true/false>"));
        }
    }

    @Override
    public String getName() {
        return "setflying";
    }
}