package com.water.crawl.core;

import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by mrwater on 2016/12/3.
 */
public class HttpCrawlResponse {
    private Response response;

    public HttpCrawlResponse(Response response) {
        this.response = response;
    }

    public boolean isSuccessful() {
        return response.isSuccessful();
    }

    public boolean isRedirect() {
        return response.isRedirect();
    }

    public Integer getStatusCode() {
        return response.code();
    }

    public String getPageBody() throws IOException {
        return response.body().string().replace("\\", "");
    }
}
