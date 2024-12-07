package org.canghai.xlwsBase.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.annoation.ServerWorld;

import java.util.OptionalLong;

@ServerWorld(id = "Test")
public class TestDimension {
    public static final RegistryKey<DimensionType> TEST_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "prologue"));

    /**
     * 加载该维度。
     */
    public static void initialize(Registerable<DimensionType> dimensionTypeRegisterable) {
        dimensionTypeRegisterable.register(
                TEST_DIMENSION_TYPE_KEY,
                // 与主世界的维度配置相同。
                new DimensionType(
                        OptionalLong.empty(),
                        true,
                        false,
                        false,
                        true,
                        1.0,
                        true,
                        false,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        DimensionTypes.OVERWORLD_ID,
                        0.0F,
                        new DimensionType.MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)
                )
        );
    }
}
