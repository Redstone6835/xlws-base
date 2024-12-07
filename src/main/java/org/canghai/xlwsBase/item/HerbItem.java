package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.HerbComponent;

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
        HerbComponent herbComponent = stack.get(Components.HERB_TYPE);
        if (herbComponent != null) {
            switch (herbComponent.herb_type()) {
                case "superior_herb":
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + herbComponent.herb_name()).formatted(Formatting.BLUE));
                    break;
                case "celestial_herb":
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + herbComponent.herb_name()).formatted(Formatting.GOLD));
                    break;
                case "rare_herb":
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + herbComponent.herb_name()).formatted(Formatting.RED));
                    break;
                default:
                    tooltip.add(Text.translatable("item.xlws-base.herb.info." + "null").formatted(Formatting.WHITE));
                    break;
            }
        }
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        HerbComponent herbComponent = stack.get(Components.HERB_TYPE);
        if (herbComponent != null) {
            return "item.xlws-base.herb." + herbComponent.herb_name();
        }
        return "null";
    }


}