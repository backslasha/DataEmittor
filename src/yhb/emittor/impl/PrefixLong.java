package yhb.emittor.impl;

import yhb.emittor.IEmitter;

/**
 * fixPart
 * dynamicPartLengthString
 */
public class PrefixLong implements IEmitter {
    @Override
    public String emit(String... params) {
        String fixPart = params[0];
        String dynamicPartLengthString = params[1];

        int dynamicPartLength = Integer.parseInt(dynamicPartLengthString);

        int dynamicPartMax = (int) Math.pow(10, dynamicPartLength);

        return fixPart + (int)(Math.random() * dynamicPartMax);
    }
}
