/*    */ package me.cain.commandbin.statistics;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import java.util.UUID;
/*    */ import java.util.logging.FileHandler;
/*    */ import java.util.logging.Logger;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfigurationOptions;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class CallHome
/*    */ {
/* 18 */   private static final File configFile = new File("plugins/PluginStats/config.yml");
/*    */   private static final String logFile = "plugins/PluginStats/log.txt";
/* 20 */   private static final YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
/* 21 */   private static Logger logger = null;
/*    */ 
/*    */   public static void init(Plugin plugin)
/*    */   {
/* 25 */     if ((configExists().booleanValue()) && (logExists().booleanValue()) && (!config.getBoolean("opt-out")))
/*    */     {
/* 27 */       plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Pinger(plugin, config.getString("guid"), logger), 10L, 1728000L);
/* 28 */       System.out.println("[" + plugin.getDescription().getName() + "] Stats are being kept for this plugin. To opt-out for any reason, check plugins/PluginStats/config.yml");
/*    */     }
/*    */   }
/*    */ 
/*    */   private static Boolean configExists()
/*    */   {
/* 34 */     config.addDefault("opt-out", Boolean.valueOf(false));
/* 35 */     config.addDefault("guid", UUID.randomUUID().toString());
/* 36 */     if ((!configFile.exists()) || (config.get("hash", null) == null))
/*    */     {
/* 38 */       System.out.println("PluginStats is initializing for the first time. To opt-out for any reason check plugins/PluginStats/config.yml");
/*    */       try
/*    */       {
/* 41 */         config.options().copyDefaults(true);
/* 42 */         config.save(configFile);
/*    */       }
/*    */       catch (Exception ex) {
/* 45 */         System.out.println("Error creating PluginStats configuration file.");
/* 46 */         ex.printStackTrace();
/* 47 */         return Boolean.valueOf(false);
/*    */       }
/*    */     }
/* 50 */     return Boolean.valueOf(true);
/*    */   }
/*    */ 
/*    */   private static Boolean logExists()
/*    */   {
/*    */     try
/*    */     {
/* 57 */       FileHandler handler = new FileHandler("plugins/PluginStats/log.txt", true);
/* 58 */       logger = Logger.getLogger("com.randomappdev");
/* 59 */       logger.setUseParentHandlers(false);
/* 60 */       logger.addHandler(handler);
/*    */     }
/*    */     catch (Exception ex) {
/* 63 */       System.out.println("Error creating PluginStats log file.");
/* 64 */       ex.printStackTrace();
/* 65 */       return Boolean.valueOf(false);
/*    */     }
/* 67 */     return Boolean.valueOf(true);
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.statistics.CallHome
 * JD-Core Version:    0.6.0
 */