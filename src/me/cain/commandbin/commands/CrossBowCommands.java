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
/*    */ public class CrossBowCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 16 */     if (l.equalsIgnoreCase("crossbow"))
/*    */     {
/* 18 */       if (args.length < 1)
/*    */       {
/* 20 */         if ((s instanceof Player))
/*    */         {
/* 22 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*    */         }
/*    */         else
/*    */         {
/* 26 */           s.sendMessage("/crossbow [on/off]");
/*    */         }
/*    */ 
/*    */       }
/* 31 */       else if ((s instanceof Player))
/*    */       {
/* 33 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.crossbow"))
/*    */         {
/* 35 */           if (args[0].equalsIgnoreCase("on"))
/*    */           {
/* 37 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".crossbow", Boolean.valueOf(true));
/* 38 */             ((Player)s).sendMessage(ChatColor.AQUA + "Crossbow enabled!");
/* 39 */             ((Player)s).sendMessage("Shoot with a bow!");
/* 40 */             CommandBin.plugin.saveConfig();
/*    */           }
/* 42 */           if (args[0].equalsIgnoreCase("off"))
/*    */           {
/* 44 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".crossbow", Boolean.valueOf(false));
/* 45 */             ((Player)s).sendMessage(ChatColor.RED + "Crossbow disabled!");
/* 46 */             CommandBin.plugin.saveConfig();
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* 51 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 56 */         s.sendMessage(ChatColor.RED + "You can't use the crossbow in-console!");
/*    */       }
/*    */     }
/*    */ 
/* 60 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.CrossBowCommands
 * JD-Core Version:    0.6.0
 */