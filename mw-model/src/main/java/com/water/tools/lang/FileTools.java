package com.water.tools.lang;

/**
 * Created by mrwater on 16/7/7.
 */
public class FileTools {

    /**
     * @description 返回文件的后缀名
     * @param originalFilename
     * @return
     */
    public static String getFileExtendsName(String originalFilename) {
        return originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
    }
}
