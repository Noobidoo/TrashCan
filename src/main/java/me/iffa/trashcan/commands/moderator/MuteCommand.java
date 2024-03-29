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
 * Represents /mute.
 * 
 * @author iffamies
 */
public class MuteCommand extends TrashCommand {
    /**
     * Constructor of MuteCommand.
     * 
     * @param label Command label
     */
    public MuteCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (!cs.hasPermission("trashcan.moderation.mute")) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
            return true;
        }
        if (args.length < 1) {
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "The player was not found!");
            return true;
        }
        TrashCan.getConfigHandler().setMuted(!TrashCan.getConfigHandler().getMuted(target), target);
        if (TrashCan.getConfigHandler().getMuted(target)) {
            MessageUtil.sendMessage(target, ChatColor.RED + "You have been muted!");
        } else {
            MessageUtil.sendMessage(target, ChatColor.GOLD + "You have been unmuted!");
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /mute <player>");
    }
    
}
