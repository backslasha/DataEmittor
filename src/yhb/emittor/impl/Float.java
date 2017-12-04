package yhb.emittor.impl;

import yhb.emittor.IEmitter;

public class Float implements IEmitter {
    @Override
    public String emit(String... params) {
        String minString = params[0];
        String maxString = params[1];
        float max = (float) Double.parseDouble(maxString);
        float min = (float) Double.parseDouble(minString);
        return String.valueOf(Math.max((Math.random() * max), min));
    }
}
