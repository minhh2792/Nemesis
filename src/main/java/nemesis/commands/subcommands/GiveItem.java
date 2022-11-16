package nemesis.commands.subcommands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class GiveItem implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc giveitem <player> <item> <amount>"));
            return;
        }

        if (args.length == 2) {
            sender.sendMessage(Utils.colorize("&cPlease specify a player!"));
            return;
        }

        if (args.length == 3) {
            sender.sendMessage(Utils.colorize("&cPlease specify an item!"));
            return;
        }
        
        if (args.length == 4) {
            sender.sendMessage(Utils.colorize("&cPlease specify an amount!"));
            return;
        }

        if (Material.getMaterial(args[2].toUpperCase()) == null) {
            sender.sendMessage(Utils.colorize("&cThat item does not exist!"));
            return;
        }

        if (!Utils.isInt(args[3])) {
            sender.sendMessage(Utils.colorize("&cThat is not a valid number!"));
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        player.getInventory().addItem(new ItemStack(Material.getMaterial(args[2].toUpperCase()), Integer.parseInt(args[3])));
        sender.sendMessage(Utils.colorize("&aYou have successfully given " + player.getName() + " " + args[3] + " " + args[2] + "!"));
    }

    @Override
    public String getName() {
        return "giveitem";
    }
}