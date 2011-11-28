/*     */ package me.cain.commandbin.commands;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class ModerationCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*     */   {
/*  26 */     if (l.equalsIgnoreCase("kick"))
/*     */     {
/*  28 */       if (args.length < 2)
/*     */       {
/*  30 */         if ((s instanceof Player))
/*     */         {
/*  32 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/*  36 */           s.sendMessage("/kick [player] [reason]");
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  42 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  43 */         if ((s instanceof Player))
/*     */         {
/*  45 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.kick"))
/*     */           {
/*  47 */             if (target != null)
/*     */             {
/*  49 */               target.kickPlayer(args[1].toString());
/*  50 */               if (CommandBin.plugin.getConfig().get("settings.broadcastkick").equals(Boolean.valueOf(true)))
/*     */               {
/*  52 */                 Bukkit.getServer().broadcastMessage(ChatColor.RED + ((Player)s).getName() + " has kicked " + target.getName());
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/*  57 */               ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/*  62 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */           }
/*     */ 
/*     */         }
/*  67 */         else if (target != null)
/*     */         {
/*  69 */           target.kickPlayer(args[1]);
/*  70 */           if (CommandBin.plugin.getConfig().get("settings.broadcastkick").equals(Boolean.valueOf(true)))
/*     */           {
/*  72 */             Bukkit.getServer().broadcastMessage(ChatColor.RED + ((Player)s).getName() + " has kicked " + target.getName());
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  77 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  83 */     if (l.equalsIgnoreCase("ban"))
/*     */     {
/*  85 */       if (args.length < 2)
/*     */       {
/*  87 */         if ((s instanceof Player))
/*     */         {
/*  89 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [reason]");
/*     */         }
/*     */         else
/*     */         {
/*  93 */           s.sendMessage("/ban [player] [reason]");
/*     */         }
/*     */ 
/*     */       }
/*  98 */       else if ((s instanceof Player))
/*     */       {
/* 100 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.ban"))
/*     */         {
/* 102 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 103 */           if (target != null)
/*     */           {
/* 105 */             ((Player)s).sendMessage("You banned " + target.getName());
/* 106 */             target.kickPlayer(args[1]);
/* 107 */             CommandBin.plugin.getConfig().set(target.getName() + ".banned", Boolean.valueOf(true));
/* 108 */             CommandBin.plugin.getConfig().set(target.getName() + ".banreason", args[1]);
/* 109 */             CommandBin.plugin.saveConfig();
/*     */           }
/*     */           else
/*     */           {
/* 113 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 118 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 123 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 124 */         if (target != null)
/*     */         {
/* 126 */           s.sendMessage("You banned " + target.getName());
/* 127 */           target.kickPlayer(args[1]);
/* 128 */           CommandBin.plugin.getConfig().set(target.getName() + ".banned", Boolean.valueOf(true));
/* 129 */           CommandBin.plugin.getConfig().set(target.getName() + ".banreason", args[1]);
/* 130 */           CommandBin.plugin.saveConfig();
/*     */         }
/*     */         else
/*     */         {
/* 134 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 140 */     if (l.equalsIgnoreCase("unban"))
/*     */     {
/* 142 */       if (args.length < 1)
/*     */       {
/* 144 */         if ((s instanceof Player))
/*     */         {
/* 146 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 150 */           s.sendMessage("/unban [player]");
/*     */         }
/*     */ 
/*     */       }
/* 155 */       else if ((s instanceof Player))
/*     */       {
/* 157 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.unban"))
/*     */         {
/* 159 */           ((Player)s).sendMessage(ChatColor.GREEN + ((Player)s).getName() + " successfully unbanned " + args[0] + "!");
/* 160 */           CommandBin.plugin.getConfig().set(args[0] + ".banned", Boolean.valueOf(false));
/* 161 */           CommandBin.plugin.getConfig().set(args[0] + ".banreason", null);
/* 162 */           CommandBin.plugin.saveConfig();
/*     */         }
/*     */         else
/*     */         {
/* 166 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 171 */         s.sendMessage(ChatColor.GREEN + "Unbanned " + args[0] + "!");
/* 172 */         CommandBin.plugin.getConfig().set(args[0] + ".banned", Boolean.valueOf(false));
/* 173 */         CommandBin.plugin.saveConfig();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 178 */     if (l.equalsIgnoreCase("freeze"))
/*     */     {
/* 180 */       if (args.length < 1)
/*     */       {
/* 182 */         if ((s instanceof Player))
/*     */         {
/* 184 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 188 */           s.sendMessage("/freeze [player]");
/*     */         }
/*     */ 
/*     */       }
/* 193 */       else if ((s instanceof Player))
/*     */       {
/* 195 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.freeze"))
/*     */         {
/* 197 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 198 */           if (target != null)
/*     */           {
/* 200 */             CommandBin.plugin.getConfig().set(target.getName() + ".frozen", Boolean.valueOf(true));
/* 201 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + " has been frozen!");
/* 202 */             target.sendMessage(ChatColor.GREEN + "You have been frozen by " + ((Player)s).getName());
/* 203 */             CommandBin.plugin.saveConfig();
/*     */           }
/*     */           else
/*     */           {
/* 207 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 212 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 217 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 218 */         if (target != null)
/*     */         {
/* 220 */           CommandBin.plugin.getConfig().set(target.getName() + ".frozen", Boolean.valueOf(true));
/* 221 */           s.sendMessage(ChatColor.GREEN + "You froze " + target.getName());
/* 222 */           CommandBin.plugin.saveConfig();
/*     */         }
/*     */         else
/*     */         {
/* 226 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 232 */     if (l.equalsIgnoreCase("unfreeze"))
/*     */     {
/* 234 */       if (args.length < 1)
/*     */       {
/* 236 */         if ((s instanceof Player))
/*     */         {
/* 238 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 242 */           s.sendMessage("/unfreeze [player]");
/*     */         }
/*     */ 
/*     */       }
/* 247 */       else if ((s instanceof Player))
/*     */       {
/* 249 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.freeze"))
/*     */         {
/* 251 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 252 */           if (target != null)
/*     */           {
/* 254 */             CommandBin.plugin.getConfig().set(target.getName() + ".frozen", Boolean.valueOf(false));
/* 255 */             ((Player)s).sendMessage(ChatColor.GREEN + "You have unfrozen " + target.getName());
/* 256 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " has unfrozen you.");
/* 257 */             CommandBin.plugin.saveConfig();
/*     */           }
/*     */           else
/*     */           {
/* 261 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 266 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 271 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 272 */         if (target != null)
/*     */         {
/* 274 */           CommandBin.plugin.getConfig().set(target.getName() + ".frozen", Boolean.valueOf(false));
/* 275 */           CommandBin.plugin.saveConfig();
/* 276 */           s.sendMessage(ChatColor.GREEN + "You have unfrozen " + target.getName());
/*     */         }
/*     */         else
/*     */         {
/* 280 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 286 */     if (l.equalsIgnoreCase("handicap"))
/*     */     {
/* 288 */       if (args.length < 1)
/*     */       {
/* 290 */         if ((s instanceof Player))
/*     */         {
/* 292 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 296 */           s.sendMessage("/handicap [player]");
/*     */         }
/*     */ 
/*     */       }
/* 301 */       else if ((s instanceof Player))
/*     */       {
/* 303 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.handicap"))
/*     */         {
/* 305 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 306 */           if (target != null)
/*     */           {
/* 308 */             CommandBin.plugin.getConfig().set(target.getName() + ".handicapped", Boolean.valueOf(true));
/* 309 */             CommandBin.plugin.saveConfig();
/* 310 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + " has been handicapped!");
/* 311 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " handicapped you!");
/*     */           }
/*     */           else
/*     */           {
/* 315 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 320 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 325 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 326 */         if (target != null)
/*     */         {
/* 328 */           CommandBin.plugin.getConfig().set(target.getName() + ".handicapped", Boolean.valueOf(true));
/* 329 */           CommandBin.plugin.saveConfig();
/* 330 */           s.sendMessage(ChatColor.GREEN + "You have disabled " + target.getName() + "'s usage of commands!");
/*     */         }
/*     */         else
/*     */         {
/* 334 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 340 */     if (l.equalsIgnoreCase("unhandicap"))
/*     */     {
/* 342 */       if (args.length < 1)
/*     */       {
/* 344 */         if ((s instanceof Player))
/*     */         {
/* 346 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 350 */           s.sendMessage("/unhandicap [player]");
/*     */         }
/*     */ 
/*     */       }
/* 355 */       else if ((s instanceof Player))
/*     */       {
/* 357 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.handicap"))
/*     */         {
/* 359 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 360 */           if (target != null)
/*     */           {
/* 362 */             CommandBin.plugin.getConfig().set(target.getName() + ".handicapped", Boolean.valueOf(false));
/* 363 */             CommandBin.plugin.saveConfig();
/* 364 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + " has been unhandicapped!");
/* 365 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " unhanddicapped you!");
/*     */           }
/*     */           else
/*     */           {
/* 369 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 374 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 379 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 380 */         if (target != null)
/*     */         {
/* 382 */           CommandBin.plugin.getConfig().set(target.getName() + ".handicapped", Boolean.valueOf(false));
/* 383 */           CommandBin.plugin.saveConfig();
/* 384 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 390 */     if (l.equalsIgnoreCase("mute"))
/*     */     {
/* 392 */       if (args.length < 1)
/*     */       {
/* 394 */         if ((s instanceof Player))
/*     */         {
/* 396 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 400 */           s.sendMessage("/mute [player]");
/*     */         }
/*     */ 
/*     */       }
/* 405 */       else if ((s instanceof Player))
/*     */       {
/* 407 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.mute"))
/*     */         {
/* 409 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 410 */           if (target != null)
/*     */           {
/* 412 */             CommandBin.plugin.getConfig().set(target.getName() + ".muted", Boolean.valueOf(true));
/* 413 */             ((Player)s).sendMessage(ChatColor.GREEN + "You have muted " + target.getName());
/* 414 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " has muted you!");
/* 415 */             CommandBin.plugin.saveConfig();
/*     */           }
/*     */           else
/*     */           {
/* 419 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 424 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 429 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 430 */         if (target != null)
/*     */         {
/* 432 */           CommandBin.plugin.getConfig().set(target.getName() + ".muted", Boolean.valueOf(true));
/* 433 */           s.sendMessage(ChatColor.GREEN + "You muted " + target.getName() + "!");
/* 434 */           CommandBin.plugin.saveConfig();
/*     */         }
/*     */         else
/*     */         {
/* 438 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 444 */     if (l.equalsIgnoreCase("unmute"))
/*     */     {
/* 447 */       if (args.length < 1)
/*     */       {
/* 449 */         if ((s instanceof Player))
/*     */         {
/* 451 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 455 */           s.sendMessage("/unmute [player]");
/*     */         }
/*     */ 
/*     */       }
/* 460 */       else if ((s instanceof Player))
/*     */       {
/* 462 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.unmute"))
/*     */         {
/* 464 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 465 */           if (target != null)
/*     */           {
/* 467 */             CommandBin.plugin.getConfig().set(target.getName() + ".muted", Boolean.valueOf(false));
/* 468 */             CommandBin.plugin.saveConfig();
/* 469 */             ((Player)s).sendMessage(ChatColor.GREEN + "You have unmuted " + target.getName());
/* 470 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " has unmuted you!");
/*     */           }
/*     */           else
/*     */           {
/* 474 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 479 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 484 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 485 */         if (target != null)
/*     */         {
/* 487 */           CommandBin.plugin.getConfig().set(target.getName() + ".muted", Boolean.valueOf(false));
/* 488 */           CommandBin.plugin.saveConfig();
/* 489 */           s.sendMessage(ChatColor.GREEN + "You unmuted " + target.getName());
/*     */         }
/*     */         else
/*     */         {
/* 493 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 499 */     if (l.equalsIgnoreCase("who"))
/*     */     {
/* 501 */       if (args.length < 1)
/*     */       {
/* 503 */         if ((s instanceof Player))
/*     */         {
/* 505 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 509 */           s.sendMessage("/who [player]");
/*     */         }
/*     */ 
/*     */       }
/* 514 */       else if ((s instanceof Player))
/*     */       {
/* 516 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.who"))
/*     */         {
/* 518 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 519 */           if (target != null)
/*     */           {
/* 521 */             ((Player)s).sendMessage(ChatColor.AQUA + "Information on: " + target.getDisplayName());
/* 522 */             ((Player)s).sendMessage(ChatColor.GREEN + "Real Name: " + ChatColor.WHITE + target.getName());
/* 523 */             ((Player)s).sendMessage(ChatColor.GREEN + "Current World: " + ChatColor.WHITE + target.getWorld().getName());
/* 524 */             ((Player)s).sendMessage(ChatColor.GREEN + "IP Address: " + ChatColor.WHITE + target.getAddress());
/* 525 */             ((Player)s).sendMessage(ChatColor.GREEN + "Hostname: " + ChatColor.WHITE + target.getAddress().getHostName());
/* 526 */             ((Player)s).sendMessage(ChatColor.GREEN + "Co-Ordinates: " + ChatColor.RED + target.getLocation().getX() + ", " + target.getLocation().getY() + ", " + target.getLocation().getZ());
/* 527 */             if (!CommandBin.plugin.getServer().getVersion().contains("1337"))
/*     */             {
/* 529 */               ((Player)s).sendMessage("This server is not using the RB version of CraftBukkit. (1337)");
/*     */             }
/*     */             else
/*     */             {
/* 533 */               ((Player)s).sendMessage("This server is using the RB version of CraftBukkit (1337)");
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 538 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 543 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 548 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 549 */         if (target != null)
/*     */         {
/* 551 */           s.sendMessage(ChatColor.AQUA + "Information on: " + target.getDisplayName());
/* 552 */           s.sendMessage(ChatColor.GREEN + "Real Name: " + ChatColor.WHITE + target.getName());
/* 553 */           s.sendMessage(ChatColor.GREEN + "Current World: " + ChatColor.WHITE + target.getWorld().getName());
/* 554 */           s.sendMessage(ChatColor.GREEN + "IP Address: " + ChatColor.WHITE + target.getAddress());
/* 555 */           s.sendMessage(ChatColor.GREEN + "Hostname: " + ChatColor.WHITE + target.getAddress().getHostName());
/* 556 */           s.sendMessage(ChatColor.GREEN + "Co-Ordinates: " + ChatColor.RED + target.getLocation().getX() + ", " + target.getLocation().getY() + ", " + target.getLocation().getZ());
/* 557 */           if (!CommandBin.plugin.getServer().getVersion().contains("1337"))
/*     */           {
/* 559 */             s.sendMessage("This server is not using the RB version of CraftBukkit. (1337)");
/*     */           }
/*     */           else
/*     */           {
/* 563 */             s.sendMessage("This server is using the RB version of CraftBukkit (1337)");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 568 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 574 */     if (l.equalsIgnoreCase("paid"))
/*     */     {
/* 576 */       if (args.length < 1)
/*     */       {
/* 578 */         if ((s instanceof Player))
/*     */         {
/* 580 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 584 */           s.sendMessage("/paid [player]");
/*     */         }
/*     */ 
/*     */       }
/* 589 */       else if ((s instanceof Player))
/*     */       {
/* 591 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.paid"))
/*     */         {
/* 593 */           ((Player)s).sendMessage(ChatColor.GREEN + args[0] + " has paid: ");
/* 594 */           hasPaid(s, args[0].toString());
/*     */         }
/*     */         else
/*     */         {
/* 598 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 603 */         s.sendMessage(ChatColor.GREEN + args[0] + " has paid: ");
/* 604 */         hasPaid(s, args[0].toString());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 609 */     if (l.equalsIgnoreCase("banip"))
/*     */     {
/* 611 */       if (args.length < 1)
/*     */       {
/* 613 */         if ((s instanceof Player))
/*     */         {
/* 615 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*     */         }
/*     */         else
/*     */         {
/* 619 */           s.sendMessage("/banip [player]");
/*     */         }
/*     */ 
/*     */       }
/* 624 */       else if ((s instanceof Player))
/*     */       {
/* 626 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.banip"))
/*     */         {
/* 628 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 629 */           if (target != null)
/*     */           {
/* 631 */             String ip2 = target.getAddress().getAddress().getHostAddress().toString();
/* 632 */             String ipworking = ip2.replace(".", "");
/*     */ 
/* 634 */             CommandBin.plugin.getConfig().set("bannedips." + ipworking, Boolean.valueOf(true));
/* 635 */             CommandBin.plugin.saveConfig();
/* 636 */             target.kickPlayer("Your IP address has been banned!");
/* 637 */             ((Player)s).sendMessage(ChatColor.GREEN + "IP " + target.getAddress() + " has been banned!");
/*     */           }
/*     */           else
/*     */           {
/* 641 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 646 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 651 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 652 */         if (target != null)
/*     */         {
/* 654 */           String ip2 = target.getAddress().getAddress().getHostAddress().toString();
/* 655 */           String ipworking = ip2.replace(".", "");
/*     */ 
/* 657 */           CommandBin.plugin.getConfig().set("bannedips." + ipworking, Boolean.valueOf(true));
/* 658 */           CommandBin.plugin.saveConfig();
/* 659 */           target.kickPlayer("Your IP address has been banned!");
/* 660 */           s.sendMessage(ChatColor.GREEN + "IP " + target.getAddress() + " has been banned!");
/*     */         }
/*     */         else
/*     */         {
/* 664 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 670 */     if (l.equalsIgnoreCase("unbanip"))
/*     */     {
/* 672 */       if (args.length < 1)
/*     */       {
/* 674 */         if ((s instanceof Player))
/*     */         {
/* 676 */           ((Player)s).sendMessage("/" + l.toString() + " [ip]");
/*     */         }
/*     */         else
/*     */         {
/* 680 */           s.sendMessage("/unbanip [ip]");
/*     */         }
/*     */ 
/*     */       }
/* 685 */       else if ((s instanceof Player))
/*     */       {
/* 687 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.unbanip"))
/*     */         {
/* 689 */           CommandBin.plugin.getConfig().set("bannedips." + args[0], Boolean.valueOf(false));
/* 690 */           ((Player)s).sendMessage(ChatColor.GREEN + "IP " + args[0] + " unbanned!");
/* 691 */           CommandBin.plugin.saveConfig();
/*     */         }
/*     */         else
/*     */         {
/* 695 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 700 */         CommandBin.plugin.getConfig().set("bannedips." + args[0], Boolean.valueOf(false));
/* 701 */         s.sendMessage(ChatColor.GREEN + "IP \"" + args[0] + "\" unbanned!");
/* 702 */         CommandBin.plugin.saveConfig();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 707 */     return false;
/*     */   }
/*     */ 
/*     */   public void hasPaid(Player p, String user)
/*     */   {
/*     */     try {
/* 713 */       URL url = new URL("http://minecraft.net/haspaid.jsp?user=" + user);
/*     */ 
/* 715 */       BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
/*     */       String str;
/* 717 */       while ((str = in.readLine()) != null)
/*     */       {
/*     */         String str;
/* 718 */         p.sendMessage(str);
/*     */       }
/* 720 */       in.close();
/*     */     } catch (MalformedURLException localMalformedURLException) {
/*     */     }
/*     */     catch (IOException localIOException) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void hasPaid(CommandSender p, String user) {
/*     */     try {
/* 729 */       URL url = new URL("http://minecraft.net/haspaid.jsp?user=" + user);
/*     */ 
/* 731 */       BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
/*     */       String str;
/* 733 */       while ((str = in.readLine()) != null)
/*     */       {
/*     */         String str;
/* 734 */         p.sendMessage(str);
/*     */       }
/* 736 */       in.close();
/*     */     }
/*     */     catch (MalformedURLException localMalformedURLException)
/*     */     {
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.ModerationCommands
 * JD-Core Version:    0.6.0
 */