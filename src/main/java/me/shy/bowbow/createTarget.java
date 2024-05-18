package me.shy.bowbow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class createTarget {
    private static Location firstTargetLocation;
    public static void createTargetPlayer(Player player){
        Random random = new Random();
        World world = player.getWorld();
        Location playerLocation = player.getLocation();
        int t = random.nextInt(20) + 20 ;
        Location targetLocation = playerLocation.add(t, 0, -3);
        Material material = Material.TARGET;
        firstTargetLocation = targetLocation.clone();
        for (int x = 1; x <= 7; x++){
            for (int y = 1; y <= 7; y++){
                player.getWorld().getBlockAt(targetLocation.toLocation(player.getWorld())).setType(material);
                targetLocation.add(0,1,0);
            }
            targetLocation.add(0,-7,1);
        }
    }
    public static Location getFirstTargetLocation() {
        return firstTargetLocation;
    }
}
