package me.cain.commandbin.commands;

import me.cain.commandbin.CommandBin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

public class MobCommands implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String [] args)
	{
		if(s instanceof Player)
		{
			if(l.equalsIgnoreCase("spawnmob"))
			{
				if(args.length < 2)
				{
					((Player) s).sendMessage("/" + l.toString() + " [mobname] [amount]");
					((Player) s).sendMessage("Mobs: chicken, cow, pig, sheep, squid, enderman, pigman, wolf, cavespider, creeper, ghast, silverfish, skeleton, slime, spider, zombie, enderdragon, villager");
				}
				else
				{
					if(CommandBin.plugin.pCheck((Player) s, "CommandBin.general.mob"))
					{
						try
						{
							if(CreatureType.valueOf(args[0].toUpperCase()) != null)
							{
									int mob = Integer.parseInt(args[1]);
									Location block = ((Player) s).getTargetBlock(null, 0).getRelative(BlockFace.UP, 2).getLocation();
									for(int i = 0; i < mob; i++)
									{
										((Player) s).getWorld().spawnCreature(block, CreatureType.valueOf(args[0].toUpperCase()));
									}
									((Player) s).sendMessage(ChatColor.GREEN + "Spawned " + args[1] + args[0] + "(s)");
							}
						} catch (IllegalArgumentException e)
						{
							((Player) s).sendMessage(ChatColor.RED + "This creature does not exist. (" + args[0] + ")");
						}
					}
					else
					{
						((Player) s).sendMessage(CommandBin.plugin.NoPermission);
					}
				}
			}
		}
		else
		{
			s.sendMessage(ChatColor.RED + "You can't spawn mobs in console!");
		}
		return false;
	}

}
