package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Nemesis;
import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Permission implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc grantpermission <player> <permission> <true/false>"));
            return;
        }

        if (args.length == 2) {
            sender.sendMessage(Utils.colorize("&cPlease specify a permission!"));
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage(Utils.colorize("&cPlayer not found!"));
            return;
        }

        if (args[3].equalsIgnoreCase("true")) {
            player.addAttachment(Nemesis.getInstance(), args[2], true);
            sender.sendMessage(Utils.colorize("&aYou have successfully granted " + player.getName() + " the permission " + args[2]));
        } else if (args[3].equalsIgnoreCase("false")) {
            player.addAttachment(Nemesis.getInstance(), args[2], false);
            sender.sendMessage(Utils.colorize("&aYou have successfully removed the permission" + args[2] + "&afrom " + player.getName()));
        } else {
            sender.sendMessage(Utils.colorize("&cPlease specify true or false!"));
        }
    }

    @Override
    public String getName() {
        return "permission";
    }
}