package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.canghai.xlwsBase.component.Components;

import java.util.List;

/**
 * 定义丹药物品的各种属性。
 * @see Item
 * @see net.minecraft.item.PotionItem
 */
public class PillItem extends Item {

    public PillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        String pill_type = stack.get(Components.PILL_TYPE);
        tooltip.add(Text.translatable("info.xlws-base.pill.type", pill_type));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        String pill_type = stack.get(Components.PILL_TYPE);

        switch (pill_type) {

        }

        return super.use(world, user, hand);
    }

}
