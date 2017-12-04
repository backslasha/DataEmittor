package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.company.ConstPool.*;

public class RandomDataGenerator {

    private String lastGeneratedGender = BOY;
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private String lastGeneratedDate = dateFormat.format(new Timestamp(calendar.getTimeInMillis()));
    private long lastGeneratedBigint = Long.MAX_VALUE;

    /**
     * 使用反射调用一系列方法，收集每个方法的返回值，以数组返回
     *
     * @param methodNames             字符串数组，存放每个方法的名称
     * @param methodParamsStringArray 字符串数组，每个字符字符串保存着一个方法的所有参数，以半角逗号隔开
     * @return 字符串数组，保存着每个方法的返回值
     */
    public String[] generateValues(String[] methodNames, String[] methodParamsStringArray) {
        String[] values = new String[methodNames.length];
        Class<RandomDataGenerator> clazz = RandomDataGenerator.class;

        // 对每一个方法名字符串，根据参数数量，类型，使用反射调用对应的方法，生成相应的结果字符串，存放在 values 中
        for (int i = 0; i < methodNames.length; i++) {
            // 获得一个方法的名字，下称“此方法”
            String methodName = methodNames[i];

            // 字符串数组，将用来存放此方法附带的参数
            String[] methodParams;
            if (methodParamsStringArray[i].equals("")) {
                methodParams = new String[0];
            } else
                methodParams = methodParamsStringArray[i].split(",");

            // 构造一个 Class 数组，有几个参数，就添加几个 String.class
            Class<?>[] paramClazzes;
            if (methodName.equals("enums")) {
                paramClazzes = new Class[1];
                paramClazzes[0] = String[].class;

            } else {
                paramClazzes = new Class[methodParams.length];
                for (int j = 0; j < paramClazzes.length; j++) {
                    paramClazzes[j] = String.class;
                }
            }


            // 此方法的返回值
            String value = null;
            try {
                Method method;
                if (paramClazzes.length == 0)
                    method = clazz.getMethod(methodName);
                else
                    method = clazz.getMethod(methodName, paramClazzes);

                if (methodName.equals("enums")) {
                    value = (String) method.invoke(RandomDataGenerator.this, new Object[]{methodParams});
                } else {
                    value = (String) method.invoke(RandomDataGenerator.this, methodParams);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            values[i] = value;
        }
        return values;
    }

    /**
     * 给定一个带 ? 的 sql 语句，和一个字符串数组，使用数组中的元素依次替换 sql 语句中的 ?
     * @param clause 带 ? 的 sql 语句
     * @param values 字符串数组
     * @return
     */
    public String fillValues(String clause, String... values) {
        StringBuilder clauseBuilder = new StringBuilder(clause);

        for (String value : values) {
            if (!value.matches("[0-9]*")) {
                value = "\'" + value + "\'";
            }

            int start = clauseBuilder.indexOf("?");
            clauseBuilder = clauseBuilder.replace(
                    start,
                    start + 1,
                    value
            );
        }
/**
 *
 *
 * smallint(max,min)
 bigint(prefix)
 gender()
 name(length)
 date(afterWhen)
 datetime(date)
 */
        return clauseBuilder.toString();
    }


    /**
     * 获得今天的 datetime 字符串
     * @return
     */
    public String today() {
        return dateFormat.format(new Timestamp(calendar.getTimeInMillis()));
    }

    /**
     * 随即返回一个 date ，此 date 可能在 afterWhen 后面的 intervalMinute 内的任意时刻
     * 此方法会刷新 lastGeneratedDate 的值
     *
     * @param afterWhen
     * @param intervalMinute
     * @return
     */
    public String date(String afterWhen, String intervalMinute) {
        int intervalMiuter = Integer.parseInt(intervalMinute);
        try {
            java.util.Date parse = dateFormat.parse(afterWhen);
            Calendar calendar = (Calendar) this.calendar.clone();
            calendar.setTime(parse);
            calendar.add(Calendar.MINUTE, (int) (Math.random() * intervalMiuter));
            lastGeneratedDate = dateFormat.format(new java.util.Date(calendar.getTimeInMillis()));
            return lastGeneratedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 随即返回一个 date ，此 date 可能在 lastGeneratedDate 后面的 intervalMinute 内的任意时刻
     *
     * @param intervalMinute
     * @return
     */
    public String dateToLast(String intervalMinute) {
        return date(lastGeneratedDate, intervalMinute);
    }

    /**
     * 随即返回一个 date ，此 date 可能在当前此刻后面的 intervalMinute 内的任意时刻
     *
     * @param intervalMinute
     * @return
     */
    public String dateFuture(String intervalMinute) {
        return date(today(), intervalMinute);
    }

    /**
     * 随即返回一个长整形，有固定部分
     *
     * @param fixPart
     * @param dynamicPartLengthString
     * @return
     */
    public String bigint(String fixPart, String dynamicPartLengthString) {

        int dynamicPartLength = Integer.parseInt(dynamicPartLengthString);

        int dynamic = (int) Math.pow(10, dynamicPartLength);

        String finalS = fixPart + (int) (Math.random() * dynamic);

        return finalS;
    }

    /**
     * 随即返回一个长整形
     *
     * @param length 指定长度
     * @return
     */
    public String bigint(String length) {
        return bigint("", length);
    }

    /**
     * 返回一个长整形的字符串形式，此长整形为 lastGeratedBigint+1 的结果
     *
     * @param fixPart                 长整形的固定部分
     * @param dynamicPartLengthString 长整形的不固定部分的位数
     * @return
     */
    public String autoIncreaseBigint(String fixPart, String dynamicPartLengthString, String start) {
        if (lastGeneratedBigint == Long.MAX_VALUE) {
            lastGeneratedBigint = Long.parseLong(start);
        }

        String lastGeneratedBigintString = String.valueOf(lastGeneratedBigint++);

        int dynamicPartLength = Integer.parseInt(dynamicPartLengthString);

        int zeroPaddingCount = dynamicPartLength - lastGeneratedBigintString.length();

        char[] zeroPaddingChars = new char[zeroPaddingCount];
        for (int i = 0; i < zeroPaddingChars.length; i++) {
            zeroPaddingChars[i] = '0';
        }

        int dynamic = (int) Math.pow(10, dynamicPartLength);

        String finalS = fixPart + new String(zeroPaddingChars) + lastGeneratedBigintString;

        return finalS;
    }

    /**
     * 返回当前性别的字符串
     *
     * @return
     */
    public String gender() {
        return lastGeneratedGender;
    }

    /**
     * 返回一个在 max 和 min 之间的整数的字符串
     *
     * @param maxString max 的 String 形式
     * @param minString min 的 String 形式
     * @return
     */
    public String smallint(String minString, String maxString) {
        int max = Integer.parseInt(maxString);
        int min = Integer.parseInt(minString);
        return String.valueOf((int) Math.max((Math.random() * max), min));
    }

    /**
     * 返回一个不会超过 max 的整数的字符串
     *
     * @param maxString max 的 String 形式
     * @return
     */
    public String smallint(String maxString) {
        int max = Integer.parseInt(maxString);
        return String.valueOf((int) (Math.random() * max));
    }

    /**
     * @return 根据性别返回一个中文名
     */
    public String generateChineseName(String gender) {
        StringBuilder nameBuilder = new StringBuilder();
        int index = (int) (Math.random() * INITIALS_ARRAY.length);
        nameBuilder.append(INITIALS_ARRAY[index]);

        if (gender == GIRL) {
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

    /**
     * @return 随即决定性别，并根据性别返回一个中文名
     */
    public String generateChineseName() {
        if (Math.random() > 0.5) {
            lastGeneratedGender = BOY;
        } else
            lastGeneratedGender = GIRL;
        return generateChineseName(lastGeneratedGender);
    }


    public String enums(String... enums) {
        int index = (int) (Math.random() * enums.length);
        return enums[index];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new RandomDataGenerator().enums("sajijai", "jsaoijoas", "iajsihiuefb"));
        }
    }

    public static void printMethods() {
        Class clazz = RandomDataGenerator.class;
        Method[] methods = clazz.getDeclaredMethods();
        String[] methodName = new String[methods.length];
        for (int i = 0; i < methods.length; i++) {
            methodName[i] = methods[i].getName() + "( " + methods[i].getParameterCount() + " param(s) )";
            System.out.println(methodName[i]);
        }
    }

}
