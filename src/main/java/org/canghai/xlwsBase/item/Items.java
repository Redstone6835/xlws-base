package org.canghai.xlwsBase.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;
import org.canghai.xlwsBase.block.Blocks;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.component.HerbCodec;
import org.canghai.xlwsBase.component.PillCodec;

import java.util.*;

/**
 * 将所有需要注册的物品全部添加至Items类中，和mojang的思路同理。
 * @see net.minecraft.block.Blocks
 * @see net.minecraft.item.Items
 */
public class Items {
    private static final Map<String, List<ItemStack>> itemMap = new HashMap<>();
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
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","test"))),
            "superior_herb"
    );
    public static final Item JIN_YIN_HUA = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","jin_yin_hua"))),
            "superior_herb"
    );
    public static final Item HUANG_LIAN = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","huang_lian"))),
            "superior_herb"
    );
    public static final Item CHEN_XIANG = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","chen_xiang"))),
            "superior_herb"
    );
    public static final Item BO_HE = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","bo_he"))),
            "superior_herb"
    );
    public static final Item YU_JIN = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","yu_jin"))),
            "superior_herb"
    );
    public static final Item MA_HUANG = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("superior_herb","ma_huang"))),
            "superior_herb"
    );
    // 仙品药草。
    public static final Item CELESTIAL_HERB = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","test"))),
            "celestial_herb"
    );
    public static final Item REN_SHEN = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","ren_shen"))),
            "celestial_herb"
    );
    public static final Item HUO_XIANG = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","huo_xiang"))),
            "celestial_herb"
    );
    public static final Item ZHU_SHA = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","zhu_sha"))),
            "celestial_herb"
    );
    public static final Item BAN_XIA = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","ban_xia"))),
            "celestial_herb"
    );
    public static final Item LU_RONG = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","lu_rong"))),
            "celestial_herb"
    );
    public static final Item YUAN_HU = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("celestial_herb","yuan_hu"))),
            "celestial_herb"
    );
    // 稀世药草。
    public static final Item RARE_HERB = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","test"))),
            "rare_herb"
    );
    public static final Item TIAN_SHAN_XUE_LIAN = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","tian_shan_xue_lian"))),
            "rare_herb"
    );
    public static final Item SHOU_WU = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","shou_wu"))),
            "rare_herb"
    );
    public static final Item DONG_CHONG_XIA_CAO = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","dong_chong_xia_cao"))),
            "rare_herb"
    );
    public static final Item LING_ZHI = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","ling_zhi"))),
            "rare_herb"
    );
    public static final Item CONG_RONG = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","cong_rong"))),
            "rare_herb"
    );
    public static final Item XI_LING = register(
            new HerbItem(new Item.Settings().component(Components.HERB_TYPE, new HerbCodec("rare_herb","xi_ling"))),
            "rare_herb"
    );
    // 上品丹药。
    public static final Item HUI_SHEN = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","hui_shen"))),
            "superior_pill"
    );
    public static final Item MING_GONG = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","ming_gong"))),
            "superior_pill"
    );
    public static final Item XU_JIA = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","xu_jia"))),
            "superior_pill"
    );
    public static final Item HUA_FENG = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","hua_feng"))),
            "superior_pill"
    );
    public static final Item YE_MING = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","ye_ming"))),
            "superior_pill"
    );
    public static final Item KANG_SU = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","kang_su"))),
            "superior_pill"
    );
    public static final Item JING_XIN = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","jing_xin"))),
            "superior_pill"
    );
    public static final Item YIN_XIU = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","yin_xiu"))),
            "superior_pill"
    );
    public static final Item CHONG_MING = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","chong_ming"))),
            "superior_pill"
    );
    public static final Item CANG_TI = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("superior_pill","cang_ti"))),
            "superior_pill"
    );
    // 仙品丹药
    public static final Item AN_HUN = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","an_hun"))),
            "celestial_pill"
    );
    public static final Item QI_XUE = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","qi_xue"))),
            "celestial_pill"
    );
    public static final Item ZHUANG_YANG = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","zhuang_yang"))),
            "celestial_pill"
    );
    public static final Item YIN_LING = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("celestial_pill","yin_ling"))),
            "celestial_pill"
    );
    // 稀世丹药
    public static final Item HUAN_HUN = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","huan_hun"))),
            "rare_pill"
    );
    public static final Item ZHOU_QI = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","zhou_qi"))),
            "rare_pill"
    );
    public static final Item CHONG_YANG = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","chong_yang"))),
            "rare_pill"
    );
    public static final Item ZHOU_LING = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, new PillCodec("rare_pill","zhou_ling"))),
            "rare_pill"
    );
    /**
     * 添加静态初始化方法，确保该类被加载。
     * 该方法用于占位。
     * 该方法在JVM上入栈时，该类的全部内容都会被加载，从而达到加载该类中的成员的目的。
     */
    public static void initialize() {
        init();
        // 注册并将物品添加进物品组。
        Registry.register(Registries.ITEM_GROUP, SERVER_ITEM_GROUP_KEY, SERVER_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(SERVER_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(Blocks.ALCHEMY_FURNACE.asItem());
            itemGroup.add(SUPERIOR_HERB);
            itemGroup.add(CELESTIAL_HERB);
            itemGroup.add(RARE_HERB);
            itemGroup.add(JIN_YIN_HUA);
            itemGroup.add(HUANG_LIAN);
            itemGroup.add(CHEN_XIANG);
            itemGroup.add(BO_HE);
            itemGroup.add(YU_JIN);
            itemGroup.add(MA_HUANG);
            itemGroup.add(REN_SHEN);
            itemGroup.add(HUO_XIANG);
            itemGroup.add(ZHU_SHA);
            itemGroup.add(BAN_XIA);
            itemGroup.add(LU_RONG);
            itemGroup.add(YUAN_HU);
            itemGroup.add(TIAN_SHAN_XUE_LIAN);
            itemGroup.add(SHOU_WU);
            itemGroup.add(DONG_CHONG_XIA_CAO);
            itemGroup.add(LING_ZHI);
            itemGroup.add(CONG_RONG);
            itemGroup.add(XI_LING);
            itemGroup.add(HUI_SHEN);
            itemGroup.add(KANG_SU);
            itemGroup.add(YE_MING);
            itemGroup.add(JING_XIN);
            itemGroup.add(MING_GONG);
            itemGroup.add(XU_JIA);
            itemGroup.add(HUA_FENG);
            itemGroup.add(YIN_XIU);
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

    /**
     * 以下方法用于随机生成特定类型的物品
     *
     */
    // 初始化时填充物品
    public static void init() {

        List<ItemStack> superiorHerbs = new ArrayList<>();
        superiorHerbs.add(new ItemStack(JIN_YIN_HUA));
        superiorHerbs.add(new ItemStack(HUANG_LIAN));
        superiorHerbs.add(new ItemStack(CHEN_XIANG));
        superiorHerbs.add(new ItemStack(BO_HE));
        superiorHerbs.add(new ItemStack(YU_JIN));
        superiorHerbs.add(new ItemStack(MA_HUANG));
        itemMap.put("superior_herb", superiorHerbs);
        List<ItemStack> celestialHerbs = new ArrayList<>();
        celestialHerbs.add(new ItemStack(REN_SHEN));
        celestialHerbs.add(new ItemStack(HUO_XIANG));
        celestialHerbs.add(new ItemStack(ZHU_SHA));
        celestialHerbs.add(new ItemStack(BAN_XIA));
        celestialHerbs.add(new ItemStack(LU_RONG));
        celestialHerbs.add(new ItemStack(YUAN_HU));
        itemMap.put("celestial_herb", celestialHerbs);
        List<ItemStack> rareHerbs = new ArrayList<>();
        rareHerbs.add(new ItemStack(TIAN_SHAN_XUE_LIAN));
        rareHerbs.add(new ItemStack(SHOU_WU));
        rareHerbs.add(new ItemStack(DONG_CHONG_XIA_CAO));
        rareHerbs.add(new ItemStack(LING_ZHI));
        rareHerbs.add(new ItemStack(CONG_RONG));
        rareHerbs.add(new ItemStack(XI_LING));
        itemMap.put("rare_herb", rareHerbs);
    }

    public static ItemStack getRandomItem(String type){
        List<ItemStack> items = itemMap.get(type);
        if (items != null && !items.isEmpty()) {
            Random random = new Random();
            return items.get(random.nextInt(items.size()));  // 随机选择
        }
        return ItemStack.EMPTY;

    }
}
