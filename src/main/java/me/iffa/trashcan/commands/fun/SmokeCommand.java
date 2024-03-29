// Package Declaration
package me.iffa.trashcan.commands.fun;

// TrashCan Imports
import me.iffa.trashcan.TrashCan;
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents /smoke.
 * 
 * @author iffamies
 */
public class SmokeCommand extends TrashCommand {
    /**
     * Constructor of SmokeCommand.
     * 
     * @param label Command label
     */
    public SmokeCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (cs.hasPermission("trashcan.fun.smoke")) {
            if (!(cs instanceof Player)) {
                MessageUtil.sendMessage(cs, "Sorry, only players can use this command.");
                return true;
            }
            TrashCan.getConfigHandler().setSmoke(!TrashCan.getConfigHandler().getSmoke((Player)cs), (Player)cs);
            if (TrashCan.getConfigHandler().getSmoke((Player)cs)) {
                MessageUtil.sendMessage(cs, ChatColor.GOLD + "Smoke has been enabled for you!");
            } else {
                MessageUtil.sendMessage(cs, ChatColor.GOLD + "Smoke has been disabled for you!");
            }
            return true;
        } else {
            MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
    }
    
}
