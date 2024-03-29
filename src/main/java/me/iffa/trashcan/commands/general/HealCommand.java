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
 * Represents /heal.
 * 
 * @author iffamies
 */
public class HealCommand extends TrashCommand {
    /**
     * Constructor of HealCommand.
     * 
     * @param label Command label
     */
    public HealCommand(String label) {
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
            if (!cs.hasPermission("trashcan.general.heal")) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
                return true;
            }
            ((Player)cs).setHealth(20);
            MessageUtil.sendMessage(cs, ChatColor.GOLD + "You've been healed!");
            return true;
        } else {
            if (!cs.hasPermission("trashcan.general.heal.others")) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "You don't have permission!");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "The player was not found!");
                return true;
            }
            target.setHealth(20);
            MessageUtil.sendMessage(target, ChatColor.GOLD + "You've been healed!");
            MessageUtil.sendMessage(cs, ChatColor.GOLD + "'" + target.getName() + "' was healed!");
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /heal [player]");
    }
    
}
