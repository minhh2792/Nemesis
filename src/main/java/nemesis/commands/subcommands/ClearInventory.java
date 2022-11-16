package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class ClearInventory implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc clearinventory <player>"));
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage(Utils.colorize("&cPlayer not found!"));
            return;
        }

        if (player.getInventory().isEmpty()) {
            sender.sendMessage(Utils.colorize("&cPlayer's inventory is already empty!"));
            return;
        }

        if (args[1].equalsIgnoreCase("all")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.getInventory().clear();
            }
            sender.sendMessage(Utils.colorize("&aYou have successfully cleared all players inventories!"));
            return;
        }

        player.getInventory().clear();
        sender.sendMessage(Utils.colorize("&aYou have successfully cleared " + player.getName() + "'s inventory!"));
    }

    @Override
    public String getName() {
        return "clearinventory";
    }
}