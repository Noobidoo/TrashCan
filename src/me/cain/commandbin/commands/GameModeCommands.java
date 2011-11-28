/*     */ package me.cain.commandbin.commands;
/*     */ 
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class GameModeCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*     */   {
/*  19 */     if (l.equalsIgnoreCase("creative"))
/*     */     {
/*  21 */       if (args.length < 1)
/*     */       {
/*  23 */         if ((s instanceof Player))
/*     */         {
/*  25 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.creative"))
/*     */           {
/*  27 */             ((Player)s).setGameMode(GameMode.CREATIVE);
/*  28 */             ((Player)s).sendMessage(ChatColor.GREEN + "You gamemode is now creative!");
/*     */           }
/*     */           else
/*     */           {
/*  32 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  37 */           s.sendMessage("/creative [player]");
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  43 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*     */ 
/*  45 */         if ((s instanceof Player))
/*     */         {
/*  47 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.creative.others"))
/*     */           {
/*  49 */             if (target != null)
/*     */             {
/*  51 */               target.setGameMode(GameMode.CREATIVE);
/*  52 */               ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + "'s gamemode is now Creative!");
/*     */             }
/*     */             else
/*     */             {
/*  56 */               ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/*  61 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */           }
/*     */ 
/*     */         }
/*  66 */         else if (target != null)
/*     */         {
/*  68 */           target.setGameMode(GameMode.CREATIVE);
/*  69 */           s.sendMessage(ChatColor.GREEN + target.getName() + "'s gamemode is now creative!");
/*     */         }
/*     */         else
/*     */         {
/*  73 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  79 */     if (l.equalsIgnoreCase("survival"))
/*     */     {
/*  81 */       if (args.length < 1)
/*     */       {
/*  83 */         if ((s instanceof Player))
/*     */         {
/*  85 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.survival"))
/*     */           {
/*  87 */             ((Player)s).setGameMode(GameMode.SURVIVAL);
/*  88 */             ((Player)s).sendMessage(ChatColor.GREEN + "Your gamemode is now survival!");
/*     */           }
/*     */           else
/*     */           {
/*  92 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  97 */           s.sendMessage("/survival [player]");
/*     */         }
/*     */ 
/*     */       }
/* 102 */       else if ((s instanceof Player))
/*     */       {
/* 104 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.survival.others"))
/*     */         {
/* 106 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 107 */           if (target != null)
/*     */           {
/* 109 */             target.setGameMode(GameMode.SURVIVAL);
/* 110 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + "'s gamemode is now Survival!");
/*     */           }
/*     */           else
/*     */           {
/* 114 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 119 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 124 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 125 */         if (target != null)
/*     */         {
/* 127 */           target.setGameMode(GameMode.SURVIVAL);
/* 128 */           s.sendMessage(ChatColor.GREEN + target.getName() + "'s gamemode is now survival!");
/*     */         }
/*     */         else
/*     */         {
/* 132 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 137 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.GameModeCommands
 * JD-Core Version:    0.6.0
 */