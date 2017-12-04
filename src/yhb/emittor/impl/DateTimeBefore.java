package yhb.emittor.impl;

import yhb.emittor.IEmitter;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import static java.lang.Math.random;

/**
 * targetDate
 * maxOffsetMinutes of past
 */
public class DateTimeBefore implements IEmitter {
    @Override
    public String emit(String... params) {
        String targetDateTime = regularTimeStamp(params[0]);
        int maxOffsetMinutes = Integer.parseInt(params[1]);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DateFormat.getDateTimeInstance().parse(targetDateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.MINUTE, -(int) (maxOffsetMinutes * random()));
        return new Timestamp(calendar.getTimeInMillis()).toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 19; i++) {
            System.out.println(new DateTimeBefore().emit("1996-01-05 18:00", "60"));
        }
    }


    public static String regularTimeStamp(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        source = source.replaceAll("([^0-9] )|([^0-9])", " ");
        source = source.replaceAll("\\s{1,}", " ");
        String[] numbers = source.split(" ");
        if (numbers.length == 1) {
            String time = numbers[0];
            SimpleDateFormat format;

            if (time.length() == 8)
                format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            else if (time.length() == 14)
                format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
            else if (time.length() > 8) {
                time = time.substring(0, 8);
                format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            } else {
                format = null;
                return sdf.format(new Date(0));
            }
            Date date = null;
            try {
                date = format.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return sdf.format(date);
        }
        Vector<Integer> nums = new Vector<Integer>();
        for (int i = 0; i < 6; i++)
            nums.add(0);

        if (numbers.length > 3) {
            if (Integer.parseInt(numbers[2]) > 31) {
                String tmp = numbers[2].substring(0, 2);
                if (Integer.parseInt(tmp) > 31)
                    tmp = numbers[2].substring(0, 1);
                numbers[3] = numbers[2].substring(tmp.length());
                numbers[2] = tmp;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            nums.setElementAt(Integer.parseInt(numbers[i]), i);
        }

        int year = nums.get(0);
        int month = nums.get(1);
        int day = nums.get(2);

        int hour = nums.get(3);
        if (hour > 24) hour = 0;
        int min = nums.get(4);
        if (min > 60) min = 0;
        int sec = nums.get(5);
        if (sec > 60) sec = 0;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hour, min, sec);
        return sdf.format(calendar.getTime());
    }
}
