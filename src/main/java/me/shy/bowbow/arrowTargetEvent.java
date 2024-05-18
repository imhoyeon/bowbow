package me.shy.bowbow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class arrowTargetEvent extends Event implements Listener {
    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
    public static HandlerList getHandlerList(){
        return HANDLERS;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();


    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        // 화살이 아닐경우
        if (event.getEntity().getType() != EntityType.ARROW) {
            return;
        }

        // 블럭이 맞지 않았을경우
        Block hitBlock = event.getHitBlock();
        if (hitBlock == null) {
            return;
        }

        // 맞은 화살
        AbstractArrow arrow = (AbstractArrow) event.getEntity();

        // 쏜사람
        Player player = (Player) arrow.getShooter();
        Vector playerLocation = player.getLocation().toVector();
        Vector arrowLocation = arrow.getLocation().toVector();


        // 왼손에 무엇을 들고있는가
        ItemStack arrowOffHand = player.getInventory().getItemInOffHand();

        // 화살 이름 가져오기
        String arrowName = arrowOffHand.getItemMeta().getDisplayName();



        // 왼손에 화살이 있는가, 화살 이름이 뭔가 판단해서 맞은 블럭 제거
        if (calculateLocation(playerLocation,arrowLocation) && event.getHitBlock().getType() == Material.TARGET){
            if (!arrowOffHand.getType().equals(Material.ARROW)) {
                player.sendMessage("왼손에 화살을 넣고 쏴주세요.");
                return;
            } else if (arrowName.equals("일반 화살")){
                    hitBlock.setType(Material.AIR);
            } else if (arrowName.equals("가로 화살")) {
                removeHorizontalBlocks(hitBlock);
            } else if (arrowName.equals("세로 화살")) {
                removeVerticalBlocks(hitBlock);
            }
        } else {
            player.sendMessage("20블럭 이상에서 화살을 발사하거나 과녁 블럭에 화살을 발사해주세요.");
            return;
        }

        event.getEntity().remove();
        bowWon.remainTargetBlock(player);
    }

    private boolean calculateLocation(Vector playerLocation, Vector arrowLocation){
        double distance = playerLocation.distance(arrowLocation);
        return distance >= 20;
    }

    // 양옆 블록 제거
    private void removeHorizontalBlocks(Block hitBlock) {
        Block leftBlock = hitBlock.getRelative(0, 0, 1);
        Block rightBlock = hitBlock.getRelative(0, 0, -1);

        hitBlock.setType(Material.AIR);
        leftBlock.setType(Material.AIR);
        rightBlock.setType(Material.AIR);
    }

    // 위아래 블록 제거
    private void removeVerticalBlocks(Block hitBlock) {
        Block upperBlock = hitBlock.getRelative(0, 1, 0);
        Block lowerBlock = hitBlock.getRelative(0, -1, 0);

        hitBlock.setType(Material.AIR);
        upperBlock.setType(Material.AIR);
        lowerBlock.setType(Material.AIR);
    }

}
