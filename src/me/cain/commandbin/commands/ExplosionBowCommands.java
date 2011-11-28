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
/*    */ public class ExplosionBowCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 16 */     if (l.equalsIgnoreCase("explosionbow"))
/*    */     {
/* 18 */       if (args.length < 1)
/*    */       {
/* 20 */         if ((s instanceof Player))
/*    */         {
/* 22 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*    */         }
/*    */         else
/*    */         {
/* 26 */           s.sendMessage("/explosionbow [on/off]");
/*    */         }
/*    */ 
/*    */       }
/* 31 */       else if ((s instanceof Player))
/*    */       {
/* 33 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.explosionbow"))
/*    */         {
/* 35 */           if (args[0].equalsIgnoreCase("on"))
/*    */           {
/* 37 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".explosionbow", Boolean.valueOf(true));
/* 38 */             ((Player)s).sendMessage(ChatColor.AQUA + "Explosion Bow Enabled!");
/* 39 */             ((Player)s).sendMessage("Shoot with a bow as normal!");
/* 40 */             CommandBin.plugin.saveConfig();
/*    */           }
/*    */ 
/* 43 */           if (args[0].equalsIgnoreCase("off"))
/*    */           {
/* 45 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".explosionbow", Boolean.valueOf(false));
/* 46 */             ((Player)s).sendMessage(ChatColor.AQUA + "Explosion Bow Disabled!");
/* 47 */             CommandBin.plugin.saveConfig();
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* 52 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 57 */         s.sendMessage(ChatColor.RED + "You can't use the explosion bow in-console!");
/*    */       }
/*    */     }
/*    */ 
/* 61 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.ExplosionBowCommands
 * JD-Core Version:    0.6.0
 */