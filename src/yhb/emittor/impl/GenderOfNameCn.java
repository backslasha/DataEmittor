package yhb.emittor.impl;

import yhb.emittor.IEmitter;

public class GenderOfNameCn implements IEmitter {
    @Override
    public String emit(String... params) {
        return NameCn.gender;
    }
}
