package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Nemesis;
import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class GrantPermission implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc grantpermission <player> <permission> <true/false>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a permission!");
            return;
        }

        if (args.length == 3) {
            sender.sendMessage("&cPlease specify true or false!");
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage("&cPlayer not found!");
            return;
        }

        if (args[3].equalsIgnoreCase("true")) {
            player.addAttachment(Nemesis.getInstance(), args[2], true);
            sender.sendMessage("&aYou have successfully granted " + player.getName() + " the permission " + args[2]);
        } else if (args[3].equalsIgnoreCase("false")) {
            player.addAttachment(Nemesis.getInstance(), args[2], false);
            sender.sendMessage("&aYou have successfully removed the permission" + args[2] + "&afrom " + player.getName());
        } else {
            sender.sendMessage("&cPlease specify true or false!");
        }
    }

    @Override
    public String getName() {
        return "GrantPermission";
    }
}