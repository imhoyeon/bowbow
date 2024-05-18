package me.shy.bowbow;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bowbow extends JavaPlugin {

    public static void wonGame(Player player) {
        player.sendMessage("승리하셨습니다.");
    }

    public static void loseGame(Player player){
        player.sendMessage("패배하셨습니다.");
    }

    public static void endGame(Player player) {
        player.getInventory().clear();
        Location targetLocation = createTarget.getFirstTargetLocation();
        if (targetLocation != null && targetLocation.getWorld() != null) {
            for (int x = 1; x <= 7; x++){
                for (int y = 1; y <= 7; y++){
                    player.getWorld().getBlockAt(targetLocation.toLocation(player.getWorld())).setType(Material.AIR);
                    targetLocation.add(0,1,0);
                }
                targetLocation.add(0,-7,1);
            }
        }
        player.sendMessage("플레이 해주셔서 감사합니다.");
    }

    public static Bowbow plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getLogger().warning("bowbow 플러그인 활성화");
        Bukkit.getCommandMap().register("shooter", new itemCommand("item"));
        Bukkit.getPluginManager().registerEvents(new arrowTargetEvent(), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().warning("bowbow 플러그인 비활성화");
    }
}
