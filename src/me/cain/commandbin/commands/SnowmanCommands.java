/*    */ package me.cain.commandbin.commands;
/*    */ 
/*    */ import me.cain.commandbin.CommandBin;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SnowmanCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 17 */     if ((s instanceof Player))
/*    */     {
/* 19 */       if (l.equalsIgnoreCase("snowman"))
/*    */       {
/* 21 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.snowman"))
/*    */         {
/* 23 */           CommandBin.plugin.getConfig().set(((Player)s).getName() + ".snowman", Boolean.valueOf(true));
/* 24 */           ((Player)s).sendMessage(ChatColor.GREEN + "You are now Frosty The Snowman! Start walking!");
/* 25 */           CommandBin.plugin.saveConfig();
/*    */         }
/*    */         else
/*    */         {
/* 29 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */ 
/* 33 */       if (l.equalsIgnoreCase("unsnowman"))
/*    */       {
/* 35 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.snowman"))
/*    */         {
/* 37 */           CommandBin.plugin.getConfig().set(((Player)s).getName() + ".snowman", Boolean.valueOf(false));
/* 38 */           ((Player)s).sendMessage(ChatColor.GREEN + "You are no longer Frosty The Snowman. :(");
/* 39 */           CommandBin.plugin.saveConfig();
/*    */         }
/*    */         else
/*    */         {
/* 43 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 49 */       s.sendMessage(ChatColor.RED + "You can't use snowman commands in-console!");
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.SnowmanCommands
 * JD-Core Version:    0.6.0
 */