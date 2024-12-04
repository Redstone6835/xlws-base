package org.canghai.xlwsBase.component;

public class PillCodec {
    private final String pill_type;
    private final String pill_name;

    public PillCodec(final String pill_type,final String pill_name) {
        this.pill_type = pill_type;
        this.pill_name = pill_name;
    }

    public String getPill_type() {
        return pill_type;
    }
    public String getPill_name() {
        return pill_name;
    }
}
