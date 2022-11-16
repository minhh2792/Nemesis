package nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class PlayerList implements SubCommand {

    private Map<Player, String> players;

    public PlayerList() {
        this.players = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            players.put(player, player.getName());
        }

        sender.sendMessage(Utils.colorize("&aPlayers (" + players.size() + "): &f"
        + players.values().toString().replace("[", "").replace("]", "")));
    }

    @Override
    public String getName() {
        return "playerlist";
    }
}