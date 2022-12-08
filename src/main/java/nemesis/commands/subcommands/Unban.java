package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unban implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            Player player = Utils.getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(Utils.colorize("&cPlayer not found!"));
                return;
            }

            if (Bukkit.getBanList(Type.NAME).isBanned(player.getName())) {
                Bukkit.getBanList(Type.NAME).pardon(player.getName());
                sender.sendMessage(Utils.colorize("&aYou have successfully unbanned " + player.getName()));
            } else {
                sender.sendMessage(Utils.colorize("&cThat player is not banned!"));
            }
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc unban <player>"));
        }
    }

    @Override
    public String getName() {
        return "unban";
    }
}