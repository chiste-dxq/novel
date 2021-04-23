package com.chiste.novel.common.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/*
 * @Author: daixq
 * @Date: 2021/4/21 17:29
 * @Description:
 **/
public class JsoupUtils {

    public Document getDocument(String url){
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
