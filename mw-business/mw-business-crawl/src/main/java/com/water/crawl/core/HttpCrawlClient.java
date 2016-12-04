package com.water.crawl.core;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.water.crawl.model.Header;
import com.water.crawl.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mrwater on 2016/12/3.
 * 默认使用chrom内核
 */
public class HttpCrawlClient {

    public static HttpCrawlClient instance = new HttpCrawlClient();
    private OkHttpClient client = null;

    private HttpCrawlClient() {
        intialize();
    }

    public static HttpCrawlClient newInstance() {
        return instance;
    }

    private void intialize() {
        client = new OkHttpClient();
    }

    public void setConnectTimeout(long timeout, TimeUnit timeUnit) {
        client.setConnectTimeout(timeout, timeUnit);
    }

    public void setConnectTimeout(long timeout) {
        this.setConnectTimeout(timeout, TimeUnit.SECONDS);
    }

    public void setWriterTimeout(long timeout, TimeUnit timeUnit) {
        client.setWriteTimeout(timeout, timeUnit);
    }

    public void setWriterTimeout(long timeout) {
        this.setWriterTimeout(timeout, TimeUnit.SECONDS);
    }

    public void setReadTimeout(long timeout, TimeUnit timeUnit) {
        client.setReadTimeout(timeout, timeUnit);
    }

    public void setReadTimeout(long timeout) {
        this.setReadTimeout(timeout, TimeUnit.SECONDS);
    }

    public void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public HttpCrawlResponse executeGetRequest(String url, List<Header> heads) throws IOException {
        if (StringUtils.isBlank(url)) {
            throw new RuntimeException("url请求地址格式不正确！");
        }
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        if (heads != null && heads.size() > 0) {
            for (Header header : heads) {
                builder.addHeader(header.getName(), header.getValue());
            }
        }
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return new HttpCrawlResponse(response);
    }

    public HttpCrawlResponse executeGetRequest(String url) throws IOException {
        return this.executeGetRequest(url, null);
    }

    public void executePostRequest(String url, List<Header> head) {

    }
}
