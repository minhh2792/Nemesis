package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class SetFlying implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc setflying <player> <true|false>");
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
            player.setAllowFlight(true);
            sender.sendMessage("&aYou have successfully set " + player.getName() + "'s flying to true!");
        } else if (args[2].equalsIgnoreCase("false")) {
            player.setAllowFlight(false);
            sender.sendMessage("&aYou have successfully set " + player.getName() + "'s flying to false!");
        } else {
            sender.sendMessage("&cUsage: /papermc setflying <player> <true|false>");
        }
    }

    @Override
    public String getName() {
        return "SetFlying";
    }
}