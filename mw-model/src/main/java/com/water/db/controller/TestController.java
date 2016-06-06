package com.water.db.controller;

import com.water.tools.lang.MWLogTool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrwater on 16/5/31.
 */
@RestController
@RequestMapping(value = "/home")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String,Object> getData(HttpServletRequest request) {
        String login_name = request.getParameter("login_name");
        MWLogTool.success(login_name);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("username","ZhangMiaojie");
        result.put("age",34);

        System.out.println("测试成功啦!");
        return result;
    }
}
