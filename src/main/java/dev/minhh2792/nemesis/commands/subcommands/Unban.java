package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class Unban implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc unban <player>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a player!");
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage("&cPlayer not found!");
            return;
        }

        if (Bukkit.getBanList(Type.NAME).isBanned(player.getName())) {
            Bukkit.getBanList(Type.NAME).pardon(player.getName());
            sender.sendMessage("&aYou have successfully unbanned " + player.getName());
        } else {
            sender.sendMessage("&cPlayer is not banned!");
        }
    }

    @Override
    public String getName() {
        return "Unban";
    }
}