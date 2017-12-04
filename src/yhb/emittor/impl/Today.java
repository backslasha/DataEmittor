package yhb.emittor.impl;

import yhb.emittor.IEmitter;

import java.sql.Timestamp;
import java.util.Calendar;

public class Today implements IEmitter {
    @Override
    public String emit(String... params) {
        return new Timestamp(Calendar.getInstance().getTimeInMillis()).toString();
    }
}
