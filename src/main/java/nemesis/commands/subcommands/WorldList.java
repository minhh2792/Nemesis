package nemesis.commands.subcommands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import nemesis.Utils;
import nemesis.commands.SubCommand;

public class WorldList implements SubCommand {

    private Map<World, String> worlds;

    public WorldList() {
        this.worlds = new HashMap<>();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Bukkit.getServer().getWorlds().forEach(w -> worlds.put(w, w.getName()));
        sender.sendMessage(Utils.colorize("&aWorlds (" + worlds.size() + "): &f"
                + worlds.values().toString().replace("[", "").replace("]", "")));
    }

    @Override
    public String getName() {
        return "worldlist";
    }
}