package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.HerbCodec;

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
        HerbCodec herbCodec = stack.get(Components.HERB_TYPE);
        if (herbCodec != null) {
            switch (herbCodec.getHerb_type()) {
                case "superior_herb":
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + herbCodec.getHerb_name()).formatted(Formatting.BLUE));
                    break;
                case "celestial_herb":
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + herbCodec.getHerb_name()).formatted(Formatting.GOLD));
                    break;
                case "rare_herb":
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + herbCodec.getHerb_name()).formatted(Formatting.RED));
            }
        }
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        HerbCodec herbCodec = stack.get(Components.HERB_TYPE);
        if (herbCodec != null) {
            return "item.xlws-base.herb." + herbCodec.getHerb_name();
        }
        return "null";
    }


}