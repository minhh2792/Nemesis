package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class SetInvulnerable implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc setinvulnerable <player> <true|false>"));
            return;
        }

        if (args.length == 2) {
            sender.sendMessage(Utils.colorize("&cPlease specify a player!"));
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (args[2].equalsIgnoreCase("true")) {
            player.setInvulnerable(true);
            sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s invincibility to true!"));
        } else if (args[2].equalsIgnoreCase("false")) {
            player.setInvulnerable(false);
            sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s invincibility to false!"));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc setinvincible <player> <true|false>"));
        }
    }

    @Override
    public String getName() {
        return "setinvulnerable";
    }
}