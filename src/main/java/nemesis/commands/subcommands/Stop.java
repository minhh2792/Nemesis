package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Stop implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Utils.colorize("&aStopping the server..."));
        Bukkit.getServer().shutdown();
    }

    @Override
    public String getName() {
        return "stop";
    }
}
