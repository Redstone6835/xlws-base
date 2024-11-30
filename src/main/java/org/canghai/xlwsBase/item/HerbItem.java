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
 * 定义药草物品的各种属性。
 * @see Item
 * @see net.minecraft.item.PotionItem
 */
public class HerbItem extends Item {
    public HerbItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        String herb_type = stack.get(Components.HERB_TYPE);
        tooltip.add(Text.translatable("info.xlws-base.herb.type", herb_type));
    }


}