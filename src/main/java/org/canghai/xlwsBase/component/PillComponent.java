package org.canghai.xlwsBase.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record PillComponent (String pill_type, String pill_name) {
    public static final Codec<PillComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
                    Codec.STRING.fieldOf("pill_type").forGetter(PillComponent::pill_type),
                    Codec.STRING.fieldOf("pill_name").forGetter(PillComponent::pill_name)
            ).apply(builder, PillComponent::new)
    );
}
