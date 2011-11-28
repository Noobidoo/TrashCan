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
/*    */ public class TorchBowCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 15 */     if ((s instanceof Player))
/*    */     {
/* 17 */       if (l.equalsIgnoreCase("torchbow"))
/*    */       {
/* 19 */         if (args.length < 1)
/*    */         {
/* 21 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*    */         }
/* 25 */         else if (CommandBin.plugin.pCheck((Player)s, "Commandbin.general.torchbow"))
/*    */         {
/* 27 */           if (args[0].equalsIgnoreCase("on"))
/*    */           {
/* 29 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".torchbow", Boolean.valueOf(true));
/* 30 */             CommandBin.plugin.saveConfig();
/* 31 */             ((Player)s).sendMessage(ChatColor.GREEN + "Torchbow has been enabled.");
/* 32 */             ((Player)s).sendMessage(ChatColor.GREEN + "Shoot with a bow as normal!");
/*    */           }
/*    */ 
/* 35 */           if (args[0].equalsIgnoreCase("off"))
/*    */           {
/* 37 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".torchbow", Boolean.valueOf(false));
/* 38 */             CommandBin.plugin.saveConfig();
/* 39 */             ((Player)s).sendMessage(ChatColor.GREEN + "Torchbow has been disabled.");
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* 44 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 51 */       s.sendMessage(ChatColor.RED + "You can't use torchbow commands in-console!");
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.TorchBowCommands
 * JD-Core Version:    0.6.0
 */