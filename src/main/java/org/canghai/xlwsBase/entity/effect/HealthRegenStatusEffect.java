package org.canghai.xlwsBase.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class HealthRegenStatusEffect extends StatusEffect {
    public HealthRegenStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x00FF00);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 30 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            float maxHealth = player.getMaxHealth();
            double currentHealth = player.getHealth();
            float healthToRestore = maxHealth * 0.05f;
            // todo:将这里的恢复值设置为玩家生命值的20%
            if (currentHealth < maxHealth * 0.2f) {
                player.setHealth((float)(currentHealth + healthToRestore));
            }
            return true;
        }
        return false;
    }
}
