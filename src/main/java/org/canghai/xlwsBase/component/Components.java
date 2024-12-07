package org.canghai.xlwsBase.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.DataComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;

/**
 * 在这个类中定义所有用到的组件类型。
 */
public class Components {
    // 丹药信息。
    public static final DataComponentType<PillCodec> PILL_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "pill_type"),
            DataComponentType.<PillCodec>builder().codec(Codecs.PILL_CODEC).build()
    );

    // 药草种类。
    public static final DataComponentType<HerbCodec> HERB_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "herb_type"),
            DataComponentType.<HerbCodec>builder().codec(Codecs.HERB_CODEC).build()
    );

    // 玩家攻击力
    public static final DataComponentType<Float> PLAYER_ATTACK = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_attack"),
            DataComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );

    // 玩家灵力值
    public static final DataComponentType<Float> PLAYER_SPIRITUALITY = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_spirituality"),
            DataComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );

    // 玩家防御力
    public static final DataComponentType<Float> PLAYER_DEFENSE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_defense"),
            DataComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );

    // 玩家攻击速度
    public static final DataComponentType<Float> PLAYER_ATTACK_SPEED = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_attack_speed"),
            DataComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );

    // 玩家经验值
    public static final DataComponentType<Float> PLAYER_EXP = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_exp"),
            DataComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );

    // 玩家境界
    public static final DataComponentType<String> PLAYER_REALM = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_realm"),
            DataComponentType.<String>builder().codec(Codec.STRING).build()
    );

    // 玩家攻击范围
    public static final DataComponentType<Float> PLAYER_ATTACK_RANGE= Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_attack_range"),
            DataComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );
    // 静态加载。
    public static void initialize() {}
}
