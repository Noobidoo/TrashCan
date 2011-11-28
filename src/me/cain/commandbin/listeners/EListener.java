package me.cain.commandbin.listeners;

import me.cain.commandbin.CommandBin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class EListener extends EntityListener
{
  public void onEntityDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player player = (Player)e.getEntity();
      if (CommandBin.plugin.getConfig().getBoolean(player.getName() + ".godmode"))
      {
        e.setCancelled(true);
      }
    }
  }

  public void onEntityDeath(EntityDeathEvent e)
  {
    if (CommandBin.plugin.getConfig().getBoolean("settings.dropxpondeath", false))
    {
      e.setDroppedExp(0);
    }
  }

  public void onEntityExplode(EntityExplodeEvent e)
  {
    if (CommandBin.plugin.getConfig().getBoolean("settings.blockcreeperexplosions", true))
    {
      e.setCancelled(true);
    }
  }

  public void onProjectileHit(ProjectileHitEvent e)
  {
    if ((e.getEntity() instanceof Arrow))
    {
      if ((((Arrow)e.getEntity()).getShooter() instanceof Player))
      {
        if (CommandBin.plugin.getConfig().getBoolean(((Player)((Arrow)e.getEntity()).getShooter()).getName() + ".torchbow"))
        {
          e.getEntity().getLocation().getBlock().setType(Material.TORCH);
        }
      }

      if ((((Arrow)e.getEntity()).getShooter() instanceof Player))
      {
        if (CommandBin.plugin.getConfig().getBoolean(((Player)((Arrow)e.getEntity()).getShooter()).getName() + ".explosionbow"))
        {
          int radius = CommandBin.plugin.getConfig().getInt("settings.bowexplosionradius");
          e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), radius);
        }
      }

      if ((((Arrow)e.getEntity()).getShooter() instanceof Player))
      {
        if (CommandBin.plugin.getConfig().getBoolean(((Player)((Arrow)e.getEntity()).getShooter()).getName() + ".crossbow"))
        {
          int radius = CommandBin.plugin.getConfig().getInt("settings.bowexplosionradius");

          e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_ON);
          Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(e, radius)
          {
            public void run()
            {
              this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_OFF);
              Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
              {
                public void run()
                {
                  this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_ON);
                  Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
                  {
                    public void run()
                    {
                      this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_OFF);
                      Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
                      {
                        public void run()
                        {
                          this.val$e.getEntity().getLocation().getBlock().setType(Material.REDSTONE_TORCH_ON);
                          Bukkit.getScheduler().scheduleAsyncDelayedTask(CommandBin.plugin, new Runnable(this.val$e, this.val$radius)
                          {
                            public void run()
                            {
                              this.val$e.getEntity().getWorld().createExplosion(this.val$e.getEntity().getLocation(), this.val$radius);
                            }
                          }
                          , 5L);
                        }
                      }
                      , 20L);
                    }
                  }
                  , 20L);
                }
              }
              , 20L);
            }
          }
          , 20L);
        }
      }
    }
  }
}