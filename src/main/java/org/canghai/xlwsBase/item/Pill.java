package org.canghai.xlwsBase.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class Pill {
    private String id;

    public Pill(String baseName) {
        id = baseName;
    }

    public String getId() {
        return id;
    }
}
