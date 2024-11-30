package org.canghai.xlwsBase.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;

/**
 * 将所有需要注册的方块全部添加至Blocks类中，和mojang的思路同理。
 * @see net.minecraft.block.Blocks
 * @see net.minecraft.item.Items
 */
public class Blocks {
    public static Block register(Block block, String name) {
        Identifier id = Identifier.of(XlwsBase.MOD_ID, name);

        // 注册方块以及它所对应的物品。
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);

        return Registry.register(Registries.BLOCK, id, block);
    }

    // 开始添加方块。
    // 炼丹炉。
    public static final Block ALCHEMY_FURNACE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)),
            "alchemy_furnace"
    );

    /**
     * 添加静态初始化方法，确保该类被加载。
     * 该方法用于占位。
     * 该方法在JVM上入栈时，该类的全部内容都会被加载，从而达到加载该类中的成员的目的。
     */
    public static void initialize() {
    }
}
