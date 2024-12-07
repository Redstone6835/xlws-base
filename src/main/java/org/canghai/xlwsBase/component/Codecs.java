package org.canghai.xlwsBase.component;

import com.mojang.serialization.Codec;
/**
 *  自定义CODEC
 */

public class Codecs {

    public static final Codec<PillCodec> PILL_CODEC = Codec.STRING.xmap(
            str -> {
                String[] parts = str.split(";", 2);
                return new PillCodec(parts[0], parts[1]);
            },
            pair -> pair.pill_name() + ";" + pair.pill_type() // 反序列化时拼接字符串
    );
    public static final Codec<HerbCodec> HERB_CODEC = Codec.STRING.xmap(
            str -> {
                String[] parts = str.split(";", 2);
                return new HerbCodec(parts[0], parts[1]);
            },
            pair -> pair.herb_name() + ";" + pair.herb_type() // 反序列化时拼接字符串
    );
}
