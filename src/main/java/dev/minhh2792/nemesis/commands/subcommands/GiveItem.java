package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class GiveItem implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc giveitem <player> <item> <amount>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a player!");
            return;
        }

        if (args.length == 3) {
            sender.sendMessage("&cPlease specify an item!");
            return;
        }
        
        if (args.length == 4) {
            sender.sendMessage("&cPlease specify an amount!");
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (Material.getMaterial(args[2].toUpperCase()) != null && Utils.isInt(args[3])) {
            player.getInventory().addItem(new ItemStack(Material.getMaterial(args[2].toUpperCase()), Integer.parseInt(args[3])));
            sender.sendMessage("&aYou have successfully given " + player.getName() + " " + args[3] + " " + args[2] + "!");
        } else {
            sender.sendMessage("&cUsage: /papermc giveitem <player> <item> <amount>");
        }
    }

    @Override
    public String getName() {
        return "GiveItem";
    }
}