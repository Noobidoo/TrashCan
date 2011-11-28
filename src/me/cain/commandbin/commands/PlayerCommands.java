/*      */ package me.cain.commandbin.commands;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import me.cain.commandbin.CommandBin;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.ChatColor;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.Server;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.block.Block;
/*      */ import org.bukkit.block.BlockFace;
/*      */ import org.bukkit.command.Command;
/*      */ import org.bukkit.command.CommandExecutor;
/*      */ import org.bukkit.command.CommandSender;
/*      */ import org.bukkit.configuration.file.FileConfiguration;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.PlayerInventory;
/*      */ import org.bukkit.util.Vector;
/*      */ 
/*      */ public class PlayerCommands
/*      */   implements CommandExecutor
/*      */ {
/*      */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*      */   {
/*   22 */     if (l.equalsIgnoreCase("tp"))
/*      */     {
/*   24 */       if (args.length < 1)
/*      */       {
/*   26 */         if ((s instanceof Player))
/*      */         {
/*   28 */           s.sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/*   32 */           s.sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */ 
/*      */       }
/*   37 */       else if ((s instanceof Player))
/*      */       {
/*   39 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.tp"))
/*      */         {
/*   41 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*   42 */           if (target != null)
/*      */           {
/*   44 */             ((Player)s).teleport(target.getLocation());
/*   45 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported to " + target.getName());
/*      */           }
/*      */           else
/*      */           {
/*   49 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*   54 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */ 
/*      */       }
/*   59 */       else if (args.length < 2)
/*      */       {
/*   61 */         s.sendMessage("/tp [player] to [player]");
/*      */       }
/*      */       else
/*      */       {
/*   65 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*   66 */         Player target2 = Bukkit.getServer().getPlayer(args[1]);
/*   67 */         if ((target != null) && (target2 != null))
/*      */         {
/*   69 */           target.teleport(target2);
/*   70 */           s.sendMessage(ChatColor.GREEN + "Teleported" + target.getName() + " to " + target2.getName());
/*      */         }
/*      */         else
/*      */         {
/*   74 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*   81 */     if (l.equalsIgnoreCase("tphere"))
/*      */     {
/*   83 */       if (args.length < 1)
/*      */       {
/*   85 */         if ((s instanceof Player))
/*      */         {
/*   87 */           s.sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/*   91 */           s.sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */ 
/*      */       }
/*   96 */       else if ((s instanceof Player))
/*      */       {
/*   98 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.tphere"))
/*      */         {
/*  100 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*  101 */           if (target != null)
/*      */           {
/*  103 */             target.teleport(((Player)s).getLocation());
/*  104 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported " + target.getName() + " to you!");
/*  105 */             target.sendMessage(((Player)s).getName() + " teleported you!");
/*      */           }
/*      */           else
/*      */           {
/*  109 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  114 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  119 */         s.sendMessage(ChatColor.RED + "You can't teleport a player to you, you're console silly!");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  124 */     if (l.equalsIgnoreCase("tp2p"))
/*      */     {
/*  126 */       if (args.length < 2)
/*      */       {
/*  128 */         if ((s instanceof Player))
/*      */         {
/*  130 */           ((Player)s).sendMessage("/" + l.toString() + " [player] to [player]");
/*      */         }
/*      */         else
/*      */         {
/*  134 */           s.sendMessage("/tp [player] to [player]");
/*      */         }
/*      */ 
/*      */       }
/*  139 */       else if ((s instanceof Player))
/*      */       {
/*  141 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.tp2p"))
/*      */         {
/*  143 */           Player target1 = Bukkit.getServer().getPlayer(args[0]);
/*  144 */           Player target2 = Bukkit.getServer().getPlayer(args[1]);
/*  145 */           if ((target1 != null) && (target2 != null))
/*      */           {
/*  147 */             target1.teleport(target2.getLocation());
/*  148 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported " + target1.getName() + " to " + target2.getName());
/*  149 */             target1.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " teleported you to " + target2.getName());
/*  150 */             target2.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " teleported " + target1.getName() + " to you!");
/*      */           }
/*      */           else
/*      */           {
/*  154 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  159 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  164 */         Player target1 = Bukkit.getServer().getPlayer(args[0]);
/*  165 */         Player target2 = Bukkit.getServer().getPlayer(args[1]);
/*  166 */         if ((target1 != null) && (target2 != null))
/*      */         {
/*  168 */           target1.teleport(target2.getLocation());
/*  169 */           s.sendMessage(ChatColor.GREEN + "Teleported " + target1.getName() + " to " + target2.getName());
/*      */         }
/*      */         else
/*      */         {
/*  173 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */     }
/*      */     Location place;
/*  179 */     if (l.equalsIgnoreCase("put"))
/*      */     {
/*  181 */       if (args.length < 1)
/*      */       {
/*  183 */         if ((s instanceof Player))
/*      */         {
/*  185 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/*  189 */           s.sendMessage("/put [player]");
/*      */         }
/*      */ 
/*      */       }
/*  194 */       else if ((s instanceof Player))
/*      */       {
/*  196 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.put"))
/*      */         {
/*  198 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*  199 */           if (target != null)
/*      */           {
/*  201 */             place = ((Player)s).getTargetBlock(null, 0).getRelative(BlockFace.UP, 2).getLocation();
/*  202 */             target.teleport(place);
/*  203 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported " + target.getName() + " to where you're looking at!");
/*  204 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " teleported you to where he/she was looking at!");
/*      */           }
/*      */           else
/*      */           {
/*  208 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  213 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  218 */         s.sendMessage(ChatColor.RED + "You are not in-game so you can't put a player where you're looking at!");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  223 */     if (l.equalsIgnoreCase("setspawn"))
/*      */     {
/*  225 */       if ((s instanceof Player))
/*      */       {
/*  227 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.setspawn"))
/*      */         {
/*  229 */           ((Player)s).getWorld().setSpawnLocation((int)((Player)s).getLocation().getX(), (int)((Player)s).getLocation().getY(), (int)((Player)s).getLocation().getZ());
/*  230 */           ((Player)s).sendMessage(ChatColor.GREEN + " World spawn set!");
/*      */         }
/*      */         else
/*      */         {
/*  234 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  239 */         s.sendMessage(ChatColor.RED + "You must be in-game to set the spawn!");
/*      */       }
/*      */     }
/*      */ 
/*  243 */     if (l.equalsIgnoreCase("spawn"))
/*      */     {
/*  245 */       if ((s instanceof Player))
/*      */       {
/*  247 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.spawn"))
/*      */         {
/*  249 */           ((Player)s).teleport(((Player)s).getWorld().getSpawnLocation());
/*  250 */           ((Player)s).sendMessage(ChatColor.GREEN + "Teleported to Spawn in '" + ((Player)s).getWorld().getName().toLowerCase() + "'");
/*      */         }
/*      */         else
/*      */         {
/*  254 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */ 
/*      */       }
/*  259 */       else if (args.length < 1)
/*      */       {
/*  261 */         s.sendMessage("/spawn [player]");
/*      */       }
/*      */       else
/*      */       {
/*  265 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  266 */         if (target != null)
/*      */         {
/*  268 */           target.teleport(target.getWorld().getSpawnLocation());
/*  269 */           s.sendMessage(ChatColor.GREEN + "Teleported " + target.getName() + " to spawn!");
/*      */         }
/*      */         else
/*      */         {
/*  273 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  279 */     if (l.equalsIgnoreCase("tpall"))
/*      */     {
/*  281 */       if ((s instanceof Player))
/*      */       {
/*  283 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.tpall"))
/*      */         {
/*  285 */           Player[] arrayOfPlayer1;
/*  285 */           Location localLocation1 = (arrayOfPlayer1 = Bukkit.getServer().getOnlinePlayers()).length; for (place = 0; place < localLocation1; place++) { Player p = arrayOfPlayer1[place];
/*      */ 
/*  287 */             p.teleport(((Player)s).getLocation());
/*  288 */             p.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " has teleported you!");
/*  289 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported everyone to you!");
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  294 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  299 */         s.sendMessage(ChatColor.RED + "You must be in-game to teleport everyone to you!");
/*      */       }
/*      */     }
/*      */ 
/*  303 */     if (l.equalsIgnoreCase("tpworld"))
/*      */     {
/*  305 */       if (args.length < 1)
/*      */       {
/*  307 */         if ((s instanceof Player))
/*      */         {
/*  309 */           ((Player)s).sendMessage("/" + l.toString() + " [world]");
/*      */         }
/*      */         else
/*      */         {
/*  313 */           s.sendMessage("/tpworld [player] [world]");
/*      */         }
/*      */ 
/*      */       }
/*  318 */       else if ((s instanceof Player))
/*      */       {
/*  320 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.teleport.world"))
/*      */         {
/*  322 */           if (Bukkit.getServer().getWorld(args[0]) != null)
/*      */           {
/*  324 */             ((Player)s).teleport(Bukkit.getServer().getWorld(args[0]).getSpawnLocation());
/*  325 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported to world '" + Bukkit.getServer().getWorld(args[0]).getName() + "'");
/*      */           }
/*      */           else
/*      */           {
/*  329 */             ((Player)s).sendMessage(ChatColor.RED + "World '" + args[0] + "' does not exist.");
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  334 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */ 
/*      */       }
/*  339 */       else if (Bukkit.getServer().getWorld(args[1]) != null)
/*      */       {
/*  341 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  342 */         if (target != null)
/*      */         {
/*  344 */           target.teleport(Bukkit.getServer().getWorld(args[1]).getSpawnLocation());
/*  345 */           s.sendMessage(ChatColor.GREEN + "Teleported " + target.getName() + " to '" + args[1] + "'");
/*      */         }
/*      */         else
/*      */         {
/*  349 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  354 */         s.sendMessage(ChatColor.RED + "This world does not exist.");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  360 */     if (l.equalsIgnoreCase("shoot"))
/*      */     {
/*  362 */       if (args.length < 1)
/*      */       {
/*  364 */         if ((s instanceof Player))
/*      */         {
/*  366 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/*  370 */           s.sendMessage("/shoot [player]");
/*      */         }
/*      */ 
/*      */       }
/*  375 */       else if ((s instanceof Player))
/*      */       {
/*  377 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.shoot"))
/*      */         {
/*  379 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*  380 */           if (target != null)
/*      */           {
/*  382 */             target.setVelocity(new Vector(0, 64, 0));
/*  383 */             ((Player)s).sendMessage(ChatColor.GREEN + "You shot " + target.getName() + " into the air!");
/*  384 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " shot you into the air!");
/*      */           }
/*      */           else
/*      */           {
/*  388 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  393 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  398 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  399 */         if (target != null)
/*      */         {
/*  401 */           target.setVelocity(new Vector(0, 64, 0));
/*  402 */           s.sendMessage(ChatColor.GREEN + "You shot " + target.getName() + " into the air!");
/*      */         }
/*      */         else
/*      */         {
/*  406 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  412 */     if (l.equalsIgnoreCase("strike"))
/*      */     {
/*  414 */       if (args.length < 1)
/*      */       {
/*  416 */         if ((s instanceof Player))
/*      */         {
/*  418 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/*  422 */           s.sendMessage("/strike [player]");
/*      */         }
/*      */ 
/*      */       }
/*  427 */       else if ((s instanceof Player))
/*      */       {
/*  429 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.strike"))
/*      */         {
/*  431 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*  432 */           if (target != null)
/*      */           {
/*  434 */             target.getWorld().strikeLightning(target.getLocation());
/*  435 */             ((Player)s).sendMessage(ChatColor.GREEN + "You striked " + target.getName());
/*  436 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " striked you!");
/*      */           }
/*      */           else
/*      */           {
/*  440 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  445 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  450 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  451 */         if (target != null)
/*      */         {
/*  453 */           target.getWorld().strikeLightning(target.getLocation());
/*  454 */           s.sendMessage(ChatColor.GREEN + "You struck lightning at " + target.getName());
/*      */         }
/*      */         else
/*      */         {
/*  458 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  464 */     if (l.equalsIgnoreCase("time"))
/*      */     {
/*  466 */       if (args.length < 1)
/*      */       {
/*  468 */         if ((s instanceof Player))
/*      */         {
/*  470 */           ((Player)s).sendMessage("/" + l.toString() + " [day/night]");
/*      */         }
/*      */         else
/*      */         {
/*  474 */           s.sendMessage("/time [day/night] [world]");
/*      */         }
/*      */ 
/*      */       }
/*  479 */       else if ((s instanceof Player))
/*      */       {
/*  481 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.time"))
/*      */         {
/*  483 */           if (args[0].equalsIgnoreCase("day"))
/*      */           {
/*  485 */             ((Player)s).sendMessage(ChatColor.GREEN + "You have set it to day-time!");
/*  486 */             ((Player)s).getWorld().setTime(0L);
/*      */           }
/*      */ 
/*  489 */           if (args[0].equalsIgnoreCase("night"))
/*      */           {
/*  491 */             ((Player)s).sendMessage(ChatColor.GREEN + "You have set it to night-time!");
/*  492 */             ((Player)s).getWorld().setTime(10000000L);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  497 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  502 */         if (args[0].equalsIgnoreCase("day"))
/*      */         {
/*  504 */           if (Bukkit.getServer().getWorld(args[1]) != null)
/*      */           {
/*  506 */             Bukkit.getServer().getWorld(args[1]).setTime(0L);
/*  507 */             s.sendMessage(ChatColor.GREEN + "Set " + args[1] + "'s time to day!");
/*      */           }
/*      */           else
/*      */           {
/*  511 */             s.sendMessage(ChatColor.RED + "This world does not exist. Did you type it correctly?");
/*      */           }
/*      */         }
/*      */ 
/*  515 */         if (args[0].equalsIgnoreCase("night"))
/*      */         {
/*  517 */           if (Bukkit.getServer().getWorld(args[1]) != null)
/*      */           {
/*  519 */             Bukkit.getServer().getWorld(args[1]).setTime(100000000L);
/*  520 */             s.sendMessage(ChatColor.GREEN + "Set " + args[1] + "'s time to night!");
/*      */           }
/*      */           else
/*      */           {
/*  524 */             s.sendMessage(ChatColor.RED + "This world does not exist. Did you type it correctly?");
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  531 */     if (l.equalsIgnoreCase("facepalm"))
/*      */     {
/*  533 */       if ((s instanceof Player))
/*      */       {
/*  535 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.facepalm"))
/*      */         {
/*  537 */           Bukkit.getServer().broadcastMessage(((Player)s).getName() + " facepalm'd");
/*      */         }
/*      */         else
/*      */         {
/*  541 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  546 */         Bukkit.getServer().broadcastMessage(ChatColor.RED + "Console /facepalm'd");
/*      */       }
/*      */     }
/*      */ 
/*  550 */     if (l.equalsIgnoreCase("heal"))
/*      */     {
/*  552 */       if (args.length < 1)
/*      */       {
/*  554 */         if ((s instanceof Player))
/*      */         {
/*  556 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.heal.others"))
/*      */           {
/*  558 */             ((Player)s).setHealth(20);
/*  559 */             ((Player)s).sendMessage(ChatColor.GREEN + "Your health bar is now full!");
/*      */           }
/*      */           else
/*      */           {
/*  563 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  568 */           s.sendMessage("/heal [player]");
/*      */         }
/*      */ 
/*      */       }
/*  573 */       else if ((s instanceof Player))
/*      */       {
/*  575 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.heal.others"))
/*      */         {
/*  577 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*  578 */           if (target != null)
/*      */           {
/*  580 */             target.setHealth(20);
/*  581 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + "'s health is now full!");
/*  582 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " restored your health!");
/*      */           }
/*      */           else
/*      */           {
/*  586 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  591 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  596 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  597 */         if (target != null)
/*      */         {
/*  599 */           target.setHealth(20);
/*  600 */           s.sendMessage(ChatColor.GREEN + target.getName() + "'s health bar is now full!");
/*      */         }
/*      */         else
/*      */         {
/*  604 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  610 */     if (l.equalsIgnoreCase("feed"))
/*      */     {
/*  612 */       if (args.length < 1)
/*      */       {
/*  614 */         if ((s instanceof Player))
/*      */         {
/*  616 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.feed"))
/*      */           {
/*  618 */             ((Player)s).setFoodLevel(20);
/*  619 */             ((Player)s).sendMessage(ChatColor.GREEN + "Your food bar is now full!");
/*      */           }
/*      */           else
/*      */           {
/*  623 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  628 */           s.sendMessage("/feed [player]");
/*      */         }
/*      */ 
/*      */       }
/*  633 */       else if ((s instanceof Player))
/*      */       {
/*  635 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.feed.others"))
/*      */         {
/*  637 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*  638 */           if (target != null)
/*      */           {
/*  640 */             target.setFoodLevel(20);
/*  641 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + "'s food bar is now full!");
/*  642 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " set your food bar to full!");
/*      */           }
/*      */           else
/*      */           {
/*  646 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  651 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  656 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  657 */         if (target != null)
/*      */         {
/*  659 */           target.setFoodLevel(20);
/*  660 */           s.sendMessage(ChatColor.GREEN + target.getName() + "'s food level is now full!");
/*      */         }
/*      */         else
/*      */         {
/*  664 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  670 */     if (l.equalsIgnoreCase("god"))
/*      */     {
/*  672 */       if (args.length < 1)
/*      */       {
/*  674 */         if ((s instanceof Player))
/*      */         {
/*  676 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*      */         }
/*      */         else
/*      */         {
/*  680 */           s.sendMessage("/god [on/off]");
/*      */         }
/*      */ 
/*      */       }
/*  685 */       else if ((s instanceof Player))
/*      */       {
/*  687 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.god"))
/*      */         {
/*  689 */           if (args[0].equalsIgnoreCase("on"))
/*      */           {
/*  691 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".godmode", Boolean.valueOf(true));
/*  692 */             ((Player)s).sendMessage(ChatColor.GREEN + "Godmode enabled!");
/*  693 */             CommandBin.plugin.saveConfig();
/*      */           }
/*      */ 
/*  696 */           if (args[0].equalsIgnoreCase("off"))
/*      */           {
/*  698 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".godmode", Boolean.valueOf(false));
/*  699 */             ((Player)s).sendMessage(ChatColor.GREEN + "Godmode disabled!");
/*  700 */             CommandBin.plugin.saveConfig();
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  705 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  710 */         s.sendMessage(ChatColor.RED + "You can't turn godmode on in-console.");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  715 */     if (l.equalsIgnoreCase("explode"))
/*      */     {
/*  717 */       if (args.length < 2)
/*      */       {
/*  719 */         if ((s instanceof Player))
/*      */         {
/*  721 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [radius]");
/*      */         }
/*      */         else
/*      */         {
/*  725 */           s.sendMessage("/explode [player] [radius]");
/*      */         }
/*      */ 
/*      */       }
/*  730 */       else if ((s instanceof Player))
/*      */       {
/*  732 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.explode"))
/*      */         {
/*  735 */           float radius = Integer.parseInt(args[1]);
/*      */ 
/*  737 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*      */ 
/*  739 */           if (target != null)
/*      */           {
/*  741 */             target.getWorld().createExplosion(target.getLocation(), radius);
/*  742 */             ((Player)s).sendMessage(ChatColor.GREEN + "You created a explosion at " + target.getName() + "'s location!");
/*  743 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " created a explosion at your location.");
/*      */           }
/*      */           else
/*      */           {
/*  747 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  752 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  757 */         float radius = Integer.parseInt(args[1]);
/*      */ 
/*  759 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*      */ 
/*  761 */         if (target != null)
/*      */         {
/*  763 */           target.getWorld().createExplosion(target.getLocation(), radius);
/*      */         }
/*      */         else
/*      */         {
/*  767 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  773 */     if (l.equalsIgnoreCase("light"))
/*      */     {
/*  775 */       if (args.length < 2)
/*      */       {
/*  777 */         if ((s instanceof Player))
/*      */         {
/*  779 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [length in seconds]");
/*      */         }
/*      */         else
/*      */         {
/*  783 */           s.sendMessage("/light [player] [length in seconds]");
/*      */         }
/*      */ 
/*      */       }
/*  788 */       else if ((s instanceof Player))
/*      */       {
/*  790 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.light"))
/*      */         {
/*  792 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/*      */ 
/*  794 */           int i = Integer.parseInt(args[1]) * 10;
/*      */ 
/*  796 */           if (target != null)
/*      */           {
/*  798 */             target.setFireTicks(i);
/*      */           }
/*      */           else
/*      */           {
/*  802 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  807 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  812 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/*  813 */         int i = Integer.parseInt(args[1]) * 10;
/*  814 */         if (target != null)
/*      */         {
/*  816 */           target.setFireTicks(i);
/*  817 */           s.sendMessage(ChatColor.GREEN + "You set " + target.getName() + " on fire for " + i + " seconds!");
/*      */         }
/*      */         else
/*      */         {
/*  821 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  827 */     if (l.equalsIgnoreCase("roll"))
/*      */     {
/*  829 */       if (args.length < 2)
/*      */       {
/*  831 */         if ((s instanceof Player))
/*      */         {
/*  833 */           ((Player)s).sendMessage("/" + l.toString() + " [min] [max]");
/*      */         }
/*      */         else
/*      */         {
/*  837 */           s.sendMessage("/roll [min] [max]");
/*      */         }
/*      */ 
/*      */       }
/*  842 */       else if ((s instanceof Player))
/*      */       {
/*  844 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.roll"))
/*      */         {
/*  846 */           Double rand = Double.valueOf(Math.random() * (Integer.parseInt(args[1]) - Integer.parseInt(args[0])) + Integer.parseInt(args[0]));
/*  847 */           long rounded = Math.round(rand.doubleValue());
/*  848 */           Bukkit.getServer().broadcastMessage(ChatColor.GREEN + ((Player)s).getName() + " Rolled " + ChatColor.RED + args[0] + ChatColor.GREEN + " and " + ChatColor.RED + args[1] + ChatColor.GREEN + " and got: " + rounded);
/*      */         }
/*      */         else
/*      */         {
/*  852 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  857 */         Double rand = Double.valueOf(Math.random() * (Integer.parseInt(args[1]) - Integer.parseInt(args[0])) + Integer.parseInt(args[0]));
/*  858 */         long rounded = Math.round(rand.doubleValue());
/*  859 */         Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Console rolled " + ChatColor.RED + args[0] + ChatColor.GREEN + " and " + ChatColor.RED + args[1] + ChatColor.GREEN + " and got: " + rounded);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  864 */     if (l.equalsIgnoreCase("smoke"))
/*      */     {
/*  866 */       if (args.length < 1)
/*      */       {
/*  868 */         if ((s instanceof Player))
/*      */         {
/*  870 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*      */         }
/*      */         else
/*      */         {
/*  874 */           s.sendMessage("/smoke on/off]");
/*      */         }
/*      */ 
/*      */       }
/*  879 */       else if ((s instanceof Player))
/*      */       {
/*  881 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.smoke"))
/*      */         {
/*  883 */           if (args[0].equalsIgnoreCase("on"))
/*      */           {
/*  885 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".smoke", Boolean.valueOf(true));
/*  886 */             CommandBin.plugin.saveConfig();
/*  887 */             ((Player)s).sendMessage(ChatColor.GREEN + "You are now a walking chimney! *giggles*");
/*      */           }
/*      */ 
/*  890 */           if (args[0].equalsIgnoreCase("off"))
/*      */           {
/*  892 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".smoke", Boolean.valueOf(false));
/*  893 */             CommandBin.plugin.saveConfig();
/*  894 */             ((Player)s).sendMessage(ChatColor.GREEN + "You are no longer the walking chimney!");
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  899 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  904 */         s.sendMessage(ChatColor.RED + "You can't turn smoke on in-console!");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  909 */     if (l.equalsIgnoreCase("explosionstick"))
/*      */     {
/*  911 */       if (args.length < 1)
/*      */       {
/*  913 */         if ((s instanceof Player))
/*      */         {
/*  915 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*      */         }
/*      */         else
/*      */         {
/*  919 */           s.sendMessage("/explosionstick [on/off]");
/*      */         }
/*      */ 
/*      */       }
/*  924 */       else if ((s instanceof Player))
/*      */       {
/*  926 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.explosionstick"))
/*      */         {
/*  928 */           if (args[0].equalsIgnoreCase("on"))
/*      */           {
/*  930 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".explosionstick", Boolean.valueOf(true));
/*  931 */             CommandBin.plugin.saveConfig();
/*  932 */             ((Player)s).sendMessage(ChatColor.AQUA + "Explosion stick enabled");
/*  933 */             ((Player)s).getInventory().addItem(new ItemStack[] { new ItemStack(Material.STICK, 1) });
/*      */           }
/*      */ 
/*  936 */           if (args[0].equalsIgnoreCase("off"))
/*      */           {
/*  938 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".explosionstick", Boolean.valueOf(false));
/*  939 */             CommandBin.plugin.saveConfig();
/*  940 */             ((Player)s).sendMessage(ChatColor.AQUA + "Explosion stick disabled");
/*  941 */             ((Player)s).getInventory().remove(new ItemStack(Material.STICK, 1));
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  946 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  952 */     if (l.equalsIgnoreCase("lightningstick"))
/*      */     {
/*  954 */       if (args.length < 1)
/*      */       {
/*  956 */         if ((s instanceof Player))
/*      */         {
/*  958 */           ((Player)s).sendMessage("/" + l.toString() + " [on/off]");
/*      */         }
/*      */         else
/*      */         {
/*  962 */           s.sendMessage("/lightingstick [on/off]");
/*      */         }
/*      */ 
/*      */       }
/*  967 */       else if ((s instanceof Player))
/*      */       {
/*  969 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.lightningstick"))
/*      */         {
/*  971 */           if (args[0].equalsIgnoreCase("on"))
/*      */           {
/*  973 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".lightningstick", Boolean.valueOf(true));
/*  974 */             ((Player)s).sendMessage(ChatColor.AQUA + "Lightning stick enabled");
/*  975 */             CommandBin.plugin.saveConfig();
/*  976 */             ((Player)s).getInventory().addItem(new ItemStack[] { new ItemStack(Material.STICK, 1) });
/*      */           }
/*      */ 
/*  979 */           if (args[0].equalsIgnoreCase("off"))
/*      */           {
/*  981 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".lightningstick", Boolean.valueOf(false));
/*  982 */             ((Player)s).sendMessage(ChatColor.AQUA + "Lightning stick disabled");
/*  983 */             CommandBin.plugin.saveConfig();
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  988 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  993 */         s.sendMessage(ChatColor.RED + "Lightningstick can't be used in-console.");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  998 */     if (l.equalsIgnoreCase("slap"))
/*      */     {
/* 1000 */       if (args.length < 2)
/*      */       {
/* 1002 */         if ((s instanceof Player))
/*      */         {
/* 1004 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [hardness]");
/*      */         }
/*      */         else
/*      */         {
/* 1008 */           s.sendMessage("/slap [player] [hardness]");
/*      */         }
/*      */ 
/*      */       }
/* 1014 */       else if ((s instanceof Player))
/*      */       {
/* 1016 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.slap"))
/*      */         {
/* 1018 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1019 */           if (target != null)
/*      */           {
/* 1021 */             double i = Integer.parseInt(args[1]) * 0.4D;
/*      */ 
/* 1023 */             target.setVelocity(new Vector(i, i, 0.0D));
/* 1024 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " slapped you!");
/* 1025 */             ((Player)s).sendMessage(ChatColor.GREEN + "You slapped " + target.getName());
/*      */           }
/*      */           else
/*      */           {
/* 1029 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1034 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1039 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1040 */         if (target != null)
/*      */         {
/* 1042 */           double i = Integer.parseInt(args[1]) * 0.4D;
/* 1043 */           target.setVelocity(new Vector(i, i, 0.0D));
/* 1044 */           s.sendMessage(ChatColor.GREEN + "You slapped " + target.getName());
/*      */         }
/*      */         else
/*      */         {
/* 1048 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1054 */     if (l.equalsIgnoreCase("clear"))
/*      */     {
/* 1056 */       if (args.length < 1)
/*      */       {
/* 1058 */         if ((s instanceof Player))
/*      */         {
/* 1060 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.clear"))
/*      */           {
/* 1062 */             ((Player)s).getInventory().clear();
/* 1063 */             ((Player)s).sendMessage(ChatColor.GREEN + "Inventory cleared!");
/*      */           }
/*      */           else
/*      */           {
/* 1067 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1072 */           s.sendMessage("/clear [player]");
/*      */         }
/*      */ 
/*      */       }
/* 1077 */       else if ((s instanceof Player))
/*      */       {
/* 1079 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1080 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.clear.others"))
/*      */         {
/* 1082 */           if (target != null)
/*      */           {
/* 1084 */             target.getInventory().clear();
/* 1085 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " cleared your inventory!");
/* 1086 */             ((Player)s).sendMessage(ChatColor.GREEN + "Successfully cleared " + target.getName() + "'s inventory!");
/*      */           }
/*      */           else
/*      */           {
/* 1090 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1095 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1100 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1101 */         if (target != null)
/*      */         {
/* 1103 */           target.getInventory().clear();
/* 1104 */           s.sendMessage(ChatColor.GREEN + "You cleared " + target.getName() + "'s inventory!");
/*      */         }
/*      */         else
/*      */         {
/* 1108 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1114 */     if (l.equalsIgnoreCase("i"))
/*      */     {
/* 1116 */       if (args.length < 1)
/*      */       {
/* 1118 */         if ((s instanceof Player))
/*      */         {
/* 1120 */           ((Player)s).sendMessage("/" + l.toString() + " [name] [amount]");
/*      */         }
/*      */         else
/*      */         {
/* 1124 */           s.sendMessage("/i [name] [amount]");
/*      */         }
/*      */ 
/*      */       }
/* 1129 */       else if ((s instanceof Player))
/*      */       {
/* 1131 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.item"))
/*      */         {
/* 1133 */           int id = -1;
/* 1134 */           int amount = 1;
/*      */           try {
/* 1136 */             id = Integer.parseInt(args[0]);
/*      */           } catch (NumberFormatException e) {
/* 1138 */             Material mat = Material.getMaterial(args[0].toUpperCase().replace(" ", "_"));
/* 1139 */             id = mat != null ? mat.getId() : -1;
/*      */           }
/* 1141 */           if (args.length > 1)
/*      */             try {
/* 1143 */               amount = Integer.parseInt(args[1]);
/*      */             }
/*      */             catch (NumberFormatException localNumberFormatException2) {
/*      */             }
/* 1147 */           if (id == -1) { ((Player)s).sendMessage(ChatColor.RED + "This item does not exist."); return false; }
/* 1148 */           ((Player)s).getInventory().addItem(new ItemStack[] { new ItemStack(id, amount) });
/* 1149 */           ((Player)s).sendMessage(ChatColor.GREEN + "You obtained " + id);
/* 1150 */           return true;
/*      */         }
/*      */ 
/* 1154 */         ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */       }
/*      */       else
/*      */       {
/* 1159 */         s.sendMessage(ChatColor.RED + "You can't spawn items in console");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1164 */     if (l.equalsIgnoreCase("msg"))
/*      */     {
/* 1166 */       if (args.length < 2)
/*      */       {
/* 1168 */         if ((s instanceof Player))
/*      */         {
/* 1170 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [message]");
/*      */         }
/*      */         else
/*      */         {
/* 1174 */           s.sendMessage("/msg [player] [message]");
/*      */         }
/*      */ 
/*      */       }
/* 1179 */       else if ((s instanceof Player))
/*      */       {
/* 1181 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.msg"))
/*      */         {
/* 1183 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1184 */           if (target != null)
/*      */           {
/* 1186 */             StringBuilder x = new StringBuilder();
/*      */ 
/* 1188 */             for (int x2 = 1; x2 < args.length; x2++) {
/* 1189 */               x.append(args[x2]).append(" ");
/*      */             }
/* 1191 */             String from = ChatColor.RED + "[FROM " + ((Player)s).getName() + "] " + ChatColor.WHITE + ": " + x.toString().trim();
/* 1192 */             String to = ChatColor.RED + "[TO " + target.getName() + "] " + ChatColor.WHITE + ": " + x.toString().trim();
/* 1193 */             String op = ChatColor.DARK_RED + "[" + ((Player)s).getName() + " > " + target.getName() + "] " + x.toString().trim();
/*      */ 
/* 1195 */             if (CommandBin.plugin.getConfig().getBoolean("settings.opscanseepms"))
/*      */             {
/* 1197 */               for (Player p : Bukkit.getServer().getOnlinePlayers())
/*      */               {
/* 1199 */                 if (!p.isOp())
/*      */                   continue;
/* 1201 */                 p.sendMessage(op);
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 1206 */             target.sendMessage(from);
/* 1207 */             ((Player)s).sendMessage(to);
/* 1208 */             System.out.println(op);
/*      */           }
/*      */           else
/*      */           {
/* 1212 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1217 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1222 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1223 */         if (target != null)
/*      */         {
/* 1225 */           StringBuilder x = new StringBuilder();
/*      */ 
/* 1227 */           for (int x2 = 1; x2 < args.length; x2++) {
/* 1228 */             x.append(args[x2]).append(" ");
/*      */           }
/* 1230 */           String from = ChatColor.RED + "[FROM CONSOLE] " + ChatColor.WHITE + ": " + x.toString().trim();
/* 1231 */           String to = ChatColor.RED + "[TO " + target.getName() + "] " + ChatColor.WHITE + ": " + x.toString().trim();
/* 1232 */           String op = ChatColor.DARK_RED + "[CONSOLE > " + target.getName() + "] " + x.toString().trim();
/*      */ 
/* 1234 */           if (CommandBin.plugin.getConfig().getBoolean("settings.opscanseepms"))
/*      */           {
/* 1236 */             for (Player p : Bukkit.getServer().getOnlinePlayers())
/*      */             {
/* 1238 */               if (!p.isOp())
/*      */                 continue;
/* 1240 */               p.sendMessage(op);
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1245 */           target.sendMessage(from);
/* 1246 */           ((Player)s).sendMessage(to);
/* 1247 */           System.out.println(op);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1253 */     if (l.equalsIgnoreCase("nick"))
/*      */     {
/* 1255 */       if (args.length < 2)
/*      */       {
/* 1257 */         if ((s instanceof Player))
/*      */         {
/* 1259 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [nickname]");
/*      */         }
/*      */         else
/*      */         {
/* 1263 */           s.sendMessage("/nick [player] [nickname]");
/*      */         }
/*      */ 
/*      */       }
/* 1268 */       else if ((s instanceof Player))
/*      */       {
/* 1270 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.nick"))
/*      */         {
/* 1272 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1273 */           if (target != null)
/*      */           {
/* 1275 */             if (args[1].length() < 20)
/*      */             {
/* 1277 */               target.setDisplayName(args[1]);
/* 1278 */               ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + "'s name changed to " + args[1]);
/* 1279 */               target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " changed your name to " + args[1]);
/* 1280 */               CommandBin.plugin.getConfig().set(target.getName() + ".nickname", args[1]);
/* 1281 */               CommandBin.plugin.saveConfig();
/*      */             }
/*      */             else
/*      */             {
/* 1285 */               ((Player)s).sendMessage(ChatColor.RED + "That name is too long. It must be below 20 characters. Sorry :(");
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 1290 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1295 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1300 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1301 */         if (target != null)
/*      */         {
/* 1303 */           if (args[1].length() < 20)
/*      */           {
/* 1305 */             target.setDisplayName(args[1]);
/* 1306 */             CommandBin.plugin.getConfig().set(target.getName() + ".nickname", args[1]);
/* 1307 */             s.sendMessage(ChatColor.GREEN + target.getName() + "'s nickname is now " + args[1]);
/*      */           }
/*      */           else
/*      */           {
/* 1311 */             s.sendMessage(ChatColor.RED + "The nickname must be below 20 letters!");
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1316 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1322 */     if (l.equalsIgnoreCase("setxp"))
/*      */     {
/* 1324 */       if (args.length < 2)
/*      */       {
/* 1326 */         if ((s instanceof Player))
/*      */         {
/* 1328 */           ((Player)s).sendMessage("/" + l.toString() + " [player] [amount]");
/*      */         }
/*      */         else
/*      */         {
/* 1332 */           s.sendMessage("/setxp [player] [amount]");
/*      */         }
/*      */ 
/*      */       }
/* 1337 */       else if ((s instanceof Player))
/*      */       {
/* 1339 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.setxp"))
/*      */         {
/* 1341 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1342 */           if (target != null)
/*      */           {
/* 1344 */             target.setExperience(Integer.parseInt(args[1]));
/* 1345 */             ((Player)s).sendMessage(ChatColor.GREEN + target.getName() + "'s experience has been set to " + args[1]);
/* 1346 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " set your experience points to " + args[1]);
/*      */           }
/*      */           else
/*      */           {
/* 1350 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1355 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1360 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1361 */         if (target != null)
/*      */         {
/* 1363 */           target.setExperience(Integer.parseInt(args[1]));
/* 1364 */           s.sendMessage(ChatColor.GREEN + target.getName() + "'s experience is now " + args[1]);
/*      */         }
/*      */         else
/*      */         {
/* 1368 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1374 */     if (l.equalsIgnoreCase("kill"))
/*      */     {
/* 1376 */       if (args.length < 1)
/*      */       {
/* 1378 */         if ((s instanceof Player))
/*      */         {
/* 1380 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/* 1384 */           s.sendMessage("/kill [player]");
/*      */         }
/*      */ 
/*      */       }
/* 1389 */       else if ((s instanceof Player))
/*      */       {
/* 1391 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.kill"))
/*      */         {
/* 1393 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1394 */           if (target != null)
/*      */           {
/* 1396 */             target.getWorld().strikeLightning(target.getLocation());
/* 1397 */             target.setHealth(0);
/* 1398 */             ((Player)s).sendMessage(ChatColor.GREEN + "You killed " + target.getName());
/* 1399 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " killed you!");
/*      */           }
/*      */           else
/*      */           {
/* 1403 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1408 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1413 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1414 */         if (target != null)
/*      */         {
/* 1416 */           target.setHealth(0);
/* 1417 */           s.sendMessage(ChatColor.GREEN + "You killed " + target.getName());
/*      */         }
/*      */         else
/*      */         {
/* 1421 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1427 */     if (l.equalsIgnoreCase("up"))
/*      */     {
/* 1429 */       if (args.length < 1)
/*      */       {
/* 1431 */         if ((s instanceof Player))
/*      */         {
/* 1433 */           ((Player)s).sendMessage("/" + l.toString() + " [blocks]");
/*      */         }
/*      */         else
/*      */         {
/* 1437 */           s.sendMessage("/up [blocks]");
/*      */         }
/*      */ 
/*      */       }
/* 1442 */       else if ((s instanceof Player))
/*      */       {
/* 1444 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.up"))
/*      */         {
/* 1446 */           ((Player)s).getLocation().getBlock().getRelative(0, Integer.parseInt(args[0]), 0).setType(Material.GLASS);
/* 1447 */           Location tpblock = ((Player)s).getLocation().getBlock().getRelative(0, Integer.parseInt(args[0]) + 2, 0).getLocation();
/* 1448 */           ((Player)s).teleport(tpblock);
/* 1449 */           ((Player)s).sendMessage(ChatColor.RED + "You went up " + args[0] + " blocks!");
/*      */         }
/*      */         else
/*      */         {
/* 1453 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1458 */         s.sendMessage(ChatColor.RED + "You can't go up in console!");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1463 */     if (l.equalsIgnoreCase("unlimited"))
/*      */     {
/* 1465 */       if (args.length < 1)
/*      */       {
/* 1467 */         if ((s instanceof Player))
/*      */         {
/* 1469 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/* 1473 */           s.sendMessage("/unlimited [player]");
/*      */         }
/*      */ 
/*      */       }
/* 1478 */       else if ((s instanceof Player))
/*      */       {
/* 1480 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.unlimited"))
/*      */         {
/* 1482 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1483 */           if (target != null)
/*      */           {
/* 1485 */             CommandBin.plugin.getConfig().set(target.getName() + ".unlimited", Boolean.valueOf(true));
/* 1486 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " has given you unlimited block usage!");
/* 1487 */             ((Player)s).sendMessage(ChatColor.GREEN + "Successfully gave " + target.getName() + " unlimited block usage!");
/* 1488 */             CommandBin.plugin.saveConfig();
/*      */           }
/*      */           else
/*      */           {
/* 1492 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1497 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1502 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1503 */         if (target != null)
/*      */         {
/* 1505 */           CommandBin.plugin.getConfig().set(target.getName() + ".unlimited", Boolean.valueOf(true));
/* 1506 */           s.sendMessage(ChatColor.GREEN + "You gave " + target.getName() + " unlimited block usage!");
/* 1507 */           CommandBin.plugin.saveConfig();
/*      */         }
/*      */         else
/*      */         {
/* 1511 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1517 */     if (l.equalsIgnoreCase("delunlimited"))
/*      */     {
/* 1519 */       if (args.length < 1)
/*      */       {
/* 1521 */         if ((s instanceof Player))
/*      */         {
/* 1523 */           ((Player)s).sendMessage("/" + l.toString() + " [player]");
/*      */         }
/*      */         else
/*      */         {
/* 1527 */           s.sendMessage("/delunlimited [player]");
/*      */         }
/*      */ 
/*      */       }
/* 1532 */       else if ((s instanceof Player))
/*      */       {
/* 1534 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.unlimited"))
/*      */         {
/* 1536 */           Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1537 */           if (target != null)
/*      */           {
/* 1539 */             CommandBin.plugin.getConfig().set(target.getName() + ".unlimited", Boolean.valueOf(false));
/* 1540 */             target.sendMessage(ChatColor.GREEN + ((Player)s).getName() + " has removed your unlimited block usage!");
/* 1541 */             ((Player)s).sendMessage(ChatColor.GREEN + "Successfully removed " + target.getName() + "'s unlimited block usage!");
/* 1542 */             CommandBin.plugin.saveConfig();
/*      */           }
/*      */           else
/*      */           {
/* 1546 */             ((Player)s).sendMessage(CommandBin.plugin.PlayerOffline);
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1551 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1556 */         Player target = Bukkit.getServer().getPlayer(args[0]);
/* 1557 */         if (target != null)
/*      */         {
/* 1559 */           CommandBin.plugin.getConfig().set(target.getName() + ".unlimited", Boolean.valueOf(false));
/* 1560 */           s.sendMessage(ChatColor.GREEN + "You removed " + target.getName() + "'s unlimited block usage!");
/* 1561 */           CommandBin.plugin.saveConfig();
/*      */         }
/*      */         else
/*      */         {
/* 1565 */           s.sendMessage(CommandBin.plugin.PlayerOffline);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1571 */     if (l.equalsIgnoreCase("mytime"))
/*      */     {
/* 1573 */       if (args.length < 1)
/*      */       {
/* 1575 */         if ((s instanceof Player))
/*      */         {
/* 1577 */           ((Player)s).sendMessage("/" + l.toString() + " [day/night/reset]");
/*      */         }
/*      */         else
/*      */         {
/* 1581 */           s.sendMessage("/mytime [day,night,reset]");
/*      */         }
/*      */ 
/*      */       }
/* 1586 */       else if ((s instanceof Player))
/*      */       {
/* 1588 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.mytime"))
/*      */         {
/* 1590 */           if (args[0].equalsIgnoreCase("day"))
/*      */           {
/* 1592 */             ((Player)s).setPlayerTime(0L, false);
/* 1593 */             ((Player)s).sendMessage(ChatColor.GREEN + "You set your time to day!");
/*      */           }
/*      */ 
/* 1596 */           if (args[0].equalsIgnoreCase("night"))
/*      */           {
/* 1598 */             ((Player)s).setPlayerTime(100000000L, false);
/* 1599 */             ((Player)s).sendMessage(ChatColor.GREEN + "You set your time to night!");
/*      */           }
/*      */ 
/* 1602 */           if (args[0].equalsIgnoreCase("reset"))
/*      */           {
/* 1604 */             ((Player)s).setPlayerTime(((Player)s).getWorld().getTime(), true);
/* 1605 */             ((Player)s).sendMessage(ChatColor.GREEN + "You reset your time to the server time!");
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1610 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1615 */         s.sendMessage(ChatColor.RED + "You must be in-game to set your own time.");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1620 */     if (l.equalsIgnoreCase("armour"))
/*      */     {
/* 1622 */       if (args.length < 1)
/*      */       {
/* 1624 */         if ((s instanceof Player))
/*      */         {
/* 1626 */           ((Player)s).sendMessage("/" + l.toString() + " [leather, iron, diamond, gold, chainmail");
/*      */         }
/*      */         else
/*      */         {
/* 1630 */           s.sendMessage("/armour [leather, iron, diamond, gold, chainmail");
/*      */         }
/*      */ 
/*      */       }
/* 1635 */       else if ((s instanceof Player))
/*      */       {
/* 1637 */         if (args[0].equalsIgnoreCase("leather"))
/*      */         {
/* 1639 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.armour.leather"))
/*      */           {
/* 1641 */             ((Player)s).getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
/* 1642 */             ((Player)s).getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
/* 1643 */             ((Player)s).getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
/* 1644 */             ((Player)s).getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
/* 1645 */             ((Player)s).sendMessage(ChatColor.GREEN + "You received " + args[0] + " armour!");
/*      */           }
/*      */           else
/*      */           {
/* 1649 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */ 
/* 1653 */         if (args[0].equalsIgnoreCase("iron"))
/*      */         {
/* 1655 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.armour.iron"))
/*      */           {
/* 1657 */             ((Player)s).getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
/* 1658 */             ((Player)s).getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
/* 1659 */             ((Player)s).getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
/* 1660 */             ((Player)s).getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
/* 1661 */             ((Player)s).sendMessage(ChatColor.GREEN + "You received " + args[0] + " armour!");
/*      */           }
/*      */           else
/*      */           {
/* 1666 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */ 
/* 1670 */         if (args[0].equalsIgnoreCase("diamond"))
/*      */         {
/* 1672 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.armour.diamond"))
/*      */           {
/* 1674 */             ((Player)s).getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
/* 1675 */             ((Player)s).getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
/* 1676 */             ((Player)s).getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
/* 1677 */             ((Player)s).getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
/* 1678 */             ((Player)s).sendMessage(ChatColor.GREEN + "You received " + args[0] + " armour!");
/*      */           }
/*      */           else
/*      */           {
/* 1682 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */ 
/* 1686 */         if (args[0].equalsIgnoreCase("gold"))
/*      */         {
/* 1688 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.armour.gold"))
/*      */           {
/* 1690 */             ((Player)s).getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
/* 1691 */             ((Player)s).getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
/* 1692 */             ((Player)s).getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
/* 1693 */             ((Player)s).getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
/* 1694 */             ((Player)s).sendMessage(ChatColor.GREEN + "You received " + args[0] + " armour!");
/*      */           }
/*      */           else
/*      */           {
/* 1699 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */ 
/* 1703 */         if (args[0].equalsIgnoreCase("chainmail"))
/*      */         {
/* 1705 */           if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.armour.chainmail"))
/*      */           {
/* 1707 */             ((Player)s).getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
/* 1708 */             ((Player)s).getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
/* 1709 */             ((Player)s).getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
/* 1710 */             ((Player)s).getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
/* 1711 */             ((Player)s).sendMessage(ChatColor.GREEN + "You received " + args[0] + " armour!");
/*      */           }
/*      */           else
/*      */           {
/* 1716 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */           }
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1722 */         s.sendMessage(ChatColor.RED + "It would be awesome if you could wear chainmail in console, but you can't!");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1727 */     if (l.equalsIgnoreCase("me"))
/*      */     {
/* 1729 */       if (args.length < 1)
/*      */       {
/* 1731 */         if ((s instanceof Player))
/*      */         {
/* 1733 */           ((Player)s).sendMessage("/" + l.toString() + " [message]");
/*      */         }
/*      */         else
/*      */         {
/* 1737 */           s.sendMessage("/me [message]");
/*      */         }
/*      */ 
/*      */       }
/* 1742 */       else if ((s instanceof Player))
/*      */       {
/* 1744 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.me"))
/*      */         {
/* 1746 */           StringBuilder x = new StringBuilder();
/*      */ 
/* 1750 */           for (int i = 0; i < args.length; i++)
/*      */           {
/* 1752 */             x.append(args[i]).append(" ");
/*      */           }
/*      */ 
/* 1755 */           Bukkit.getServer().broadcastMessage(ChatColor.RED + ((Player)s).getName() + " : " + x.toString().trim());
/*      */         }
/*      */         else
/*      */         {
/* 1759 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1764 */         StringBuilder x = new StringBuilder();
/*      */ 
/* 1766 */         for (int i = 0; i < args.length; i++)
/*      */         {
/* 1768 */           x.append(args[i]).append(" ");
/*      */         }
/* 1770 */         Bukkit.getServer().broadcastMessage(ChatColor.RED + "Console: " + x.toString().trim());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1775 */     if (l.equalsIgnoreCase("more"))
/*      */     {
/* 1777 */       if ((s instanceof Player))
/*      */       {
/* 1779 */         if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.more"))
/*      */         {
/* 1781 */           ((Player)s).getInventory().addItem(new ItemStack[] { new ItemStack(((Player)s).getItemInHand().getType(), 64) });
/* 1782 */           ((Player)s).sendMessage(ChatColor.GREEN + "Received 64 of what you're holding!");
/*      */         }
/*      */         else
/*      */         {
/* 1786 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1791 */         s.sendMessage(ChatColor.RED + "You can't do that in-console!");
/*      */       }
/*      */     }
/* 1794 */     return false;
/*      */   }
/*      */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.PlayerCommands
 * JD-Core Version:    0.6.0
 */