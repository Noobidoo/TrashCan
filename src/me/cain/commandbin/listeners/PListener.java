/*     */ package me.cain.commandbin.listeners;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.CreatureType;
/*     */ import org.bukkit.entity.Egg;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerChatEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.event.player.PlayerEggThrowEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerListener;
/*     */ import org.bukkit.event.player.PlayerLoginEvent;
/*     */ import org.bukkit.event.player.PlayerLoginEvent.Result;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class PListener extends PlayerListener
/*     */ {
/*     */   static CommandBin derp;
/*     */ 
/*     */   public void onPlayerMove(PlayerMoveEvent e)
/*     */   {
/*  30 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".frozen"))
/*     */     {
/*  32 */       e.setCancelled(true);
/*     */     }
/*     */ 
/*  35 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".smoke"))
/*     */     {
/*  37 */       e.getPlayer().getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 5);
/*     */     }
/*     */ 
/*  40 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".snowman"))
/*     */     {
/*  42 */       if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN, 1).getType() != Material.AIR)
/*     */       {
/*  44 */         e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN, 0).setType(Material.SNOW);
/*     */       }
/*     */ 
/*  47 */       if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN, 1).getType() == Material.SNOW)
/*     */       {
/*  49 */         e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN, 1).setType(Material.SNOW_BLOCK);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e)
/*     */   {
/*  58 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".handicapped"))
/*     */     {
/*  60 */       e.getPlayer().sendMessage(ChatColor.RED + CommandBin.plugin.getConfig().getString("settings.playercannotusecommands"));
/*  61 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerChat(PlayerChatEvent e)
/*     */   {
/*  67 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".muted"))
/*     */     {
/*  69 */       e.getPlayer().sendMessage(ChatColor.RED + CommandBin.plugin.getConfig().getString("settings.playerismuted"));
/*  70 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerInteract(PlayerInteractEvent e)
/*     */   {
/*  88 */     if (e.getAction() == Action.RIGHT_CLICK_AIR)
/*     */     {
/*  90 */       if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".explosionstick"))
/*     */       {
/*  92 */         if (e.getPlayer().getItemInHand().getType() == Material.STICK)
/*     */         {
/*  94 */           Location block = e.getPlayer().getTargetBlock(null, 0).getLocation();
/*  95 */           e.getPlayer().getWorld().createExplosion(block, 8.0F);
/*     */         }
/*     */       }
/*     */ 
/*  99 */       if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".lightningstick"))
/*     */       {
/* 101 */         if (e.getPlayer().getItemInHand().getType() == Material.STICK)
/*     */         {
/* 103 */           Location block = e.getPlayer().getTargetBlock(null, 0).getLocation();
/* 104 */           e.getPlayer().getWorld().strikeLightning(block);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 109 */     if (e.getAction() == Action.LEFT_CLICK_BLOCK)
/*     */     {
/* 111 */       if (CommandBin.plugin.getConfig().getBoolean("settings.spawn-enderdragon-on-hitting-enderegg"))
/*     */       {
/* 113 */         if (e.getClickedBlock().getType() == Material.DRAGON_EGG)
/*     */         {
/* 115 */           Location dragon = e.getClickedBlock().getLocation();
/* 116 */           e.getPlayer().getWorld().spawnCreature(dragon, CreatureType.ENDER_DRAGON);
/* 117 */           e.getPlayer().sendMessage(ChatColor.RED + "You have made the Ender Dragon arise from hell!");
/* 118 */           e.getClickedBlock().setType(Material.AIR);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 123 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".frozen"))
/*     */     {
/* 125 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerLogin(PlayerLoginEvent e)
/*     */   {
/* 132 */     if (CommandBin.plugin.getConfig().getBoolean(e.getPlayer().getName() + ".banned"))
/*     */     {
/* 134 */       e.setKickMessage(CommandBin.plugin.getConfig().get(e.getPlayer().getName() + ".banreason").toString());
/* 135 */       e.disallow(PlayerLoginEvent.Result.KICK_BANNED, "You were banned for: " + ChatColor.GRAY + CommandBin.plugin.getConfig().get(new StringBuilder(String.valueOf(e.getPlayer().getName())).append(".banreason").toString()).toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerJoin(PlayerJoinEvent e)
/*     */   {
/* 142 */     if (CommandBin.plugin.getConfig().get("settings.joinmessage") != null)
/*     */     {
/* 144 */       e.setJoinMessage(ChatColor.YELLOW + e.getPlayer().getName() + " " + CommandBin.plugin.getConfig().get("settings.joinmessage").toString());
/*     */     }
/*     */ 
/* 147 */     if (CommandBin.plugin.getConfig().get(e.getPlayer().getName() + ".nickname") != null)
/*     */     {
/* 149 */       e.getPlayer().setDisplayName(CommandBin.plugin.getConfig().getString(e.getPlayer().getName() + ".nickname"));
/*     */     }
/*     */ 
/* 152 */     String motd = CommandBin.plugin.getConfig().getString("settings.message-of-the-day");
/* 153 */     for (String str : motd.split("/break"))
/*     */     {
/* 155 */       e.getPlayer().sendMessage(str.replace("[p]", e.getPlayer().getName()));
/*     */     }
/*     */ 
/* 160 */     if (CommandBin.plugin.getConfig().getBoolean("bannedips." + e.getPlayer().getAddress().getAddress().getHostAddress().toString().replace(".", "")))
/*     */     {
/* 162 */       e.getPlayer().kickPlayer("You have been IP banned from this server");
/* 163 */       e.setJoinMessage("");
/* 164 */       e.getPlayer().sendMessage("your ip is banned ;O");
/*     */     }
/*     */ 
/* 167 */     if (CommandBin.plugin.pCheck(e.getPlayer(), "CommandBin.other.strikeonjoin"))
/*     */     {
/* 169 */       if (CommandBin.plugin.getConfig().getBoolean("settings.lightningonjoin"))
/*     */       {
/* 171 */         e.getPlayer().getWorld().strikeLightningEffect(e.getPlayer().getLocation());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerQuit(PlayerQuitEvent e)
/*     */   {
/* 180 */     if (CommandBin.plugin.getConfig().get("settings.leavemessage") != null)
/*     */     {
/* 182 */       e.setQuitMessage(ChatColor.YELLOW + e.getPlayer().getName() + " " + CommandBin.plugin.getConfig().get("settings.leavemessage").toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPlayerRespawn(PlayerRespawnEvent e)
/*     */   {
/* 189 */     e.getPlayer().teleport(e.getPlayer().getWorld().getSpawnLocation());
/*     */   }
/*     */ 
/*     */   public void onPlayerEggThrow(PlayerEggThrowEvent e)
/*     */   {
/* 195 */     if (CommandBin.plugin.getConfig().getBoolean("settings.teleportonthrowegg"))
/*     */     {
/* 197 */       if (CommandBin.plugin.pCheck(e.getPlayer(), "CommandBin.general.canteleportonthrowegg"))
/*     */       {
/* 199 */         e.getPlayer().teleport(e.getEgg().getLocation());
/* 200 */         e.getPlayer().sendMessage(ChatColor.GREEN + "Teleported to the egg!");
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.listeners.PListener
 * JD-Core Version:    0.6.0
 */