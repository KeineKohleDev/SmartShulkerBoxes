package net.keinekohle.smartshulkerboxes.util;

import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.HashMap;
import java.util.UUID;

public class Utilities
{
    public static HashMap<UUID, Integer> openShulkerBoxes = new HashMap<>();
    public static boolean isShulkerBox(Material m)
    {
        switch (m)
        {
            case LIGHT_GRAY_SHULKER_BOX:
            case SHULKER_BOX:
            case BLACK_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case WHITE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
                return true;
            default:
                return false;
        }
    }

    public static void updateShulkerBoxInv(ItemStack[] items, Player player)
    {
        if (openShulkerBoxes.containsKey(player.getUniqueId()))
        {
            int slot = 0;
            for (ItemStack itemStack : player.getInventory().getContents())
            {
                if (itemStack != null && itemStack.getItemMeta().getDisplayName().equals(String.valueOf(openShulkerBoxes.get(player.getUniqueId()))))
                {
                    ItemStack shulkerBox = itemStack;
                    BlockStateMeta bsm = (BlockStateMeta) shulkerBox.getItemMeta();
                    ShulkerBox box = (ShulkerBox) bsm.getBlockState();
                    box.getInventory().setContents(items);
                    bsm.setBlockState(box);
                    bsm.displayName(null);
                    shulkerBox.setItemMeta(bsm);
                    player.getInventory().setItem(slot, shulkerBox);
                }
                slot++;
            }
            openShulkerBoxes.remove(player.getUniqueId());
        }
    }
}
