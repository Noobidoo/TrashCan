/*    */ package me.cain.commandbin.statistics;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import me.cain.commandbin.CommandBin;
/*    */ 
/*    */ public class Statistics
/*    */ {
/*    */   public static void StartStats()
/*    */   {
/* 14 */     String url = String.format("http://cain.donaghey.x10.mx/usage/counter.php", new Object[0]);
/*    */ 
/* 17 */     System.out.println(CommandBin.plugin.Plugin + "[Stats] Starting up CommandBin has been logged online!");
/*    */     try
/*    */     {
/* 20 */       new URL(url).openConnection().getInputStream();
/*    */     }
/*    */     catch (MalformedURLException e)
/*    */     {
/* 24 */       e.printStackTrace();
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 28 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.statistics.Statistics
 * JD-Core Version:    0.6.0
 */