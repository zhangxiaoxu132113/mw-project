package com.water.tools.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by mrwater on 16/6/4.
 */
public class MWStringUtils {

    public static boolean isBlank(Object ... params){
        if (params == null) {
            throwNullPoint();
        }
        for (Object param : params) {
            if (param instanceof String) {
                if (StringUtils.isBlank((String)param)) {
                    throwContentEmpty();
                }
            }

        }
        return true;
    }

    /*常见的抛出错误抛出信息*/
    public static void throwWrongfulParams(){
        throw new RuntimeException("参数不合法!");
    }

    public static void throwContentEmpty(){
        throw new RuntimeException("参数内容为空!");
    }

    public static void throwNullPoint() {
        throw new RuntimeException("参数对象为空!");
    }

    /*Test*/
    public static void main(String[]args) {
        isBlank("zhangmioajie","haha");
//        isBlank(null);
        isBlank("zhangmiaojie","haha","");
    }
}
