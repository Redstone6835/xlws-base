package org.canghai.xlwsBase.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import org.canghai.xlwsBase.item.Items;

import java.util.Random;

/**
 * 所有事件监听回调
 *
 */
public class ModEventListener {
    private static final double superiorHerbChance = 0.09;
    private static final double celestialHerbChance = 0.009;
    private static final double rareHerbChance = 0.001;

    public static void registerEvents() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (state.getBlock() instanceof CropBlock) {
                // 判断作物是否成熟
                final Random random = new Random();
                if (state.get(CropBlock.AGE) == 7) {
                    double chance = random.nextDouble();
                    ItemStack herbStack = Items.getRandomItem("null");
                    if (chance < superiorHerbChance & chance >celestialHerbChance) {
                        herbStack = Items.getRandomItem("superior_herb");
                    } else if (chance < celestialHerbChance & chance > rareHerbChance) {
                        herbStack = Items.getRandomItem("celestial_herb");
                    } else if (chance < rareHerbChance) {
                        herbStack = Items.getRandomItem("rare_herb");
                    }
                    world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), herbStack));
                }
            }
        });
    }
}