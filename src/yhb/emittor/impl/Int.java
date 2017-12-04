package yhb.emittor.impl;

import yhb.emittor.IEmitter;

public class Int implements IEmitter {
    @Override
    public String emit(String... params) {
        String minString = params[0];
        String maxString = params[1];
        int max = Integer.parseInt(maxString);
        int min = Integer.parseInt(minString);
        return String.valueOf((int) Math.max((Math.random() * max), min));
    }
}
