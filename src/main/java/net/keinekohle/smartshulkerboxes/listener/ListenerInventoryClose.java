package net.keinekohle.smartshulkerboxes.listener;

import net.keinekohle.smartshulkerboxes.util.Utilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ListenerInventoryClose implements Listener
{
    @EventHandler
    public void onClose(InventoryCloseEvent event)
    {
        Utilities.updateShulkerBoxInv(event.getInventory().getContents(), (Player) event.getPlayer());
    }
}
