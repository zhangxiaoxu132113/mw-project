<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 16/6/30
  Time: 上午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/font/iconfont/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/font/englishFont/mw-font.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/mw-moon.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/mrwater.css">
    <link rel="stylesheet" type="text/css" href="/plugs/sweet-alert/css/sweet-alert.css">
</head>
<body>
<!-- slider bar  -->
<div class="slider-bar-left">
    <div class="slider-bar-inner">
        <div>
            <!-- operator slider  -->
            <div></div>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </div>


</div>
<div class="slider-bar-right">
    <div class="slider-bar-inner">
        <!-- operator slider  -->
        <div></div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

</div>
<!-- page container -->
<div id="doc">
    <!-- header content -->
    <header class="header">
        <div class="header-inner">
            <!-- logo -->
            <!--<h1 class="logo"><a>MrWater<sup>mood</sup></a></h1>-->
            <h1 class="logo"><a>Mr Water<sup>mood</sup></a></h1>
            <!-- tools bar -->
            <div class="main-nav">
                <div class="nav-inner">
                    <div class="nav-controler-wrap">
                        <ul class="nav-controler-wrap-items">
                            <li class="prev"><a href="#" title="上一页"><i class="iconfont">&#xe650;</i></a></li>
                            <li class="shuffle"><a href="#" title="随机"><i class="iconfont">&#xe69b;</i></a></li>
                            <li class="next"><a href="#" title="下一页"><i class="iconfont">&#xe651;</i></a></li>
                        </ul>
                    </div>
                    <div class="nav-feature-wrap">
                        <ul>
                            <li><a class="directory-btn" href="#" title=""><i class="iconfont">&#xe790;</i></a></li>
                            <li><a class="write-btn" href="#" title=""><i class="iconfont">&#xe6b0;</i></a></li>
                            <li><a class="message-btn" href="#" title=""><i class="iconfont">&#xe6ad;</i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- tools bar end -->
        </div>
    </header>
    <!-- header end -->

    <!-- main content -->
    <div class="page-container">
        <div class="app-content">
            <div class="Grid Grid-withGutter">
                <div class="Grid-cell u-lg-size3of5">
                    <div class="content-detail">
                        <!--<img src="../asset/img/login/mw-login-bg01.jpg" class="mr-img-responsive">-->
                        <h2>
                            <span class=""><span>No.</span></span>65
                        </h2>
                        <p class="face-text">
                            <!--Hello!My name is Zhang Miaojie.I like drawing and ...let me think ! oh No,I don't kown what i like.-->
                            With Herb Lubalin as editor and designer, ITC began publishing “U&lc” in 1973 to market the company’s typefaces.

                        </p>
                        <div class="meta">
                            <ul>
                                <li>
                                    <span class="meta-icon"><i class="iconfont">&#xe62a;</i></span><span>陆丰市甲子镇元高管区</span>
                                </li>
                                <li>
                                    <span class="meta-icon"><i class="iconfont">&#xe74f;</i></span><span style="font-family: sans-serif;">2016-06-30 : 17:10:10</span>
                                </li>
                            </ul>

                        </div>
                    </div>

                </div>
                <div class="Grid-cell u-lg-size2of5">
                    <div class="media-content">
                        <img src="/asset/img/commons/user_image.jpg" class="mr-img-responsive">
                        <!--<img src="../asset/tmp/liliqun.jpg" class="mr-img-responsive">-->
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-- 内容主体 end -->
    <footer>
        <div class="footer-inner">
            <div class="footer-left">
                <p>©2016 Mr Water ™ Images are ™© of their respective owners.</p>
            </div>
            <div class="footer-right">
                <p>know more</p>
            </div>
        </div>
        <div style="clear: both"></div>
    </footer>
    <!-- 发表个人心情的模钛窗口-->
    <div class="mw-popup" style="display: none">
        <div class="mw-popup-inner" >
            <a class="closeBtn"><i class="iconfont" style="font-size: 14px">&#xe659;</i></a>
            <h4>心情物语</h4>
            <div class="moon-content" style="outline: none" contenteditable="true" ></div>
            <div class="moon-toolbar">
                <a class="addPhoto"><i class="iconfont">&#xe780;</i></a>
                <!-- 隐藏的文件上传的input表单 -->
                <form action="/upload/imageList" id="uploadMultiFiles" method="post" enctype="multipart/form-data">
                    <input type="file" name="file" class="uploadFiles mw-hidden">
                </form>
                <a class="addLocaltion"><i class="iconfont">&#xe768;</i></a>
                <a class="addMusic"><i class="iconfont" style="font-size: 25px">&#xe624;</i></a>

                <a class="sendContBtn"><i class="iconfont">&#xe6b0;</i>发送</a>
                <span class="limitNumber">135</span>
                <div style="clear: both"></div>

            </div>
            <div class="add-content">
                <!--<ul>-->
                <!--<li><img src="../asset/img/commons/user_image.jpg" style="height: 80px;width: auto"></li>-->
                <!--<li><img src="../asset/content/bg02.jpg" style="height: 80px;width: auto"></li>-->
                <!--</ul>-->
                <em></em>
                <div class="added-img-list">
                    <span  class="img-panel-item" style="position: relative">
                        <span class="img-hover-bg">
                            <i class="iconfont">&#xe659;</i>
                        </span>
                        <img src="/asset/img/commons/user_image.jpg" />
                    </span>
                    <span class="addImageBtn">
                      <i class="iconfont">&#xe6ea;</i>
                    </span>
                </div>


            </div>
        </div>
    </div>
</div>
<!--<div id="map" style="width: 800px;height: 500px;z-index: 10000">-->

</div>
<script src="/asset/js/jquery.js"></script>
<script src="/asset/js/mrwater.js"></script>
<script src="/asset/js/mw/mw-moon.js"></script>
<script src="/plugs/sweet-alert/js/sweet-alert.min.js"></script>
<!--<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>-->
<!--<script type="text/javascript">
    $(window).ready(function () {
        if (navigator.geolocation) {
            //获取当前地理位置
            navigator.geolocation.getCurrentPosition(function (position) {
                        var coords = position.coords;
                        //console.log(position);
                        //指定一个google地图上的坐标点，同时指定该坐标点的横坐标和纵坐标
                        var latlng = new google.maps.LatLng(coords.latitude, coords.longitude);
                        var myOptions = {
                            zoom: 14,    //设定放大倍数
                            center: latlng,  //将地图中心点设定为指定的坐标点
                            mapTypeId: google.maps.MapTypeId.ROADMAP //指定地图类型
                        };
                        //创建地图，并在页面map中显示
                        var map = new google.maps.Map(document.getElementById("map"), myOptions);
                        //在地图上创建标记
                        var marker = new google.maps.Marker({
                            position: latlng,    //将前面设定的坐标标注出来
                            map: map //将该标注设置在刚才创建的map中
                        });
                        //标注提示窗口
                        var infoWindow = new google.maps.InfoWindow({
                            content: "当前位置：<br/>经度：" + latlng.lat() + "<br/>维度：" + latlng.lng()   //提示窗体内的提示信息
                        });
                        //打开提示窗口
                        infoWindow.open(map, marker);
                    },
                    function (error) {
                        //处理错误
                        switch (error.code) {
                            case 1:
                                alert("位置服务被拒绝。");
                                break;
                            case 2:
                                alert("暂时获取不到位置信息。");
                                break;
                            case 3:
                                alert("获取信息超时。");
                                break;
                            default:
                                alert("未知错误。");
                                break;
                        }
                    });
        } else {
            alert("你的浏览器不支持HTML5来获取地理位置信息。");
        }
    });

<!--</script>-->
</body>
</html>

