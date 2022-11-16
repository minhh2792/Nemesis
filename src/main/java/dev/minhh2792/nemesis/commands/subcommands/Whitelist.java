package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class Whitelist implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc whitelist <add|remove> <player>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a player!");
            return;
        }

        Player player = Utils.getPlayerExact(args[2]);

        if (args[1].equalsIgnoreCase("add")) {
            player.setWhitelisted(true);
            sender.sendMessage("&aYou have successfully added " + player.getName() + " to the whitelist!");
        } else if (args[1].equalsIgnoreCase("remove")) {
            player.setWhitelisted(false);
            sender.sendMessage("&aYou have successfully removed " + player.getName() + " from the whitelist!");
        } else {
            sender.sendMessage("&cUsage: /papermc whitelist <add|remove> <player>");
        }
    }

    @Override
    public String getName() {
        return "Whitelist";
    }
}