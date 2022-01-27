package org.qeston.easymoneysystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.qeston.easymoneysystem.main.Main;
import org.qeston.easymoneysystem.utils.MoneySystem;

import static org.qeston.easymoneysystem.main.Main.color;

public class PayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 2){
                Player receiver = Bukkit.getPlayer(args[0]);
                if(receiver == null) {
                    sender.sendMessage("Player was not found");
                    return false;
                }
                if(isInteger(args[1])){
                    int amount = Integer.parseInt(args[1]);
                    MoneySystem.transfer(player, receiver, amount);
                    sender.sendMessage(color("&7You have sent &a" + MoneySystem.getPriceFromNumber(amount) + " &7to &a" + receiver.getName() + "&7!"));
                    receiver.sendMessage(color("&7You have received &a" + MoneySystem.getPriceFromNumber(amount) + " &7from &a" + sender.getName() + "&7!"));

                    return true;
                }
            }
        }
        else{
            if(args.length == 2){
                Player receiver = Bukkit.getPlayer(args[0]);
                if(receiver == null) {
                    sender.sendMessage("Player was not found");
                    return false;
                }
                if(isInteger(args[1])){
                    int amount = Integer.parseInt(args[1]);
                    MoneySystem.addMoney(receiver, amount);

                    sender.sendMessage(color("&7You have sent &a" + MoneySystem.getPriceFromNumber(amount) + " &7to &a" + receiver.getName() + "&7!"));
                    receiver.sendMessage(color("&7You have received &a" + MoneySystem.getPriceFromNumber(amount) + " &7from &aServer &7!"));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
