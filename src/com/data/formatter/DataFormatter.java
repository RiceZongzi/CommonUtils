package com.data.formatter;

import java.text.NumberFormat;

/**
 * @Author ：by wgz
 * @description：用于数据格式化
 * @Date ：Created in 2020/9/10 14:27
 * @Version: $
 */
public class DataFormatter {
    /**
     * Double 使用官方的Double.toString()方法转String时，
     * 位数大于8位时会自动科学计数法，影响可读性
     * @author wgz
     * @date 2020/8/30
     * @param d 要转成String的double
     * @param digits 保留小数点位数
     * @param group 小数点两端是否分组，true--分，false--不分
     * @return java.lang.String
     */

    public static String doubleToString(Double d, int digits, boolean group) {
        if (d == null) {
            return "";
        }
        NumberFormat nf = NumberFormat.getInstance();
        // true，分组，如 12,345,678
        // false，不分组
        nf.setGroupingUsed(group);
        // 设置保留的小数位数
        if (digits < 3) {
            nf.setMaximumFractionDigits(digits);
        } else {
            nf.setMinimumFractionDigits(digits);
        }
        return (nf.format(d));
    }
}
