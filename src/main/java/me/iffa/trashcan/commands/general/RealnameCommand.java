// Package Declaration
package me.iffa.trashcan.commands.general;

// Java Imports
import java.util.ArrayList;
import java.util.List;

// TrashCan Imports
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents /realname.
 * 
 * @author iffamies
 */
public class RealnameCommand extends TrashCommand {
    /**
     * Constructor of RealnameCommand.
     * 
     * @param label Command label
     */
    public RealnameCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (!cs.hasPermission("trashcan.general.realname")) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
            return true;
        }
        if (args.length < 1) {
            return false;
        }
        List<String> reals = new ArrayList<String>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getDisplayName().equalsIgnoreCase(args[0]) || player.getDisplayName().contains(args[0])) {
                reals.add(player.getName());
            }
        }
        if (reals.isEmpty()) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "No player(s) online with nickname '" + args[0] + "'!");
        } else {
            MessageUtil.sendMessage(cs, ChatColor.GOLD + "All players with nickname '" + args[0] + "':");
            MessageUtil.sendMessage(cs, ChatColor.GRAY + reals.toString().replace("[", "").replace("]", ""));
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /realname <nick>");
    }
    
}
