/*    */ package me.cain.commandbin.commands;
/*    */ 
/*    */ import me.cain.commandbin.CommandBin;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.World.Environment;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class WorldCommands
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String l, String[] args)
/*    */   {
/* 20 */     Player sender = (Player)s;
/*    */ 
/* 22 */     if (l.equalsIgnoreCase("createworld"))
/*    */     {
/* 24 */       if (args.length < 1)
/*    */       {
/* 26 */         sender.sendMessage("/" + l.toString() + " [worldname]");
/*    */       }
/* 30 */       else if (CommandBin.plugin.pCheck(sender, "CommandBin.world.create"))
/*    */       {
/* 32 */         sender.sendMessage(ChatColor.RED + "World creation in progress.. please wait.");
/* 33 */         Bukkit.getServer().createWorld(args[0], World.Environment.NORMAL);
/* 34 */         sender.sendMessage(ChatColor.GREEN + "New world '" + args[0] + "' created!");
/*    */       }
/*    */       else
/*    */       {
/* 38 */         sender.sendMessage(CommandBin.plugin.NoPermission);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 43 */     if (l.equalsIgnoreCase("unloadworld"))
/*    */     {
/* 45 */       if (args.length < 1)
/*    */       {
/* 47 */         sender.sendMessage("/" + l.toString() + " [worldname]");
/*    */       }
/* 51 */       else if (CommandBin.plugin.pCheck(sender, "CommandBin.world.unload"))
/*    */       {
/* 53 */         Bukkit.getServer().unloadWorld(args[0], true);
/* 54 */         sender.sendMessage(ChatColor.GREEN + "'" + args[0] + "' unloaded successfully!");
/*    */       }
/*    */       else
/*    */       {
/* 58 */         sender.sendMessage(CommandBin.plugin.NoPermission);
/*    */       }
/*    */     }
/*    */ 
/* 62 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.commands.WorldCommands
 * JD-Core Version:    0.6.0
 */