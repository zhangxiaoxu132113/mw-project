package com.water.db.controller;

import com.water.db.service.IUserService;
import com.water.tools.lang.MWLogTool;
import com.water.tools.web.MWLoginUtils;
import com.water.tools.web.MWSessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource(name = IUserService.SERVICE_NAME)
    private IUserService userService;

    /**
     * @description 用户登录授权
     * @time    2016-06-04
     */
    @RequestMapping(value = "/authorize", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> authorize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> response_status = new HashMap<String, Object>();
        String login_username = request.getParameter("login_name");
        String login_password = request.getParameter("login_pwd");
        String redirect_after_login = request.getParameter("redirect_after_login");

        Map<String,Object> userMap = userService.findUserByNameAndPwd(login_username,login_password);
        if (userMap == null) {
            MWLogTool.warn("用户不存在!登陆失败");
            response_status.put("login_status","login_F");
            return response_status;
        }
        response_status.put("login_status","login_S");
        //是否要添加cookie
        MWLoginUtils.addCookie(login_username,login_password,request,response);
        //将用户对象添加到Session中
        MWSessionUtils.addUser2Session(request,userMap);
        //跳转视图
        if (redirect_after_login != null && StringUtils.isNotBlank(redirect_after_login)) {
            response_status.put("redirect_url",redirect_after_login);
        }
        response_status.put("redirect_url","/"+(String) userMap.get("account")+"/home");
        return response_status;
    }
}
