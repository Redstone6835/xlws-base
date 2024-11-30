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
    // 丹药。
    public static final Item PILL = register(
            new PillItem(new Item.Settings().component(Components.HERB_TYPE, "null")),
            "pill"
    );

    // 草药。
    public static final Item HERB = register(
            new Item(new Item.Settings()),
            "herb"
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
            itemGroup.add(PILL);
            itemGroup.add(HERB);
            // 更多物品的添加
            // TODO
        });
    }
}
