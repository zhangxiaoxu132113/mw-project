package com.water.crawl.utils;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by mrwater on 2016/11/29.
 * 从配置文件读取的常量
 */
public class Constants {
    public static Properties properties;

    static {
        Resource resource = new ClassPathResource("/config.properties");
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class RequestHeaders {
        public static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36";

        public static String HOST_WEIBO = "weibo.com";
    }
}
