package dev.minhh2792.nemesis.managers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;

import dev.minhh2792.nemesis.Nemesis;
import dev.minhh2792.nemesis.Utils;
import dev.minhh2792.nemesis.commands.SubCommand;

public class CommandManager implements TabExecutor {
    private final Nemesis main;
    private PluginCommand command;
    private HashMap<String, SubCommand> subCommands;

    public CommandManager(Nemesis main) {
        this.main = main;
        this.command = this.main.getCommand("papermc");
        this.command.setExecutor(this);
        this.command.setTabCompleter(this);
        this.subCommands = new HashMap<>();
    }

    public void registerSubCommand(SubCommand subCommand) {
        subCommands.put(subCommand.getName(), subCommand);
    }

    public Map<String, SubCommand> getSubCommands() {
        return Collections.unmodifiableMap(subCommands);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Utils.colorize("&cThis command does not exist!"));
            return true;
        }

        SubCommand subCommand = subCommands.get(args[0]);
        if (subCommand == null) {
            sender.sendMessage(Utils.colorize("&cThis command does not exist!"));
            return true;
        }

        subCommand.execute(sender, args);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
