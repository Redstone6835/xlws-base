package org.canghai.xlwsBase.component;

public class HerbCodec {
    private final String herb_type;
    private final String herb_name;

    public HerbCodec(final String herb_type,final String herb_name) {
        this.herb_type = herb_type;
        this.herb_name = herb_name;
    }

    public String getHerb_type() {
        return herb_type;
    }
    public String getHerb_name() {
        return herb_name;
    }
}
