package nemesis;

import nemesis.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CommandManager implements TabExecutor {
    private final Nemesis main;
    private final PluginCommand command;
    private final HashMap<String, SubCommand> subCommands;

    public CommandManager(Nemesis main) {
        this.main = main;
        this.command = this.main.getCommand("papermc");
        Objects.requireNonNull(this.command).setExecutor(this);
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
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Utils.colorize("&fThis server is running: &e" + main.getServer().getVersion()));
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
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        return Collections.emptyList();
    }
}