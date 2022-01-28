package org.qeston.easymoneysystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.qeston.easymoneysystem.main.Main;

public class ScoreboardUtil {

    public static void setScoreboard(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective sidebar = board.registerNewObjective("Sidebar", "dummy", "EasyMoney");
        sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score moneyText = sidebar.getScore(  ChatColor.AQUA + "" + ChatColor.BOLD +  "Money");
        moneyText.setScore(9);
        Score moneyAmount = sidebar.getScore( ChatColor.GREEN + MoneySystem.getBalanceString(player));
        moneyAmount.setScore(8);

        Objective belowName = board.registerNewObjective("Belowname", "dummy", "Money");
        belowName.setDisplaySlot(DisplaySlot.BELOW_NAME);
        belowName.setDisplayName(ChatColor.GREEN + String.valueOf(MoneySystem.getBalanceString(player)));

        player.setScoreboard(board);
    }

}
