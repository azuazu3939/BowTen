package mclove32.bowten;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BowListener implements Listener {

    public static final Map<String, Float> bow_ten = new HashMap<>();

    @EventHandler
    public void onShoot(@NotNull EntityShootBowEvent e) {

        if (e.getBow() == null) return;

        LivingEntity live = e.getEntity();
        if (live instanceof Player) {

            Player p = (Player) live;
            bow_ten.put(p.getUniqueId().toString(), e.getForce());
        }
    }
}
