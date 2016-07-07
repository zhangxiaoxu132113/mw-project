$(window).ready(function(){
    var sliderBarW = 385;
    var sliderDurationT = 600;
    var zeroW = 0;
    //展示左边的工具栏
    $('.directory-btn').bind('click',function(){
        $('#doc').css('right','auto');
        if ($('.slider-bar-left').is(":hidden")) {
            //左边的slider bar显示出来
            $('.slider-bar-left').css('display','block');
            $('.slider-bar-left').animate({'width':sliderBarW+'px'},sliderDurationT);
            $('#doc').animate({'left':sliderBarW+'px'},sliderDurationT);
        } else {
            //左边的slider bar隐藏掉
            $('.slider-bar-left').animate({'width':zeroW+'px'},sliderDurationT);
            $('#doc').animate({'left':zeroW+'px'},sliderDurationT,function(){
                $('.slider-bar-left').css('display','none');
            });

        }
    });

    //展示右边的留言信息栏
    $('.message-btn').bind('click',function(){
        $('#doc').css('left','auto');
        if ($('.slider-bar-right').is(":hidden")) {
            //左边的slider bar显示出来
            $('.slider-bar-right').css('display','block');
            $('.slider-bar-right').animate({'width':sliderBarW+'px'},sliderDurationT);
            $('#doc').animate({'right':sliderBarW+'px'},sliderDurationT);
        } else {
            //左边的slider bar隐藏掉
            $('.slider-bar-right').animate({'width':zeroW+'px'},sliderDurationT);
            $('#doc').animate({'right':zeroW+'px'},sliderDurationT,function(){
                $('.slider-bar-right').css('display','none');
            });

        }
    });


    /*关闭发表心情魔胎窗口的事件*/
    $('.closeBtn').bind('click',function() {
        _background('hidden');
        $('.mw-popup').fadeToggle();

    });

    /*显示发表心情的魔胎窗口*/
    $('.write-btn').bind('click',function() {
        _background('show');
        $('.mw-popup').fadeToggle();
    });

    /*发送按钮的事件*/
    $('.sendContBtn').bind('click',function(){
        //$('.sendContBtn').css('background','#FFF');
        //$('.sendContBtn').css('padding','0');
        //$('.sendContBtn').html("<img src='../asset/img/loading_gif/loading_7.gif'>");
        $('.closeBtn').click();
        setTimeout(function(){
            swal("发表成功", "", "success");
        },250);
    });

    /*添加图片*/
    $('.addPhoto').bind('click',function(){
        if ($('.add-content').is(':hidden')) {
            if ($('.added-img-list').find('img').length>0) {
                $('.add-content').slideToggle('fast',function() {
                    controlBtnStatus('.add-content','.addPhoto');
                });
            } else {
                $('.uploadFiles').click();
            }
        } else {
            $('.add-content').slideToggle('fast',function() {
                controlBtnStatus('.add-content','.addPhoto');
            });
        }

    });
    $('.addImageBtn').bind('click', function () {
        $('.uploadFiles').click();
    });
    /*file input表单的事件*/
    $('.uploadFiles').bind('change',function(){
        //这里上传图片,假设上传成功了的操作
        var imgSrc = "../asset/img/commons/user_image.jpg";
        $('.addImageBtn').before("<span class='img-panel-item' style='position: relative'><span class='img-hover-bg'><i class='iconfont'>&#xe659;</i></span><img src='"+imgSrc+"' /></span>") ;
        if ($('.add-content').is(':hidden')) {
            $('.add-content').slideToggle('fast',function(){
                controlBtnStatus('.add-content','.addPhoto');

            });
        }

    });

    /*图片获取焦点 \ 失去焦点*/
    // 注: 使用代理的方式可以使得jquery动态创建出来的元素可以绑定事件
    $(document).delegate('.img-panel-item', 'mouseover', function() {
        $(this).find('span:first-child').each(function(){
            $(this).css('display','block');
        });
    });
    $(document).delegate('.img-panel-item', 'mouseout', function() {
        $(this).find('span:first-child').each(function(){
            $(this).css('display','none');
        });
    });
    /*改变按钮处于linked or active 的颜色*/
    var controlBtnStatus = function(flagObj,targetObj) {
        if ($(flagObj).is(':hidden')) {
            $(targetObj).css('color','#66757f');
        } else {
            $(targetObj).css('color','#1b95e0');
        }
    }
});