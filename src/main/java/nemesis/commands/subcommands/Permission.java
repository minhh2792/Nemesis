package nemesis.commands.subcommands;

import nemesis.Nemesis;
import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Permission implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            if (args[2] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a permission!"));
                return;
            }

            if (args[3] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a true/false!"));
                return;
            }

            if (args[3].equalsIgnoreCase("true")) {
                player.addAttachment(Nemesis.getInstance(), args[2], true);
            } else if (args[3].equalsIgnoreCase("false")) {
                player.addAttachment(Nemesis.getInstance(), args[2], false);
            } else {
                sender.sendMessage(Utils.colorize("&cPlease specify a true/false!"));
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc permission <player> <permission> <true/false>"));
        }
    }

    @Override
    public String getName() {
        return "permission";
    }
}