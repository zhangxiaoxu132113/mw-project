<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 16/5/31
  Time: 下午2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Miaojie Zhang">
    <title>MrWater 主页</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/mrwater.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/index.css">
</head>
<body>
<div class="doc">
    <!-- topbar -->
    <div class="topbar">
        <div class="global_nav">
            <div class="global_nav_inner">
                <div class="container">
                    <div class="nav">
                        <ul id="global_actions">
                            <li>
                                <a>
                                    <!-- web logo -->
                                    <span class="Icon mr-logo">MrWater</span>
                                    <span class="text">主页</span>
                                </a>
                            </li>
                            <li>
                                <a>
                                    <span>关于</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main body -->
    <div id="page-outer">
        <div id="page-container" class="AppContent">
            <div class="profile-canopy profile-canopy-widthNav">
                <div class="profile-canopy-inner">
                    <!-- profile-canopy-header -->
                    <div class="profile-canopy-header" style="margin-top: 0">
                        <div class="profile-canopy-headerBg">
                            <img class="profile-bg-img" src="/asset/content/user_bg.jpeg" style="transform: none">
                        </div>
                        <!-- 用户头像 -->
                        <div class="AppContainer" >
                            <div class="ProfileCanopy-avatar">
                                <div class="ProfileAvatar">
                                    <a style="outline: 0">
                                        <img src="/asset/content/User_header.jpg" class="ProfileAvatar-img">
                                    </a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- profile-canopy-header end ! -->
                    <!-- profile-canopy-navber -->
                    <div class="profile-canopy-navBar">
                        <div class="AppContainer">
                            <div class="Grid Grid-withGutter">
                                <div class="Grid-cell u-size1of4">
                                    <div class="profile-canopy-card">
                                        <div class="profile-card-mini">
                                            <a class="profile-card-mini-avatar">
                                                <img src="/asset/content/User_header.jpg" class="profile-card-mini-avatar-img">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="Grid-cell u-size3of4">
                                    <div class="profileCanopy-nav">
                                        <div class="profileNav" role="navigation">
                                            <ul class="profileNav-list">
                                                <li class="profileNav-item ">
                                                    <a class="profileNav-start is-Active">
                                                        <span class="profileNav-label">最新动态</span>
                                                        <span class="profileNav-value">1</span>
                                                    </a>
                                                </li>
                                                <li class="profileNav-item">
                                                    <a class="profileNav-start">
                                                        <span class="profileNav-label">心情</span>
                                                        <span class="profileNav-value">34</span>
                                                    </a>
                                                </li>
                                                <li class="profileNav-item">
                                                    <a class="profileNav-start">
                                                        <span class="profileNav-label">日志</span>
                                                        <span class="profileNav-value">13</span>
                                                    </a>
                                                </li>
                                                <li class="profileNav-item">
                                                    <a class="profileNav-start">
                                                        <span class="profileNav-label">相册</span>
                                                        <span class="profileNav-value">19</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- profile-canopy-navbar end ! -->
                </div>
            </div>
            <div class="AppContainer-bg" style="margin:0;padding:0;background: rgb(245,248,250);height:auto;width: 100%">
                <div class="AppContainer">
                    <div class="main-Content">
                        <div class="Grid Grid--withGutter">
                            <!-- 左边的内容 -->
                            <div class="Grid-cell u-size1of4">
                                <div class="Grid Grid-withGutter">
                                    <div class="Grid-cell">
                                        <div class="profile-SiderBar">
                                            <!-- 跟人的详细信息 -->
                                            <div class="profile-headerCard">
                                                <h1 class="profile-headerCard-name">
                                                    <a href="#" class="profile-headerCard-nameLink">MrWater</a>
                                                </h1>
                                                <h2 class="profile-headerCard-screenName"><a>@<span>136218949Mr</span></a></h2>
                                                <p class="profile-headerCard-bio">等风来!</p>
                                            </div>
                                            <div class="profile-photo"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 右边的内容 -->
                            <div class="Grid-cell u-size3of4">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/asset/js/jquery.js"></script>
<script src="/asset/js/mw/index.js"></script>
</body>
</html>
