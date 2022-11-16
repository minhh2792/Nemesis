package nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import nemesis.commands.SubCommand;

public class BanList implements SubCommand {

    private Map<OfflinePlayer, String> bans;

    public BanList() {
        this.bans = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (OfflinePlayer ban : Bukkit.getBannedPlayers()) {
            bans.put(ban, ban.getName());
        }

        sender.sendMessage("&aBans (" + bans.size() + "): &f" + bans.values().toString().replace("[", "").replace("]", ""));
    }

    @Override
    public String getName() {
        return "BanList";
    }
}