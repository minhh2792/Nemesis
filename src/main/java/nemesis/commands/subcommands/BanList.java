package nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class BanList implements SubCommand {

    private Map<OfflinePlayer, String> bans;

    public BanList() {
        this.bans = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Bukkit.getBannedPlayers().forEach(p -> bans.put(p, p.getName()));
        sender.sendMessage(Utils.colorize("&aBans (" + bans.size() + "): &f" + bans.values().toString().replace("[", "").replace("]", "")));
    }

    @Override
    public String getName() {
        return "banlist";
    }
}