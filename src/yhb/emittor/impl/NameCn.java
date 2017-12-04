package yhb.emittor.impl;

import yhb.emittor.IEmitter;

import java.util.Objects;

import static yhb.emittor.ConstPool.*;
import static yhb.emittor.ConstPool.BOY_NAME_ARRAY;

public class NameCn implements IEmitter {
    public static String gender = null;

    @Override
    public String emit(String... params) {
        StringBuilder nameBuilder = new StringBuilder();
        int index = (int) (Math.random() * INITIALS_ARRAY.length);
        nameBuilder.append(INITIALS_ARRAY[index]);

        if (params != null && params.length != 0) {
            gender = params[0];
        } else if (Math.random() > 0.5) {
            gender = BOY;
        } else
            gender = GIRL;

        if (Objects.equals(gender, GIRL)) {
            index = (int) (Math.random() * GIRL_NAME_ARRAY.length);
            nameBuilder.append(GIRL_NAME_ARRAY[index]);
            index = (int) (Math.random() * GIRL_NAME_ARRAY.length);
            nameBuilder.append(GIRL_NAME_ARRAY[index]);
        } else {
            index = (int) (Math.random() * BOY_NAME_ARRAY.length);
            nameBuilder.append(BOY_NAME_ARRAY[index]);
            index = (int) (Math.random() * BOY_NAME_ARRAY.length);
            nameBuilder.append(BOY_NAME_ARRAY[index]);
        }
        return nameBuilder.toString();
    }
}
