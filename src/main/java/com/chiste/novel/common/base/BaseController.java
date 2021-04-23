package com.chiste.novel.common.base;

import com.chiste.novel.common.util.DateUtils;
import com.chiste.novel.common.util.ShiroUtils;
import com.chiste.novel.domain.user.SysUser;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/*
 * @Author: daixq
 * @Date: 2021/4/21 17:10
 * @Description:
 **/
public class BaseController {

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    public SysUser getUser() {
        return ShiroUtils.getUser();
    }

    public Long getUserId() {
        return getUser().getId();
    }
    public String getUserCode() {
        return getUser().getUserCode();
    }

    public String getPassword() {
        return getUser().getPassword();
    }

    public String getUsername() {
        return getUser().getUserName();
    }
}
