package com.example.qimendunjia;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimendunjia.adapter.GridAdapter;
import com.example.qimendunjia.model.QiMenData;
import com.example.qimendunjia.utils.QiMenCalculator;
import com.example.qimendunjia.utils.QiMenAnalyzer;
import com.example.qimendunjia.utils.QiMenAnalyzerEnhanced; // 添加增强版分析器的导入
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etYear, etMonth, etDay, etHour, etMinute;
    private MaterialButton btnCalculate, btnCopy;
    private TextView tvResult;
    private TextView tvAnalysis;  // 用于单独显示分析结果的TextView
    private RecyclerView recyclerView;
    private NestedScrollView scrollView;
    private GridAdapter gridAdapter;
    private QiMenData currentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setCurrentDateTime(); // 设置当前时间
        setupListeners();
    }

    private void initViews() {
        etYear = findViewById(R.id.etYear);
        etMonth = findViewById(R.id.etMonth);
        etDay = findViewById(R.id.etDay);
        etHour = findViewById(R.id.etHour);
        etMinute = findViewById(R.id.etMinute);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCopy = findViewById(R.id.btnCopy);
        tvResult = findViewById(R.id.tvResult);
        recyclerView = findViewById(R.id.recyclerView);
        scrollView = findViewById(R.id.scrollView);

        // 初始化分析结果TextView - 如果XML中有这个控件
        try {
            tvAnalysis = findViewById(R.id.tvAnalysis);
        } catch (Exception e) {
            tvAnalysis = null; // 如果XML中没有，设置为null
        }

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void setCurrentDateTime() {
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();

        // 设置年
        int year = calendar.get(Calendar.YEAR);
        etYear.setText(String.valueOf(year));

        // 设置月 (Calendar.MONTH 从0开始，所以要+1)
        int month = calendar.get(Calendar.MONTH) + 1;
        etMonth.setText(String.format("%02d", month));

        // 设置日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        etDay.setText(String.format("%02d", day));

        // 设置时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        etHour.setText(String.format("%02d", hour));

        // 设置分
        int minute = calendar.get(Calendar.MINUTE);
        etMinute.setText(String.format("%02d", minute));
    }

    private void setupListeners() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyToClipboard();
            }
        });
    }

    private void calculate() {
        try {
            // 获取输入的年月日时分
            int year = Integer.parseInt(etYear.getText().toString());
            int month = Integer.parseInt(etMonth.getText().toString());
            int day = Integer.parseInt(etDay.getText().toString());
            int hour = Integer.parseInt(etHour.getText().toString());
            int minute = Integer.parseInt(etMinute.getText().toString());

            // 验证输入
            if (year < 1900 || year > 2100) {
                Toast.makeText(this, "年份超出支持范围（1900-2100年）", Toast.LENGTH_SHORT).show();
                return;
            }

            if (month < 1 || month > 12) {
                Toast.makeText(this, "月份必须在1-12之间", Toast.LENGTH_SHORT).show();
                return;
            }

            if (day < 1 || day > 31) {
                Toast.makeText(this, "日期必须在1-31之间", Toast.LENGTH_SHORT).show();
                return;
            }

            if (hour < 0 || hour > 23) {
                Toast.makeText(this, "小时必须在0-23之间", Toast.LENGTH_SHORT).show();
                return;
            }

            if (minute < 0 || minute > 59) {
                Toast.makeText(this, "分钟必须在0-59之间", Toast.LENGTH_SHORT).show();
                return;
            }

//            // 执行计算
//            QiMenCalculator calculator = new QiMenCalculator();
//            currentResult = calculator.calculate(year, month, day, hour, minute);

            // 在 calculate() 方法中，找到以下代码段
// 执行计算
            QiMenCalculator calculator = new QiMenCalculator();
            currentResult = calculator.calculate(year, month, day, hour, minute);




            displayResult(currentResult);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "请输入有效的数字", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "计算错误: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void displayResult(QiMenData data) {
        // 显示九宫格数字
        gridAdapter = new GridAdapter(data.getDigitalNumbers(), data.getGongNames());
        recyclerView.setAdapter(gridAdapter);

        // 构建详细结果文本
        StringBuilder result = new StringBuilder();

        result.append("");
        result.append(String.format("公历时间: %d年%d月%d日 %02d:%02d\n",
                data.getYear(), data.getMonth(), data.getDay(), data.getHour(), data.getMinute()));
        result.append("排盘工具：数字奇门遁甲排盘系统 v1.0 - 时家奇门-转盘-拆补法\n");
        result.append(String.format("四柱八字: %s年 %s月 %s日 %s时\n",
                data.getYearGanZhi(), data.getMonthGanZhi(), data.getDayGanZhi(), data.getHourGanZhi()));
        result.append(String.format("节气: %s%s %s遁%d局\n",
                data.getJieQi(), data.getYuan(), data.getDun(), data.getJu()));
        result.append(String.format("符头: %s 旬首: %s\n", data.getFuTou(), data.getXunGan()));
        result.append(String.format("直符: %s加%s%d宫\n",
                data.getZhiFuXing(), data.getNumToJiuGong(data.getZhiFuLuoGong()), data.getZhiFuLuoGong()));
        result.append(String.format("直使: %s门加%s%d宫\n\n",
                data.getZhiShiMen(), data.getNumToJiuGong(data.getZhiShiLuoGong()), data.getZhiShiLuoGong()));

        result.append(String.format("%s遁%d局 九六心盘<九六灵图> (%s日%s时)\n",
                data.getDun(), data.getJu(), data.getDayGanZhi().substring(0, 1),
                data.getHourGanZhi().substring(0, 1)));
        result.append(data.getXunGan() + "为旬首。\n");
        result.append(String.format("直符：%s星加%s%d宫。\n",
                data.getZhiFuXing(), data.getNumToJiuGong(data.getZhiFuLuoGong()), data.getZhiFuLuoGong()));
        result.append(String.format("直使：%s门加%s%d宫。\n\n",
                data.getZhiShiMen(), data.getNumToJiuGong(data.getZhiShiLuoGong()), data.getZhiShiLuoGong()));

        // 添加九宫格数字显示
        String[] numbers = data.getDigitalNumbers();
        result.append(String.format("[ %s , %s , %s ]\n", numbers[0], numbers[1], numbers[2]));
        result.append(String.format("[ %s , %s , %s ]\n", numbers[3], numbers[4], numbers[5]));
        result.append(String.format("[ %s , %s , %s ]\n\n", numbers[6], numbers[7], numbers[8]));

        result.append("=".repeat(60) + "\n\n");
        result.append("【详细排盘信息】\n");
        result.append("-".repeat(40) + "\n");

        // 详细九宫信息
        for (int gong = 1; gong <= 9; gong++) {
            String gongName = data.getNumToJiuGong(gong);
            result.append(String.format("%s%d宫: ", gongName, gong));
            result.append(String.format("地盘%s | 天盘%s | ",
                    data.getDiPan().get(gong), data.getTianPanJiuGan().get(gong)));

            if (data.getTianPanXing().containsKey(gong)) {
                result.append(String.format("星%s | ", data.getTianPanXing().get(gong)));
            } else {
                result.append("星天禽 | ");
            }

            if (data.getBaMen().containsKey(gong)) {
                result.append(String.format("门%s | ", data.getBaMen().get(gong)));
            } else {
                result.append("门中 | ");
            }

            if (data.getBaShen().containsKey(gong)) {
                result.append(String.format("神%s\n", data.getBaShen().get(gong)));
            } else {
                result.append("神-\n");
            }
        }

        result.append("\n" + "=".repeat(60) + "\n\n");

        // 添加数字盘说明
        result.append("【数字盘说明】\n");
        result.append("六位数字含义: (十万位-万位-千位-百位-十位-个位)\n");
        result.append("十万位: 地盘九宫 (1坎,2坤,3震,4巽,5中,6乾,7兑,8艮,9离)\n");
        result.append("万位: 地盘九干 (1戊,2己,3庚,4辛,5壬,6癸,7丁,8丙,9乙)\n");
        result.append("千位: 天盘九星 (1蓬,2芮,3冲,4辅,5禽,6心,7柱,8任,9英)\n");
        result.append("百位: 天盘九干 (1戊,2己,3庚,4辛,5壬,6癸,7丁,8丙,9乙)\n");
        result.append("十位: 人盘九门 (1休,2死,3伤,4杜,5中,6开,7惊,8生,9景)\n");
        result.append("个位: 神盘九神 (1值符,8腾蛇,3太阴,4六合,5明王,9白虎,2玄武,7九地,6九天)\n\n");

        String[] gongNames = {"巽4", "离9", "坤2", "震3", "中5", "兑7", "艮8", "坎1", "乾6"};
        int[] displayOrder = {4, 9, 2, 3, 5, 7, 8, 1, 6};

        for (int i = 0; i < 9; i++) {
            int gong = displayOrder[i];
            int geValue = data.getBaShenNum().get(data.getBaShen().get(gong));
            String geName = data.getBaShen().get(gong);

            result.append(String.format("%s宫: %s = ", gongNames[i], data.getDigitalNumbers()[i]));
            result.append(String.format("%d(%s)/%s(%d)/",
                    gong, data.getNumToJiuGong(gong),
                    data.getDiPan().get(gong), data.getJiuGanNum().get(data.getDiPan().get(gong))));

            if (data.getTianPanXing().containsKey(gong)) {
                result.append(String.format("%s(%d)/",
                        data.getTianPanXing().get(gong),
                        data.getJiuXingNum().get(data.getTianPanXing().get(gong))));
            } else {
                result.append("天禽(5)/");
            }

            result.append(String.format("%s(%d)/",
                    data.getTianPanJiuGan().get(gong),
                    data.getJiuGanNum().get(data.getTianPanJiuGan().get(gong))));

            if (data.getBaMen().containsKey(gong)) {
                result.append(String.format("%s(%d)/",
                        data.getBaMen().get(gong),
                        data.getBaMenNum().get(data.getBaMen().get(gong))));
            } else {
                result.append("中(5)/");
            }

            result.append(String.format("%s(%d)\n", geName, geValue));
        }

        // ========== 调用增强版分析器进行析盘和断局 ==========
        QiMenAnalyzerEnhanced.analyzeEnhanced(data);

// 获取析盘结果并添加到result
        String analysis = data.getAnalysisResult();
        if (analysis != null && !analysis.isEmpty()) {
            result.append("\n\n").append(analysis).append("\n\n");
        }

// 获取断局结果并添加到result（增强版分析器已经包含了免责声明）
        String interpretation = data.getInterpretationResult();
        if (interpretation != null && !interpretation.isEmpty()) {
            result.append(interpretation);
        }

        tvResult.setText(result.toString());

        // 如果单独的tvAnalysis存在，也设置它的内容（只显示分析结果，不重复排盘信息）
        if (tvAnalysis != null) {
            StringBuilder analysisContent = new StringBuilder();
            if (analysis != null && !analysis.isEmpty()) {
                analysisContent.append("【析盘结果】\n").append(analysis).append("\n\n");
            }
            if (interpretation != null && !interpretation.isEmpty()) {
                analysisContent.append("【断局结果】\n").append(interpretation);
            }
            tvAnalysis.setText(analysisContent.toString());
        }

        // 滚动到顶部
        scrollView.post(() -> scrollView.scrollTo(0, 0));
    }

    private void copyToClipboard() {
        if (currentResult == null) {
            Toast.makeText(this, "请先进行排盘", Toast.LENGTH_SHORT).show();
            return;
        }

        String content = tvResult.getText().toString();
        android.content.ClipboardManager clipboard =
                (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("奇门遁甲排盘", content);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, "已复制到剪贴板", Toast.LENGTH_SHORT).show();
    }
}