package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            StringBuilder reason = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                reason.append(args[i]).append(" ");
            }

            if (reason.length() == 0) {
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