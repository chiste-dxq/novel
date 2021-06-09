package com.chiste.novel.common.util;

import com.chiste.novel.domain.novel.vo.NovelContentAddVo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author: daixq
 * @Date: 2021/6/8 10:39
 * @Description:
 **/
public class FileUtils {

    /**
     * 分割小说工具
     * @param filePath
     */
    public static List<NovelContentAddVo> readTxtFile(String filePath,Integer novelId){
        List<NovelContentAddVo> contents = new ArrayList<>();
        try {
            // 编码格式
            String encoding = "UTF-8";
            // 文件路径
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                // 输入流
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                String newStr=null;
                String titleName=null;
                String newChapterName = null;//新章节名称
                String beforeChapterName = null;
                String substring=null;
                int indexOf=0;
                int indexOf1=0;
                int line=0;
                //小说内容类

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String pattern = "第(.{1,9})[章|节|卷|集|部|篇|回]";
                    // 正则表达式
                    Pattern p = Pattern.compile(pattern);
                    Matcher matcher = p.matcher(lineTxt);
                    newStr=newStr+lineTxt;

                    while (matcher.find()) {
                        NovelContentAddVo content=new NovelContentAddVo();
                        content.setNovelId(novelId);
                        //小说名称
                        titleName = matcher.group();
                        newChapterName = titleName.trim();
                        //获取章节
                        //System.out.println(newChapterName);
                        content.setChapter(beforeChapterName);
                        beforeChapterName = newChapterName;

                        indexOf1=indexOf;
                        indexOf = newStr.indexOf(newChapterName);
                        if(indexOf>indexOf1) {
                            //根据章节数量生成
                            substring = newStr.substring(indexOf1, indexOf);
                            content.setContent(substring);
                            contents.add(content);
                        }
                    }
                }
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return contents;
    }
    /**
     * 获取文件后缀名
     * @param url
     * @return
     */
    public static String getContentType(String url){
        String video = url.substring(0,url.lastIndexOf("?"));
        return video.substring(video.lastIndexOf("."));
    }
}
