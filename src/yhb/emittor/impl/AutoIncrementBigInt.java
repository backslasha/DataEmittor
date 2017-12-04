package yhb.emittor.impl;

import yhb.emittor.IEmitter;

/**
 * fixPart
 * dynamicPartLengthString
 * baseL
 * if exist, mean it 's time to rebase baseLong with value baseL
 */
public class AutoIncrementBigInt implements IEmitter {
    private static long baseLong = -1;
    @Override
    public String emit(String... params) {
        String fixPart = params[0];
        String dynamicPartLengthString = params[1];
        String baseL = params[2];

        int dynamicPartGoalLength = Integer.parseInt(dynamicPartLengthString);

        if (params.length>=4){
            baseLong = -1;
        }

        if (baseLong == -1) {
            baseLong = Long.parseLong(baseL);
        }

        String dynamicPartString = String.valueOf(baseLong++);

        return fixPart + zeroPadding(dynamicPartGoalLength,dynamicPartString.length())+ dynamicPartString;
    }

    private String zeroPadding(int dynamicPartGoalLength,int dynamicPartCurrentLength) {

        int zeroPaddingCount = dynamicPartGoalLength - dynamicPartCurrentLength;

        char[] zeroPaddingChars = new char[zeroPaddingCount];
        for (int i = 0; i < zeroPaddingChars.length; i++) {
            zeroPaddingChars[i] = '0';
        }
        return new String(zeroPaddingChars) ;
    }
}
