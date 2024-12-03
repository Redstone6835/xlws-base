package org.canghai.xlwsBase.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;

/**
 *  为丹药组件创建专门的CODEC
 *  Todo
 *
 */

public class PillCodec {
    private final String pill_type;
    private final String pill_name;

    public PillCodec(final String pill_type, final String pill_name) {
        this.pill_type = pill_type;
        this.pill_name = pill_name;
    }
    public String getPill_name() {
        return pill_name;
    }
    public String getPill_type() {
        return pill_type;
    }

    public static final Codec<PillCodec> PILL_CODEC = Codec.STRING.xmap(
            str -> {
                String[] parts = str.split(";", 2);
                return new PillCodec(parts[0], parts[1]);
            },
            pair -> pair.getPill_name() + ";" + pair.getPill_type() // 反序列化时拼接字符串
    );
}
