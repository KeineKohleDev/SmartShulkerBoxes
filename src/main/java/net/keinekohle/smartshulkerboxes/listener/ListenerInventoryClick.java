package net.keinekohle.smartshulkerboxes.listener;

import net.keinekohle.smartshulkerboxes.main.Main;
import net.keinekohle.smartshulkerboxes.util.Utilities;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class ListenerInventoryClick implements Listener
{
    @EventHandler
    public void onInventoryClick (InventoryClickEvent event)
    {
        if (!(event.getWhoClicked() instanceof Player))
            return;

        Player player = (Player) event.getWhoClicked();

        if ((event.getClickedInventory() instanceof PlayerInventory) && (event.getCurrentItem() != null) && (Utilities.isShulkerBox(event.getCurrentItem().getType())) && (event.getClick() == ClickType.CONTROL_DROP))
        {
            event.setCancelled(true);
            player.getOpenInventory().getTopInventory().close();

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), () ->
            {
                // Get the clicked shulker box
                ShulkerBox shulkerBox = (ShulkerBox) ((BlockStateMeta) event.getCurrentItem().getItemMeta()).getBlockState();
                ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
                // Create an id for the box
                int shulker_box_id = new Random().nextInt(1000, 9999);
                itemMeta.displayName(Component.text(shulker_box_id));
                event.getCurrentItem().setItemMeta(itemMeta);
                player.updateInventory();
                Utilities.openShulkerBoxes.put(player.getUniqueId(), shulker_box_id);
                player.openInventory(shulkerBox.getInventory());
            }, 1L);
        }
    }
}
