package me.cain.commandbin.commands;

import me.cain.commandbin.CommandBin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SnowmanCommands
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command c, String l, String[] args)
  {
    if ((s instanceof Player))
    {
      if (l.equalsIgnoreCase("snowman"))
      {
        if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.snowman"))
        {
          CommandBin.plugin.getConfig().set(((Player)s).getName() + ".snowman", Boolean.valueOf(true));
          ((Player)s).sendMessage(ChatColor.GREEN + "You are now Frosty The Snowman! Start walking!");
          CommandBin.plugin.saveConfig();
        }
        else
        {
          ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
        }
      }

      if (l.equalsIgnoreCase("unsnowman"))
      {
        if (CommandBin.plugin.pCheck((Player)s, "CommandBin.general.snowman"))
        {
          CommandBin.plugin.getConfig().set(((Player)s).getName() + ".snowman", Boolean.valueOf(false));
          ((Player)s).sendMessage(ChatColor.GREEN + "You are no longer Frosty The Snowman. :(");
          CommandBin.plugin.saveConfig();
        }
        else
        {
          ((Player)s).sendMessage(CommandBin.plugin.NoPermission);
        }
      }
    }
    else
    {
      s.sendMessage(ChatColor.RED + "You can't use snowman commands in-console!");
    }
    return false;
  }
}