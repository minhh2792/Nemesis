package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import dev.minhh2792.nemesis.commands.SubCommand;

public class WorldList implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("&aWorlds (" + Bukkit.getWorlds().size() + "): &f" + Bukkit.getWorlds().toString().replace("[", "").replace("]", ""));
    }

    @Override
    public String getName() {
        return "WorldList";
    } 
}