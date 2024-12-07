package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.PillCodec;
import org.canghai.xlwsBase.entity.effect.Effects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RarePillItem extends Item {
    public RarePillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        PillCodec pillCodec = stack.get(Components.PILL_TYPE);
        String pill_name = pillCodec.getPill_name();
        tooltip.add(Text.translatable("item.xlws-base.rare_pill.info." + pill_name).formatted(Formatting.RED));
    }


    @Override
    public String getTranslationKey(ItemStack stack) {
        PillCodec pillCodec = stack.get(Components.PILL_TYPE);
        if (pillCodec != null) {
            String name = pillCodec.getPill_name();
            return super.getTranslationKey(stack) + "." + name;
        }
        else {
            return super.getTranslationKey(stack) + ".null";
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        PillCodec pillCodec = user.getStackInHand(hand).get(Components.PILL_TYPE);
        String pill_name = pillCodec.getPill_name();
        switch (pill_name) {
            case "huan_hun":
                user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(user.getMaxHealth() + 20f);
                break;
                // TODO:完善丹药效果
            default:
                break;
        }
        user.playSound(SoundEvent.of(new Identifier("minecraft", "entity.ender_dragon.ambient")));
        return super.use(world, user, hand);
    }
}
