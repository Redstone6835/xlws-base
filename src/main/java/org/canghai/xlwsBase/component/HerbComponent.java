package org.canghai.xlwsBase.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record HerbComponent(String herb_type, String herb_name) {
    public static final Codec<HerbComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("herb_type").forGetter(HerbComponent::herb_type),
            Codec.STRING.fieldOf("herb_name").forGetter(HerbComponent::herb_name)
    ).apply(builder, HerbComponent::new)
    );
}