package org.canghai.xlwsBase.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.canghai.xlwsBase.item.Items;

import java.util.Random;

/**
 *  实现药草掉落的事件监听逻辑
 */
public class HerbDropCallback {
    private static final double superiorHerbChance = 0.09;
    private static final double celestialHerbChance = 0.009;
    private static final double rareHerbChance = 0.001;
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (state.getBlock() instanceof CropBlock) {
                final Random random = new Random();
                if (state.get(CropBlock.AGE) == 7) {
                    double chance = random.nextDouble();
                    ItemStack herbStack = Items.getRandomItem("null");

                    if (chance < superiorHerbChance & chance > celestialHerbChance) {
                        herbStack = Items.getRandomItem("superior_herb");
                    } else if (chance < celestialHerbChance & chance > rareHerbChance) {
                        herbStack = Items.getRandomItem("celestial_herb");
                    } else if (chance < rareHerbChance) {
                        herbStack = Items.getRandomItem("rare_herb");
                    }
                    if (herbStack != null) {
                        world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), herbStack));
                    }
                }
            }
        });
    }
}