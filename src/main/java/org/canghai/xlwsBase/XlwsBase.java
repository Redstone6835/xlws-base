package org.canghai.xlwsBase;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.canghai.xlwsBase.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XlwsBase implements ModInitializer {
    public static final String MOD_ID = "xlws-base";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // 加载Blocks类中的全部成员。
        Blocks.initialize();
    }
}
