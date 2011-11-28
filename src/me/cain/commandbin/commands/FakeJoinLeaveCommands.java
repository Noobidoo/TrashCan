/*    */ package me.cain.commandbin.commands;
/*    */ 
/*    */ import me.cain.commandbin.CommandBin;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class FakeJoinLeaveCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 18 */     if (l.equalsIgnoreCase("join"))
/*    */     {
/* 20 */       if ((s instanceof Player))
/*    */       {
/* 22 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.join"))
/*    */         {
/* 24 */           Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + ((Player)s).getName() + " has joined the game");
/*    */         }
/*    */         else
/*    */         {
/* 28 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 33 */         s.sendMessage(ChatColor.RED + "You can't use fake join/leave in-console!");
/*    */       }
/*    */     }
/*    */ 
/* 37 */     if (l.equalsIgnoreCase("leave"))
/*    */     {
/* 39 */       if ((s instanceof Player))
/*    */       {
/* 41 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.leave"))
/*    */         {
/* 43 */           Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + ((Player)s).getName() + " has left the game");
/*    */         }
/*    */         else
/*    */         {
/* 47 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 52 */         s.sendMessage(ChatColor.RED + "You can't use fake join/leave in-console!");
/*    */       }
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.FakeJoinLeaveCommands
 * JD-Core Version:    0.6.0
 */