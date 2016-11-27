package com.water.crawl.core;

import com.water.crawl.model.Html;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by mrwater on 16/5/26.
 */
public class WaterTest {

    /**
     * 缺陷的记录
     * 1,有时候图片的src没有包含http请求协议的,所以我们要智能的拼装
     * 2,保存的文件格式有时候后缀有点问题,such as 04b2ac55c302360000013b7b90d16b.jpg@48w_48h_2o
     * 所以要只能判断这个后缀,在保存的时候要判断一下
     */
    public static void main(String[] args) {
        WaterloadHtml waterloadHtml = new WaterloadHtml();

        String requestUrl = "http://travel.163.com/15/1202/15/B9RC7R8200063KE8.html";
        System.out.println("requesturl = " + requestUrl);
        Html html = waterloadHtml.getHtml(requestUrl);

        System.out.println("content = " + html.getBody());
        List<String> hrefLists = WaterHtmlParse.getHrefWithA(html.getBody());
        hrefLists.add(0, requestUrl);
        System.out.println("开始解析下载图片... ...");
        long beingTime = System.currentTimeMillis();
        for (int i = 0; i < hrefLists.size(); i++) {
            String hrefStr = hrefLists.get(i);
            System.out.println("in = " + hrefStr);
            if (hrefStr != null && !hrefStr.contains("http")) {
                try {
                    hrefStr = "http://" + DownloadImg.getTopDomainWithoutSubdomain(requestUrl) + hrefStr;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            Html targetHtml = waterloadHtml.getHtml(hrefStr);

            List<String> imageSrcList = WaterHtmlParse.getImgSrc(targetHtml.getBody());
            if (imageSrcList == null) continue;
            //遍历所有的img路径,并下载到本地
            for (String imgsrc : imageSrcList) {
                DownloadImg.loadImg(requestUrl, imgsrc, "/Users/mrwater/Downloads/qj/");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总共耗时 --- --- " + (beingTime - endTime) + " s");

    }
}
