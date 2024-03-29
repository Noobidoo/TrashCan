// Package Declaration
package me.iffa.trashcan.commands.general;

// TrashCan Imports
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents /feed.
 * 
 * @author iffamies
 */
public class FeedCommand extends TrashCommand {
    /**
     * Constructor of FeedCommand.
     * 
     * @param label Command label
     */
    public FeedCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (args.length < 1) {
            if (!(cs instanceof Player)) {
                MessageUtil.sendMessage(cs, "Sorry, only players can use this command.");
                return true;
            }
            if (!cs.hasPermission("trashcan.general.feed")) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
                return true;
            }
            ((Player)cs).setFoodLevel(20);
            MessageUtil.sendMessage(cs, ChatColor.GOLD + "You've been fed!");
            return true;
        } else {
            if (!cs.hasPermission("trashcan.general.feed.others")) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "The player was not found!");
                return true;
            }
            target.setFoodLevel(20);
            MessageUtil.sendMessage(target, ChatColor.GOLD + "You've been fed!");
            MessageUtil.sendMessage(cs, ChatColor.GOLD + "'" + target.getName() + "' was fed!");
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /feed [player]");
    }
    
}
