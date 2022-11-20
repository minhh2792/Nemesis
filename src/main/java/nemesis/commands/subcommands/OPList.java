package nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class OPList implements SubCommand {

    private Map<OfflinePlayer, String> ops;

    public OPList() {
        this.ops = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Bukkit.getOperators().forEach(p -> ops.put(p, p.getName()));
        sender.sendMessage(Utils.colorize("&aOPs (" + ops.size() + "): &f" + ops.values().toString().replace("[", "").replace("]", "")));
    }

    @Override
    public String getName() {
        return "oplist";
    }  
}