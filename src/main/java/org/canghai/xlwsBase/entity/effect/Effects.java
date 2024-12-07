package org.canghai.xlwsBase.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;

public class Effects {
    public static final RegistryEntry<StatusEffect> HEALTH_REGEN = register(XlwsBase.MOD_ID, "health_regen", new HealthRegenStatusEffect());

    public static RegistryEntry<StatusEffect> register(String nameSpace, String path, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(nameSpace, path), statusEffect);
    }

    public static void initalize() {

    }
}
