// Package Declaration
package me.iffa.trashcan.commands.admin;

// TrashCan Imports
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents /time.
 * 
 * @author iffamies
 */
public class TimeCommand extends TrashCommand {
    /**
     * Constructor of TimeCommand.
     * 
     * @param label Command label
     */
    public TimeCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (!(cs instanceof Player)) {
            MessageUtil.sendMessage(cs, "Sorry, only players can use this command.");
            return true;
        }
        if (args.length < 1) {
            return false;
        }
        Player player = (Player) cs;
        if (!player.hasPermission("trashcan.admin.time")) {
            MessageUtil.sendMessage(player, ChatColor.RED + "You don't have permission!");
            return true;
        }
        if (args[0].equalsIgnoreCase("day")) {
            player.getWorld().setTime(0);
            MessageUtil.sendMessage(player, ChatColor.GREEN + "Changed time of '" + player.getWorld() + "' to day!");
        } else if (args[0].equalsIgnoreCase("night")) {
            player.getWorld().setTime(13801);
            MessageUtil.sendMessage(player, ChatColor.GREEN + "Changed time of '" + player.getWorld() + "' to night!");
        } else {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /time <day/night>");
    }
    
}
