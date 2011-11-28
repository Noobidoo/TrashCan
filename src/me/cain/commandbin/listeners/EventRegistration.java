package me.cain.commandbin.listeners;

import me.cain.commandbin.CommandBin;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;

public class EventRegistration
{
  CommandBin events;

  public static void setup()
  {
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_MOVE, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_INTERACT, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DAMAGE, new EListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_CHAT, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_LOGIN, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DEATH, new EListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.ENDERMAN_PICKUP, new EnderListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.ENDERMAN_PLACE, new EnderListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_TOGGLE_SPRINT, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_RESPAWN, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_GAME_MODE_CHANGE, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new BListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, new BListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_EGG_THROW, new PListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.ENTITY_EXPLODE, new EListener(), Event.Priority.Normal, CommandBin.plugin);
    Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PROJECTILE_HIT, new EListener(), Event.Priority.Normal, CommandBin.plugin);
  }
}