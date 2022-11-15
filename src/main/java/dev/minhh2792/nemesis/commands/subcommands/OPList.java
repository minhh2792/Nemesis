package dev.minhh2792.nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import dev.minhh2792.nemesis.commands.SubCommand;

public class OPList implements SubCommand {

    private Map<OfflinePlayer, String> ops;

    public OPList() {
        this.ops = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (OfflinePlayer op : Bukkit.getOperators()) {
            ops.put(op, op.getName());
        }

        sender.sendMessage("&aOPs (" + ops.size() + "): &f" + ops.values().toString().replace("[", "").replace("]", ""));
    }

    @Override
    public String getName() {
        return "OPList";
    }  
}