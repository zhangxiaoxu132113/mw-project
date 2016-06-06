package com.water.tools.web;

import com.water.tools.lang.MWStringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mrwater on 16/6/5.
 */
public class MWLoginUtils {

    /**
     * @description 添加用户登录信息到cookie中
     * @time 2016-06-05
     */
    public static void addCookie(String login_name, String login_pwd,
                                 HttpServletRequest request, HttpServletResponse response) {
        MWStringUtils.isBlank(login_name,login_pwd);
        //创建Cookie对象，并创建Cookie的父路径
        Cookie userNameCookie = new Cookie("login_name", login_name);
        Cookie pwdCookie = new Cookie("login_pwd", login_pwd);

        userNameCookie.setPath(request.getContextPath()+"/");
        pwdCookie.setPath(request.getContextPath()+"/");
        //根据numberMe的值，来判断cookie的生命周期
        String rememberMe = request.getParameter("remember_me");
        if(rememberMe!=null && rememberMe.equals("yes")){
            userNameCookie.setMaxAge(7*24*60*60);
            pwdCookie.setMaxAge(7*24*60*60);
        }else{
            userNameCookie.setMaxAge(0);
            pwdCookie.setMaxAge(0);
        }
        response.addCookie(userNameCookie);
        response.addCookie(pwdCookie);
    }
}
