/*自定义封装的插件*/
/*显示遮罩背景*/
var isInit = false; //是否已经初始化了,遮罩层.默认为false
var _background = function(option) {
    var display ;
    if (!isInit) {
        $('body').append("<div class='mw-bg' style='position: fixed;width: 100%;height: 100%;top:0;left: 0;background:rgba(0, 0, 0, 0.4);z-index: 10000;display: "+display+"'"+">");
        $('body').append("</div>");
        isInit = true;
    }
    if (option == "show") {
        $('.mw-bg').css('display','block');
        //$('.mw-bg').fadeToggle();
    } else {
        $('.mw-bg').css('display','none');
    }

}