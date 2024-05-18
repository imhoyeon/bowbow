package me.shy.bowbow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class bowWon {
    public static void remainTargetBlock(Player player) {
        Location isThereTarget = createTarget.getFirstTargetLocation();
        int countTarget = 49;

        for (int x = 1; x <= 7; x++){
            for (int y = 1; y <= 7; y++){
                if (isThereTarget.getBlock().getType() == Material.AIR){
                    countTarget--;
                    if (countTarget == 0){
                        Bowbow.wonGame(player);
                        Bowbow.endGame(player);
                    }
                    if (checkLose(player)){
                        Bowbow.loseGame(player);
                        Bowbow.endGame(player);
                    }
                }
                isThereTarget.add(0,1,0);
            }
            isThereTarget.add(0,-7,1);
        }
        isThereTarget.add(0,0,-7);

    }
    public static boolean checkLose(Player player){
        ItemStack[] invContents = player.getInventory().getContents(); // 인벤토리 안에있는 모든 내용을 배열로 가져옴
        int arrowCount = 0;

        for (ItemStack itemStack : invContents) {   // 배열 안에 있는 모든 내용을 for 문으로 돈다
            if (itemStack.getType() == Material.ARROW) { // 화살이 있는지 체크한다
                arrowCount += itemStack.getAmount();    // 화살의 개수를 가져온다
            }
        }

        return arrowCount != 0;
    }
}
