package com.zjut.azhen.ncov.utils;

public class DateUtil {
    /**
     * 在数字中填入横线使得 20200322 -> 2020-03-22
     */

    public static String parseDateFormat(String string){
        StringBuilder sb=new StringBuilder(string);
                sb.insert(4,"-");
        sb.insert(7,"-");
        return sb.toString();
    }
}
