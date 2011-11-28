package me.cain.commandbin.config;

import java.io.PrintStream;
import me.cain.commandbin.CommandBin;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;

public class ConfigSetup
{
  public static void start()
  {
    CommandBin.plugin.getConfig().options().header(
      "###############################\nDefault Configuration File for CommandBin \nCommandBin was created by CainFoool\nAll the values generated below are default and are fully editable.\nFeel free to edit them as you plead.\nEvery time this plugin starts up, this text\nWill be generated every time (sorry :p)\n\nCainFoool\n###############################\n");

    if (CommandBin.plugin.getConfig().getString("settings.shutdownmessage", null) == null)
    {
      CommandBin.plugin.getConfig().set("settings.shutdownmessage", "The server is going down for shutdown!");
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default shutdown message");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.broadcastkick") == null)
    {
      CommandBin.plugin.getConfig().set("settings.broadcastkick", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default broadcast on kick");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.broadcastban") == null)
    {
      CommandBin.plugin.getConfig().set("settings.broadcastban", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default broadcast on ban");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().getString("settings.playerismuted", null) == null)
    {
      CommandBin.plugin.getConfig().set("settings.playerismuted", "You are muted, shh!");
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Player is Muted message");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().getString("settings.playercannotusecommands", null) == null)
    {
      CommandBin.plugin.getConfig().set("settings.playercannotusecommands", "You cannot use commands. Stop trying!");
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default player cannot use commands message");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().getString("settings.joinmessage", null) == null)
    {
      CommandBin.plugin.getConfig().set("settings.joinmessage", "has joined the game");
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Join Message");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().getString("settings.leavemessage", null) == null)
    {
      CommandBin.plugin.getConfig().set("settings.leavemessage", "has left the game");
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Leave Message");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.dropxpondeath") == null)
    {
      CommandBin.plugin.getConfig().set("settings.dropxpondeath", Boolean.valueOf(false));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Drop XP on Death");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().getString("settings.craftbukkitversion", null) == null)
    {
      CommandBin.plugin.getConfig().set("settings.craftbukkitversion", Bukkit.getServer().getVersion().toString());
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Craftbukkit Version");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.spawn-mob-max-amount") == null)
    {
      CommandBin.plugin.getConfig().set("settings.spawn-mob-max-amount", Integer.valueOf(100));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default /spawnmob max amount");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.endermangriefing") == null)
    {
      CommandBin.plugin.getConfig().set("settings.endermangriefing", Boolean.valueOf(false));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Enderman can grief to false");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.block-placing-tnt") == null)
    {
      CommandBin.plugin.getConfig().set("settings.block-placing-tnt", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default block placing of tnt");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.block-placing-lava") == null)
    {
      CommandBin.plugin.getConfig().set("settings.block-placing-lava", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default block placing of lava");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.teleportonthrowegg") == null)
    {
      CommandBin.plugin.getConfig().set("settings.teleportonthrowegg", Boolean.valueOf(false));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default teleport on throw egg");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.blockcreeperexplosions") == null)
    {
      CommandBin.plugin.getConfig().set("settings.blockcreeperexplosions", Boolean.valueOf(false));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default block creeper explosions");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.orebroadcast.coalore") == null)
    {
      CommandBin.plugin.getConfig().set("settings.orebroadcast.coalore", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast coal");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.orebroadcast.ironore") == null)
    {
      CommandBin.plugin.getConfig().set("settings.orebroadcast.ironore", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast iron");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.orebroadcast.goldore") == null)
    {
      CommandBin.plugin.getConfig().set("settings.orebroadcast.goldore", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast gold");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.orebroadcast.diamondore") == null)
    {
      CommandBin.plugin.getConfig().set("settings.orebroadcast.diamondore", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast diamond");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.orebroadcast.redstoneore") == null)
    {
      CommandBin.plugin.getConfig().set("settings.orebroadcast.redstoneore", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast redstone");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.orebroadcast.lapislazuliore") == null)
    {
      CommandBin.plugin.getConfig().set("settings.orebroadcast.lapislazuliore", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ore broadcast lapis lazuli");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.mineablemobspawners") == null)
    {
      CommandBin.plugin.getConfig().set("settings.mineablemobspawners", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default mineable mob spawners");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.opscanseepms") == null)
    {
      CommandBin.plugin.getConfig().set("settings.opscanseepms", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default ops can see pms");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().getString("settings.message-of-the-day") == null)
    {
      CommandBin.plugin.getConfig().set("settings.message-of-the-day", "Please Modify This! [MOTD]");
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default message of the day");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.customchat") == null)
    {
      CommandBin.plugin.getConfig().set("settings.customchat", Boolean.valueOf(true));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default custom chat");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.bowexplosionradius") == null)
    {
      CommandBin.plugin.getConfig().set("settings.bowexplosionradius", Integer.valueOf(3));
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default bow explosion radius");
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.spawn-enderdragon-on-hitting-enderegg") == null)
    {
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default Enderegg");
      CommandBin.plugin.getConfig().set("settings.spawn-enderdragon-on-hitting-enderegg", Boolean.valueOf(true));
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.multihomesupport") == null)
    {
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting Multi Home Support");
      CommandBin.plugin.getConfig().set("settings.multihomesupport", Boolean.valueOf(true));
      CommandBin.plugin.saveConfig();
    }

    if (CommandBin.plugin.getConfig().get("settings.lightningonjoin") == null)
    {
      System.out.println(CommandBin.plugin.Plugin + "[Config] Setting default lightning on join");
      CommandBin.plugin.getConfig().set("settings.lightningonjoin", Boolean.valueOf(true));
      CommandBin.plugin.saveConfig();
    }
  }
}