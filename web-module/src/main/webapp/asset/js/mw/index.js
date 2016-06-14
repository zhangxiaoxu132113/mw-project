/**
 * Created by mrwater on 16/6/10.
 */
$(document).ready(function(){
    var initTop = 0;
    var translateSpeed = 0.3;
    var translateHeight = 0 ;
    $(window).scroll(function(){
        var scrollTop = $(document).scrollTop();
        if (scrollTop > initTop) {//滚动条向下滚动
            translateHeight += translateSpeed;
        } else {//滚动条向上滚动
            translateHeight -= translateSpeed;
        }
        if (window.pageYOffset == 0 ) {
            translateHeight = 0;
        }
        $(".profile-bg-img").css("transform","translate3d(0px, "+translateHeight+"px, 0px)");

        initTop = scrollTop;
    });
});