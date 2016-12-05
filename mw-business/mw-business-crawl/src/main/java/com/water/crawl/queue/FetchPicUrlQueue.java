package com.water.crawl.queue;

import java.util.LinkedList;

/**
 * Created by zhangmiaojie on 2016/12/2.
 */
public class FetchPicUrlQueue {
    public static LinkedList<String> urlQueue = new LinkedList<String>(); //抓取图片的超链接队列

    public static final int MAX_SIZE = 10000;

    public synchronized static void pushUrl(String url) {
        if (size() > MAX_SIZE) throw new RuntimeException("队列数量超出最大限制！");
        urlQueue.add(url);
    }

    public synchronized static void pushFirstUrl(String url) {
        urlQueue.addFirst(url);
    }

    public synchronized static String popUrl() {
        return urlQueue.remove();
    }

    public synchronized static boolean isEmpty() {
        return urlQueue.isEmpty();
    }

    public synchronized static int size() {
        return urlQueue.size();
    }

    public synchronized static boolean isContaines(String url) {
        return urlQueue.contains(url);
    }

    public static void showAllUrl() {
        if (!isEmpty()) {
            for (String url:urlQueue) {
                System.out.println("url = " + url);
            }
        }
    }

}
