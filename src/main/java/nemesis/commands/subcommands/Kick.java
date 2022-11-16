package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Kick implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc kick <player> <reason>");
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

        player.kickPlayer(args[2]);
    }

    @Override
    public String getName() {
        return "Kick";
    }
}