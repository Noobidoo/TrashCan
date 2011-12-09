// Package Declaration
package me.iffa.trashcan.commands.moderator;

// TrashCan Imports
import me.iffa.trashcan.TrashCan;
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents /say.
 * TrashCan license: http://creativecommons.org/licenses/by-nc-nd/3.0/
 * 
 * @author iffamies
 */
public class SayCommand extends TrashCommand {
    /**
     * Constructor of SayCommand.
     * 
     * @param label Command label
     */
    public SayCommand(String label) {
        super(label);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (!cs.hasPermission("trashcan.moderation.say")) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
            return true;
        }
        if (args.length < 1) {
            return false;
        }
        StringBuilder builder = new StringBuilder(1337);
        for (int arg = 0; arg < args.length; arg++) {
            builder.append(" ").append(args[arg]);
        }
        Bukkit.broadcastMessage(ChatColor.GRAY + "<" + ChatColor.GOLD + (cs instanceof Player ? cs.getName() : TrashCan.getConfigHandler().getConsoleName()) + ChatColor.GRAY + ">" + builder.toString());
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /say <message>");
    }
}
