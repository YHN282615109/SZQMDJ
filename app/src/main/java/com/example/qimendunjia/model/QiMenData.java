package com.example.qimendunjia.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;      // 添加这个导入
import java.util.ArrayList; // 添加这个导入

public class QiMenData {
    // 输入时间
    private int year, month, day, hour, minute;

    // 四柱
    private String yearGanZhi, monthGanZhi, dayGanZhi, hourGanZhi;

    // 节气局数
    private String jieQi, dun, yuan;
    private int ju;

    // 符头旬首
    private String fuTou, xunGan;

    // 值符值使
    private String zhiFuXing, zhiShiMen;
    private int zhiFuLuoGong, zhiShiLuoGong;

    // 九宫数据
    private Map<Integer, String> diPan = new HashMap<>();
    private Map<Integer, String> tianPanJiuGan = new HashMap<>();
    private Map<Integer, String> tianPanXing = new HashMap<>();
    private Map<Integer, String> baMen = new HashMap<>();
    private Map<Integer, String> baShen = new HashMap<>();

    // 数字盘
    private String[] digitalNumbers = new String[9];
    private String[] gongNames = {"巽4", "离9", "坤2", "震3", "中5", "兑7", "艮8", "坎1", "乾6"};

    // 映射表
    private Map<String, Integer> jiuGanNum = new HashMap<>();
    private Map<String, Integer> jiuXingNum = new HashMap<>();
    private Map<String, Integer> baMenNum = new HashMap<>();
    private Map<String, Integer> baShenNum = new HashMap<>();
    private Map<Integer, String> numToJiuGong = new HashMap<>();

    // === 新增字段：用于存储析盘和断局结果 ===
    private String analysisResult;      // 存储析盘内容
    private String interpretationResult; // 存储断局结果
    private Map<Integer, String> gongAnalysis = new HashMap<>(); // 存储详细的宫位分析结果

    // === 增强版分析器所需字段 ===
    // 用神相关
    private String yongShen; // 用神
    private String yongShenGong; // 用神落宫
    private Map<String, String> yongShenMap = new HashMap<>(); // 用神映射

    // 吉凶格
    private List<String> jiGeList = new ArrayList<>(); // 吉格列表
    private List<String> xiongGeList = new ArrayList<>(); // 凶格列表

    // 十二长生状态
    private Map<Integer, String> shiErZhangSheng = new HashMap<>(); // 各宫十二长生状态

    // 旺相休囚死
    private Map<Integer, String> wangXiangStatus = new HashMap<>(); // 各宫旺相休囚死状态

    // 空亡
    private List<Integer> kongWangGong = new ArrayList<>(); // 空亡之宫
    private String kongWang; // 空亡字符串

    // 马星
    private int maXingGong; // 马星所在宫
    private String maXing; // 马星

    // 入墓
    private List<String> ruMuList = new ArrayList<>(); // 入墓列表

    // 击刑
    private List<String> jiXingList = new ArrayList<>(); // 击刑列表

    // 旬首
    private String xunShou; // 旬首
    private int xunShouGong; // 旬首所在宫

    // 值符值使旬首
    private String xunShouGan; // 旬首干
    private String xunShouZhi; // 旬首支

    // 九星旺衰
    private Map<String, String> xingWangShuai = new HashMap<>(); // 九星旺衰

    // 八门旺衰
    private Map<String, String> menWangShuai = new HashMap<>(); // 八门旺衰

    // 三奇状态
    private boolean youQi; // 是否有三奇
    private List<String> sanQiList = new ArrayList<>(); // 三奇列表

    // 遁格
    private List<String> dunGeList = new ArrayList<>(); // 遁格列表（天遁、地遁、人遁等）

    // 诈格
    private List<String> zhaGeList = new ArrayList<>(); // 诈格列表（真诈、重诈、休诈等）

    // 假格
    private List<String> jiaGeList = new ArrayList<>(); // 假格列表（天假、地假、人假等）

    // 生克关系
    private Map<String, String> shengKeRelation = new HashMap<>(); // 生克关系

    public QiMenData() {
        initMaps();
        initLists(); // 初始化所有List字段
    }

    private void initMaps() {
        // 九干对应数
        jiuGanNum.put("戊", 1); jiuGanNum.put("己", 2); jiuGanNum.put("庚", 3);
        jiuGanNum.put("辛", 4); jiuGanNum.put("壬", 5); jiuGanNum.put("癸", 6);
        jiuGanNum.put("丁", 7); jiuGanNum.put("丙", 8); jiuGanNum.put("乙", 9);

        // 九星对应数
        jiuXingNum.put("天蓬", 1); jiuXingNum.put("天芮", 2); jiuXingNum.put("天冲", 3);
        jiuXingNum.put("天辅", 4); jiuXingNum.put("天禽", 5); jiuXingNum.put("天心", 6);
        jiuXingNum.put("天柱", 7); jiuXingNum.put("天任", 8); jiuXingNum.put("天英", 9);

        // 八门对应数
        baMenNum.put("休", 1); baMenNum.put("死", 2); baMenNum.put("伤", 3);
        baMenNum.put("杜", 4); baMenNum.put("中", 5); baMenNum.put("开", 6);
        baMenNum.put("惊", 7); baMenNum.put("生", 8); baMenNum.put("景", 9);

        // 八神对应数
        baShenNum.put("值符", 1); baShenNum.put("腾蛇", 8); baShenNum.put("太阴", 3);
        baShenNum.put("六合", 4); baShenNum.put("明王", 5); baShenNum.put("白虎", 9);
        baShenNum.put("玄武", 2); baShenNum.put("九地", 7); baShenNum.put("九天", 6);

        // 数字转九宫
        numToJiuGong.put(1, "坎"); numToJiuGong.put(2, "坤"); numToJiuGong.put(3, "震");
        numToJiuGong.put(4, "巽"); numToJiuGong.put(5, "中"); numToJiuGong.put(6, "乾");
        numToJiuGong.put(7, "兑"); numToJiuGong.put(8, "艮"); numToJiuGong.put(9, "离");
    }

    private void initLists() {
        jiGeList = new ArrayList<>();
        xiongGeList = new ArrayList<>();
        kongWangGong = new ArrayList<>();
        ruMuList = new ArrayList<>();
        jiXingList = new ArrayList<>();
        sanQiList = new ArrayList<>();
        dunGeList = new ArrayList<>();
        zhaGeList = new ArrayList<>();
        jiaGeList = new ArrayList<>();

        shiErZhangSheng = new HashMap<>();
        wangXiangStatus = new HashMap<>();
        xingWangShuai = new HashMap<>();
        menWangShuai = new HashMap<>();
        shengKeRelation = new HashMap<>();
        yongShenMap = new HashMap<>();
    }

    // ==================== 原有的 Getters and Setters ====================
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }

    public String getYearGanZhi() { return yearGanZhi; }
    public void setYearGanZhi(String yearGanZhi) { this.yearGanZhi = yearGanZhi; }

    public String getMonthGanZhi() { return monthGanZhi; }
    public void setMonthGanZhi(String monthGanZhi) { this.monthGanZhi = monthGanZhi; }

    public String getDayGanZhi() { return dayGanZhi; }
    public void setDayGanZhi(String dayGanZhi) { this.dayGanZhi = dayGanZhi; }

    public String getHourGanZhi() { return hourGanZhi; }
    public void setHourGanZhi(String hourGanZhi) { this.hourGanZhi = hourGanZhi; }

    public String getJieQi() { return jieQi; }
    public void setJieQi(String jieQi) { this.jieQi = jieQi; }

    public String getDun() { return dun; }
    public void setDun(String dun) { this.dun = dun; }

    public String getYuan() { return yuan; }
    public void setYuan(String yuan) { this.yuan = yuan; }

    public int getJu() { return ju; }
    public void setJu(int ju) { this.ju = ju; }

    public String getFuTou() { return fuTou; }
    public void setFuTou(String fuTou) { this.fuTou = fuTou; }

    public String getXunGan() { return xunGan; }
    public void setXunGan(String xunGan) { this.xunGan = xunGan; }

    public String getZhiFuXing() { return zhiFuXing; }
    public void setZhiFuXing(String zhiFuXing) { this.zhiFuXing = zhiFuXing; }

    public String getZhiShiMen() { return zhiShiMen; }
    public void setZhiShiMen(String zhiShiMen) { this.zhiShiMen = zhiShiMen; }

    public int getZhiFuLuoGong() { return zhiFuLuoGong; }
    public void setZhiFuLuoGong(int zhiFuLuoGong) { this.zhiFuLuoGong = zhiFuLuoGong; }

    public int getZhiShiLuoGong() { return zhiShiLuoGong; }
    public void setZhiShiLuoGong(int zhiShiLuoGong) { this.zhiShiLuoGong = zhiShiLuoGong; }

    public Map<Integer, String> getDiPan() { return diPan; }
    public void setDiPan(Map<Integer, String> diPan) { this.diPan = diPan; }

    public Map<Integer, String> getTianPanJiuGan() { return tianPanJiuGan; }
    public void setTianPanJiuGan(Map<Integer, String> tianPanJiuGan) { this.tianPanJiuGan = tianPanJiuGan; }

    public Map<Integer, String> getTianPanXing() { return tianPanXing; }
    public void setTianPanXing(Map<Integer, String> tianPanXing) { this.tianPanXing = tianPanXing; }

    public Map<Integer, String> getBaMen() { return baMen; }
    public void setBaMen(Map<Integer, String> baMen) { this.baMen = baMen; }

    public Map<Integer, String> getBaShen() { return baShen; }
    public void setBaShen(Map<Integer, String> baShen) { this.baShen = baShen; }

    public String[] getDigitalNumbers() { return digitalNumbers; }
    public void setDigitalNumbers(String[] digitalNumbers) { this.digitalNumbers = digitalNumbers; }

    public String[] getGongNames() { return gongNames; }

    public Map<String, Integer> getJiuGanNum() { return jiuGanNum; }
    public Map<String, Integer> getJiuXingNum() { return jiuXingNum; }
    public Map<String, Integer> getBaMenNum() { return baMenNum; }
    public Map<String, Integer> getBaShenNum() { return baShenNum; }
    public String getNumToJiuGong(int num) { return numToJiuGong.get(num); }

    // ==================== 新增字段的getter/setter ====================
    public String getAnalysisResult() {
        return analysisResult;
    }

    public void setAnalysisResult(String analysisResult) {
        this.analysisResult = analysisResult;
    }

    public String getInterpretationResult() {
        return interpretationResult;
    }

    public void setInterpretationResult(String interpretationResult) {
        this.interpretationResult = interpretationResult;
    }

    public Map<Integer, String> getGongAnalysis() {
        return gongAnalysis;
    }

    public void setGongAnalysis(Map<Integer, String> gongAnalysis) {
        this.gongAnalysis = gongAnalysis;
    }

    // ==================== 增强版分析器字段的getter/setter ====================
    public String getYongShen() { return yongShen; }
    public void setYongShen(String yongShen) { this.yongShen = yongShen; }

    public String getYongShenGong() { return yongShenGong; }
    public void setYongShenGong(String yongShenGong) { this.yongShenGong = yongShenGong; }

    public Map<String, String> getYongShenMap() { return yongShenMap; }
    public void setYongShenMap(Map<String, String> yongShenMap) { this.yongShenMap = yongShenMap; }

    public List<String> getJiGeList() { return jiGeList; }
    public void setJiGeList(List<String> jiGeList) { this.jiGeList = jiGeList; }

    public List<String> getXiongGeList() { return xiongGeList; }
    public void setXiongGeList(List<String> xiongGeList) { this.xiongGeList = xiongGeList; }

    public Map<Integer, String> getShiErZhangSheng() { return shiErZhangSheng; }
    public void setShiErZhangSheng(Map<Integer, String> shiErZhangSheng) { this.shiErZhangSheng = shiErZhangSheng; }

    public Map<Integer, String> getWangXiangStatus() { return wangXiangStatus; }
    public void setWangXiangStatus(Map<Integer, String> wangXiangStatus) { this.wangXiangStatus = wangXiangStatus; }

    public List<Integer> getKongWangGong() { return kongWangGong; }
    public void setKongWangGong(List<Integer> kongWangGong) { this.kongWangGong = kongWangGong; }

    public String getKongWang() { return kongWang; }
    public void setKongWang(String kongWang) { this.kongWang = kongWang; }

    public int getMaXingGong() { return maXingGong; }
    public void setMaXingGong(int maXingGong) { this.maXingGong = maXingGong; }

    public String getMaXing() { return maXing; }
    public void setMaXing(String maXing) { this.maXing = maXing; }

    public List<String> getRuMuList() { return ruMuList; }
    public void setRuMuList(List<String> ruMuList) { this.ruMuList = ruMuList; }

    public List<String> getJiXingList() { return jiXingList; }
    public void setJiXingList(List<String> jiXingList) { this.jiXingList = jiXingList; }

    public String getXunShou() { return xunShou; }
    public void setXunShou(String xunShou) { this.xunShou = xunShou; }

    public int getXunShouGong() { return xunShouGong; }
    public void setXunShouGong(int xunShouGong) { this.xunShouGong = xunShouGong; }

    public String getXunShouGan() { return xunShouGan; }
    public void setXunShouGan(String xunShouGan) { this.xunShouGan = xunShouGan; }

    public String getXunShouZhi() { return xunShouZhi; }
    public void setXunShouZhi(String xunShouZhi) { this.xunShouZhi = xunShouZhi; }

    public Map<String, String> getXingWangShuai() { return xingWangShuai; }
    public void setXingWangShuai(Map<String, String> xingWangShuai) { this.xingWangShuai = xingWangShuai; }

    public Map<String, String> getMenWangShuai() { return menWangShuai; }
    public void setMenWangShuai(Map<String, String> menWangShuai) { this.menWangShuai = menWangShuai; }

    public boolean isYouQi() { return youQi; }
    public void setYouQi(boolean youQi) { this.youQi = youQi; }

    public List<String> getSanQiList() { return sanQiList; }
    public void setSanQiList(List<String> sanQiList) { this.sanQiList = sanQiList; }

    public List<String> getDunGeList() { return dunGeList; }
    public void setDunGeList(List<String> dunGeList) { this.dunGeList = dunGeList; }

    public List<String> getZhaGeList() { return zhaGeList; }
    public void setZhaGeList(List<String> zhaGeList) { this.zhaGeList = zhaGeList; }

    public List<String> getJiaGeList() { return jiaGeList; }
    public void setJiaGeList(List<String> jiaGeList) { this.jiaGeList = jiaGeList; }

    public Map<String, String> getShengKeRelation() { return shengKeRelation; }
    public void setShengKeRelation(Map<String, String> shengKeRelation) { this.shengKeRelation = shengKeRelation; }
}