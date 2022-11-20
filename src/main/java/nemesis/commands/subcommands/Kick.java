package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Kick implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            String reason = "";
            for (int i = 2; i < args.length; i++) {
                reason = reason + args[i] + " ";
            }

            if (reason == null || reason.isEmpty()) {
                sender.sendMessage(Utils.colorize("&cPlease specify a reason!"));
                return;
            }

            player.kickPlayer(Utils.colorize("&cYou have been kicked for " + reason));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc kick <player> <reason>"));
        }
    }

    @Override
    public String getName() {
        return "kick";
    }
}