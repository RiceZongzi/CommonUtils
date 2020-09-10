package com.math.compute;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @description�������ַ����͹�ʽ
 * @date: Created in 2020/7/23 17:04
 * @Version: $
 */
public class CalcStringFormulaUtil {

    private static ScriptEngine jse;

    static {
        jse = new ScriptEngineManager().getEngineByName("JavaScript");
    }

    /**
     * �����ʵ����Ҫ����
     * @date 2020/7/23
     * @param strExpress �滻��ʽ
     * @param formula �滻ǰ��ʽ
     * @return java.lang.Double
     */

    public static Double calc(String strExpress, String formula) {
        Double number = null;
        try{
            number = Double.valueOf(jse.eval(strExpress).toString());
            // ������ֵ
            if (Double.isNaN(number)) {
                number = 0.0;
            // ֵΪ�����
            } else if(Double.isInfinite(number)){
                number = 0.0;
            }
        }catch(Exception t){
            t.printStackTrace();
        }
        // ��ʽ�д�
        if(number == null){
            System.err.println(formula);
        }
        return number;
    }
}
