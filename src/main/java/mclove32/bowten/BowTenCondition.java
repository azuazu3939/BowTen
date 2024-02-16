package mclove32.bowten;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BowTenCondition extends SkillCondition implements IEntityCondition {

    private final float f;
    private final boolean just;

    public BowTenCondition(@NotNull MythicLineConfig config) {
        super(config.getLine());
        f = config.getPlaceholderFloat(new String[]{"f", "force"}, 0f).get();
        just = config.getBoolean(new String[]{"just", "j"}, false);
    }

    @Override
    public boolean check(AbstractEntity abstractEntity) {

        Entity entity = BukkitAdapter.adapt(abstractEntity);
        if (entity instanceof Player) {

            Player p = (Player) entity;
            String uuid = p.getUniqueId().toString();

            if (BowListener.bow_ten.isEmpty() || !BowListener.bow_ten.containsKey(uuid)) return false;

            float get = BowListener.bow_ten.get(uuid);
            BowListener.bow_ten.remove(uuid);

            if (just) {
                return f == get;
            }
            return f >= get;

        }
        return false;
    }
}
