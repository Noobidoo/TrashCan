/*    */ package me.cain.commandbin.commands;
/*    */ 
/*    */ import me.cain.commandbin.CommandBin;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class WeatherCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 18 */     if (l.equalsIgnoreCase("sun"))
/*    */     {
/* 20 */       if ((s instanceof Player))
/*    */       {
/* 22 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.weather"))
/*    */         {
/* 24 */           ((Player)s).getWorld().setStorm(false);
/* 25 */           Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + ((Player)s).getName() + " has made the sun shine!");
/*    */         }
/*    */         else
/*    */         {
/* 29 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */ 
/*    */       }
/* 34 */       else if (args.length < 1)
/*    */       {
/* 36 */         s.sendMessage("/sun [world]");
/*    */       }
/* 40 */       else if (Bukkit.getServer().getWorld(args[0]) != null)
/*    */       {
/* 42 */         Bukkit.getServer().getWorld(args[0]).setStorm(false);
/* 43 */         Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Console has made the sun shine!");
/*    */       }
/*    */       else
/*    */       {
/* 47 */         s.sendMessage(ChatColor.RED + "This world does not exist.");
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 53 */     if (l.equalsIgnoreCase("rain"))
/*    */     {
/* 55 */       if ((s instanceof Player))
/*    */       {
/* 57 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.weather"))
/*    */         {
/* 59 */           ((Player)s).getWorld().setStorm(true);
/* 60 */           ((Player)s).getWorld().setThundering(true);
/* 61 */           Bukkit.getServer().broadcastMessage(ChatColor.GRAY + ((Player)s).getName() + " made it begin to rain!");
/*    */         }
/*    */         else
/*    */         {
/* 65 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */ 
/*    */       }
/* 70 */       else if (args.length < 1)
/*    */       {
/* 72 */         s.sendMessage("/rain [world]");
/*    */       }
/* 76 */       else if (Bukkit.getServer().getWorld(args[0]) != null)
/*    */       {
/* 78 */         Bukkit.getServer().getWorld(args[0]).setStorm(true);
/* 79 */         Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "Console has made the world begin to rain!");
/*    */       }
/*    */       else
/*    */       {
/* 83 */         s.sendMessage(ChatColor.RED + "This world does not exist.");
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 88 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.WeatherCommands
 * JD-Core Version:    0.6.0
 */