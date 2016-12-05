package com.water.crawl.model;

/**
 * Created by zhangmiaojie on 2016/12/2.
 */
public class Test implements java.io.Serializable{
    private static final long serialVersionUID = 7792729L;
    private Integer id;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
