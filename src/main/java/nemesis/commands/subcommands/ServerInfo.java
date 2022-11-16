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
        sender.sendMessage(Utils.colorize("&aServer IP: &f" + Bukkit.getServer().getIp()));
        sender.sendMessage(Utils.colorize("&aServer worlds: &f" + Bukkit.getWorlds().size()));
        sender.sendMessage(Utils.colorize("&aServer online players: &f" + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers()));
        sender.sendMessage("");
    }

    @Override
    public String getName() {
        return "ServerInfo";
    }
}