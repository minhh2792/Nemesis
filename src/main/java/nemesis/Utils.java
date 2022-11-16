package nemesis;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
                if (e.getMessage() != null) {
                    sender.sendMessage(colorize("&c" + e.getMessage()));
                }
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

    public static String getPublicIP() {
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            Scanner sc = new Scanner(whatismyip.openStream());
            String ip = sc.next();
            sc.close();
            return ip;
        } catch (Exception e) {
            return "Error getting public IP!";
        }
    }

    public static List<String> getLinuxUsers() {
        List<String> users = new ArrayList<String>();
        try {
            Process p = Runtime.getRuntime().exec("cut -d: -f1 /etc/passwd");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                users.add(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return users;
    }

    public static List<String> getWindowsUsers() {
        List<String> users = new ArrayList<String>();
        try {
            Process p = Runtime.getRuntime().exec("net user");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("User accounts for")) {
                    continue;
                }
                if (line.contains("-------------------------------------------------------------------------------")) {
                    continue;
                }
                if (line.contains("The command completed successfully.")) {
                    continue;
                }
                users.add(line);
            }
            sc.close();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return users;
    }

    public static boolean isLinux() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("nix") || os.contains("nux") || os.contains("aix");
    }

    public static boolean hasRootAccess() {
        try {
            Process p = Runtime.getRuntime().exec("sudo -l");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("may run the following commands on")) {
                    sc.close();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static String getLinuxUser() {
        try {
            Process p = Runtime.getRuntime().exec("whoami");
            Scanner sc = new Scanner(p.getInputStream());
            String user = sc.nextLine();
            sc.close();
            return user;
        } catch (Exception e) {
            return "Error getting linux user!";
        }
    }
}
