package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Reload implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Utils.colorize("&aReloading the server..."));
        Bukkit.getServer().reload();
    }

    @Override
    public String getName() {
        return "reload";
    }
}