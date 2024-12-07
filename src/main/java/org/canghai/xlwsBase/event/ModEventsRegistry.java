package org.canghai.xlwsBase.event;

import net.minecraft.entity.ItemEntity;

/**
 * 用于注册所有事件监听器
 */
public class ModEventsRegistry {
    public static void registry(){
        HerbDropEventListener.register();
    }
}
