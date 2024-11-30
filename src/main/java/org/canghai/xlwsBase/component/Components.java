package org.canghai.xlwsBase.component;

import net.minecraft.component.DataComponentType;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;

/**
 * 在这个类中定义所有用到的组件类型。
 */
public class Components {

    // 丹药种类。
    public static final DataComponentType<String> PILL_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "pill_type"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 药草种类。
    public static final DataComponentType<String> HERB_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "herb_type"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 丹药质量。
    public static final DataComponentType<String> PILL_QUALITY = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "pill_quality"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家攻击力
    public static final DataComponentType<String> PLAYER_ATTACK = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_attack"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家灵力值
    public static final DataComponentType<String> PLAYER_SPIRITUALITY = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_spirituality"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家防御力
    public static final DataComponentType<String> PLAYER_DEFENSE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_defense"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家攻击速度
    public static final DataComponentType<String> PLAYER_ATTACK_SPEED = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_attack_speed"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家经验值
    public static final DataComponentType<String> PLAYER_EXP = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_exp"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家境界
    public static final DataComponentType<String> PLAYER_REALM = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_realm"),
            DataComponentType.<String>builder().codec(null).build()
    );

    // 玩家攻击范围
    public static final DataComponentType<String> PLAYER_ATTACK_RANGE= Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(XlwsBase.MOD_ID, "player_attack_range"),
            DataComponentType.<String>builder().codec(null).build()
    );
    // 静态加载。
    protected static void initialize() {}
}
