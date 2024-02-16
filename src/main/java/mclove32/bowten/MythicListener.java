package mclove32.bowten;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class MythicListener implements Listener {

    @EventHandler
    public void onLoad(@NotNull MythicConditionLoadEvent e) {

        String s = e.getConditionName();
        if (s.equalsIgnoreCase("bowTen")) {

            e.register(new BowTenCondition(e.getConfig()));
        }
    }
}
