package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.PillCodec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CelestialPillItem extends Item {
    public CelestialPillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        PillCodec pillCodec = stack.get(Components.PILL_TYPE);
        String pill_name = "";
        if (pillCodec != null) {
            pill_name = pillCodec.getPill_name();
        }
        tooltip.add(Text.translatable("item.xlws-base.celestial_pill.info." + pill_name).formatted(Formatting.GOLD));
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
            case "an_hun":
                // 永久增加10生命值
                user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(user.getMaxHealth() + 20f);
                // TODO:限制使用次数

                // TODO:完善丹药效果

            default:
                break;

        }
        user.playSound(SoundEvent.of(new Identifier("minecraft", "entity.ender_dragon.ambient")));
        return super.use(world, user, hand);
    }
}
