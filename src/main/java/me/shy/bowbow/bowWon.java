package me.shy.bowbow;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class bowWon {
    public static int remainTargetBlock() {
        Location isThereTarget = createTarget.getFirstTargetLocation();
        int countTarget = 49;
        for (int x = 1; x <= 7; x++){
            for (int y = 1; y <= 7; y++){
                if (isThereTarget.getBlock().getType() == Material.AIR){
                    --countTarget;
                }
                isThereTarget.add(0,1,0);
            }
            isThereTarget.add(0,-7,1);
        }
        isThereTarget.add(0,0,-7);

        return countTarget;
    }
    public static int getArrowCount(Player player, String s){
        Inventory invContents = player.getInventory(); // 인벤토리 안에있는 모든 내용을 배열로 가져옴
        int arrowCount = 0;

        for (ItemStack itemStack : invContents.getContents()) {   // 배열 안에 있는 모든 내용을 for 문으로 돈다
            if (itemStack != null && itemStack.getType() == Material.ARROW && itemStack.getItemMeta().getDisplayName().equals(s)) { // 화살이 있는지 체크한다
                arrowCount += itemStack.getAmount();    // 화살의 개수를 가져온다
            }
        }
        Bukkit.broadcast(Component.text(arrowCount));
        return arrowCount;
    }

    public static boolean asda(Player player) {
        int normal = getArrowCount(player, "일반 화살");
        int w = getArrowCount(player, "가로 화살");
        int h = getArrowCount(player, "세로 화살");
        Bukkit.broadcast(Component.text("남은 화살의 개수"));
        return normal + w + h == 0;
    }
}