/*     */ package me.cain.commandbin.listeners;
/*     */ 
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.event.block.BlockListener;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class BListener extends BlockListener
/*     */ {
/*     */   public void onBlockPlace(BlockPlaceEvent e)
/*     */   {
/*  18 */     if (CommandBin.plugin.getConfig().get(e.getPlayer().getName() + ".unlimited") != null)
/*     */     {
/*  20 */       if (CommandBin.plugin.getConfig().get(e.getPlayer().getName() + ".unlimited").equals(Boolean.valueOf(true)))
/*     */       {
/*  22 */         e.getPlayer().setItemInHand(new ItemStack(e.getPlayer().getItemInHand().getType(), 64));
/*     */       }
/*     */     }
/*     */ 
/*  26 */     if (CommandBin.plugin.getConfig().get("settings.block-placing-tnt") != null)
/*     */     {
/*  28 */       if (CommandBin.plugin.getConfig().get("settings.block-placing-tnt").equals(Boolean.valueOf(true)))
/*     */       {
/*  30 */         if (e.getBlock().getType() == Material.TNT)
/*     */         {
/*  32 */           if (!CommandBin.plugin.pCheck(e.getPlayer(), "CommandBin.general.tntbypass"))
/*     */           {
/*  34 */             e.setCancelled(true);
/*  35 */             e.getPlayer().sendMessage(ChatColor.RED + "Your administrator has disabled the placement of TNT.");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  41 */     if (CommandBin.plugin.getConfig().get("settings.block-placing-lava") != null)
/*     */     {
/*  43 */       if (CommandBin.plugin.getConfig().get("settings.block-placing-lava").equals(Boolean.valueOf(true)))
/*     */       {
/*  45 */         if ((e.getBlock().getType() == Material.LAVA) || (e.getBlock().getType() == Material.LAVA_BUCKET))
/*     */         {
/*  47 */           if (!CommandBin.plugin.pCheck(e.getPlayer(), "CommandBin.general.lavabypass"))
/*     */           {
/*  49 */             e.setCancelled(true);
/*  50 */             e.getPlayer().sendMessage(ChatColor.RED + "Your administrator has disabled the placement of LAVA.");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onBlockBreak(BlockBreakEvent e)
/*     */   {
/*  63 */     Block brokenblock = e.getBlock();
/*     */ 
/*  65 */     if (CommandBin.plugin.getConfig().getBoolean("settings.mineablemobspawners"))
/*     */     {
/*  67 */       if (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE)
/*     */       {
/*  69 */         if (brokenblock.getType() == Material.MOB_SPAWNER)
/*     */         {
/*  71 */           e.getPlayer().getWorld().dropItemNaturally(brokenblock.getLocation(), new ItemStack(Material.MOB_SPAWNER, 1));
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  76 */     if (CommandBin.plugin.getConfig().getBoolean("settings.orebroadcast.coalore"))
/*     */     {
/*  78 */       if (e.getBlock().getType() == Material.COAL_ORE)
/*     */       {
/*  80 */         Bukkit.getServer().broadcastMessage(ChatColor.GRAY + e.getPlayer().getName() + " mined some Coal Ore!");
/*     */       }
/*     */     }
/*     */ 
/*  84 */     if (CommandBin.plugin.getConfig().getBoolean("settings.orebroadcast.ironore"))
/*     */     {
/*  86 */       if (e.getBlock().getType() == Material.IRON_ORE)
/*     */       {
/*  88 */         Bukkit.getServer().broadcastMessage(e.getPlayer().getName() + " mined some Iron Ore!");
/*     */       }
/*     */     }
/*     */ 
/*  92 */     if (CommandBin.plugin.getConfig().getBoolean("settings.orebroadcast.goldore"))
/*     */     {
/*  94 */       if (e.getBlock().getType() == Material.GOLD_ORE)
/*     */       {
/*  96 */         Bukkit.getServer().broadcastMessage(ChatColor.GOLD + e.getPlayer().getName() + " mined some Gold Ore!");
/*     */       }
/*     */     }
/*     */ 
/* 100 */     if (CommandBin.plugin.getConfig().getBoolean("settings.orebroadcast.diamondore"))
/*     */     {
/* 102 */       if (e.getBlock().getType() == Material.DIAMOND_ORE)
/*     */       {
/* 104 */         Bukkit.getServer().broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + " mined some Diamond Ore!");
/*     */       }
/*     */     }
/*     */ 
/* 108 */     if (CommandBin.plugin.getConfig().getBoolean("settings.orebroadcast.redstoneore"))
/*     */     {
/* 110 */       if (e.getBlock().getType() == Material.REDSTONE_ORE)
/*     */       {
/* 112 */         Bukkit.getServer().broadcastMessage(ChatColor.RED + e.getPlayer().getName() + " mined some Redstone Ore!");
/*     */       }
/*     */     }
/*     */ 
/* 116 */     if (CommandBin.plugin.getConfig().getBoolean("settings.orebroadcast.lapislazuliore"))
/*     */     {
/* 118 */       if (e.getBlock().getType() == Material.LAPIS_ORE)
/*     */       {
/* 120 */         Bukkit.getServer().broadcastMessage(ChatColor.BLUE + e.getPlayer().getName() + " mined some Lapis Lazuli Ore!");
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.listeners.BListener
 * JD-Core Version:    0.6.0
 */