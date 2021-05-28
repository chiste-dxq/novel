package com.chiste.novel.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author: daixq
 * @Date: 2021/4/23 13:45
 * @Description:
 **/
public class DateUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public final static String DATE_FORMAT_CORN = "ss mm HH dd MM ? yyyy";

    public final static String DATE_FORMAT_01 = "yyyy-MM-dd HH:mm:ss";

    public static Date parse(String date, String type){
        SimpleDateFormat formatter = new SimpleDateFormat(type);
        Date strtodate = null;
        try {
            strtodate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strtodate;
    }

    public static Date getNow(){
        return new Date();
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str.toString(),parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getCron(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_CORN);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    public static void main(String[] args) {
        Date date = parse("2021-05-28 11:00:00","YYYY-MM-dd HH:mm:ss");
        System.out.println(date);
    }
}
