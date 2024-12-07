package org.canghai.xlwsBase.block;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.block.entity.AlchemyFurnaceBlockEntity;

/**
 * 这里实现所有方块实体和方块实体类型的注册
 */
public class BlockEntityTypes {
    // 注册方块实体类型
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(XlwsBase.MOD_ID, path), blockEntityType);
    }
    // 注册方块实体
    public static final BlockEntityType<AlchemyFurnaceBlockEntity> ALCHEMY_FURNACE = register(
            "alchemy_furnace",
            BlockEntityType.Builder.create(AlchemyFurnaceBlockEntity::new, Blocks.ALCHEMY_FURNACE).build()
    );

    public static void initialize() {
    }
}
