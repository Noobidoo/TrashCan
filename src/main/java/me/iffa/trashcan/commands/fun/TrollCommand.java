// Package Declaration
package me.iffa.trashcan.commands.fun;

// TrashCan Imports
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Represents /troll.
 * TrashCan license: http://creativecommons.org/licenses/by-nc-nd/3.0/
 * 
 * @author iffamies
 */
public class TrollCommand extends TrashCommand {
    /**
     * Constructor of TrollCommand.
     * 
     * @param label Command label
     */
    public TrollCommand(String label) {
        super(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (!cs.hasPermission("trashcan.fun.troll")) {
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
        Material trollingItem = Material.DIAMOND;
        try {
            trollingItem = Material.getMaterial(args[1]);
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        if (trollingItem == null) {
            MessageUtil.sendMessage(cs, ChatColor.RED + "Invalid item '" + args[1] + "'!");
            return true;
        }
        target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(trollingItem, 0));
        MessageUtil.sendMessage(cs, ChatColor.GOLD + "'" + target.getName() + "' has been trolled!");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /troll <player> [item]");
    }
    
}
