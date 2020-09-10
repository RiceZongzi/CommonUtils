package com.math.compute;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @description：计算字符串型公式
 * @date: Created in 2020/7/23 17:04
 * @Version: $
 */
public class CalcStringFormulaUtil {

    private static ScriptEngine jse;

    static {
        jse = new ScriptEngineManager().getEngineByName("JavaScript");
    }

    /**
     * 请根据实际需要调整
     * @date 2020/7/23
     * @param strExpress 替换后公式
     * @param formula 替换前公式
     * @return java.lang.Double
     */

    public static Double calc(String strExpress, String formula) {
        Double number = null;
        try{
            number = Double.valueOf(jse.eval(strExpress).toString());
            // 不是数值
            if (Double.isNaN(number)) {
                number = 0.0;
            // 值为无穷大
            } else if(Double.isInfinite(number)){
                number = 0.0;
            }
        }catch(Exception t){
            t.printStackTrace();
        }
        // 公式有错
        if(number == null){
            System.err.println(formula);
        }
        return number;
    }
}
