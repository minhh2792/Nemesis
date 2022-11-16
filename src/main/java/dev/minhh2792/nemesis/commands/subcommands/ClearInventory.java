package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class ClearInventory implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc clearinventory <player>");
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage("&cPlayer not found!");
            return;
        }

        if (player.getInventory().isEmpty()) {
            sender.sendMessage("&cPlayer's inventory is already empty!");
            return;
        }

        if (args[1].equalsIgnoreCase("all") && args[1].equalsIgnoreCase("*")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.getInventory().clear();
            }
            sender.sendMessage("&aYou have successfully cleared all players inventories!");
            return;
        }

        player.getInventory().clear();
    }

    @Override
    public String getName() {
        return "ClearInventory";
    }
}