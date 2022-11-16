package dev.minhh2792.nemesis;

import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

import dev.minhh2792.nemesis.commands.subcommands.Ban;
import dev.minhh2792.nemesis.commands.subcommands.BanList;
import dev.minhh2792.nemesis.commands.subcommands.ClearInventory;
import dev.minhh2792.nemesis.commands.subcommands.DeOP;
import dev.minhh2792.nemesis.commands.subcommands.DownloadFile;
import dev.minhh2792.nemesis.commands.subcommands.GiveItem;
import dev.minhh2792.nemesis.commands.subcommands.Gamemode;
import dev.minhh2792.nemesis.commands.subcommands.GrantPermission;
import dev.minhh2792.nemesis.commands.subcommands.Kick;
import dev.minhh2792.nemesis.commands.subcommands.OP;
import dev.minhh2792.nemesis.commands.subcommands.PlayerList;
import dev.minhh2792.nemesis.commands.subcommands.PluginList;
import dev.minhh2792.nemesis.commands.subcommands.PluginManager;
import dev.minhh2792.nemesis.commands.subcommands.Reload;
import dev.minhh2792.nemesis.commands.subcommands.SetFlying;
import dev.minhh2792.nemesis.commands.subcommands.SetInvulnerable;
import dev.minhh2792.nemesis.commands.subcommands.ServerInfo;
import dev.minhh2792.nemesis.commands.subcommands.Stop;
import dev.minhh2792.nemesis.commands.subcommands.Unban;
import dev.minhh2792.nemesis.commands.subcommands.Whitelist;
import dev.minhh2792.nemesis.commands.subcommands.WorldList;
import dev.minhh2792.nemesis.managers.CommandManager;

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
                new GrantPermission(),
                new Kick(),
                new OP(),
                new PlayerList(),
                new PluginList(),
                new PluginManager(),
                new Reload(),
                new ServerInfo(),
                new Stop(),
                new Unban(),
                new ClearInventory(),
                new GiveItem(),
                new SetFlying(),
                new SetInvulnerable(),
                new Whitelist(),
                new WorldList()).forEach(commandManager::registerSubCommand);
    }

    public static Nemesis getInstance() {
        return instance;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}