// Package Declaration
package me.iffa.trashcan.commands.general;

// Java Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TrashCan Imports
import me.iffa.trashcan.TrashCan;
import me.iffa.trashcan.commands.TrashCommand;
import me.iffa.trashcan.utils.HelpPage;
import me.iffa.trashcan.utils.MessageUtil;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Represents /help.
 * 
 * @author iffamies
 */
public class HelpCommand extends TrashCommand {
    // Variables
    private Map<Integer, HelpPage> pages = new HashMap<Integer, HelpPage>();

    /**
     * Constructor of HelpCommand.
     * 
     * @param label 
     */
    public HelpCommand(String label) {
        super(label);
    }

    /**
     * Sets up help pages.
     */
    @SuppressWarnings("unchecked")
    public void setupHelp() {
        // TODO: Set up help pages here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean executeCommand(CommandSender cs, String[] args) {
        if (args.length < 1) {
            pages.get(1).sendHelpPage(cs);
        } else {
            int page = 0;
            try {
                page = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex) {
                return false;
            }
            if (!pages.containsKey(page)) {
                MessageUtil.sendMessage(cs, ChatColor.RED + "Page not found! Valid pages: 1-" + pages.size() + ".");
                return true;
            }
            pages.get(page).sendHelpPage(cs);
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendUsage(CommandSender cs) {
        MessageUtil.sendMessage(cs, ChatColor.GRAY + "Usage: /help [page (1-" + pages.size() + ")]");
    }
}
