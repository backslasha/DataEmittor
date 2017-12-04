package yhb.emittor.impl;

import yhb.emittor.IEmitter;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

import static java.lang.Math.random;

/**
 * targetDate
 * maxOffsetMinutes of future
 */
public class DateTimeAfter implements IEmitter {
    @Override
    public String emit(String... params) {
        String targetDate = params[0];
        int maxOffsetMinutes = Integer.parseInt(params[1]);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DateFormat.getDateInstance().parse(targetDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.MINUTE, (int) (maxOffsetMinutes* random()));
        return new Timestamp(calendar.getTimeInMillis()).toString();
    }
}
