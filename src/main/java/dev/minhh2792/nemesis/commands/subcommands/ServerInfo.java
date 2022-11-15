package dev.minhh2792.nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class ServerInfo implements SubCommand {

    private Map<World, String> worlds;

    public ServerInfo() {
       this.worlds = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (World world : Bukkit.getWorlds()) {
            worlds.put(world, world.getName());
        }

        sender.sendMessage(Utils.colorize("&6&m-----------------------------"));
        sender.sendMessage("");
        sender.sendMessage(Utils.colorize("&aServer version: &f" + sender.getServer().getVersion()));
        sender.sendMessage(Utils.colorize("&aServer name: &f" + sender.getServer().getName()));
        sender.sendMessage(Utils.colorize("&aServer port: &f" + sender.getServer().getPort()));
        sender.sendMessage(Utils.colorize("&aServer IP: &f" + sender.getServer().getIp()));
        sender.sendMessage(Utils.colorize("&aServer worlds: &f" + worlds.size()));
        sender.sendMessage(Utils.colorize("&aServer online players: &f" + sender.getServer().getOnlinePlayers().size() + "/" + sender.getServer().getMaxPlayers()));
        sender.sendMessage("");
        sender.sendMessage(Utils.colorize("&6&m-----------------------------"));
    }

    @Override
    public String getName() {
        return "ServerInfo";
    }
}