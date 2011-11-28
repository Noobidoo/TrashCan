/*    */ package me.cain.commandbin.commands;
/*    */ 
/*    */ import me.cain.commandbin.CommandBin;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.CreatureType;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class MobCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 19 */     if ((s instanceof Player))
/*    */     {
/* 21 */       if (l.equalsIgnoreCase("spawnmob"))
/*    */       {
/* 23 */         if (args.length < 2)
/*    */         {
/* 25 */           ((Player)s).sendMessage("/" + l.toString() + " [mobname] [amount]");
/* 26 */           ((Player)s).sendMessage("Mobs: chicken, cow, pig, sheep, squid, enderman, pigman, wolf, cavespider, creeper, ghast, silverfish, skeleton, slime, spider, zombie, enderdragon, villager");
/*    */         }
/* 30 */         else if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.mob"))
/*    */         {
/*    */           try
/*    */           {
/* 34 */             if (CreatureType.valueOf(args[0].toUpperCase()) == null) break label321;
/* 36 */             int mob = Integer.parseInt(args[1]);
/* 37 */             Location block = ((Player)s).getTargetBlock(null, 0).getRelative(BlockFace.UP, 2).getLocation();
/* 38 */             for (int i = 0; i < mob; i++)
/*    */             {
/* 40 */               ((Player)s).getWorld().spawnCreature(block, CreatureType.valueOf(args[0].toUpperCase()));
/*    */             }
/* 42 */             ((Player)s).sendMessage(ChatColor.GREEN + "Spawned " + args[1] + args[0] + "(s)");
/*    */           }
/*    */           catch (IllegalArgumentException e)
/*    */           {
/* 46 */             ((Player)s).sendMessage(ChatColor.RED + "This creature does not exist. (" + args[0] + ")");
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* 51 */           ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 58 */       s.sendMessage(ChatColor.RED + "You can't spawn mobs in console!");
/*    */     }
/* 60 */     label321: return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.MobCommands
 * JD-Core Version:    0.6.0
 */