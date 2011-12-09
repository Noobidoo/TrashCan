// Package Declaration
package me.iffa.trashcan.commands.fun;

// TrashCan Imports
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents /fsay.
 * 
 * @author iffamies
 */
public class ForcesayCommand extends TrashCommand {
    /**
     * Constructor of ForcesayCommand.
     * 
     * @param label Command label
     */
    public ForcesayCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (!cs.hasPermission("trashcan.fun.fsay")) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
            return true;
        }
        if (args.length < 2) {
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "The player was not found!");
            return true;
        }
        StringBuilder message = new StringBuilder(1337);
        for (int arg = 1; arg < args.length; arg++) {
            message.append(args[arg]).append(" ");
        }
        target.chat(message.toString());
        MessageUtil.sendMessage(cs, ChatColor.GOLD + "The player has been forced to chat!");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /fsay <player> <message>");
    }
    
}
