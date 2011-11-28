/*    */ package me.cain.commandbin.statistics;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import java.net.URLEncoder;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.PluginDescriptionFile;
/*    */ 
/*    */ class Pinger
/*    */   implements Runnable
/*    */ {
/*    */   private Plugin plugin;
/*    */   private String guid;
/*    */   private Logger logger;
/*    */ 
/*    */   public Pinger(Plugin plugin, String guid, Logger theLogger)
/*    */   {
/* 79 */     this.plugin = plugin;
/* 80 */     this.guid = guid;
/* 81 */     this.logger = theLogger;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 86 */     pingServer();
/*    */   }
/*    */ 
/*    */   private void pingServer()
/*    */   {
/* 92 */     String authors = "";
/*    */     try
/*    */     {
/* 97 */       for (String auth : this.plugin.getDescription().getAuthors())
/*    */       {
/* 99 */         authors = authors + " " + auth;
/*    */       }
/* 101 */       authors = authors.trim();
/*    */ 
/* 103 */       String url = String.format("http://pluginstats.randomappdev.com/ping.aspx?snam=%s&sprt=%s&shsh=%s&sver=%s&spcnt=%s&pnam=%s&pmcla=%s&paut=%s&pweb=%s&pver=%s", new Object[] { 
/* 104 */         URLEncoder.encode(this.plugin.getServer().getServerName(), "UTF-8"), 
/* 105 */         Integer.valueOf(this.plugin.getServer().getPort()), 
/* 106 */         this.guid, 
/* 107 */         URLEncoder.encode(Bukkit.getVersion(), "UTF-8"), 
/* 108 */         Integer.valueOf(this.plugin.getServer().getOnlinePlayers().length), 
/* 109 */         URLEncoder.encode(this.plugin.getDescription().getName(), "UTF-8"), 
/* 110 */         URLEncoder.encode(this.plugin.getDescription().getMain(), "UTF-8"), 
/* 111 */         URLEncoder.encode(authors, "UTF-8"), 
/* 112 */         URLEncoder.encode(this.plugin.getDescription().getWebsite(), "UTF-8"), 
/* 113 */         URLEncoder.encode(this.plugin.getDescription().getVersion(), "UTF-8") });
/*    */ 
/* 115 */       new URL(url).openConnection().getInputStream();
/* 116 */       this.logger.log(Level.INFO, "PluginStats pinged the central server.");
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 121 */       this.logger.log(Level.SEVERE, ex.getStackTrace().toString());
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.statistics.Pinger
 * JD-Core Version:    0.6.0
 */