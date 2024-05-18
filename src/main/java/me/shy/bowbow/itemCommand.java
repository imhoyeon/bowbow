package me.shy.bowbow;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class itemCommand extends BukkitCommand {

    public itemCommand(@NotNull String name){
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args){
            if (sender instanceof Player player){
                timer.timerStart();
                itemBow.createItem(player);
                createTarget.createTargetPlayer(player);
            }
        return false;
    }
}
