/*    */ package me.cain.commandbin.listeners;
/*    */ 
/*    */ import me.cain.commandbin.CommandBin;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.event.entity.EndermanPickupEvent;
/*    */ import org.bukkit.event.entity.EndermanPlaceEvent;
/*    */ import org.bukkit.event.entity.EntityListener;
/*    */ 
/*    */ public class EnderListener extends EntityListener
/*    */ {
/*    */   public void onEndermanPickup(EndermanPickupEvent e)
/*    */   {
/* 14 */     if (CommandBin.plugin.getConfig().getBoolean("settings.endermangriefing", false))
/*    */     {
/* 16 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void onEndermanPlace(EndermanPlaceEvent e)
/*    */   {
/* 23 */     if (CommandBin.plugin.getConfig().getBoolean("settings.endermangriefing", false))
/*    */     {
/* 25 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.listeners.EnderListener
 * JD-Core Version:    0.6.0
 */