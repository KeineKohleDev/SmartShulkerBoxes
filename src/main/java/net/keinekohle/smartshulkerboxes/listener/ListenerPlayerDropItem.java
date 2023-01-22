package net.keinekohle.smartshulkerboxes.listener;

import net.keinekohle.smartshulkerboxes.util.Utilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ListenerPlayerDropItem implements Listener
{
    @EventHandler
    public void itemDrop (PlayerDropItemEvent event)
    {
        if (Utilities.isShulkerBox(event.getItemDrop().getItemStack().getType()))
            if (Utilities.openShulkerBoxes.containsKey(event.getPlayer().getUniqueId()))
                event.setCancelled(true);
    }
}
