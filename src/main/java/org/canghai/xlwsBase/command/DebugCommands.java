package org.canghai.xlwsBase.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.RegistryEntryReferenceArgumentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;

public class DebugCommands {
    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((
                (dispatcher, registryAccess, environment) -> {
                    dispatcher.register(CommandManager.literal("change_dimension")
                            .then(CommandManager.argument("dimension",
                                            RegistryEntryReferenceArgumentType.registryEntry(registryAccess,
                                                    RegistryKeys.DIMENSION))
                            )
                            .executes((context -> {
                                var dimension = RegistryEntryReferenceArgumentType.getRegistryEntry(context, "dimension", RegistryKeys.DIMENSION);
                                var player = context.getSource().getPlayer();

                                if (player != null) {
                                    player.teleport(
                                            player.getServer().getWorld(RegistryKeys.toWorldKey(dimension.registryKey())),
                                            player.getX(),
                                            player.getY(),
                                            player.getZ(),
                                            player.getYaw(),
                                            player.getPitch()
                                    );
                                }
                                return 0;
                            })));
        }));
    }
}
