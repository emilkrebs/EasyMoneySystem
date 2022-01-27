package org.qeston.easymoneysystem.utils;

import org.bukkit.entity.Player;
import org.qeston.playerprefs.utils.PlayerPrefs;

import static org.qeston.easymoneysystem.utils.ScoreboardUtil.setScoreboard;

public class MoneySystem {
    public static String keyName = "money";

    public void transfer(Player sender, Player receiver, int amount){
        removeMoney(sender, amount);
        addMoney(receiver, amount);
    }


    public int getBalance(Player player){
        return PlayerPrefs.getInt(player, keyName);
    }

    public String getBalanceString(Player player){
        return getPriceFromNumber( PlayerPrefs.getInt(player, keyName));
    }

    public void addMoney(Player player, int amount){
        int newBalance = PlayerPrefs.getInt(player, keyName) + amount;
        PlayerPrefs.setInt(player, keyName, newBalance);
        setScoreboard(player);
    }

    public void removeMoney(Player player, int amount){
        int newBalance = PlayerPrefs.getInt(player, keyName) - amount;
        PlayerPrefs.setInt(player, keyName, newBalance);
        setScoreboard(player);
    }

    public static String getPriceFromNumber(long number){
        if(number >= 1000000000){
            return String.format("%.2fB", number/ 1000000000.0);
        }

        if(number >= 1000000){
            return String.format("%.2fM", number/ 1000000.0);
        }

        if(number >= 100000){
            return String.format("%.2fL", number/ 100000.0);
        }

        if(number >=1000){
            return String.format("%.2fK", number/ 1000.0);
        }
        return String.valueOf(number);

    }
}
