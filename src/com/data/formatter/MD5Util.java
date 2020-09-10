package com.data.formatter;

import java.security.MessageDigest;

/**
 * @Author ：by wgz
 * @description：MD5工具类
 * @Date ：Created in 2020/7/23 9:16
 * @Version: $
 */
public class MD5Util {

    /**
     * 生成32位大写的MD5
     * @author wgz
     * @date 2020/7/23
     * @param plainText 要转化为MD5的字符串
     * @return java.lang.String
     */

    public String encryption(String plainText) {
        String re_md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();

            int i;

            StringBuilder buf = new StringBuilder("");
            for (byte value : b) {
                i = value;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString().toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}
