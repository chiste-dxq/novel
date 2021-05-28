package com.chiste.novel.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author: daixq
 * @Date: 2021/5/28 13:58
 * @Description:
 **/
public class RegexUtils {

    public static String contentRegex(String content){
        String pattern = "<br>|\\s+";
        return content.replaceAll(pattern,"");
    }

    public static String liRegex(String li){
        String pattern = "[\\u4e00-\\u9fa5|：]{0,}";

        return li.replaceAll(pattern,"");
    }
}
