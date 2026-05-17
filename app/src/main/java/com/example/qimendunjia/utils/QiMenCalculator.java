package com.example.qimendunjia.utils;

import android.util.Log;

import com.example.qimendunjia.model.QiMenData;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QiMenCalculator {
    private static final String TAG = "QiMenCalculator";

    // 天干
    private final String[] tianGan = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};

    // 地支
    private final String[] diZhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    // 六十甲子表 - 与Python完全一致
    private final String[] jiaZiTable = {
            "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉",
            "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未",
            "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳",
            "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯",
            "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑",
            "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"
    };

    // 天干转九干 - 与Python一致
    private final Map<String, String> tianGanToJiuGan = new HashMap<String, String>() {{
        put("甲", "戊"); put("乙", "乙"); put("丙", "丙"); put("丁", "丁"); put("戊", "戊");
        put("己", "己"); put("庚", "庚"); put("辛", "辛"); put("壬", "壬"); put("癸", "癸");
    }};

    // 九干对应数 - 与Python一致
    private final Map<String, Integer> jiuGanNum = new HashMap<String, Integer>() {{
        put("戊", 1); put("己", 2); put("庚", 3); put("辛", 4); put("壬", 5); put("癸", 6);
        put("丁", 7); put("丙", 8); put("乙", 9);
    }};

    // 数字转九干 - 与Python一致
    private final Map<Integer, String> numToJiuGan = new HashMap<Integer, String>() {{
        put(1, "戊"); put(2, "己"); put(3, "庚"); put(4, "辛"); put(5, "壬");
        put(6, "癸"); put(7, "丁"); put(8, "丙"); put(9, "乙");
    }};

    // 九星对应数 - 与Python一致
    private final Map<String, Integer> jiuXingNum = new HashMap<String, Integer>() {{
        put("天蓬", 1); put("天任", 8); put("天冲", 3); put("天辅", 4);
        put("天英", 9); put("天芮", 2); put("天柱", 7); put("天心", 6); put("天禽", 5);
    }};

    // 数字转九星 - 与Python一致
    private final Map<Integer, String> numToJiuXing = new HashMap<Integer, String>() {{
        put(1, "天蓬"); put(2, "天芮"); put(3, "天冲"); put(4, "天辅"); put(5, "天禽");
        put(6, "天心"); put(7, "天柱"); put(8, "天任"); put(9, "天英");
    }};

    // 八门对应数 - 与Python一致
    private final Map<String, Integer> baMenNum = new HashMap<String, Integer>() {{
        put("休", 1); put("生", 8); put("伤", 3); put("杜", 4);
        put("景", 9); put("死", 2); put("惊", 7); put("开", 6); put("中", 5);
    }};

    // 数字转八门 - 与Python一致
    private final Map<Integer, String> numToBaMen = new HashMap<Integer, String>() {{
        put(1, "休"); put(2, "死"); put(3, "伤"); put(4, "杜");
        put(5, "中"); put(6, "开"); put(7, "惊"); put(8, "生"); put(9, "景");
    }};

    // 八神对应数 - 与Python一致
    private final Map<String, Integer> baShenNum = new HashMap<String, Integer>() {{
        put("值符", 1); put("腾蛇", 8); put("太阴", 3); put("六合", 4);
        put("明王", 5); put("白虎", 9); put("玄武", 2); put("九地", 7); put("九天", 6);
    }};

    // 数字转八神 - 与Python一致
    private final Map<Integer, String> numToBaShen = new HashMap<Integer, String>() {{
        put(1, "值符"); put(8, "腾蛇"); put(3, "太阴"); put(4, "六合");
        put(5, "明王"); put(9, "白虎"); put(2, "玄武"); put(7, "九地"); put(6, "九天");
    }};

    // 时干序号 - 与Python一致
    private final Map<String, Integer> shiGanXuHao = new HashMap<String, Integer>() {{
        put("甲", 1); put("乙", 2); put("丙", 3); put("丁", 4); put("戊", 5);
        put("己", 6); put("庚", 7); put("辛", 8); put("壬", 9); put("癸", 10);
    }};

    // 九星本位宫 - 与Python一致
    private final Map<String, Integer> xingBenWei = new HashMap<String, Integer>() {{
        put("天蓬", 1); put("天任", 8); put("天冲", 3); put("天辅", 4);
        put("天英", 9); put("天芮", 2); put("天柱", 7); put("天心", 6); put("天禽", 5);
    }};

    // 八门本位宫 - 与Python一致
    private final Map<String, Integer> menBenWei = new HashMap<String, Integer>() {{
        put("休", 1); put("生", 8); put("伤", 3); put("杜", 4);
        put("景", 9); put("死", 2); put("惊", 7); put("开", 6);
    }};

    // 六旬对应数 - 与Python一致
    private final Map<Integer, String> xunMap = new HashMap<Integer, String>() {{
        put(0, "甲子戊"); put(10, "甲戌己"); put(8, "甲申庚");
        put(6, "甲午辛"); put(4, "甲辰壬"); put(2, "甲寅癸");
    }};

    // 六旬序数 - 与Python一致
    private final Map<String, Integer> xunOrder = new HashMap<String, Integer>() {{
        put("甲子戊", 1); put("甲戌己", 2); put("甲申庚", 3);
        put("甲午辛", 4); put("甲辰壬", 5); put("甲寅癸", 6);
    }};

    // 节气局数 - 与Python一致
    private class JieQiInfo {
        int gong;
        String dun;
        JieQiInfo(int gong, String dun) { this.gong = gong; this.dun = dun; }
    }

    private final Map<String, JieQiInfo> solarTerms = new HashMap<String, JieQiInfo>() {{
        put("冬至", new JieQiInfo(1, "阳")); put("小寒", new JieQiInfo(2, "阳")); put("大寒", new JieQiInfo(3, "阳"));
        put("立春", new JieQiInfo(8, "阳")); put("雨水", new JieQiInfo(9, "阳")); put("惊蛰", new JieQiInfo(1, "阳"));
        put("春分", new JieQiInfo(3, "阳")); put("清明", new JieQiInfo(4, "阳")); put("谷雨", new JieQiInfo(5, "阳"));
        put("立夏", new JieQiInfo(4, "阳")); put("小满", new JieQiInfo(5, "阳")); put("芒种", new JieQiInfo(6, "阳"));
        put("夏至", new JieQiInfo(9, "阴")); put("小暑", new JieQiInfo(8, "阴")); put("大暑", new JieQiInfo(7, "阴"));
        put("立秋", new JieQiInfo(2, "阴")); put("处暑", new JieQiInfo(1, "阴")); put("白露", new JieQiInfo(9, "阴"));
        put("秋分", new JieQiInfo(7, "阴")); put("寒露", new JieQiInfo(6, "阴")); put("霜降", new JieQiInfo(5, "阴"));
        put("立冬", new JieQiInfo(6, "阴")); put("小雪", new JieQiInfo(5, "阴")); put("大雪", new JieQiInfo(4, "阴"));
    }};

    // 节气顺序 - 与Python一致
    private final String[] jieQiOrder = {
            "冬至", "小寒", "大寒", "立春", "雨水", "惊蛰",
            "春分", "清明", "谷雨", "立夏", "小满", "芒种",
            "夏至", "小暑", "大暑", "立秋", "处暑", "白露",
            "秋分", "寒露", "霜降", "立冬", "小雪", "大雪"
    };

    // 节气到月支的映射 - 与Python一致
    private final Map<String, String> jieQiToDiZhi = new HashMap<String, String>() {{
        put("立春", "寅"); put("雨水", "寅");
        put("惊蛰", "卯"); put("春分", "卯");
        put("清明", "辰"); put("谷雨", "辰");
        put("立夏", "巳"); put("小满", "巳");
        put("芒种", "午"); put("夏至", "午");
        put("小暑", "未"); put("大暑", "未");
        put("立秋", "申"); put("处暑", "申");
        put("白露", "酉"); put("秋分", "酉");
        put("寒露", "戌"); put("霜降", "戌");
        put("立冬", "亥"); put("小雪", "亥");
        put("大雪", "子"); put("冬至", "子");
        put("小寒", "丑"); put("大寒", "丑");
    }};

    // 月干映射表 - 与Python一致
    private final Map<String, String[]> monthGanMap = new HashMap<String, String[]>() {{
        put("甲", new String[]{"丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁"});
        put("己", new String[]{"丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁"});
        put("乙", new String[]{"戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己"});
        put("庚", new String[]{"戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己"});
        put("丙", new String[]{"庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛"});
        put("辛", new String[]{"庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛"});
        put("丁", new String[]{"壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"});
        put("壬", new String[]{"壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"});
        put("戊", new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙"});
        put("癸", new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙"});
    }};

    // 时干映射 - 与Python一致
    private final Map<String, String[]> hourGanMap = new HashMap<String, String[]>() {{
        put("甲", new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙"});
        put("己", new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙"});
        put("乙", new String[]{"丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁"});
        put("庚", new String[]{"丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁"});
        put("丙", new String[]{"戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己"});
        put("辛", new String[]{"戊", "己", "庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己"});
        put("丁", new String[]{"庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛"});
        put("壬", new String[]{"庚", "辛", "壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛"});
        put("戊", new String[]{"壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"});
        put("癸", new String[]{"壬", "癸", "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"});
    }};

    // 九宫数转名称 - 与Python一致
    private final Map<Integer, String> numToJiuGong = new HashMap<Integer, String>() {{
        put(1, "坎"); put(2, "坤"); put(3, "震"); put(4, "巽");
        put(5, "中"); put(6, "乾"); put(7, "兑"); put(8, "艮"); put(9, "离");
    }};

    // 九宫名称转数字 - 与Python一致
    private final Map<String, Integer> jiuGongToNum = new HashMap<String, Integer>() {{
        put("坎", 1); put("坤", 2); put("震", 3); put("巽", 4);
        put("中", 5); put("乾", 6); put("兑", 7); put("艮", 8); put("离", 9);
    }};

    // 九星顺序 - 与Python一致
    private final String[] xingOrder = {"天蓬", "天任", "天冲", "天辅", "天英", "天芮", "天柱", "天心"};

    // 八神顺序 - 与Python一致
    private final int[] bashenOrder = {1, 8, 3, 4, 9, 2, 7, 6};

    // 洛书圆环八宫顺时针顺序 - 与Python一致
    private final int[] luoshuClockwise = {1, 8, 3, 4, 9, 2, 7, 6};
    private final int[] luoshuCounter = {1, 6, 7, 2, 9, 4, 3, 8};

    // 显示顺序 - 与Python一致
    private final int[] displayOrder = {4, 9, 2, 3, 5, 7, 8, 1, 6};

    // 2026年精准节气表 - 与Python一致
    private class JieQi2026 {
        int month, day, hour, minute;
        String name;
        JieQi2026(int m, int d, int h, int min, String n) {
            month = m; day = d; hour = h; minute = min; name = n;
        }
    }

    private final JieQi2026[] preciseJieQi2026 = {
            new JieQi2026(1, 5, 23, 29, "小寒"), new JieQi2026(1, 20, 16, 47, "大寒"),
            new JieQi2026(2, 4, 10, 33, "立春"), new JieQi2026(2, 19, 6, 24, "雨水"),
            new JieQi2026(3, 5, 21, 58, "惊蛰"), new JieQi2026(3, 20, 22, 45, "春分"),
            new JieQi2026(4, 5, 2, 39, "清明"), new JieQi2026(4, 20, 9, 33, "谷雨"),
            new JieQi2026(5, 5, 19, 44, "立夏"), new JieQi2026(5, 21, 8, 51, "小满"),
            new JieQi2026(6, 5, 22, 3, "芒种"), new JieQi2026(6, 21, 14, 50, "夏至"),
            new JieQi2026(7, 7, 8, 17, "小暑"), new JieQi2026(7, 22, 23, 41, "大暑"),
            new JieQi2026(8, 7, 16, 2, "立秋"), new JieQi2026(8, 23, 6, 53, "处暑"),
            new JieQi2026(9, 7, 19, 11, "白露"), new JieQi2026(9, 22, 18, 19, "秋分"),
            new JieQi2026(10, 8, 14, 29, "寒露"), new JieQi2026(10, 23, 17, 37, "霜降"),
            new JieQi2026(11, 7, 17, 38, "立冬"), new JieQi2026(11, 22, 15, 2, "小雪"),
            new JieQi2026(12, 7, 10, 35, "大雪"), new JieQi2026(12, 21, 7, 27, "冬至")
    };

    // ==================== 年干支计算 ====================
    /**
     * 计算年干支 - 与Python的calculate_year_ganzhi一致
     * Python版：def calculate_year_ganzhi(self, year, month=None, day=None):
     */
    public String calculateYearGanZhi(int year, int month, int day) {
        // 考虑立春分界
        if (month < 2 || (month == 2 && day < 4)) {
            year = year - 1;
        }
        int remainder = (year - 3) % 60;
        if (remainder <= 0) remainder += 60;
        return jiaZiTable[remainder - 1];
    }

    // ==================== 日干支计算 ====================
    /**
     * 计算日干支 - 与Python的calculate_day_ganzhi_precise完全一致
     * Python版：def calculate_day_ganzhi_precise(self, year, month, day):
     */
    public String calculateDayGanZhiPrecise(int year, int month, int day) {
        // 使用2026年3月7日作为基准（庚辰日）
        Calendar baseCal = Calendar.getInstance();
        baseCal.set(2026, Calendar.MARCH, 7);
        baseCal.set(Calendar.HOUR_OF_DAY, 0);
        baseCal.set(Calendar.MINUTE, 0);
        baseCal.set(Calendar.SECOND, 0);
        baseCal.set(Calendar.MILLISECOND, 0);
        Date baseDate = baseCal.getTime();

        Calendar targetCal = Calendar.getInstance();
        targetCal.set(year, month - 1, day);
        targetCal.set(Calendar.HOUR_OF_DAY, 0);
        targetCal.set(Calendar.MINUTE, 0);
        targetCal.set(Calendar.SECOND, 0);
        targetCal.set(Calendar.MILLISECOND, 0);
        Date targetDate = targetCal.getTime();

        long diff = targetDate.getTime() - baseDate.getTime();
        long diffDays = diff / (1000 * 60 * 60 * 24);

        // 庚辰在六十甲子表中的索引
        int baseIndex = -1;
        for (int i = 0; i < jiaZiTable.length; i++) {
            if (jiaZiTable[i].equals("庚辰")) {
                baseIndex = i;
                break;
            }
        }

        int targetIndex = (int)((baseIndex + diffDays) % 60);
        if (targetIndex < 0) targetIndex += 60;

        return jiaZiTable[targetIndex];
    }

    /**
     * 获取节气 - 与Python的_get_jieqi_by_date完全一致
     */
    private String getJieQiByDate(int year, int month, int day, int hour, int minute) {
        if (year == 2026) {
            return getJieQi2026(month, day, hour, minute);
        } else if (year == 2044) {
            return getJieQi2044(month, day, hour, minute);
        } else {
            return getJieQiApproximate(year, month, day, hour, minute);
        }
    }

    /**
     * 获取2026年节气 - 与Python的precise_jieqi_2026一致
     */
    private String getJieQi2026(int month, int day, int hour, int minute) {
        // Python版：self.precise_jieqi_2026
        Object[][] jieQi2026 = {
                {1, 5, 23, 29, "小寒"}, {1, 20, 16, 47, "大寒"},
                {2, 4, 10, 33, "立春"}, {2, 19, 6, 24, "雨水"},
                {3, 5, 21, 58, "惊蛰"}, {3, 20, 22, 45, "春分"},
                {4, 5, 2, 39, "清明"}, {4, 20, 9, 33, "谷雨"},
                {5, 5, 19, 44, "立夏"}, {5, 21, 8, 51, "小满"},
                {6, 5, 22, 3, "芒种"}, {6, 21, 14, 50, "夏至"},
                {7, 7, 8, 17, "小暑"}, {7, 22, 23, 41, "大暑"},
                {8, 7, 16, 2, "立秋"}, {8, 23, 6, 53, "处暑"},
                {9, 7, 19, 11, "白露"}, {9, 22, 18, 19, "秋分"},
                {10, 8, 14, 29, "寒露"}, {10, 23, 17, 37, "霜降"},
                {11, 7, 17, 38, "立冬"}, {11, 22, 15, 2, "小雪"},
                {12, 7, 10, 35, "大雪"}, {12, 21, 7, 27, "冬至"}
        };

        String currentJieQi = "冬至";
        for (Object[] jq : jieQi2026) {
            int m = (int)jq[0];
            int d = (int)jq[1];
            int h = (int)jq[2];
            int mi = (int)jq[3];
            String name = (String)jq[4];

            if ((month > m) ||
                    (month == m && day > d) ||
                    (month == m && day == d && hour > h) ||
                    (month == m && day == d && hour == h && minute >= mi)) {
                currentJieQi = name;
            }
        }
        return currentJieQi;
    }

    /**
     * 获取2044年节气 - 与Python的2044年表一致
     */
    private String getJieQi2044(int month, int day, int hour, int minute) {
        // 2044年节气表
        Object[][] jieQi2044 = {
                {1, 6, 10, 27, "小寒"}, {1, 21, 3, 47, "大寒"},
                {2, 4, 22, 3, "立春"}, {2, 19, 17, 53, "雨水"},
                {3, 5, 15, 58, "惊蛰"}, {3, 20, 16, 48, "春分"},
                {4, 4, 20, 39, "清明"}, {4, 20, 3, 51, "谷雨"},
                {5, 5, 14, 8, "立夏"}, {5, 21, 3, 14, "小满"},
                {6, 5, 18, 26, "芒种"}, {6, 21, 11, 16, "夏至"},
                {7, 7, 4, 44, "小暑"}, {7, 22, 22, 5, "大暑"},
                {8, 7, 14, 23, "立秋"}, {8, 23, 4, 56, "处暑"},
                {9, 7, 17, 13, "白露"}, {9, 23, 2, 26, "秋分"},
                {10, 8, 8, 38, "寒露"}, {10, 23, 11, 43, "霜降"},
                {11, 7, 11, 54, "立冬"}, {11, 22, 9, 18, "小雪"},
                {12, 7, 4, 39, "大雪"}, {12, 22, 22, 17, "冬至"}
        };

        String currentJieQi = "冬至";
        for (Object[] jq : jieQi2044) {
            int m = (int)jq[0];
            int d = (int)jq[1];
            int h = (int)jq[2];
            int mi = (int)jq[3];
            String name = (String)jq[4];

            if ((month > m) ||
                    (month == m && day > d) ||
                    (month == m && day == d && hour > h) ||
                    (month == m && day == d && hour == h && minute >= mi)) {
                currentJieQi = name;
            }
        }
        return currentJieQi;
    }

    /**
     * 获取其他年份节气（近似）- 与Python的_get_jieqi_approximate一致
     */
    private String getJieQiApproximate(int year, int month, int day, int hour, int minute) {
        // 节气名称
        String[] jieQiNames = {
                "小寒", "大寒", "立春", "雨水", "惊蛰", "春分",
                "清明", "谷雨", "立夏", "小满", "芒种", "夏至",
                "小暑", "大暑", "立秋", "处暑", "白露", "秋分",
                "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"
        };

        // 基础节气日期
        int[][] jieQiDates = {
                {1, 5}, {1, 20}, {2, 4}, {2, 19}, {3, 5}, {3, 20},
                {4, 5}, {4, 20}, {5, 5}, {5, 21}, {6, 6}, {6, 21},
                {7, 7}, {7, 23}, {8, 7}, {8, 23}, {9, 7}, {9, 23},
                {10, 8}, {10, 23}, {11, 7}, {11, 22}, {12, 7}, {12, 21}
        };

        // 年份偏移
        int yearOffset = 0;
        if (year < 2000) yearOffset = -1;
        else if (year > 2020) yearOffset = 1;

        String currentJieQi = "冬至";

        for (int i = 0; i < jieQiNames.length; i++) {
            int m = jieQiDates[i][0];
            int d = jieQiDates[i][1] + yearOffset;

            if ((month > m) ||
                    (month == m && day > d) ||
                    (month == m && day == d && hour >= 12)) {
                currentJieQi = jieQiNames[i];
            }
        }

        return currentJieQi;
    }

    // ==================== 月干支计算 ====================
    public String[] getJieQiAndMonthGanZhi(int year, int month, int day, int hour, int minute) {
        // 1. 获取当前节气 - 直接调用统一的节气获取方法
        String currentJieQi = getJieQiByDate(year, month, day, hour, minute);

        Log.d(TAG, "节气: " + currentJieQi + " (年:" + year + " 月:" + month + " 日:" + day + " " + hour + ":" + minute + ")");

        // 2. 根据节气获取月支
        String monthZhi = jieQiToDiZhi.get(currentJieQi);
        if (monthZhi == null) {
            Log.e(TAG, "未知节气: " + currentJieQi + "，使用默认月支寅");
            monthZhi = "寅";
        }

        // 3. 获取年干（考虑立春分界）
        String yearGan = calculateYearGanZhi(year, month, day).substring(0, 1);

        // 4. 计算月干索引 - 与Python完全一致
        int diZhiIndex = -1;
        for (int i = 0; i < diZhi.length; i++) {
            if (diZhi[i].equals(monthZhi)) {
                diZhiIndex = i;
                break;
            }
        }

        // Python版：dizhi_index - 2
        int monthIndex = diZhiIndex - 2;
        if (monthIndex < 0) {
            monthIndex += 12;
        }

        String[] monthGanArray = monthGanMap.get(yearGan);
        String monthGan = monthGanArray[monthIndex];

        Log.d(TAG, "月支: " + monthZhi + " 索引:" + diZhiIndex + " 月干索引:" + monthIndex + " 年干:" + yearGan + " 月干:" + monthGan);

        return new String[]{currentJieQi, monthGan + monthZhi};
    }

    // ==================== 时干支计算 ====================
    /**
     * 计算时干支 - 与Python的calculate_hour_ganzhi一致
     */
    public String calculateHourGanZhi(String dayGan, int hour) {
        int hourIndex;
        if (hour >= 23 || hour < 1) hourIndex = 0;
        else if (hour < 3) hourIndex = 1;
        else if (hour < 5) hourIndex = 2;
        else if (hour < 7) hourIndex = 3;
        else if (hour < 9) hourIndex = 4;
        else if (hour < 11) hourIndex = 5;
        else if (hour < 13) hourIndex = 6;
        else if (hour < 15) hourIndex = 7;
        else if (hour < 17) hourIndex = 8;
        else if (hour < 19) hourIndex = 9;
        else if (hour < 21) hourIndex = 10;
        else hourIndex = 11;

        String[] hourGanArray = hourGanMap.get(dayGan);
        String[] hourDiZhiArray = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

        return hourGanArray[hourIndex] + hourDiZhiArray[hourIndex];
    }

    // ==================== 符头计算 ====================
    /**
     * 求符头 - 与Python的get_fu_tou_correct一致
     */
    public String getFuTouCorrect(String ganzhi) {
        String tianGan = ganzhi.substring(0, 1);
        String diZhi = ganzhi.substring(1);

        int tianIndex = -1;
        for (int i = 0; i < this.tianGan.length; i++) {
            if (this.tianGan[i].equals(tianGan)) {
                tianIndex = i + 1;
                break;
            }
        }

        int diIndex = -1;
        for (int i = 0; i < this.diZhi.length; i++) {
            if (this.diZhi[i].equals(diZhi)) {
                diIndex = i + 1;
                break;
            }
        }

        int result = diIndex - tianIndex;
        if (result < 0) result += 12;

        // 根据日干判断是六甲还是六己
        if (tianIndex <= 5) {
            Map<Integer, String> jiaMap = new HashMap<Integer, String>() {{
                put(0, "甲子"); put(10, "甲戌"); put(8, "甲申");
                put(6, "甲午"); put(4, "甲辰"); put(2, "甲寅");
            }};
            return jiaMap.get(result);
        } else {
            Map<Integer, String> jiMap = new HashMap<Integer, String>() {{
                put(0, "己巳"); put(10, "己卯"); put(8, "己丑");
                put(6, "己亥"); put(4, "己酉"); put(2, "己未");
            }};
            return jiMap.get(result);
        }
    }

    // ==================== 时旬计算 ====================
    /**
     * 求时旬 - 与Python的get_xun_shu_correct一致
     */
    public int[] getXunShuCorrect(String ganzhi) {
        String tianGan = ganzhi.substring(0, 1);
        String diZhi = ganzhi.substring(1);

        int tianIndex = -1;
        for (int i = 0; i < this.tianGan.length; i++) {
            if (this.tianGan[i].equals(tianGan)) {
                tianIndex = i + 1;
                break;
            }
        }

        int diIndex = -1;
        for (int i = 0; i < this.diZhi.length; i++) {
            if (this.diZhi[i].equals(diZhi)) {
                diIndex = i + 1;
                break;
            }
        }

        int result = diIndex - tianIndex;
        if (result < 0) result += 12;

        String xunShou = xunMap.get(result);
        int xunOrder = this.xunOrder.get(xunShou);

        return new int[]{xunOrder, xunOrder};
    }

    // ==================== 元计算 ====================
    /**
     * 获取元 - 与Python的get_yuan一致
     */
    public String getYuan(String fuTou) {
        String diZhi = fuTou.substring(1);
        if (diZhi.equals("子") || diZhi.equals("午") || diZhi.equals("卯") || diZhi.equals("酉")) {
            return "上元";
        } else if (diZhi.equals("寅") || diZhi.equals("申") || diZhi.equals("巳") || diZhi.equals("亥")) {
            return "中元";
        } else {
            return "下元";
        }
    }

    // ==================== 局数计算 ====================
    /**
     * 获取局数 - 与Python的get_ju_correct一致
     */
    public int[] getJuCorrect(String jieQi, String yuan) {
        JieQiInfo info = solarTerms.get(jieQi);
        if (info == null) info = new JieQiInfo(1, "阳");

        int baseJu = info.gong;
        String dun = info.dun;
        int ju;

        if (yuan.equals("上元")) {
            ju = baseJu;
        } else if (yuan.equals("中元")) {
            if (dun.equals("阳")) {
                ju = baseJu + 6;
            } else {
                ju = baseJu - 6;
            }
        } else {
            if (dun.equals("阳")) {
                ju = baseJu + 12;
            } else {
                ju = baseJu - 12;
            }
        }

        while (ju > 9) ju -= 9;
        while (ju < 1) ju += 9;

        return new int[]{ju, dun.equals("阳") ? 1 : 2};
    }

    // ==================== 地盘九干 ====================
    /**
     * 布地盘九干 - 与Python的arrange_dipan_jiugan一致
     */
    public Map<Integer, String> arrangeDiPanJiuGan(int ju, String dun) {
        String[] jiyiOrder = {"戊", "己", "庚", "辛", "壬", "癸", "丁", "丙", "乙"};
        Map<Integer, String> diPan = new HashMap<>();

        if (dun.equals("阳")) {
            int startGong = ju;
            for (int i = 0; i < jiyiOrder.length; i++) {
                int gong = startGong + i;
                if (gong > 9) gong -= 9;
                diPan.put(gong, jiyiOrder[i]);
            }
        } else {
            int startGong = ju;
            for (int i = 0; i < jiyiOrder.length; i++) {
                int gong = startGong - i;
                if (gong < 1) gong += 9;
                diPan.put(gong, jiyiOrder[i]);
            }
        }
        return diPan;
    }

    // ==================== 值符值使 ====================
    /**
     * 获取值符值使 - 与Python的get_zhifu_zhishi一致
     */
    public String[] getZhiFuZhiShi(Map<Integer, String> diPan, String xunGan) {
        if (xunGan == null || xunGan.length() < 1) {
            return new String[]{"天蓬", "休"};
        }

        String xunGanChar = xunGan.substring(xunGan.length() - 1);
        int xunGong = 1;

        for (Map.Entry<Integer, String> entry : diPan.entrySet()) {
            if (entry.getValue().equals(xunGanChar)) {
                xunGong = entry.getKey();
                break;
            }
        }

        // 宫位对应的星和门
        Map<Integer, String[]> gongToXingMen = new HashMap<Integer, String[]>() {{
            put(1, new String[]{"天蓬", "休"});
            put(2, new String[]{"天芮", "死"});
            put(3, new String[]{"天冲", "伤"});
            put(4, new String[]{"天辅", "杜"});
            put(5, new String[]{"天禽", "中"});
            put(6, new String[]{"天心", "开"});
            put(7, new String[]{"天柱", "惊"});
            put(8, new String[]{"天任", "生"});
            put(9, new String[]{"天英", "景"});
        }};

        return gongToXingMen.get(xunGong);
    }

    // ==================== 值符落宫 ====================
    /**
     * 获取值符落宫 - 与Python的get_zhifu_luogong一致
     */
    public int getZhiFuLuoGong(Map<Integer, String> diPan, String shiGan) {
        String jiuGan = tianGanToJiuGan.get(shiGan);
        for (Map.Entry<Integer, String> entry : diPan.entrySet()) {
            if (entry.getValue().equals(jiuGan)) {
                return entry.getKey();
            }
        }
        return 1;
    }

    // ==================== 天盘九星 ====================
    /**
     * 布天盘九星 - 与Python的arrange_tianpan_xing一致
     */
    public Map<Integer, String> arrangeTianPanXing(String zhiFuXing, int zhiFuLuoGong, String dun) {
        Map<Integer, String> tianPanXing = new HashMap<>();
        tianPanXing.put(5, "天禽");

        // 处理值符落中5宫的情况
        int actualStartGong = zhiFuLuoGong;
        if (zhiFuLuoGong == 5) {
            actualStartGong = 2;
        }

        // 确定实际值符星
        String actualZhiFu = zhiFuXing;
        if (zhiFuXing.equals("天禽")) {
            actualZhiFu = "天芮";
        }

        // 找到值符星在顺序中的位置
        int zhiFuIndex = -1;
        for (int i = 0; i < xingOrder.length; i++) {
            if (xingOrder[i].equals(actualZhiFu)) {
                zhiFuIndex = i;
                break;
            }
        }
        if (zhiFuIndex == -1) zhiFuIndex = 0;

        // 找到起始宫在洛书顺序中的位置
        int startIndex = -1;
        for (int i = 0; i < luoshuClockwise.length; i++) {
            if (luoshuClockwise[i] == actualStartGong) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) startIndex = 0;

        // 从起始宫开始，按顺时针填入八星
        for (int i = 0; i < 8; i++) {
            int xingIdx = (zhiFuIndex + i) % 8;
            String xingName = xingOrder[xingIdx];
            int gong = luoshuClockwise[(startIndex + i) % 8];
            tianPanXing.put(gong, xingName);
        }

        return tianPanXing;
    }

    // ==================== 天盘九干 ====================
    /**
     * 布天盘九干 - 使用星移宫动法 - 与Python的arrange_tianpan_jiugan一致
     */
    public Map<Integer, String> arrangeTianPanJiuGan(Map<Integer, String> diPan, Map<Integer, String> tianPanXing) {
        Map<Integer, String> tianPanJiuGan = new HashMap<>();

        for (Map.Entry<Integer, String> entry : tianPanXing.entrySet()) {
            int gong = entry.getKey();
            String xingName = entry.getValue();
            int benWeiGong = xingBenWei.get(xingName);
            tianPanJiuGan.put(gong, diPan.get(benWeiGong));
        }

        if (!tianPanJiuGan.containsKey(5)) {
            tianPanJiuGan.put(5, diPan.get(5));
        }

        return tianPanJiuGan;
    }

    // ==================== 值使落宫 ====================
    /**
     * 计算直使落宫 - 速算法 - 与Python的get_zhishi_luogong_simple一致
     */
    public int getZhiShiLuoGongSimple(String zhiShiMen, String hourGan, String dun) {
        int shiXu = shiGanXuHao.get(hourGan);
        int zhiXu = baMenNum.get(zhiShiMen);

        int result;
        if (dun.equals("阳")) {
            result = zhiXu + shiXu - 1;
            while (result > 9) result -= 9;
            while (result < 1) result += 9;
        } else {
            result = zhiXu - shiXu + 1;
            while (result < 1) result += 9;
            while (result > 9) result -= 9;
        }

        return result;
    }

    // ==================== 八门 ====================
    /**
     * 布八门 - 与Python的arrange_men一致
     */
    public Map<Integer, String> arrangeMen(String zhiShiMen, int zhiShiLuoGong, String dun) {
        Map<Integer, String> baMen = new HashMap<>();
        baMen.put(5, "中");

        // 处理直使门为"中"的情况
        String actualZhiShiMen = zhiShiMen;
        int actualZhiShiLuoGong = zhiShiLuoGong;

        if (zhiShiMen.equals("中")) {
            actualZhiShiMen = "死";
        }

        int zhiShiNum = baMenNum.get(actualZhiShiMen);

        // 找到直使门在八门顺序中的位置
        int zhiShiIndex = -1;
        for (int i = 0; i < luoshuClockwise.length; i++) {
            if (luoshuClockwise[i] == zhiShiNum) {
                zhiShiIndex = i;
                break;
            }
        }
        if (zhiShiIndex == -1) zhiShiIndex = 0;

        // 处理直使落宫
        int startGong = actualZhiShiLuoGong;
        if (actualZhiShiLuoGong == 5) {
            startGong = 2;
        }

        int startIndex = -1;
        for (int i = 0; i < luoshuClockwise.length; i++) {
            if (luoshuClockwise[i] == startGong) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) startIndex = 0;

        // 从直使落宫开始，顺时针填入八门
        for (int i = 0; i < 8; i++) {
            int menIdx = (zhiShiIndex + i) % 8;
            int menNum = luoshuClockwise[menIdx];
            String menName = numToBaMen.get(menNum);
            int gong = luoshuClockwise[(startIndex + i) % 8];
            if (gong != 5) {
                baMen.put(gong, menName);
            }
        }

        return baMen;
    }

    // ==================== 八神 ====================
    /**
     * 布八神 - 与Python的arrange_bashen一致
     */
    public Map<Integer, String> arrangeBaShen(int zhiFuLuoGong, String dun) {
        Map<Integer, String> baShen = new HashMap<>();
        baShen.put(5, "明王");

        // 处理值符落中5宫的情况
        int actualStartGong = zhiFuLuoGong;
        if (zhiFuLuoGong == 5) {
            actualStartGong = 2;
        }

        // 根据阴阳遁选择顺序
        int[] luoshuOrder = dun.equals("阳") ? luoshuClockwise : luoshuCounter;

        int startIndex = -1;
        for (int i = 0; i < luoshuOrder.length; i++) {
            if (luoshuOrder[i] == actualStartGong) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) startIndex = 0;

        for (int i = 0; i < 8; i++) {
            int shenNum = bashenOrder[i % 8];
            String shenName = numToBaShen.get(shenNum);
            int gong = luoshuOrder[(startIndex + i) % 8];
            if (gong != 5) {
                baShen.put(gong, shenName);
            }
        }

        return baShen;
    }

    // ==================== 数字盘 ====================
    /**
     * 生成数字盘 - 与Python的generate_digital_numbers一致
     */
    public String[] generateDigitalNumbers(QiMenData data) {
        Map<Integer, String> diPan = data.getDiPan();
        Map<Integer, String> tianPanJiuGan = data.getTianPanJiuGan();
        Map<Integer, String> tianPanXing = data.getTianPanXing();
        Map<Integer, String> baMen = data.getBaMen();
        Map<Integer, String> baShen = data.getBaShen();

        String[] numbers = new String[9];

        for (int i = 0; i < displayOrder.length; i++) {
            int gong = displayOrder[i];

            int shiWan = gong;
            int wan = jiuGanNum.get(diPan.get(gong));

            int qian;
            if (tianPanXing.containsKey(gong)) {
                qian = jiuXingNum.get(tianPanXing.get(gong));
            } else {
                qian = 5;
            }

            int bai = jiuGanNum.get(tianPanJiuGan.get(gong));

            int shi;
            if (gong == 5) {
                shi = 5;
            } else if (baMen.containsKey(gong)) {
                String menName = baMen.get(gong);
                if (menName.equals("中")) {
                    shi = 5;
                } else {
                    shi = baMenNum.get(menName);
                }
            } else {
                shi = 5;
            }

            int ge;
            if (gong == 5) {
                ge = 5;
            } else if (baShen.containsKey(gong)) {
                ge = baShenNum.get(baShen.get(gong));
            } else {
                ge = 5;
            }

            numbers[i] = String.format("%d%d%d%d%d%d", shiWan, wan, qian, bai, shi, ge);
        }

        return numbers;
    }

    // ==================== 主计算函数 ====================
    /**
     * 主计算函数 - 与Python的calculate一致
     */
    public QiMenData calculate(int year, int month, int day, int hour, int minute) {
        QiMenData data = new QiMenData();

        data.setYear(year);
        data.setMonth(month);
        data.setDay(day);
        data.setHour(hour);
        data.setMinute(minute);

        // 1. 计算年干支（考虑立春分界）
        String yearGanZhi = calculateYearGanZhi(year, month, day);
        data.setYearGanZhi(yearGanZhi);
        Log.d(TAG, "年干支: " + yearGanZhi);

        // 2. 计算节气和月干支
        String[] jieQiResult = getJieQiAndMonthGanZhi(year, month, day, hour, minute);
        String jieQi = jieQiResult[0];
        String monthGanZhi = jieQiResult[1];
        data.setJieQi(jieQi);
        data.setMonthGanZhi(monthGanZhi);
        Log.d(TAG, "节气: " + jieQi + ", 月干支: " + monthGanZhi);

        // 3. 计算日干支（使用2026年3月7日庚辰日为基准）
        String dayGanZhi = calculateDayGanZhiPrecise(year, month, day);
        data.setDayGanZhi(dayGanZhi);
        Log.d(TAG, "日干支: " + dayGanZhi);

        // 4. 计算时干支
        String dayGan = dayGanZhi.substring(0, 1);
        String hourGanZhi = calculateHourGanZhi(dayGan, hour);
        data.setHourGanZhi(hourGanZhi);
        Log.d(TAG, "时干支: " + hourGanZhi);

        // 5. 计算符头
        String fuTou = getFuTouCorrect(dayGanZhi);
        data.setFuTou(fuTou);
        Log.d(TAG, "符头: " + fuTou);

        // 6. 计算时旬
        int[] xunResult = getXunShuCorrect(hourGanZhi);
        int xunOrder = xunResult[0];

        String xunGan = "";
        switch (xunOrder) {
            case 1: xunGan = "甲子戊"; break;
            case 2: xunGan = "甲戌己"; break;
            case 3: xunGan = "甲申庚"; break;
            case 4: xunGan = "甲午辛"; break;
            case 5: xunGan = "甲辰壬"; break;
            case 6: xunGan = "甲寅癸"; break;
            default: xunGan = "甲子戊"; break;
        }
        data.setXunGan(xunGan);
        Log.d(TAG, "旬首: " + xunGan + ", 旬序: " + xunOrder);

        // 7. 计算元
        String yuan = getYuan(fuTou);
        data.setYuan(yuan);
        Log.d(TAG, "元: " + yuan);

        // 8. 计算局数
        int[] juResult = getJuCorrect(jieQi, yuan);
        int ju = juResult[0];
        String dun = juResult[1] == 1 ? "阳" : "阴";
        data.setJu(ju);
        data.setDun(dun);
        Log.d(TAG, "局数: " + ju + ", 遁: " + dun);

        // 9. 布地盘九干
        Map<Integer, String> diPan = arrangeDiPanJiuGan(ju, dun);
        data.setDiPan(diPan);
        Log.d(TAG, "地盘: " + diPan.toString());

        // 10. 获取值符值使
        String[] zhiFuZhiShi = getZhiFuZhiShi(diPan, xunGan);
        String zhiFuXing = zhiFuZhiShi[0];
        String zhiShiMen = zhiFuZhiShi[1];
        data.setZhiFuXing(zhiFuXing);
        data.setZhiShiMen(zhiShiMen);
        Log.d(TAG, "值符: " + zhiFuXing + ", 值使: " + zhiShiMen);

        // 11. 获取值符落宫
        String hourGan = hourGanZhi.substring(0, 1);
        String actualHourGan = hourGan.equals("甲") ? xunGan.substring(2) : hourGan;
        int zhiFuLuoGong = getZhiFuLuoGong(diPan, actualHourGan);
        data.setZhiFuLuoGong(zhiFuLuoGong);
        Log.d(TAG, "值符落宫: " + zhiFuLuoGong);

        // 12. 布天盘九星
        Map<Integer, String> tianPanXing = arrangeTianPanXing(zhiFuXing, zhiFuLuoGong, dun);
        data.setTianPanXing(tianPanXing);
        Log.d(TAG, "天盘星: " + tianPanXing.toString());

        // 13. 布天盘九干
        Map<Integer, String> tianPanJiuGan = arrangeTianPanJiuGan(diPan, tianPanXing);
        data.setTianPanJiuGan(tianPanJiuGan);
        Log.d(TAG, "天盘干: " + tianPanJiuGan.toString());

        // 14. 获取值使落宫
        int zhiShiLuoGong = getZhiShiLuoGongSimple(zhiShiMen, hourGan, dun);
        data.setZhiShiLuoGong(zhiShiLuoGong);
        Log.d(TAG, "值使落宫: " + zhiShiLuoGong);

        // 15. 布八门
        Map<Integer, String> baMen = arrangeMen(zhiShiMen, zhiShiLuoGong, dun);
        data.setBaMen(baMen);
        Log.d(TAG, "八门: " + baMen.toString());

        // 16. 布八神
        Map<Integer, String> baShen = arrangeBaShen(zhiFuLuoGong, dun);
        data.setBaShen(baShen);
        Log.d(TAG, "八神: " + baShen.toString());

        // 17. 生成数字盘
        String[] digitalNumbers = generateDigitalNumbers(data);
        data.setDigitalNumbers(digitalNumbers);
        Log.d(TAG, "数字盘: " + Arrays.toString(digitalNumbers));

        return data;
    }
}