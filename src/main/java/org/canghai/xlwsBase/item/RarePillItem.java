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
        ArrayList<String> list = new ArrayList<>(Arrays.asList(super.getTranslationKey(stack).split("\\.")));
        if (list.size() > 1) {
            list.add(list.size() - 1, pillCodec.getPill_type());
        } else {
            // 处理列表为空或只有一个元素的情况
            list.add(pillCodec.getPill_type());  // 直接添加到列表末尾
        }
        // 将List转化为String
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(".");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        String pill_name = sb.toString();
        return pill_name;
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
