package com.water.crawl.core;

import com.water.crawl.model.Html;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by mrwater on 16/5/25.
 */
public class WaterloadHtml {

    /**
     *
     * @param url 请求的路径
     * @return String[]
     *          0 -> http请求的状态
     *          1 -> 请求得到的内容实体
     */
    public Html getHtml(String url){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .build();
            httpClient = HttpClients.custom().
                    setDefaultRequestConfig(requestConfig)
                    .build();

            HttpGet httpGet = new HttpGet(url);
            response = httpClient.execute(httpGet);

            return new Html(response,url);
        } catch (Exception e) {
            System.out.println("Connection outtime ... ...");
            e.printStackTrace();
        } finally {
            if (httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    /**
     * @Description 通过代理的方式来访问资源
     * @param url      访问url路径
     * @param hostName 主机名
     * @param port     端口号
     * @return html 访问到的html内容
     */
    public String getHtmlByProxy (String url, String hostName, int port) {
        String html = null;
        HttpHost proxy = new HttpHost(hostName,port);
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(2000)
                .setConnectTimeout(2000)
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                html = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            }
            httpResponse.close();
        } catch (IOException e) {
            System.out.println("connection timeout ... .. ");
            e.printStackTrace();
        } finally {

        }
        return html;
    }

    public static void main(String[]args){
        WaterloadHtml waterloadHtml = new WaterloadHtml();
        Html html = waterloadHtml.getHtml("http://localhost:8080/");
        System.out.println("html content :\n " + html.getBody());
    }
}
