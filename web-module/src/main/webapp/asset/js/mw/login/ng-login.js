/**
 * Created by mrwater on 16/6/3.
 */
var app = angular.module('mw.login',[]);

app.controller('loginCtrl',function($scope,$http){
    $scope.login_name = $("#jq_login_name").val();
    $scope.login_pwd  = $("#jq_login_pwd").val();
    var redirect_after_login = $("#redirect_after_login").val();
    //是否提交了表单,避免表单重复提交
    var isCommited = false;

    /*登陆按钮事件*/
    $scope.login = function(login_name,login_pwd) {
        var remember_me = $("#remember_me").val();
        if (!isCommited) {
            isCommited = true;
        } else {
            return;
        }
        $http({
            url:'/user/authorize',
            method:'POST',
            params:{
                login_name:login_name,
                login_pwd :login_pwd,
                redirect_after_login:redirect_after_login,
                remember_me:remember_me
            }
        })
            .success(function(data){
                console.log("提交成功");
                if (data.login_status == "login_F") {
                    isCommited = false;
                } else if (data.login_status == "login_S") {
                    //验证成功!跳转到主页面
                    window.location.href = data.redirect_url;
                }
                console.log(data);
            })
            .error(function(data){
                console.log("提交失败");
                console.log(data);
            });
    }
});
