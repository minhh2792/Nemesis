package nemesis;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class Utils {

    private static final Nemesis main = Nemesis.getInstance();

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', "&8[&e&l!&8] " + message);
    }

    public static List<String> colorize(List<String> message) {
        ArrayList<String> newList = new ArrayList<String>();
        message.forEach(msg -> newList.add(colorize(msg)));

        return newList;
    }

    public static void runAsync(Runnable runnable) {
        main.getServer().getScheduler().runTaskAsynchronously(main,
                runnable);
    }

    public static Player getPlayerExact(String name) {
        return main.getServer().getPlayerExact(name);
    }

    public static Player getFromUUID(String uuid) {
        return main.getServer().getPlayer(uuid);
    }

    public static Plugin getFromString(String name) {
        return main.getServer().getPluginManager().getPlugin(name);
    }

    public static void downloadFile(CommandSender sender, String url, String fileName, String path) {
        runAsync(() -> {
            try {
                sender.sendMessage(colorize("&aDownloading " + fileName + " from " + url + " to " + path));
                InputStream in = new URL(url).openStream();
                FileOutputStream fos = new FileOutputStream(path + "/" + fileName);
                BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
                byte[] data = new byte[1024];
                int x = 0;
                while ((x = in.read(data, 0, 1024)) >= 0) {
                    bout.write(data, 0, x);
                }
                bout.close();
                in.close();
                sender.sendMessage(colorize("&aDownloaded " + fileName + " from " + url + " to " + path));
            } catch (Exception e) {
                sender.sendMessage(colorize("&cError downloading file!"));
                sender.sendMessage(colorize("&c" + e.getMessage()));
            }
        });
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
