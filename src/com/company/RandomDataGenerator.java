package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RandomDataGenerator {
    public static final String INITIALS_TABLE = "赵 钱 孙 李 周 吴 郑 王 冯 陈 褚 卫 蒋 沈 韩 杨\n" +
            "朱 秦 尤 许 何 吕 施 张 孔 曹 严 华 金 魏 陶 姜\n" +
            "戚 谢 邹 喻 柏 水 窦 章 云 苏 潘 葛 奚 范 彭 郎\n" +
            "鲁 韦 昌 马 苗 凤 花 方 俞 任 袁 柳 酆 鲍 史 唐\n" +
            "费 廉 岑 薛 雷 贺 倪 汤 滕 殷 罗 毕 郝 邬 安 常\n" +
            "乐 于 时 傅 皮 卞 齐 康 伍 余 元 卜 顾 孟 平 黄\n" +
            "和 穆 萧 尹 姚 邵 湛 汪 祁 毛 禹 狄 米 贝 明 臧\n" +
            "计 伏 成 戴 谈 宋 茅 庞 熊 纪 舒 屈 项 祝 董 梁\n" +
            "杜 阮 蓝 闵 席 季 麻 强 贾 路 娄 危 江 童 颜 郭\n" +
            "梅 盛 林 刁 钟 徐 邱 骆 高 夏 蔡 田 樊 胡 凌 霍\n" +
            "虞 万 支 柯 昝 管 卢 莫 经 房 裘 缪 干 解 应 宗\n" +
            "丁 宣 贲 邓 郁 单 杭 洪 包 诸 左 石 崔 吉 钮 龚\n" +
            "程 嵇 邢 滑 裴 陆 荣 翁 荀 羊 於 惠 甄 曲 家 封\n" +
            "芮 羿 储 靳 汲 邴 糜 松 井 段 富 巫 乌 焦 巴 弓\n" +
            "牧 隗 山 谷 车 侯 宓 蓬 全 郗 班 仰 秋 仲 伊 宫\n" +
            "宁 仇 栾 暴 甘 钭 厉 戎 祖 武 符 刘 景 詹 束 龙\n" +
            "叶 幸 司 韶 郜 黎 蓟 薄 印 宿 白 怀 蒲 台 从 鄂\n" +
            "索 咸 籍 赖 卓 蔺 屠 蒙 池 乔 阴 郁 胥 能 苍 双\n" +
            "闻 莘 党 翟 谭 贡 劳 逄 姬 申 扶 堵 冉 宰 郦 雍\n" +
            "却 璩 桑 桂 濮 牛 寿 通 边 扈 燕 冀 郏 浦 尚 农\n" +
            "温 别 庄 晏 柴 瞿 阎 充 慕 连 茹 习 宦 艾 鱼 容\n" +
            "向 古 易 慎 戈 廖 庚 终 暨 居 衡 步 都 耿 满 弘\n" +
            "匡 国 文 寇 广 禄 阙 东 殴 殳 沃 利 蔚 越 夔 隆\n" +
            "师 巩 厍 聂 晁 勾 敖 融 冷 訾 辛 阚 那 简 饶 空\n" +
            "曾 毋 沙 乜 养 鞠 须 丰 巢 关 蒯 相 查 后 荆 红\n" +
            "游 竺 权 逯 盖 益 桓公 万俟 司马 上官 欧阳\n" +
            "夏侯 诸葛 闻人 东方 赫连 皇甫 尉迟 公羊\n" +
            "澹台 公冶 宗政 濮阳 淳于 单于 太叔 申屠\n" +
            "公孙 仲孙 轩辕 令狐 钟离 宇文 长孙 慕容\n" +
            "鲜于 闾丘 司徒 司空 亓官 司寇 仉 督 子车\n" +
            "颛孙 端木 巫马 公西 漆雕 乐正 壤驷 公良\n" +
            "拓跋 夹谷 宰父 谷粱 晋 楚 闫 法 汝 鄢 涂 钦\n" +
            "段干 百里 东郭 南门 呼延 归海 羊舌 微生\n" +
            "岳 帅 缑 亢 况 后 有 琴 梁丘 左丘 东门 西门";
    public static final String GIRLS_NAME_COMMON_WORDS = "筠 柔 竹 霭 凝 晓 欢 霄 枫 芸 菲 寒 伊 亚 宜 可 姬 舒 影 荔 枝 思 丽 秀 娟 英 华 慧 巧 美 娜 静 淑 惠 珠 翠 雅 芝 玉 萍 红 娥 玲 芬 芳 燕 彩 春 菊 勤 珍 贞 莉 兰 凤 洁 梅 琳 素 云 莲 真 环 雪 荣 爱 妹 霞 香 月 莺 媛  艳 瑞 凡 佳 嘉 琼 桂 娣 叶 璧 璐 娅 琦 晶 妍 茜 秋 珊 莎 锦 黛 青 倩 婷 姣 婉 娴 瑾 颖 露 瑶 怡 婵 雁 蓓 纨 仪 荷 丹 蓉 眉 君 琴 蕊 薇 菁 梦 岚  苑 婕 馨 瑗 琰 韵 融 园 艺 咏 卿 聪 澜 纯 毓 悦 昭 冰 爽 琬 茗 羽 希 宁 欣 飘 育 滢 馥";
    public static final String BOYS_NAME_COMMON_WORDS = "嘉 哲 俊 博 妍 乐 佳 涵  晨 宇 怡 泽 子 凡 悦 思  奕 依 浩 泓 彤 冰 媛 凯  伊 淇 淳 一 洁 茹 清 吉  源 渊 和 函 妤 宜 云 琪  菱 宣 沂 健 信 欣 可 洋  萍 荣 榕 含 佑 明 雄 梅  芝 英 义 淑 卿 乾 亦 芬  萱 昊 芸 天 岚 昕 尧 鸿  棋 琳 孜 娟 宸 林 乔 琦  丞 安 毅 凌 泉 坤 晴 竹  娴 婕 恒 渝 菁 龄 弘 佩  勋 宁 元 栋 盈 江 卓  春 晋 逸 沅 倩 昱 绮  海 圣 承 民 智 棠 容  羚 峰 钰 涓 新 莉 恩  羽 妮 旭 维 家 泰 诗  谚 阳 彬 书 苓 汉 蔚  坚 茵 耘 喆 国 仑 良  裕 融 致 富 德 易 虹  纲 筠 奇 平 蓓 真 之  凰 桦 玫 强 村 沛 汶  锋 彦 延 庭 霞 冠 益  劭 钧 薇 亭 瀚 桓 东  滢 恬 瑾 达 群 茜 先  洲 溢 楠 基 轩 月 美  心 茗 丹 森 学 文";
    public static final String[] INITIALS_ARRAY = INITIALS_TABLE.split("\\s");
    public static final String[] BOY_NAME_ARRAY = BOYS_NAME_COMMON_WORDS.split("\\s");
    public static final String[] GIRL_NAME_ARRAY = GIRLS_NAME_COMMON_WORDS.split("\\s");

    public static final String GIRL = "女";
    public static final String BOY = "男";

    private String lastGeneratedGender = BOY;
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private String lastGeneratedDate = dateFormat.format(new Date(calendar.getTimeInMillis()));
    private long lastGeneratedBigint = Long.MAX_VALUE;

    public String[] generateValues(String[] methodNames, String[] methodParamsStringArray) {
        String[] values = new String[methodNames.length];
        Class<RandomDataGenerator> clazz = RandomDataGenerator.class;

        for (int i = 0; i < methodNames.length; i++) {
            String methodName = methodNames[i];
            String[] methodParams;
            if (methodParamsStringArray[i].equals("")) {
                methodParams = new String[0];
            } else
                methodParams = methodParamsStringArray[i].split(",");

            Class<String>[] paramClazzes = new Class[methodParams.length];
            for (int j = 0; j < paramClazzes.length; j++) {
                paramClazzes[j] = String.class;
            }

            String value = null;
            try {
                Method method;
                if (paramClazzes.length == 0)
                    method = clazz.getMethod(methodName);
                else
                    method = clazz.getMethod(methodName, paramClazzes);

                value = (String) method.invoke(RandomDataGenerator.this, methodParams);
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


    public String today() {
        return dateFormat.format(new Date(calendar.getTimeInMillis()));
    }

    /**
     * 随即返回一个 date ，此 date 可能在 afterWhen 后面的 intervalMinute 内的任意时刻
     * 此方法会刷新 lastGeneratedDate 的值
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
     *
     * 随即返回一个 date ，此 date 可能在 lastGeneratedDate 后面的 intervalMinute 内的任意时刻
     * @param intervalMinute
     * @return
     */
    public String dateToLast(String intervalMinute) {
        return date(lastGeneratedDate, intervalMinute);
    }

    /**
     * 随即返回一个 date ，此 date 可能在当前此刻后面的 intervalMinute 内的任意时刻
     * @param intervalMinute
     * @return
     */
    public String dateFuture(String intervalMinute) {
        return date(today(), intervalMinute);
    }

    /**
     * 随即返回一个长整形，有固定部分
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
     * @param length 指定长度
     * @return
     */
    public String bigint(String length) {
        return bigint("", length);
    }

    /**
     * 返回一个长整形的字符串形式，此长整形为 lastGeratedBigint+1 的结果
     * @param fixPart 长整形的固定部分
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
     * @return
     */
    public String gender() {
        return lastGeneratedGender;
    }

    /**
     * 返回一个在 max 和 min 之间的整数的字符串
     * @param maxString max 的 String 形式
     * @param minString min 的 String 形式
     * @return
     */
    public String smallint(String maxString, String minString) {
        int max = Integer.parseInt(maxString);
        int min = Integer.parseInt(minString);
        return String.valueOf((int) Math.max((Math.random() * max), min));
    }

    /**
     * 返回一个不会超过 max 的整数的字符串
     * @param maxString max 的 String 形式
     * @return
     */
    public String smallint(String maxString) {
        int max = Integer.parseInt(maxString);
        return String.valueOf((int) (Math.random() * max));
    }

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
     *
     * @return 根据当前性别返回一个中文名
     */
    public String generateChineseName() {
        if (Math.random() > 0.5) {
            lastGeneratedGender = BOY;
            return "男";
        } else
            lastGeneratedGender = GIRL;
        return generateChineseName(lastGeneratedGender);
    }


    public static void main(String[] args) {
        Class clazz = RandomDataGenerator.class;
        Method[] methods = clazz.getDeclaredMethods();
        String[] methodName = new String[methods.length];
        for (int i = 0; i < methods.length; i++) {
            methodName[i] = methods[i].getName() + "( " + methods[i].getParameterCount() + " param(s) )";
            System.out.println(methodName[i]);
        }
    }

}
