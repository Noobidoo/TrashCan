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
/*     */ public class WarpCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*     */   {
/*  20 */     if ((s instanceof Player))
/*     */     {
/*  22 */       if (l.equalsIgnoreCase("setwarp"))
/*     */       {
/*  24 */         if (args.length < 1)
/*     */         {
/*  26 */           ((Player)s).sendMessage("/" + l.toString() + " [warpname]");
/*     */         }
/*  30 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.setwarp"))
/*     */         {
/*  32 */           double x = ((Player)s).getLocation().getX();
/*  33 */           double y = ((Player)s).getLocation().getY();
/*  34 */           double z = ((Player)s).getLocation().getZ();
/*  35 */           World world = ((Player)s).getWorld();
/*     */ 
/*  37 */           if (CommandBin.plugin.getConfig().getString("settings.warps." + args[0]) == null)
/*     */           {
/*  39 */             CommandBin.plugin.getConfig().set("settings.warps." + args[0] + ".x", Double.valueOf(x));
/*  40 */             CommandBin.plugin.getConfig().set("settings.warps." + args[0] + ".y", Double.valueOf(y));
/*  41 */             CommandBin.plugin.getConfig().set("settings.warps." + args[0] + ".z", Double.valueOf(z));
/*  42 */             CommandBin.plugin.getConfig().set("settings.warps." + args[0] + ".world", world.getName());
/*  43 */             CommandBin.plugin.saveConfig();
/*  44 */             ((Player)s).sendMessage(ChatColor.GREEN + "Warp '" + args[0] + "' created.");
/*  45 */             ((Player)s).sendMessage(ChatColor.GREEN + "Use /warp " + args[0] + " to teleport!");
/*     */           }
/*     */           else
/*     */           {
/*  49 */             ((Player)s).sendMessage(ChatColor.RED + "Warp '" + args[0] + "' already exists!");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  54 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  59 */       if (l.equalsIgnoreCase("warp"))
/*     */       {
/*  61 */         if (args.length < 1)
/*     */         {
/*  63 */           ((Player)s).sendMessage("/" + l.toString() + " [warpname]");
/*     */         }
/*  67 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.warp"))
/*     */         {
/*  69 */           if (CommandBin.plugin.getConfig().get("settings.warps." + args[0]) != null)
/*     */           {
/*  71 */             double x = CommandBin.plugin.getConfig().getDouble("settings.warps." + args[0] + ".x");
/*  72 */             double y = CommandBin.plugin.getConfig().getDouble("settings.warps." + args[0] + ".y");
/*  73 */             double z = CommandBin.plugin.getConfig().getDouble("settings.warps." + args[0] + ".z");
/*  74 */             String world = (String)CommandBin.plugin.getConfig().get("settings.warps." + args[0] + ".world");
/*     */ 
/*  76 */             ((Player)s).teleport(new Location(Bukkit.getServer().getWorld(world), x, y, z));
/*  77 */             ((Player)s).sendMessage(ChatColor.GREEN + "Teleported to warp '" + args[0] + "' successfully!");
/*     */           }
/*     */           else
/*     */           {
/*  81 */             ((Player)s).sendMessage(ChatColor.RED + "This warp does not exist.");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  86 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  91 */       if (l.equalsIgnoreCase("delwarp"))
/*     */       {
/*  93 */         if (args.length < 1)
/*     */         {
/*  95 */           ((Player)s).sendMessage("/" + l.toString() + " [warpname]");
/*     */         }
/*  99 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.delwarp"))
/*     */         {
/* 101 */           if (CommandBin.plugin.getConfig().get("settings.warps." + args[0]) != null)
/*     */           {
/* 103 */             CommandBin.plugin.getConfig().set("settings.warps." + args[0], null);
/* 104 */             ((Player)s).sendMessage(ChatColor.GREEN + "Warp '" + args[0] + "' removed!");
/* 105 */             CommandBin.plugin.saveConfig();
/*     */           }
/*     */           else
/*     */           {
/* 109 */             ((Player)s).sendMessage(ChatColor.RED + "This warp does not exist");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 114 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 121 */       s.sendMessage(ChatColor.RED + "You can't use Warps in console!");
/*     */     }
/*     */ 
/* 124 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.WarpCommands
 * JD-Core Version:    0.6.0
 */