package de.syskoh.customCrafting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("You need to be a player to execute this command");
            return true;
        }

        Player p = (Player) commandSender;
        p.getInventory().addItem(CustomCrafting.customIngridient);
        p.sendMessage("§aHaste bekommen");

        return true;
    }
}
