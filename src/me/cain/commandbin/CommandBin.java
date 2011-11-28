/*     */ package me.cain.commandbin;
/*     */ 
/*     */ import com.nijiko.permissions.PermissionHandler;
/*     */ import com.nijikokun.bukkit.Permissions.Permissions;
/*     */ import java.io.PrintStream;
/*     */ import me.cain.commandbin.commands.CommandRegistration;
/*     */ import me.cain.commandbin.config.ConfigSetup;
/*     */ import me.cain.commandbin.listeners.EventRegistration;
/*     */ import me.cain.commandbin.statistics.CallHome;
/*     */ import me.cain.commandbin.statistics.Statistics;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.ShapelessRecipe;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class CommandBin extends JavaPlugin
/*     */ {
/*  23 */   public String Plugin = "[CommandBin] ";
/*     */   public static CommandBin plugin;
/*     */   public static PermissionHandler permissionHandler;
/*  26 */   public String NoPermission = ChatColor.GRAY + "You have no permission to use this command.";
/*  27 */   public String PlayerOffline = ChatColor.RED + "This player is offline";
/*     */ 
/*     */   public void onEnable()
/*     */   {
/*  99 */     plugin = this;
/* 100 */     setupCommandBin();
/* 101 */     System.out.println(this.Plugin + "Enabled successfully.");
/* 102 */     System.out.println(this.Plugin + "You are running version: v" + getDescription().getVersion());
/*     */   }
/*     */ 
/*     */   public void setupCommandBin()
/*     */   {
/* 107 */     EventRegistration.setup();
/* 108 */     setupPermissions();
/* 109 */     CommandRegistration.SetupCommands();
/* 110 */     ConfigSetup.start();
/*     */ 
/* 112 */     Statistics.StartStats();
/* 113 */     CallHome.init(plugin);
/*     */   }
/*     */ 
/*     */   public void onDisable()
/*     */   {
/* 118 */     System.out.println(this.Plugin + "Disabled successfully.");
/*     */   }
/*     */ 
/*     */   public void RegisterRecipes()
/*     */   {
/* 124 */     ShapelessRecipe lol = new ShapelessRecipe(new ItemStack(Material.TNT, 1));
/* 125 */     lol.addIngredient(Material.DIAMOND);
/* 126 */     lol.addIngredient(Material.GOLD_INGOT);
/* 127 */     lol.addIngredient(Material.STICK);
/* 128 */     Bukkit.getServer().addRecipe(lol);
/*     */   }
/*     */ 
/*     */   public boolean pCheck(Player player, String l)
/*     */   {
/* 134 */     Plugin permissionsPlugin = getServer().getPluginManager().getPlugin("Permissions");
/* 135 */     if (permissionsPlugin == null) {
/* 136 */       return (player.hasPermission(l)) || (player.isOp());
/*     */     }
/*     */ 
/* 140 */     return permissionHandler.has(player, l);
/*     */   }
/*     */ 
/*     */   private void setupPermissions()
/*     */   {
/* 145 */     if (permissionHandler != null) {
/* 146 */       return;
/*     */     }
/*     */ 
/* 149 */     Plugin permissionsPlugin = getServer().getPluginManager().getPlugin("Permissions");
/*     */ 
/* 151 */     if (permissionsPlugin == null) {
/* 152 */       System.out.println(this.Plugin + "I could not detect any Permissions on your server. Defaulting to OP!");
/* 153 */       return;
/*     */     }
/*     */ 
/* 156 */     permissionHandler = ((Permissions)permissionsPlugin).getHandler();
/* 157 */     System.out.println(this.Plugin + "Permissions Plugin Found and will use plugin " + ((Permissions)permissionsPlugin).getDescription().getFullName() + "!");
/*     */   }
/*     */ }

/* Location:           C:\Users\iffamies\Desktop\JD GUI\CommandBin (1).jar
 * Qualified Name:     me.cain.commandbin.CommandBin
 * JD-Core Version:    0.6.0
 */