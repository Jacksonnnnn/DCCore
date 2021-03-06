package com.Jacksonnn.DCCore.StaffUtils.Warnings;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class WarningGeneral {
    public String warningPrefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "DC Warnings" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW + " ";
    private ArrayList<Warning> warnings = new ArrayList<>();

    public Warning getWarning(int id) {
        for (Warning warning : warnings) {
            if (warning.getID() == id) {
                return warning;
            }
        }

        return null;
    }

    public ArrayList<Warning> getAllWarnings() {
        return warnings;
    }

    public void addWarning(Warning warning) {
        Bukkit.getLogger().info("Adding warning to overall warnings...");
        warnings.add(warning);
        Bukkit.getLogger().info("Successfully added warning!");
    }

    public void removeWarning(Warning warning) {
        Bukkit.getLogger().info("Removing warning from overall warnings...");
        warnings.remove(warning);
        Bukkit.getLogger().info("Successfully removed warning!");
    }

    public void getHelp(CommandSender sender) {
        sender.sendMessage(warningPrefix + "Warning Commands: ");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/warning help");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/warning add <player> <note>");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/warning delete <id>");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/warning list <player>");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/warning clear <player>");
    }
}
