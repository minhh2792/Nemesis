package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.command.CommandSender;

public class DownloadFile implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[1] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a url!"));
                return;
            }

            if (args[2] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a file name!"));
                return;
            }

            if (args[3] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a path!"));
                return;
            }

            Utils.downloadFile(sender, args[1], args[2], args[3]);
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc downloadfile <url> <file name> <path>"));
        }
    }

    @Override
    public String getName() {
        return "downloadfile";
    }
}