/*     */ package me.cain.commandbin.commands;
/*     */ 
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
/*     */ public class HomeCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*     */   {
/*  20 */     if ((s instanceof Player))
/*     */     {
/*  22 */       if (l.equalsIgnoreCase("sethome"))
/*     */       {
/*  24 */         if (CommandBin.plugin.getConfig().getBoolean("settings.multihomesupport"))
/*     */         {
/*  26 */           if (args.length < 1)
/*     */           {
/*  28 */             ((Player)s).sendMessage("/" + l.toString() + " [home-name]");
/*     */           }
/*  32 */           else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.home"))
/*     */           {
/*  34 */             double x = ((Player)s).getLocation().getX();
/*  35 */             double y = ((Player)s).getLocation().getY();
/*  36 */             double z = ((Player)s).getLocation().getZ();
/*  37 */             World world = ((Player)s).getWorld();
/*     */ 
/*  39 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home." + args[0] + ".x", Double.valueOf(x));
/*  40 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home." + args[0] + ".y", Double.valueOf(y));
/*  41 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home." + args[0] + ".z", Double.valueOf(z));
/*  42 */             CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home." + args[0] + ".world", world.getName());
/*     */ 
/*  44 */             ((Player)s).sendMessage(ChatColor.GREEN + "Your new home '" + args[0] + "' is set.");
/*  45 */             ((Player)s).sendMessage(ChatColor.YELLOW + "Type '/home " + args[0] + "' to teleport");
/*     */ 
/*  47 */             CommandBin.plugin.saveConfig();
/*     */           }
/*     */           else
/*     */           {
/*  52 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */           }
/*     */ 
/*     */         }
/*  58 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.home"))
/*     */         {
/*  60 */           double x = ((Player)s).getLocation().getX();
/*  61 */           double y = ((Player)s).getLocation().getY();
/*  62 */           double z = ((Player)s).getLocation().getZ();
/*  63 */           World world = ((Player)s).getWorld();
/*     */ 
/*  65 */           CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home.x", Double.valueOf(x));
/*  66 */           CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home.y", Double.valueOf(y));
/*  67 */           CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home.z", Double.valueOf(z));
/*  68 */           CommandBin.plugin.getConfig().set(((Player)s).getName() + ".home.world", world.getName());
/*     */ 
/*  70 */           ((Player)s).sendMessage(ChatColor.GREEN + "Your new home is set!");
/*  71 */           ((Player)s).sendMessage(ChatColor.YELLOW + "Type /home to teleport to it!");
/*     */ 
/*  73 */           CommandBin.plugin.saveConfig();
/*     */         }
/*     */         else
/*     */         {
/*  77 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  82 */       if (l.equalsIgnoreCase("home"))
/*     */       {
/*  84 */         if (CommandBin.plugin.getConfig().getBoolean("settings.multihomesupport"))
/*     */         {
/*  86 */           if (args.length < 1)
/*     */           {
/*  88 */             ((Player)s).sendMessage("/" + l.toString() + " [home-name]");
/*     */           }
/*  92 */           else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.home"))
/*     */           {
/*  94 */             if (CommandBin.plugin.getConfig().get(((Player)s).getName() + ".home") != null)
/*     */             {
/*  96 */               if (CommandBin.plugin.getConfig().get(((Player)s).getName() + ".home." + args[0]) != null)
/*     */               {
/*  99 */                 double x = CommandBin.plugin.getConfig().getDouble(((Player)s).getName() + ".home." + args[0] + ".x");
/* 100 */                 double y = CommandBin.plugin.getConfig().getDouble(((Player)s).getName() + ".home." + args[0] + ".y");
/* 101 */                 double z = CommandBin.plugin.getConfig().getDouble(((Player)s).getName() + ".home." + args[0] + ".z");
/* 102 */                 String world = (String)CommandBin.plugin.getConfig().get(((Player)s).getName() + ".home." + args[0] + ".world");
/*     */ 
/* 104 */                 ((Player)s).teleport(new Location(Bukkit.getServer().getWorld(world), x, y, z));
/* 105 */                 ((Player)s).sendMessage(ChatColor.GREEN + "Teleported to your home '" + args[0] + "' !");
/*     */               }
/*     */               else
/*     */               {
/* 109 */                 ((Player)s).sendMessage(ChatColor.RED + "This home '" + args[0] + "' does not exist!");
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/* 114 */               ((Player)s).sendMessage(ChatColor.RED + "You have no home! Type /sethome [homename] to set it!");
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 119 */             ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */           }
/*     */ 
/*     */         }
/* 125 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.home"))
/*     */         {
/* 127 */           if (CommandBin.plugin.getConfig().get(((Player)s).getName() + ".home") != null)
/*     */           {
/* 129 */             double x = CommandBin.plugin.getConfig().getDouble(((Player)s).getName() + ".home.x");
/* 130 */             double y = CommandBin.plugin.getConfig().getDouble(((Player)s).getName() + ".home.y");
/* 131 */             double z = CommandBin.plugin.getConfig().getDouble(((Player)s).getName() + ".home.z");
/* 132 */             String world = (String)CommandBin.plugin.getConfig().get(((Player)s).getName() + ".home.world");
/*     */ 
/* 134 */             ((Player)s).teleport(new Location(Bukkit.getServer().getWorld(world), x, y, z));
/* 135 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported to your home!");
/*     */           }
/*     */           else
/*     */           {
/* 139 */             ((Player)s).sendMessage(ChatColor.RED + "You have no home! Type /sethome to set it!");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 144 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 151 */       s.sendMessage(ChatColor.RED + "You can't use home commands in console!");
/*     */     }
/* 153 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.HomeCommands
 * JD-Core Version:    0.6.0
 */