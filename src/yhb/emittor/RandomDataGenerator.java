package yhb.emittor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static yhb.emittor.ConstPool.*;

public class RandomDataGenerator {

    private static final String PACKAGE_PREFIX = "yhb.emittor.impl.";

    /**
     * 使用反射调用一系列策略类的方法，收集每个方法的返回值，以数组返回
     *
     * @param actionNames             字符串数组，存放每个策略类的名称
     * @param methodParamsStringArray 字符串数组，每个字符字符串保存着一个方法的所有参数，以半角逗号隔开
     * @return 字符串数组，保存着每个方法的返回值
     */
    public String[] generateValues(String[] actionNames, String[] methodParamsStringArray) {
        String[] values = new String[actionNames.length];

        // 对每一个方法名字符串，根据参数数量，类型，使用反射调用对应的方法，生成相应的结果字符串，存放在 values 中
        for (int i = 0; i < actionNames.length; i++) {
            // 获得一个策略类的名字，下称“此策略类”
            String className = actionNames[i];

            // 字符串数组，将用来存放此策略类的方法附带的参数
            String[] methodParams;
            if (methodParamsStringArray[i].equals("")) {
                methodParams = new String[0];
            } else
                methodParams = methodParamsStringArray[i].split(",");

            // 此方法的返回值
            String result = null;
            try {
                Class<? extends IEmitter> clazz = (Class<? extends IEmitter>) Class.forName(PACKAGE_PREFIX + className);
                IEmitter emitter = clazz.newInstance();
                result = emitter.emit(methodParams);
                values[i] = result;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
        return values;
    }

    /**
     * 给定一个带 ? 的 sql 语句，和一个字符串数组，使用数组中的元素依次替换 sql 语句中的 ?
     *
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
        return clauseBuilder.toString();
    }

    public static void main(String[] args) {
        RandomDataGenerator r = new RandomDataGenerator();
        for (int i = 0; i < 10; i++) {
            String[] strings = r.generateValues(new String[]{"NameCn", "Enum","DateTimeBefore"}, new String[]{"", "大厦比啊,是啊即哦呵,是骄傲时间啊,介绍ij","1999-10-1 18:00,60"});
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
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
