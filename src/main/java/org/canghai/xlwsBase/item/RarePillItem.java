package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.component.Components;

import java.util.List;

public class RarePillItem extends Item {
    public RarePillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        String pill_type = stack.get(Components.PILL_TYPE);
        tooltip.add(Text.translatable("item.xlws-base.rare_pill.info." + pill_type).formatted(Formatting.GOLD));
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return super.getTranslationKey(stack) + '.' + stack.get(Components.PILL_TYPE);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        String pill_type = user.getStackInHand(hand).get(Components.PILL_TYPE);
        switch (pill_type) {
            case "huan_hun":
                // 永久增加10生命值
                // TODO

                // TODO:完善丹药效果

            default:
                // TODO
        }
        user.playSound(SoundEvent.of(new Identifier("minecraft", "entity.ender_dragon.ambient")));
        return super.use(world, user, hand);
    }
}
