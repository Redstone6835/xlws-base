package org.canghai.xlwsBase.client.ui;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.canghai.xlwsBase.block.screen.ScreenHandlers;

public class Screens {
    public static void initialize() {
        HandledScreens.register(ScreenHandlers.ALCHEMY_FURNACE_SCREEN_HANDLER, AlchemyFurnaceScreen::new);
    }
}
