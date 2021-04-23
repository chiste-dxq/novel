package com.chiste.novel.controller.system;

import com.chiste.novel.common.annotion.Log;
import com.chiste.novel.common.base.BaseController;
import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.jwt.JwtUtils;
import com.chiste.novel.common.util.*;
import com.chiste.novel.domain.user.SysUser;
import com.chiste.novel.service.user.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserService sysUserService;

    @Log(title="请求访问主页")
    @GetMapping({"","/","/index"})
    String index(Model model) {
        model.addAttribute("name", getUser().getUserName());
        model.addAttribute("code", getUser().getUserCode());
        return "index";
    }

    @Log(title="登录")
    @GetMapping("/login")
    @ResponseBody
    ResultMap ajaxLogin(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        SysUser user = sysUserService.selectUserByCode(username);
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号不正确");
        }
        // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        return ResultUtils.success(JwtUtils.encode(username, password, null));
    }

    @GetMapping("/logout")
    String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    /**
     * 生成验证码
     */
    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtils randomValidateCode = new RandomValidateCodeUtils();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }

}
