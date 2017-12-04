package yhb.emittor.impl;

import yhb.emittor.IEmitter;

public class Enum implements IEmitter {
    @Override
    public String emit(String... params) {
        int index = (int) (Math.random() * params.length);
        return params[index];
    }
}
