<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 16/6/3
  Time: 下午8:30
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login_name = "";
    String login_pwd = "";
    String remember_me = "";
    Cookie[]cookies = request.getCookies();
    //判断cookie是否为null，且长度是否小于1
    if(cookies!=null && cookies.length>0){
        for(int i=0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            if("login_name".equals(cookie.getName())){
                login_name = URLDecoder.decode(cookie.getValue(), "UTF-8");
                remember_me = "checked";
            }
            if("login_pwd".equals(cookie.getName())){
                login_pwd = cookie.getValue();
            }
        }
    }else{
        remember_me = "";
    }
%>
<html lang="en" ng-app="mw.login">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Miaojie Zhang">
    <meta name="description" content="Mr Water 登陆页面">
    <title>登陆MrWater</title>
    <!--<link rel="stylesheet" type="text/css" media="screen" href="../plugs/bootstrap-3.3.5-dist/css/bootstrap.min.css">-->
    <link rel="stylesheet" type="text/css" media="screen" href="/asset/css/mrwater.css">
    <link rel="stylesheet" type="text/css" media="screen" href="/asset/css/login.css">
    <link rel="stylesheet" type="text/css" media="screen" href="/plugs/vegas/vegas.min.css">
</head>

<body ng-controller="loginCtrl">
<!-- navigation bar -->
<div class="mw-login-topbar">
    <div class="login-topbar-nav">
        <div class="topbar-nav-inner">
            <div class="container">
                <!-- navigator -->
                <ul class="nav">
                    <li class="nav-home">
                        <a href="#">
                            <span class="mr-logo">MrWater</span>
                            <span>主页</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span>关于</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- main body -->
<div class="mw-login-wrap">
    <div class="mw-login-wrap-inner">
        <div class="login-wrap-container">
            <div class="login-wrap-left">
                <div class="login-poster">
                    <!--<h1>耐得住寂寞,才能守得住繁华!</h1>-->
                    <h1>欢迎!Mr Water。</h1>
                    <!--<p>耐得住寂寞,才能守得住繁华!</p>-->
                    <p>
                        但凡成功之人，往往都要经历一段没人支持、没人帮助的黑暗岁月，
                        而这段时光，恰恰是沉淀自我的关键阶段。犹如黎明前的黑暗，捱过去，天也就亮了。
                    </p>
                </div>
            </div>
            <div class="login-wrap-right">
                <!-- signin -->
                <div class="login-frame">
                    <form action="" method="post" class="login-form">
                        <div class="username-field">
                            <input type="text" placeholder="手机、邮件地址或用户名" class="text-input" ng-model="login_name">
                        </div>
                        <table class="fixed-table">
                            <tbody>
                            <tr>
                                <td class="flex-table-primary"><input class="login-password" placeholder="密码" type="password" ng-model="login_pwd"></td>
                                <td class="flex-table-secondary"><button class="mr-btn mr-primary-btn" ng-click="login(login_name,login_pwd)">登陆</button></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="remember-forgot">
                            <label class="remember">
                                <input type="checkbox" value="no" name="remember_me" id="remember_me" >
                                <span>记住我</span>
                            </label>
                            <span class="separator">.</span>
                            <a class="forgot" href="#">忘记密码</a>
                        </div>
                        <input type="hidden" value="${redirect_after_login }" name="redirect_after_login" id="redirect_after_login">
                        <input type="hidden" value="xxx" name="authenticity_token">
                        <input type="hidden" value="<%=login_name%>" id="jq_login_name">
                        <input type="hidden" value="<%=login_pwd%>" id="jq_login_pwd">
                        <input type="hidden" value="<%=remember_me%>" id="jq_remember_me">
                    </form>
                </div>
                <!-- signup -->
                <div class="signup-frame">
                    <h2><strong>新来访客?</strong> 注册</h2>
                    <form action="" method="post">
                        <div class="field">
                            <input type="text" placeholder="全名" class="text-input">
                        </div>
                        <div class="field">
                            <input type="text" placeholder="邮件" class="text-input">
                        </div>
                        <div class="field">
                            <input type="password" placeholder="密码" class="text-input">
                        </div>
                        <button type="submit" class="mr-btn signup-btn mr-pull-right">注册Mr Water</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<footer>
    <p style="padding:2em 0;text-align: center;color:rgba(246, 246, 246, 0.79);">
        Copyright © 2016 MrWater工作室
    </p>
</footer>
<!-- background image qzone-css -->
<!--<div class="mw-login-bg" style="overflow: auto">-->
<!--<img src="../asset/img/login/mw-login-bg.jpg" class="mr-img-responsive" width="1273" height="auto" alt="背景图片" id="mw-login-bg-img" />-->
<!--&lt;!&ndash;<img src="../asset/img/login/mw-login-bg01.jpg" class="mr-img-responsive" width="1273" height="auto" alt="背景图片" id="mw-login-bg-img" />&ndash;&gt;-->
<!--</div>-->
<!-- Here introduce the js file -->
<script src="/asset/js/jquery.js"></script>
<script src="/asset/js/zepto.js"></script>
<script src="/asset/js/jquery.form.js"></script>
<script src="/plugs/angularjs/angular-1.2.22.min.js"></script>
<script src="/plugs/vegas/vegas.min.js"></script>
<script src="/asset/js/mw/login/login.js"></script>
<script src="/asset/js/mw/login/ng-login.js"></script>

</body>
</html>
