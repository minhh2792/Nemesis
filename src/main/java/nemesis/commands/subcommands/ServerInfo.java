package nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class ServerInfo implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("");
        sender.sendMessage(Utils.colorize("&aServer version: &f" + Bukkit.getServer().getVersion()));
        sender.sendMessage(Utils.colorize("&aServer port: &f" + Bukkit.getServer().getPort()));
        sender.sendMessage(Utils.colorize("&aJava version: &f" + System.getProperty("java.version")));
        sender.sendMessage(Utils.colorize("&aOS: &f" + System.getProperty("os.name") + " " + System.getProperty("os.version")));
        sender.sendMessage(Utils.colorize("&aPterodactyl: &f" + (Utils.isPterodactyl() ? "Yes" : "No")));
        sender.sendMessage(Utils.colorize("&aBackend IP: &f" + Utils.getPublicIP()));
        sender.sendMessage(Utils.colorize("&aMemory: &f" + (Runtime.getRuntime().totalMemory() / 1024 / 1024 - Runtime.getRuntime().freeMemory() / 1024 / 1024) + "MB / " + (Runtime.getRuntime().totalMemory() / 1024 / 1024) + "MB"));
        sender.sendMessage(Utils.colorize("&aCPU: &f" + Utils.getCPUName() + " (" + Utils.getCPUCores() + " cores)"));
        sender.sendMessage("");
    }

    @Override
    public String getName() {
        return "serverinfo";
    }
}