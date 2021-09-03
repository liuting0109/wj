package com.evan.wj.util;

import java.util.Random;

/**
 * @Author: liuting
 * @Date: 2021/8/30 15:42
 * @Description:
 */
public class StringUtils {
//    编写生成指定长度随机字符串的方法：
public static void main(String[] args) {
    System.out.println(getRandomString(5));
}
    public static String getRandomString(int len){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int num = r.nextInt(base.length());
            sb.append(base.charAt(num));
        }
        return sb.toString();
    }
}

