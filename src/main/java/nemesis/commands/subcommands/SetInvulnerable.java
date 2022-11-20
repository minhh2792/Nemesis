package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class SetInvulnerable implements SubCommand {

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
                if (!player.isInvulnerable()) {
                    player.setInvulnerable(true);
                    sender.sendMessage(Utils.colorize(
                            "&aYou have successfully set " + player.getName() + "'s invulnerability to true!"));
                } else {
                    sender.sendMessage(Utils.colorize("&c" + player.getName() + " is already invulnerable!"));
                }
            } else if (args[2].equalsIgnoreCase("false")) {
                if (player.isInvulnerable()) {
                    player.setInvulnerable(false);
                    sender.sendMessage(Utils.colorize(
                            "&aYou have successfully set " + player.getName() + "'s invulnerability to false!"));
                } else {
                    sender.sendMessage(Utils.colorize("&c" + player.getName() + " is not invulnerable!"));
                }
            } else {
                sender.sendMessage(Utils.colorize("&cPlease specify a true/false!"));
                return;
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc setinvulnerable <player> <true/false>"));
        }
    }

    @Override
    public String getName() {
        return "setinvulnerable";
    }
}