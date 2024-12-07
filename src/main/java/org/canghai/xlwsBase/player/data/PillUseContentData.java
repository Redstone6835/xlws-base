package org.canghai.xlwsBase.player.data;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.codec.PacketCodecs;

public class PillUseContentData {
    private int MAX_USES;  // 最大使用次数
    private static final TrackedDataHandler<Integer> handler = TrackedDataHandler.create(PacketCodecs.INTEGER);
    private TrackedData<Integer> USE_COUNT;

    public  PillUseContentData(int id){
         this.USE_COUNT = handler.create(id);
    }
    // 获取玩家的物品使用次数
    public int getUseCount(PlayerEntity player, String pillName) {
        return player.getDataTracker().get(USE_COUNT);
    }

    // 增加物品使用次数
    public void incrementUseCount(PlayerEntity player, String pillName) {
        int currentCount = getUseCount(player, pillName);
        player.getDataTracker().set(USE_COUNT, currentCount + 1);  // 增加使用次数
    }

    // 检查玩家是否可以使用物品
    public boolean canUseItem(PlayerEntity player, String pillName) {
        return getUseCount(player, pillName) < MAX_USES;
    }
}
