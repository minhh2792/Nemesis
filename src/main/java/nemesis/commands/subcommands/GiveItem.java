package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveItem implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            Material material = Material.getMaterial(args[2].toUpperCase());
            if (material == null) {
                sender.sendMessage(Utils.colorize("&cInvalid material!"));
                return;
            }

            if (args[3] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify an amount!"));
                return;
            }

            if (!Utils.isInt(args[3])) {
                sender.sendMessage(Utils.colorize("&cPlease specify a valid amount!"));
                return;
            }

            ItemStack item = new ItemStack(material, Integer.parseInt(args[3]));
            player.getInventory().addItem(item);
            sender.sendMessage(Utils.colorize("&aYou have successfully given " + player.getName() + " " + args[3] + " "
                    + material.name().toLowerCase() + "(s)!"));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc giveitem <player> <item> <amount>"));
        }
    }

    @Override
    public String getName() {
        return "giveitem";
    }
}