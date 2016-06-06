package com.water.tools.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
public class MWSessionUtils {
    public static String GLOBAL_USER = "global_user";
    private MWSessionUtils (){}

    /**
     * @description 添加用户对象到session中
     * @param request
     * @param user
     * @time 2016-06-04
     */
    public static void addUser2Session(HttpServletRequest request, Map<String,Object> user) {
        HttpSession session = request.getSession();
        session.setAttribute(GLOBAL_USER,user);
    }


}
