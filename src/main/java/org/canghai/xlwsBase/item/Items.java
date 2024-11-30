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
    public static final Item SUPERIOR_PILL = register(
            new SuperiorPillItem(new Item.Settings().component(Components.PILL_TYPE, "null")),
            "superior_pill"
    );
    // 仙品丹药。
    public static final Item CELESTIAL_PILL = register(
            new CelestialPillItem(new Item.Settings().component(Components.PILL_TYPE, "null")),
            "celestial_pill"
    );
    // 稀世丹药。
    public static final Item RARE_PILL = register(
            new RarePillItem(new Item.Settings().component(Components.PILL_TYPE, "null")),
            "rare_pill"
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
            // 更多物品的添加
            // TODO
        });
    }
}
