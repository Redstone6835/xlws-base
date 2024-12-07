package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.PillComponent;
import org.canghai.xlwsBase.entity.effect.Effects;
import org.canghai.xlwsBase.player.data.PillUseContentData;

import java.util.List;

public class SuperiorPillItem extends Item {
    public SuperiorPillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        PillComponent pillComponent = stack.get(Components.PILL_TYPE);
        String pill_name = pillComponent.pill_name();
        tooltip.add(Text.translatable("item.xlws-base.superior_pill.info." + pill_name).formatted(Formatting.BLUE));
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        PillComponent pillComponent = stack.get(Components.PILL_TYPE);
        if (pillComponent != null) {
            String name = pillComponent.pill_name();
            return super.getTranslationKey(stack) + "." + name;
        }
        else {
            return super.getTranslationKey(stack) + ".null";
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        PillComponent pillComponent = user.getStackInHand(hand).get(Components.PILL_TYPE);
        String pill_name = pillComponent.pill_name();
        StatusEffectInstance effect;
        switch (pill_name) {
            case "hui_shen":
                PillUseContentData useContentData = new PillUseContentData(0);
                RegistryEntry<StatusEffect> healthRegenEffect = Effects.HEALTH_REGEN;
                effect = new StatusEffectInstance(healthRegenEffect, 1200, 0);
                user.addStatusEffect(effect);
                break;
            case "ye_ming":
                effect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0);
                user.addStatusEffect(effect);
                break;
            case "kang_su":
                effect = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0);
                user.addStatusEffect(effect);
                effect = new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0);
                user.addStatusEffect(effect);
                break;
            case "jing_xin":
                user.clearStatusEffects();
            case "cang_ti":
                effect = new StatusEffectInstance(StatusEffects.INVISIBILITY, 1200,0);
                user.addStatusEffect(effect);
            case "ming_gong":
            // Todo:将攻击力改成自定义属性
                user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).addPersistentModifier(new EntityAttributeModifier("custom_attack_damage_boost", 10, EntityAttributeModifier.Operation.ADD_VALUE));
                break;
            // TODO:完善丹药效果
            default:
                break;        }
        user.playSound(SoundEvent.of(new Identifier("minecraft", "entity.ender_dragon.ambient")));
        return super.use(world, user, hand);
    }
}
