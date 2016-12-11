package com.water.crawl.core;

import com.squareup.okhttp.Response;
import com.water.crawl.utils.StringUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String htmlBody = StringUtil.decodeUnicode(response.body().string());
        return htmlBody.replace("\\", "");
    }


}
