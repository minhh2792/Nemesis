package dev.minhh2792.nemesis.commands.subcommands;

import org.bukkit.command.CommandSender;

import dev.minhh2792.nemesis.commands.SubCommand;

public class Stop implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.getServer().shutdown();
    }

    @Override
    public String getName() {
        return "Stop";
    }
}
