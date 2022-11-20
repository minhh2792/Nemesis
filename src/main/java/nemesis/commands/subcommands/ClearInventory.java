package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class ClearInventory implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[1].equalsIgnoreCase("all")) {
                Bukkit.getOnlinePlayers().forEach(p -> p.getInventory().clear());
                sender.sendMessage(Utils.colorize("&aYou have successfully cleared the inventory of all players!"));
                return;
            }

            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            player.getInventory().clear();
            sender.sendMessage(Utils.colorize("&aYou have successfully cleared " + player.getName() + "'s inventory!"));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc clearinventory <player>"));
        }
    }

    @Override
    public String getName() {
        return "clearinventory";
    }
}