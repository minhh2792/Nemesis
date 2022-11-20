package nemesis.commands.subcommands;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Gamemode implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            if (args[2].equalsIgnoreCase("creative") && args[2].equalsIgnoreCase("gmc")) {
                player.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s gamemode to creative!"));
            } else if (args[2].equalsIgnoreCase("survival") && args[2].equalsIgnoreCase("gms")) {
                player.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s gamemode to survival!"));
            } else if (args[2].equalsIgnoreCase("adventure") && args[2].equalsIgnoreCase("gma")) {
                player.setGameMode(GameMode.ADVENTURE);
                sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s gamemode to adventure!"));                
            } else if (args[2].equalsIgnoreCase("spectator") && args[2].equalsIgnoreCase("gmsp")) {
                player.setGameMode(GameMode.SPECTATOR);
                sender.sendMessage(Utils.colorize("&aYou have successfully set " + player.getName() + "'s gamemode to spectator!"));              
            } else {
                sender.sendMessage(Utils.colorize("&cUsage: /papermc gamemode <player> <gmc/gms/gma/gmsp>"));
                return;
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc gamemode <player> <gmc/gms/gma/gmsp>"));
        }
    }

    @Override
    public String getName() {
        return "gamemode";
    }
}