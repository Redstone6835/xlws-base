package org.canghai.xlwsBase.client;

import net.fabricmc.api.ClientModInitializer;
import org.canghai.xlwsBase.client.ui.Screens;

public class XlwsBaseClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // 加载Screen类中的全部内容。
        Screens.initialize();
    }
}
