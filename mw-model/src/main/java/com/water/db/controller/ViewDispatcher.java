package com.water.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mrwater on 16/6/4.
 * 视图转发器
 */
@Controller
public class ViewDispatcher {

    /**
     * @description 跳转到用户的首页
     * @time 2016-06-04
     */
    @RequestMapping(value = "/{account}/home")
    public String redirect2homePage() {
        return "/index";
    }
}
