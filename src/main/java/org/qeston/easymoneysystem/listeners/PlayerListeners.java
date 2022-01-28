package org.qeston.easymoneysystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.qeston.easymoneysystem.main.Main;
import org.qeston.easymoneysystem.utils.MoneySystem;
import org.qeston.playerprefs.utils.PlayerPrefs;

import static org.qeston.easymoneysystem.main.Main.color;
import static org.qeston.easymoneysystem.utils.ScoreboardUtil.setScoreboard;

public class PlayerListeners implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent event){
        if(!PlayerPrefs.hasKey(event.getPlayer(), MoneySystem.keyName)){
            PlayerPrefs.setInt(event.getPlayer(), MoneySystem.keyName, 1000);
        }
        setScoreboard(event.getPlayer());
    }

    @EventHandler
    public void OnDeath(PlayerDeathEvent event){
        if(event.getEntity() instanceof Player){
            Player killed = event.getEntity();
            Player killer = killed.getKiller();

            int amount = MoneySystem.getBalance(killed);
            MoneySystem.transfer(killed, killer, amount);

            killer.sendMessage(color("&7You have received &a" + amount + "$ &7for killing &a" + killed.getName() + "&7!"));
            killed.sendMessage(color("&cYou have lost all your money to &e" + killed.getName() + "&c!"));

        }
    }
}
