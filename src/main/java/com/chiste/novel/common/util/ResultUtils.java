package com.chiste.novel.common.util;

import com.chiste.novel.common.base.ResultMap;

/*
 * @Author: daixq
 * @Date: 2021/4/2 16:51
 * @Description:
 **/
public class ResultUtils {

    public static Integer NORMAL_SUCCESS_CODE = 200;
    public static Integer NORMAL_FAILED_CODE = 400;
    public static String DEFAULT_SUCCESS_MESSAGE = "请求成功";
    public static String DEFAULT_FAILED_MESSAGE = "请求失败";

    /**
     * 无参请求成功返回
     * @return
     */
    public static ResultMap success(){
        return success(null);
    }

    /**
     * 无参请求成功返回
     * @return
     */
    public static ResultMap success(String successMsg){
        ResultMap msg=new ResultMap();
        msg.setCode(NORMAL_SUCCESS_CODE);
        msg.setMsg(successMsg);
        return msg;
    }

    /**
     * 带参请求成功返回
     * @return
     */
    public static ResultMap success(Integer code,String successMsg){
        ResultMap msg=new ResultMap();
        msg.setCode(code);
        msg.setMsg(successMsg);
        return msg;
    }

    /**
     * 带数据请求成功返回
     * @param object
     * @return
     */
    public static ResultMap success(Object object){
        ResultMap msg = new ResultMap();
        msg.setCode(NORMAL_SUCCESS_CODE);
        msg.setMsg(DEFAULT_SUCCESS_MESSAGE);
        msg.setData(object);
        return msg;
    }

    /**
     * 定制返回消息失败返回
     * @param failedMsg
     * @return
     */
    public static ResultMap error(String failedMsg){
        ResultMap msg=new ResultMap();
        msg.setCode(NORMAL_FAILED_CODE);
        msg.setMsg(failedMsg);
        return msg;
    }

    /**
     * 带参请求失败返回
     * @param code
     * @param failedMsg
     * @return
     */
    public static ResultMap error(Integer code,String failedMsg){
        ResultMap msg=new ResultMap();
        msg.setCode(code);
        msg.setMsg(failedMsg);
        return msg;
    }
    /**
     * 登录授权的异常
     * @param msg
     * @return
     */
    public static ResultMap authorizationFailed(String msg){
        ResultMap ResponseData=new ResultMap();
        ResponseData.setCode(401);
        ResponseData.setMsg(msg);
        ResponseData.setData(null);
        return ResponseData;
    }

}
