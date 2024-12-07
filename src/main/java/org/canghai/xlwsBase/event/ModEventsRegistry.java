package org.canghai.xlwsBase.event;

/**
 * 用于注册所有事件监听器
 */
public class ModEventsRegistry {
    public static void registry(){
        HerbDropCallback.register();
    }
}
