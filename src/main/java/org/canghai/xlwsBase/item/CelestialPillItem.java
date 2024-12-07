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
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
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
