package me.shy.bowbow;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemBow {

    public static void createItem(Player player){
        ItemStack itemBow = new ItemStack(Material.BOW, 1);
        ItemMeta itemBowMeta = itemBow.getItemMeta();
        itemBowMeta.setDisplayName("미니게임용 활");
        itemBow.setItemMeta(itemBowMeta);

        ItemStack itemArrow1 = new ItemStack(Material.ARROW, 30);
        ItemMeta itemArrow1Meta = itemArrow1.getItemMeta();
        itemArrow1Meta.setDisplayName("일반 화살");
        itemArrow1.setItemMeta(itemArrow1Meta);

        ItemStack itemArrow2 = new ItemStack(Material.ARROW, 10);
        ItemMeta itemArrow2Meta = itemArrow2.getItemMeta();
        itemArrow2Meta.setDisplayName("가로 화살");
        itemArrow2.setItemMeta(itemArrow2Meta);

        ItemStack itemArrow3 = new ItemStack(Material.ARROW, 10);
        ItemMeta itemArrow3Meta = itemArrow3.getItemMeta();
        itemArrow3Meta.setDisplayName("세로 화살");
        itemArrow3.setItemMeta(itemArrow3Meta);

        player.getInventory().addItem(itemBow);
        player.getInventory().addItem(itemArrow1);
        player.getInventory().addItem(itemArrow2);
        player.getInventory().addItem(itemArrow3);

    }
}
