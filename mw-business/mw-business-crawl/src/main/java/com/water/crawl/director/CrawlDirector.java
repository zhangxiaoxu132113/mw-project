package com.water.crawl.director;

import com.water.crawl.handler.Handler;
import com.water.crawl.model.CrawlingTask;
import com.water.crawl.utils.ObjectUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangmiaojie on 2016/12/2.
 */
public class CrawlDirector {
    public static List<String> watchList = null;
    public static Handler handler;

    public static void intialize() {    //是否要使用懒汉式还是恶汉式
        watchList = new ArrayList<String>(20);  //默认只监听队列数量 20
    }

    public static void registerHandler(Handler handler) {
        CrawlDirector.handler = handler;
    }

    public static void registerWatchQueue(final String queueName) {
        if (watchList.contains(queueName)) return;
        watchList.add(queueName);
    }

    public static void submitTask(String queueName, CrawlingTask task) {
        boolean isWatch = false;
        Iterator iterator = watchList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(queueName)) isWatch = true;
        }
        if (isWatch) {
            if (task != null && StringUtils.isNotBlank(queueName) && task.getDatas() != null && task.getTaskId().length() > 0) {
                try {
                    Iterator<Object> var4 = task.getDatas().iterator();
                    while (var4.hasNext()) {
                        byte[] data = ObjectUtil.objectToBytes(var4.next());
                        //TODO 将数据放到redis队列中
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
