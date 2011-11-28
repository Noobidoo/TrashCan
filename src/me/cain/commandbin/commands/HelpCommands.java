/*     */ package me.cain.commandbin.commands;
/*     */ 
/*     */ import me.cain.commandbin.CommandBin;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class HelpCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*     */   {
/*  17 */     if (l.equalsIgnoreCase("cbhelp"))
/*     */     {
/*  19 */       if ((s instanceof Player))
/*     */       {
/*  21 */         if (args.length < 1)
/*     */         {
/*  23 */           ((Player)s).sendMessage("/cbhelp [page-number]");
/*     */         }
/*  27 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.help"))
/*     */         {
/*  29 */           if (args[0].equalsIgnoreCase("1"))
/*     */           {
/*  31 */             ((Player)s).sendMessage("/tp [player] - Teleport to a player");
/*  32 */             ((Player)s).sendMessage("/tphere [player] - Teleport a player to you");
/*  33 */             ((Player)s).sendMessage("/setspawn - Set the world spawn");
/*  34 */             ((Player)s).sendMessage("/tpworld [world] - Teleport to a world");
/*  35 */             ((Player)s).sendMessage("/spawn - Teleport to the world spawn");
/*  36 */             ((Player)s).sendMessage("/tpall - Teleport all players to you");
/*  37 */             ((Player)s).sendMessage("/createworld [world] - Create a new world");
/*  38 */             ((Player)s).sendMessage("/unloadworld [world] - Unload a world");
/*     */           }
/*  40 */           if (args[0].equalsIgnoreCase("2"))
/*     */           {
/*  42 */             ((Player)s).sendMessage("/shutdown - Shut the server down");
/*  43 */             ((Player)s).sendMessage("/commandbin - CommandBin");
/*  44 */             ((Player)s).sendMessage("/join - A fake join message");
/*  45 */             ((Player)s).sendMessage("/leave - A fake leave message");
/*  46 */             ((Player)s).sendMessage("/ping - Pong!");
/*  47 */             ((Player)s).sendMessage("/creative - Set your mode to creative");
/*  48 */             ((Player)s).sendMessage("/survival - Set your mode to survival");
/*  49 */             ((Player)s).sendMessage("/shoot [player] - Shoots a player into the air");
/*     */           }
/*  51 */           if (args[0].equalsIgnoreCase("3"))
/*     */           {
/*  53 */             ((Player)s).sendMessage("/time [day/night] - Set your server time");
/*  54 */             ((Player)s).sendMessage("/rain - Make it rain");
/*  55 */             ((Player)s).sendMessage("/sun - Make the sun shine");
/*  56 */             ((Player)s).sendMessage("/kick [player] [reason] - Self explanotory");
/*  57 */             ((Player)s).sendMessage("/ban [player] [reason] - Ban a player");
/*  58 */             ((Player)s).sendMessage("/unban [player] - Unban a player");
/*  59 */             ((Player)s).sendMessage("/feed - Feed a player to full food bar");
/*  60 */             ((Player)s).sendMessage("/heal - Give yourself/others full health");
/*     */           }
/*  62 */           if (args[0].equalsIgnoreCase("4"))
/*     */           {
/*  64 */             ((Player)s).sendMessage("/freeze [player] - Stop a player from moving");
/*  65 */             ((Player)s).sendMessage("/unfreeze [player] - Reallow a player to move");
/*  66 */             ((Player)s).sendMessage("/facepalm - Nuff said.");
/*  67 */             ((Player)s).sendMessage("/god [on/off] - Enable/disable godmode");
/*  68 */             ((Player)s).sendMessage("/snowman - Enable Snowman Mode!");
/*  69 */             ((Player)s).sendMessage("/unsnowman - Disable Snowman Mode");
/*  70 */             ((Player)s).sendMessage("/explode [player] - Explode a player");
/*  71 */             ((Player)s).sendMessage("/light [player] - Set a player on fire");
/*     */           }
/*  73 */           if (args[0].equalsIgnoreCase("5"))
/*     */           {
/*  75 */             ((Player)s).sendMessage("/roll [x] [y] - Roll a random number");
/*  76 */             ((Player)s).sendMessage("/handicap [player] - Stop a player from using commands");
/*  77 */             ((Player)s).sendMessage("/unhandicap [player] - Reallow a player to use command");
/*  78 */             ((Player)s).sendMessage("/mute [player] - Mute a plyer");
/*  79 */             ((Player)s).sendMessage("/unmute [player] - Unmute a player");
/*  80 */             ((Player)s).sendMessage("/smoke [on/off] - Smoke particles around you");
/*  81 */             ((Player)s).sendMessage("/explosionstick [on/off] - The explosion stick!");
/*  82 */             ((Player)s).sendMessage("/lightningstick [on/off] - The lightning stick!");
/*     */           }
/*  84 */           if (args[0].equalsIgnoreCase("6"))
/*     */           {
/*  86 */             ((Player)s).sendMessage("/slap [player] - Slap a player");
/*  87 */             ((Player)s).sendMessage("/who [player] - Information about a player");
/*  88 */             ((Player)s).sendMessage("/clear - Clear your inventory");
/*  89 */             ((Player)s).sendMessage("/spawnmob [mob] [amount] - Spawn mobs");
/*  90 */             ((Player)s).sendMessage("/i [item] [amount] - Give yourself items");
/*  91 */             ((Player)s).sendMessage("/msg [player] [message] - Message a player");
/*  92 */             ((Player)s).sendMessage("/sethome [homename] - Set your home");
/*  93 */             ((Player)s).sendMessage("/home [homename] - Teleport to your home");
/*     */           }
/*  95 */           if (args[0].equalsIgnoreCase("7"))
/*     */           {
/*  97 */             ((Player)s).sendMessage("/setwarp [warp] - Set a warp");
/*  98 */             ((Player)s).sendMessage("/warp [name] - Teleport to a warp");
/*  99 */             ((Player)s).sendMessage("/delwarp [name] - Remove a warp");
/* 100 */             ((Player)s).sendMessage("/nick [player] [nickname] - Set a player's nickname");
/* 101 */             ((Player)s).sendMessage("/setxp [player] [xp] - Set your experience points");
/* 102 */             ((Player)s).sendMessage("/armour [iron/gold/diamond/leather/chainmail] - Nuff said.");
/* 103 */             ((Player)s).sendMessage("/kill [player] - Kill a player");
/* 104 */             ((Player)s).sendMessage("/up [amount] - Go up [x] amount of blocks");
/*     */           }
/* 106 */           if (args[0].equalsIgnoreCase("8"))
/*     */           {
/* 108 */             ((Player)s).sendMessage("/unlimited - Place unlimited blocks");
/* 109 */             ((Player)s).sendMessage("/delunlimited - Stop placement of unlimited blocks");
/* 110 */             ((Player)s).sendMessage("/crossbow - The crossbow");
/* 111 */             ((Player)s).sendMessage("/tp2p - Teleport one player to another");
/* 112 */             ((Player)s).sendMessage("/put - Put a player in the location your looking at");
/* 113 */             ((Player)s).sendMessage("/banip - Ban a player's IP address");
/* 114 */             ((Player)s).sendMessage("/unbanip - Unban a player's IP address");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 119 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 125 */         s.sendMessage(ChatColor.RED + "You can only view the commands in-game!");
/*     */       }
/*     */     }
/* 128 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.HelpCommands
 * JD-Core Version:    0.6.0
 */