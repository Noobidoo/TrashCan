/*     */ package me.cain.commandbin.listeners;
/*     */ 
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Arrow;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;
/*     */ import org.bukkit.event.entity.EntityExplodeEvent;
/*     */ import org.bukkit.event.entity.EntityListener;
/*     */ import org.bukkit.event.entity.ProjectileHitEvent;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class EListener extends EntityListener
/*     */ {
/*     */   public void onEntityDamage(EntityDamageEvent e)
/*     */   {
/*  20 */     if ((e.getEntity() instanceof Player))
/*     */     {
/*  22 */       Player player = (Player)e.getEntity();
/*  23 */       if (CommandBin.plugin.getConfig().getBoolean(player.getName() + ".godmode"))
/*     */       {
/*  25 */         e.setCancelled(true);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onEntityDeath(EntityDeathEvent e)
/*     */   {
/*  33 */     if (CommandBin.plugin.getConfig().getBoolean("settings.dropxpondeath", false))
/*     */     {
/*  35 */       e.setDroppedExp(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onEntityExplode(EntityExplodeEvent e)
/*     */   {
/*  42 */     if (CommandBin.plugin.getConfig().getBoolean("settings.blockcreeperexplosions", true))
/*     */     {
/*  44 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onProjectileHit(ProjectileHitEvent e)
/*     */   {
/*  54 */     if ((e.getEntity() instanceof Arrow))
/*     */     {
/*  56 */       if ((((Arrow)e.getEntity()).getShooter() instanceof Player))
/*     */       {
/*  58 */         if (CommandBin.plugin.getConfig().getBoolean(((Player)((Arrow)e.getEntity()).getShooter()).getName() + ".torchbow"))
/*     */         {
/*  60 */           e.getEntity().getLocation().getBlock().setType(Material.TORCH);
/*     */         }
/*     */       }
/*     */ 
/*  64 */       if ((((Arrow)e.getEntity()).getShooter() instanceof Player))
/*     */       {
/*  66 */         if (CommandBin.plugin.getConfig().getBoolean(((Player)((Arrow)e.getEntity()).getShooter()).getName() + ".explosionbow"))
/*     */         {
/*  68 */           int radius = CommandBin.plugin.getConfig().getInt("settings.bowexplosionradius");
/*  69 */           e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), radius);
/*     */         }
/*     */       }
/*     */ 
/*  73 */       if ((((Arrow)e.getEntity()).getShooter() instanceof Player))
/*     */       {
/*  75 */         if (CommandBin.plugin.getConfig().getBoolean(((Player)((Arrow)e.getEntity()).getShooter()).getName() + ".crossbow"))
/*     */         {
/*  77 */           int radius = CommandBin.plugin.getConfig().getInt("settings.bowexplosionradius");
/*     */ 
/*  79 */           e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_ON);
/*  80 */           Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(e, radius)
/*     */           {
/*     */             public void run()
/*     */             {
/*  84 */               this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_OFF);
/*  85 */               Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
/*     */               {
/*     */                 public void run()
/*     */                 {
/*  89 */                   this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_ON);
/*  90 */                   Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
/*     */                   {
/*     */                     public void run()
/*     */                     {
/*  94 */                       this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_OFF);
/*  95 */                       Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
/*     */                       {
/*     */                         public void run()
/*     */                         {
/*  99 */                           this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_ON);
/* 100 */                           Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
/*     */                           {
/*     */                             public void run()
/*     */                             {
/* 104 */                               this.val$e.getEntity().getWorld().createExplosion(this.val$e.getEntity().getLocation(), this.val$radius);
/*     */                             }
/*     */                           }
/*     */                           , 5L);
/*     */                         }
/*     */                       }
/*     */                       , 20L);
/*     */                     }
/*     */                   }
/*     */                   , 20L);
/*     */                 }
/*     */               }
/*     */               , 20L);
/*     */             }
/*     */           }
/*     */           , 20L);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.listeners.EListener
 * JD-Core Version:    0.6.0
 */