package com.Jacksonnn.DCCore.StaffUtils.Reports;

import com.Jacksonnn.DCCore.StaffUtils.Reports.ReportTypes.BugReport;
import com.Jacksonnn.DCCore.StaffUtils.Reports.ReportTypes.PlayerReport;
import com.Jacksonnn.DCCore.StaffUtils.Reports.ReportTypes.StaffReport;
import com.Jacksonnn.DCCore.StaffUtils.Reports.ReportTypes.ToDoReport;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class ReportGeneral {
    public String reportsPrefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "DC Reports" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW + " ";
    private ArrayList<ToDoReport> todoReports = new ArrayList<>();
    private ArrayList<BugReport> bugReports = new ArrayList<>();
    private ArrayList<PlayerReport> playerReports = new ArrayList<>();
    private ArrayList<StaffReport> staffReports = new ArrayList<>();

    public ArrayList<REPORT_TYPE> getReportTypes() {
        ArrayList<REPORT_TYPE> reportTypes = new ArrayList<>();

        reportTypes.add(REPORT_TYPE.TODO);
        reportTypes.add(REPORT_TYPE.BUG);
        reportTypes.add(REPORT_TYPE.PLAYER);
        reportTypes.add(REPORT_TYPE.STAFF);

        return reportTypes;
    }

    public ToDoReport getToDoReport(int id) {
        for (ToDoReport report : todoReports) {
            if (report.getID() == id) {
                return report;
            }
        }
        return null;
    }

    public BugReport getBugReport(int id) {
        for (BugReport report : bugReports) {
            if (report.getID() == id) {
                return report;
            }
        }
        return null;
    }

    public PlayerReport getPlayerReport(int id) {
        for (PlayerReport report : playerReports) {
            if (report.getID() == id) {
                return report;
            }
        }
        return null;
    }

    public StaffReport getStaffReport(int id) {
        for (StaffReport report : staffReports) {
            if (report.getID() == id) {
                return report;
            }
        }
        return null;
    }

    public ArrayList<ToDoReport> getTodoReports() {
        return todoReports;
    }

    public ArrayList<BugReport> getBugReports() {
        return bugReports;
    }

    public ArrayList<PlayerReport> getPlayerReports() {
        return playerReports;
    }

    public ArrayList<StaffReport> getStaffReports() {
        return staffReports;
    }

    public void addReport(Object report) {
        if (report instanceof ToDoReport) {
            Bukkit.getLogger().info("Adding report to overall todo reports...");
            todoReports.add((ToDoReport) report);
            Bukkit.getLogger().info("Successfully added todo report!");
        } else if (report instanceof BugReport) {
            Bukkit.getLogger().info("Adding report to overall bug reports...");
            bugReports.add((BugReport) report);
            Bukkit.getLogger().info("Successfully added bug report!");
        } else if (report instanceof PlayerReport) {
            Bukkit.getLogger().info("Adding report to overall player reports...");
            playerReports.add((PlayerReport) report);
            Bukkit.getLogger().info("Successfully added player report!");
        } else if (report instanceof StaffReport) {
            Bukkit.getLogger().info("Adding report to overall staff reports...");
            staffReports.add((StaffReport) report);
            Bukkit.getLogger().info("Successfully added staff report!");
        }
    }

    public void removeReport(Object report) {
        if (report instanceof ToDoReport) {
            Bukkit.getLogger().info("Removing report from overall todo reports...");
            todoReports.remove(report);
            Bukkit.getLogger().info("Successfully removed todo report!");
        } else if (report instanceof BugReport) {
            Bukkit.getLogger().info("Removing report from overall bug reports...");
            bugReports.remove(report);
            Bukkit.getLogger().info("Successfully removed bug report!");
        } else if (report instanceof PlayerReport) {
            Bukkit.getLogger().info("Removing report from overall player reports...");
            playerReports.remove(report);
            Bukkit.getLogger().info("Successfully removed player report!");
        } else if (report instanceof StaffReport) {
            Bukkit.getLogger().info("Removing report from overall staff reports...");
            staffReports.remove(report);
            Bukkit.getLogger().info("Successfully removed staff report!");
        }
    }

    public void getHelp(CommandSender sender) {
        sender.sendMessage(reportsPrefix + "Report Commands: ");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/reports help");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/reports add <type>");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/reports delete <type> <id>");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/reports list <type>");
        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "/reports clear <type>");

        String[] rTypes = new String[4];
        int i = 0;
        for (REPORT_TYPE type : getReportTypes()) {
            rTypes[i] = type.getShorthand();
            i++;
        }

        sender.sendMessage(org.bukkit.ChatColor.YELLOW + "VALID REPORT TYPES: \"" + String.join("\", \"", rTypes) + "\"");
    }

    public enum REPORT_TYPE {
        TODO("To-Do Report", "todo"),
        BUG("Bug Report", "bug"),
        PLAYER("Player Report", "player"),
        STAFF("Staff Report", "staff");

        private String generalUsage;
        private String shorthand;

        REPORT_TYPE(String generalUsage, String shorthand) {
            this.generalUsage = generalUsage;
            this.shorthand = shorthand;
        }

        public String getGeneralUsage() {
            return generalUsage;
        }

        public String getShorthand() {
            return shorthand;
        }
    }
}
