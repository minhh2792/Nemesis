package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class Ban implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc ban <player> <reason>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a reason!");
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage("&cPlayer not found!");
            return;
        }

        Bukkit.getBanList(Type.NAME).addBan(player.getName(), args[2], null, sender.getName());
        sender.sendMessage("&aYou have successfully banned " + player.getName() + " for " + args[2]);
    }

    @Override
    public String getName() {
        return "Ban";
    }
}