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

});