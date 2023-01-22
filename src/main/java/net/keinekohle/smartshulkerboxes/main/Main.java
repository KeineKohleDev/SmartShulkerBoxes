package net.keinekohle.smartshulkerboxes.main;

import net.keinekohle.smartshulkerboxes.listener.ListenerInventoryClick;
import net.keinekohle.smartshulkerboxes.listener.ListenerInventoryClose;
import net.keinekohle.smartshulkerboxes.listener.ListenerPlayerDropItem;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{

    @Override
    public void onEnable ()
    {
        registerEvents();
    }

    private void registerEvents ()
    {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ListenerInventoryClick(), this);
        pluginManager.registerEvents(new ListenerPlayerDropItem(), this);
        pluginManager.registerEvents(new ListenerInventoryClose(), this);
    }
}
