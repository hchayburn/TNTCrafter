package net.hchayburn.tntcrafter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTCrafter extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        if (command.getName().equalsIgnoreCase("tntcraft")) {
            Player player = (Player) sender;
            if (!player.hasPermission("tntcrafter.use")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
                return true;
            }

            Inventory inventory = player.getInventory();
            ItemStack sulphur = new ItemStack(Material.SULPHUR, 4);
            ItemStack tnt = new ItemStack(Material.TNT, 1);

            if (inventory.containsAtLeast(sulphur, 4)) {
                inventory.removeItem(sulphur);
                inventory.addItem(new ItemStack(tnt));
                player.sendMessage(ChatColor.GREEN + "Your TNT has successfully been crafted!");
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "You do not have enough sulphur to craft TNT!");
            }
        }
        return false;
    }
}
