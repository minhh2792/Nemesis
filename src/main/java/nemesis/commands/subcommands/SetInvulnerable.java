package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class SetInvulnerable implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc setinvulnerable <player> <true|false>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a player!");
            return;
        }

        if (args.length == 3) {
            sender.sendMessage("&cPlease specify a true or false!");
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (args[2].equalsIgnoreCase("true")) {
            player.setInvulnerable(true);
            sender.sendMessage("&aYou have successfully set " + player.getName() + "'s invincibility to true!");
        } else if (args[2].equalsIgnoreCase("false")) {
            player.setInvulnerable(false);
            sender.sendMessage("&aYou have successfully set " + player.getName() + "'s invincibility to false!");
        } else {
            sender.sendMessage("&cUsage: /papermc setinvincible <player> <true|false>");
        }
    }

    @Override
    public String getName() {
        return "SetInvulnerable";
    }
}