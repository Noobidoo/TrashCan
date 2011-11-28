package me.cain.commandbin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import java.io.PrintStream;
import me.cain.commandbin.commands.CommandRegistration;
import me.cain.commandbin.config.ConfigSetup;
import me.cain.commandbin.listeners.EventRegistration;
import me.cain.commandbin.statistics.CallHome;
import me.cain.commandbin.statistics.Statistics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandBin extends JavaPlugin
{
  public String Plugin = "[CommandBin] ";
  public static CommandBin plugin;
  public static PermissionHandler permissionHandler;
  public String NoPermission = ChatColor.GRAY + "You have no permission to use this command.";
  public String PlayerOffline = ChatColor.RED + "This player is offline";

  public void onEnable()
  {
    plugin = this;
    setupCommandBin();
    System.out.println(this.Plugin + "Enabled successfully.");
    System.out.println(this.Plugin + "You are running version: v" + getDescription().getVersion());
  }

  public void setupCommandBin()
  {
    EventRegistration.setup();
    setupPermissions();
    CommandRegistration.SetupCommands();
    ConfigSetup.start();

    Statistics.StartStats();
    CallHome.init(plugin);
  }

  public void onDisable()
  {
    System.out.println(this.Plugin + "Disabled successfully.");
  }

  public void RegisterRecipes()
  {
    ShapelessRecipe lol = new ShapelessRecipe(new ItemStack(Material.TNT, 1));
    lol.addIngredient(Material.DIAMOND);
    lol.addIngredient(Material.GOLD_INGOT);
    lol.addIngredient(Material.STICK);
    Bukkit.getServer().addRecipe(lol);
  }

  public boolean pCheck(Player player, String l)
  {
    Plugin permissionsPlugin = getServer().getPluginManager().getPlugin("Permissions");
    if (permissionsPlugin == null) {
      return (player.hasPermission(l)) || (player.isOp());
    }

    return permissionHandler.has(player, l);
  }

  private void setupPermissions()
  {
    if (permissionHandler != null) {
      return;
    }

    Plugin permissionsPlugin = getServer().getPluginManager().getPlugin("Permissions");

    if (permissionsPlugin == null) {
      System.out.println(this.Plugin + "I could not detect any Permissions on your server. Defaulting to OP!");
      return;
    }

    permissionHandler = ((Permissions)permissionsPlugin).getHandler();
    System.out.println(this.Plugin + "Permissions Plugin Found and will use plugin " + ((Permissions)permissionsPlugin).getDescription().getFullName() + "!");
  }
}