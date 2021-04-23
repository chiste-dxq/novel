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

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str.toString(),parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
}
