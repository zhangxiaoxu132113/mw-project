package com.water.tools.lang;

/**
 * Created by mrwater on 16/6/3.
 */
public class MWLogTool {

    private MWLogTool(){}

    public static void info(String information) {
        System.out.println("[info]\t"+information);
    }

    public static void success(String information) {
        System.out.println("[success]\t"+information);
    }

    public static void error(String information) {
        System.out.println("[error]\t"+information);
    }

    public static void warn(String information) {
        System.out.println("[warn]\t"+information);
    }
}
