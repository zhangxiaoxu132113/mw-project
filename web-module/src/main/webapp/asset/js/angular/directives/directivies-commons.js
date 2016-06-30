/**
 * Created by MrWater on 2016-06-30
 */
/*
* 实验:如何让我们在input hidden设置的value在前端不给显示
* */
//input hidden value
app.directive("mw-input-hidden",function(){
    return {
        restrict:"E",
        transclude:true,
        template: "<input type='hidden' value='' id='{{id}}'>",
        replace:true,
        scope:{id:'=id'}
    }
});