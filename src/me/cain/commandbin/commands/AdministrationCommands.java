/*     */ package me.cain.commandbin.commands;
/*     */ 
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ 
/*     */ public class AdministrationCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*     */   {
/*  18 */     if (l.equalsIgnoreCase("cmdbin"))
/*     */     {
/*  20 */       if (args.length < 1)
/*     */       {
/*  22 */         if ((s instanceof Player))
/*     */         {
/*  24 */           ((Player)s).sendMessage(ChatColor.YELLOW + "+++++++++CommandBin++++++++++");
/*  25 */           ((Player)s).sendMessage(ChatColor.GREEN + "+ Over 60 commands in CommandBin!");
/*  26 */           ((Player)s).sendMessage(ChatColor.RED + "+ Version: " + CommandBin.plugin.getDescription().getVersion());
/*  27 */           ((Player)s).sendMessage(ChatColor.LIGHT_PURPLE + "+ Developer: " + CommandBin.plugin.getDescription().getAuthors());
/*  28 */           ((Player)s).sendMessage(ChatColor.YELLOW + "+++++++++++++++++++++++++++++");
/*     */         }
/*     */         else
/*     */         {
/*  32 */           s.sendMessage(ChatColor.YELLOW + "+++++++++CommandBin++++++++++");
/*  33 */           s.sendMessage(ChatColor.GREEN + "+ Over 60 commands in CommandBin!");
/*  34 */           s.sendMessage(ChatColor.RED + "+ Version: " + CommandBin.plugin.getDescription().getVersion());
/*  35 */           s.sendMessage(ChatColor.LIGHT_PURPLE + "+ Developer: " + CommandBin.plugin.getDescription().getAuthors());
/*  36 */           s.sendMessage(ChatColor.YELLOW + "+++++++++++++++++++++++++++++");
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  41 */         if (args[0].equalsIgnoreCase("reload"))
/*     */         {
/*  43 */           if ((s instanceof Player))
/*     */           {
/*  45 */             if (CommandBin.plugin.pCheck((Player)s, "CommandBin.admin.reload"))
/*     */             {
/*  47 */               CommandBin.plugin.reloadConfig();
/*  48 */               ((Player)s).sendMessage(ChatColor.GREEN + "CommandBin Configuration Reloaded!");
/*     */             }
/*     */             else
/*     */             {
/*  53 */               ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/*  58 */             CommandBin.plugin.reloadConfig();
/*  59 */             s.sendMessage(ChatColor.GREEN + "CommandBin Configuration Reloaded!");
/*     */           }
/*     */         }
/*     */ 
/*  63 */         if (args[0].equalsIgnoreCase("credits"))
/*     */         {
/*  65 */           if ((s instanceof Player))
/*     */           {
/*  67 */             ((Player)s).sendMessage(ChatColor.YELLOW + " - CommandBin Credits");
/*  68 */             ((Player)s).sendMessage(ChatColor.GREEN + "Author/Developer/Coder: CainFoool");
/*  69 */             ((Player)s).sendMessage(ChatColor.RED + "Tester/Debugger: vicente947");
/*     */           }
/*     */           else
/*     */           {
/*  73 */             s.sendMessage(ChatColor.YELLOW + " - CommandBin Credits");
/*  74 */             s.sendMessage(ChatColor.GREEN + "Author/Developer/Coder: CainFoool");
/*  75 */             s.sendMessage(ChatColor.RED + "Tester/Debugger: vicente947");
/*     */           }
/*     */         }
/*     */ 
/*  79 */         if (args[0].equalsIgnoreCase("debug"))
/*     */         {
/*  81 */           if ((s instanceof Player))
/*     */           {
/*  83 */             if (CommandBin.plugin.pCheck((Player)s, "CommandBin.admin.debug"))
/*     */             {
/*  85 */               Runtime rt = Runtime.getRuntime();
/*  86 */               double max = Math.floor(rt.maxMemory() / 1024.0D / 1024.0D);
/*  87 */               double free = Math.floor(rt.freeMemory() / 1024.0D / 1024.0D);
/*  88 */               ((Player)s).sendMessage(ChatColor.RED + free + " / " + max + " memory available");
/*     */             }
/*     */             else
/*     */             {
/*  92 */               ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/*  97 */             Runtime rt = Runtime.getRuntime();
/*  98 */             double max = Math.floor(rt.maxMemory() / 1024.0D / 1024.0D);
/*  99 */             double free = Math.floor(rt.freeMemory() / 1024.0D / 1024.0D);
/* 100 */             s.sendMessage(ChatColor.RED + free + " / " + max + " memory available");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 106 */     if (l.equalsIgnoreCase("shutdown"))
/*     */     {
/* 108 */       if ((s instanceof Player))
/*     */       {
/* 110 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.admin.shutdown"))
/*     */         {
/* 112 */           Bukkit.getServer().broadcastMessage(ChatColor.RED + "Server is going down!");
/* 113 */           Bukkit.getServer().shutdown();
/*     */         }
/*     */         else
/*     */         {
/* 117 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 122 */         Bukkit.getServer().broadcastMessage(ChatColor.RED + "Console initiated shutdown, shutting down server!");
/* 123 */         Bukkit.getServer().shutdown();
/*     */       }
/*     */     }
/* 126 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.AdministrationCommands
 * JD-Core Version:    0.6.0
 */