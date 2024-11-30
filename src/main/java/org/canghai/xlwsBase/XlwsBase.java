package org.canghai.xlwsBase;

import net.fabricmc.api.ModInitializer;
import net.minecraft.potion.Potions;
import org.canghai.xlwsBase.block.Blocks;
import org.canghai.xlwsBase.component.Components;
import org.canghai.xlwsBase.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XlwsBase implements ModInitializer {
    public static final String MOD_ID = "xlws-base";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // 加载Blocks类中的全部成员。
        Blocks.initialize();
        // 加载Items类中的全部成员。
        Items.initialize();
        // 加载Components类中的全部成员。
        Components.initialize();
    }
}
