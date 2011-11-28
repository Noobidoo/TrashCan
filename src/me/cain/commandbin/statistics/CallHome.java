package me.cain.commandbin.statistics;

import java.io.File;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitScheduler;

public class CallHome
{
  private static final File configFile = new File("plugins/PluginStats/config.yml");
  private static final String logFile = "plugins/PluginStats/log.txt";
  private static final YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
  private static Logger logger = null;

  public static void init(Plugin plugin)
  {
    if ((configExists().booleanValue()) && (logExists().booleanValue()) && (!config.getBoolean("opt-out")))
    {
      plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Pinger(plugin, config.getString("guid"), logger), 10L, 1728000L);
      System.out.println("[" + plugin.getDescription().getName() + "] Stats are being kept for this plugin. To opt-out for any reason, check plugins/PluginStats/config.yml");
    }
  }

  private static Boolean configExists()
  {
    config.addDefault("opt-out", Boolean.valueOf(false));
    config.addDefault("guid", UUID.randomUUID().toString());
    if ((!configFile.exists()) || (config.get("hash", null) == null))
    {
      System.out.println("PluginStats is initializing for the first time. To opt-out for any reason check plugins/PluginStats/config.yml");
      try
      {
        config.options().copyDefaults(true);
        config.save(configFile);
      }
      catch (Exception ex) {
        System.out.println("Error creating PluginStats configuration file.");
        ex.printStackTrace();
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(true);
  }

  private static Boolean logExists()
  {
    try
    {
      FileHandler handler = new FileHandler("plugins/PluginStats/log.txt", true);
      logger = Logger.getLogger("com.randomappdev");
      logger.setUseParentHandlers(false);
      logger.addHandler(handler);
    }
    catch (Exception ex) {
      System.out.println("Error creating PluginStats log file.");
      ex.printStackTrace();
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}