package com.water.crawl.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by mrwater on 2016/11/27.
 */
public class Html {

    public int id;

    /**
     * 请求状态码
     */
    public int responseStatus;

    /**
     * 链接地址
     */
    public String url;

    /**
     * 内容
     */
    public String body;

    public Header[] headers;

    public Html() {}

    public Html(HttpResponse httpResponse, String url) {
        try {
            if (httpResponse != null && StringUtils.isNotBlank(url)) {
                this.url = url;
                this.responseStatus = httpResponse.getStatusLine().getStatusCode();
                this.body = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                System.out.println("请求资源地址 =【" + url + "】响应状态码 = 【" +responseStatus + "】");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }
}
