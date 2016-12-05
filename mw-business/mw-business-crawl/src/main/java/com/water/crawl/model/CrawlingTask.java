package com.water.crawl.model;

import java.util.List;

/**
 * Created by zhangmiaojie on 2016/12/2.
 * 爬虫任务
 */
public class CrawlingTask {
    private String taskId;

    private List<Object> datas;

    public String getTaskId() {
        return taskId;
    }

    public CrawlingTask setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public CrawlingTask setDatas(List<Object> datas) {
        this.datas = datas;
        return this;
    }
}
