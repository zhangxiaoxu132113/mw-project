/**
 * Created by mrwater on 16/7/8.
 */
/**
 * @author Mr Water
 * @param formObj                要提交的表单
 * @param iframeName             隐藏的iframe,//todo 后面打算自己在js里面生成
 * @param uploadSuccess_callBack 回调函数
 */
var setJsonBySubmit = function(formObj,iframeName,uploadSuccess_callBack) {
    formObj.attr("target",iframeName);
    formObj.submit();
    var resultJson ;
    setTimeout(function(){
        var result = $(window.frames[iframeName].document).find("pre").html(); //这里写的比较死
        resultJson = JSON.parse(result);
        uploadSuccess_callBack.call(this,resultJson);
    },1000);
}
/*提交成功回调的方法*/
var uploadSuccess_callBack = function(obj) {}


