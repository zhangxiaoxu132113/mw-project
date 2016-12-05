package com.water.crawl.handler;

/**
 * Created by zhangmiaojie on 2016/12/2.
 */
public interface Handler {

    /**
     * 任务提交队列
     */
    void onTaskSubmitQueueCompleted(String taskId);

    /**
     * 任务完成
     */
    void onTaskCompleted(String taskId);

    /**
     * 任务取消
     */
    abstract void onTaskCancelled(String taskId);
}
