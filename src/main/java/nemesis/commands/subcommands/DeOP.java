package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class DeOP implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            if (player.isOp()) {
                player.setOp(false);
                sender.sendMessage(Utils.colorize("&aYou have successfully deopped " + player.getName()));
            } else {
                sender.sendMessage(Utils.colorize("&cThat player is not opped!"));
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc deop <player>"));
        }
    }

    @Override
    public String getName() {
        return "deop";
    }
}