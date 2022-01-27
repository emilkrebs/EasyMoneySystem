package org.qeston.easymoneysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.qeston.easymoneysystem.main.Main;
import org.qeston.easymoneysystem.utils.MoneySystem;

import static org.qeston.easymoneysystem.main.Main.color;

public class BalanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(args.length == 0){
                sender.sendMessage(color("&aYou have &e" + MoneySystem.getBalanceString((Player) sender)));
                return true;
            }
        }
        if(args.length == 1) {
            sender.sendMessage(color("&a" + args[1] + " has &e" + MoneySystem.getBalanceString(Bukkit.getPlayer(args[1]))));
            return true;
        }
        return false;
    }
}
