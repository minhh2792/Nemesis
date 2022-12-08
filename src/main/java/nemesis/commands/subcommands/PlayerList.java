package nemesis.commands.subcommands;

import nemesis.Utils;
import nemesis.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerList implements SubCommand {

    private Map<Player, String> players;

    public PlayerList() {
        this.players = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Bukkit.getOnlinePlayers().forEach(p -> players.put(p, p.getName()));
        sender.sendMessage(Utils.colorize("&aPlayers (" + players.size() + "): &f"
                + players.values().toString().replace("[", "").replace("]", "")));
    }

    @Override
    public String getName() {
        return "playerlist";
    }
}