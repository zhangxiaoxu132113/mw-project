/**
 * Created by mrwater on 16/6/3.
 */
/*实现背景图片的轮播效果*/
$('body').vegas({
    delay: 7000,
    color:"#1b95e0",
    transitionDuration: 2000,
    overlay: true,
    slides:[
        {src:"../asset/content/bottom5.jpg",color:"#1b95e0"},
        {src:"../asset/content/wildsee-pizol3.jpg",color:"#1b95e0"},
        {src:"../asset/content/bg01.jpg",color:"#1b95e0"},
        {src:"../asset/content/bg02.jpg",color:"#1b95e0"},
        {src:"../asset/content/bg03.jpg",color:"#1b95e0"},
        {src:"../asset/content/bg04.jpg",color:"#1b95e0"},
        {src:"../asset/content/bg05.jpg",color:"#1b95e0"},
        {src:"../asset/content/bg06.jpg",color:"#1b95e0"}
    ]
});

/*监听记住密码的复选框选择状态*/
$("#remember_me").change(function(){
   if (this.checked) {
       $("#remember_me").val("yes");
   } else {
       $("#remember_me").val("no");
   }
});

/*设置记住密码复选框的初始状态*/
var initRememberME = function () {
    $("#remember_me").prop("checked",$("#jq_remember_me").val());
    if ($("#jq_remember_me").val() == "checked") {
        $("#remember_me").val("yes");
    } else {
        $("#remember_me").val("no");
    }
}
initRememberME();