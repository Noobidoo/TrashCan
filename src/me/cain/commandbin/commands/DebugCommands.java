/*    */ package me.cain.commandbin.commands;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class DebugCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 15 */     if (l.equalsIgnoreCase("ping"))
/*    */     {
/* 17 */       if ((s instanceof Player))
/*    */       {
/* 19 */         ((Player)s).sendMessage(ChatColor.GREEN + "Pong!");
/*    */       }
/*    */       else
/*    */       {
/* 23 */         s.sendMessage(ChatColor.GREEN + "PONG!");
/*    */       }
/*    */     }
/* 26 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.DebugCommands
 * JD-Core Version:    0.6.0
 */