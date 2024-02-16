package mclove32.bowten;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BowTen extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm =getServer().getPluginManager();
        pm.registerEvents(new MythicListener(), this);
        pm.registerEvents(new BowListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
