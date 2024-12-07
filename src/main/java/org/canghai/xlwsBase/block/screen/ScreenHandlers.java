package org.canghai.xlwsBase.block.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.canghai.xlwsBase.XlwsBase;

public class ScreenHandlers {
    public static final ScreenHandlerType<AlchemyFurnaceScreenHandler> ALCHEMY_FURNACE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(XlwsBase.MOD_ID, "alchemy_furnace"),
            new ScreenHandlerType<>(AlchemyFurnaceScreenHandler::new, FeatureSet.empty())
    );

    public static void initialize() {}
}
