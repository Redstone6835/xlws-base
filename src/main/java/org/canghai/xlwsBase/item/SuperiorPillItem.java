package org.canghai.xlwsBase.item;

import net.minecraft.client.item.TooltipType;
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
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.component.Components;

import java.util.List;

public class SuperiorPillItem extends Item {
    public SuperiorPillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        String pill_type = stack.get(Components.PILL_TYPE);
        tooltip.add(Text.translatable("item.xlws-base.superior_pill.info." + pill_type).formatted(Formatting.GOLD));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        String pill_type = user.getStackInHand(hand).get(Components.PILL_TYPE);
        switch (pill_type) {
            case "hui_shen":
                // 恢复20%生命值
                // TODO

            // TODO:完善丹药效果

            default:
                // TODO
        }
        user.playSound(SoundEvent.of(new Identifier("minecraft", "entity.ender_dragon.ambient")));
        return super.use(world, user, hand);
    }
}
