package org.canghai.xlwsBase.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.block.Blocks;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.PillCodec;

/**
 * 将所有需要注册的物品全部添加至Items类中，和mojang的思路同理。
 * @see net.minecraft.block.Blocks
 * @see net.minecraft.item.Items
 */
public class Items {
    // 注册。
    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(XlwsBase.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    // 创建一个新的物品组。
    public static final RegistryKey<ItemGroup> SERVER_ITEM_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of(XlwsBase.MOD_ID, "item_group")
    );
    public static final ItemGroup SERVER_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(net.minecraft.item.Items.DIAMOND_SWORD)) // 图标待定
            .displayName(Text.translatable("itemGroup.xlws_base"))
            .build();

    // 添加物品。
    // 上品药草。
    public static final Item SUPERIOR_HERB = register(
            new HerbItem(new Item.Settings()),
            "superior_herb"
    );
    // 仙品药草。
    public static final Item CELESTIAL_HERB = register(
            new HerbItem(new Item.Settings()),
            "celestial_herb"
    );
    // 稀世药草。
    public static final Item RARE_HERB = register(
            new HerbItem(new Item.Settings()),
            "rare_herb"
    );
    // 上品丹药。
    public static final Item HUI_SHEN = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","hui_shen"))),
            "hui_shen"
    );
    public static final Item MING_GONG = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","ming_gong"))),
            "ming_gong"
    );
    public static final Item XU_JIA = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","xu_jia"))),
            "xu_jia"
    );
    public static final Item HUA_FENG = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","hua_feng"))),
            "hua_feng"
    );
    public static final Item YE_MING = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","ye_ming"))),
            "ye_ming"
    );
    public static final Item KANG_SU = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","kang_su"))),
            "kang_su"
    );
    public static final Item JING_XIN = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","jing_xin"))),
            "jing_xin"
    );
    public static final Item YING_XIU = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","ying_xiu"))),
            "ying_xiu"
    );
    public static final Item CHONG_MING = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","chong_ming"))),
            "chong_ming"
    );
    public static final Item CANG_TI = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","cang_ti"))),
            "cang_ti"
    );
    // 仙品丹药
    public static final Item AN_HUN = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","an_hun"))),
            "an_hun"
    );
    public static final Item QI_XUE = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","hui_shen"))),
            "qi_xue"
    );
    public static final Item ZHUANG_YANG = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","zhuang_yang"))),
            "zhuang_yang"
    );
    public static final Item YIN_LING = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","yin_ling"))),
            "yin_ling"
    );
    // 稀世丹药
    public static final Item HUAN_HUN = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","huan_hun"))),
            "huan_hun"
    );
    public static final Item ZHOU_QI = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","zhou_qi"))),
            "zhou_qi"
    );
    public static final Item CHONG_YANG = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","chong_yang"))),
            "chong_yang"
    );
    public static final Item ZHOU_LING = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","zhou_ling"))),
            "zhou_ling"
    );

    /**
     * 添加静态初始化方法，确保该类被加载。
     * 该方法用于占位。
     * 该方法在JVM上入栈时，该类的全部内容都会被加载，从而达到加载该类中的成员的目的。
     */
    public static void initialize() {
        // 注册并将物品添加进物品组。
        Registry.register(Registries.ITEM_GROUP, SERVER_ITEM_GROUP_KEY, SERVER_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(SERVER_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(Blocks.ALCHEMY_FURNACE.asItem());
            itemGroup.add(SUPERIOR_HERB);
            itemGroup.add(CELESTIAL_HERB);
            itemGroup.add(RARE_HERB);
            itemGroup.add(HUI_SHEN);
            itemGroup.add(MING_GONG);
            itemGroup.add(XU_JIA);
            itemGroup.add(HUA_FENG);
            itemGroup.add(YING_XIU);
            itemGroup.add(CHONG_MING);
            itemGroup.add(CANG_TI);
            itemGroup.add(AN_HUN);
            itemGroup.add(QI_XUE);
            itemGroup.add(ZHUANG_YANG);
            itemGroup.add(YIN_LING);
            itemGroup.add(HUAN_HUN);
            itemGroup.add(ZHOU_QI);
            itemGroup.add(CHONG_YANG);
            itemGroup.add(ZHOU_LING);
            itemGroup.add(YIN_LING);
            itemGroup.add(HUAN_HUN);
            itemGroup.add(ZHOU_QI);
            // 更多物品的添加
            // TODO
        });
    }
}
