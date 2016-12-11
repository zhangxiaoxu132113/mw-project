package com.water.crawl.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.water.crawl.utils.Constants;

import java.io.IOException;

/**
 * Created by mrwater on 2016/12/3.
 */
public class TestOkHttp {

    private static String profileUrl = "http://weibo.com/u/3191114182";
    private static String searchUrl = "http://s.weibo.com/weibo/%25E4%25BA%2594%25E6%259C%2588%25E5%25A4%25A9?topnav=1&wvr=6&b=1";
    private static String cookie = "YF-V5-G0=c99031715427fe982b79bf287ae448f6; login_sid_t=9d70050cbcefc980f4dac3bb724aca7f; YF-Ugrow-G0=ad06784f6deda07eea88e095402e4243; _s_tentry=-; Apache=9869863894752.172.1480736532240; SINAGLOBAL=9869863894752.172.1480736532240; ULV=1480736532247:1:1:1:9869863894752.172.1480736532240:; YF-Page-G0=ee5462a7ca7a278058fd1807a910bc74; SSOLoginState=1480736775; un=15820310498; wvr=6; SCF=AsgibHDoXqjT_r1qlCKJD9H9QJb8ZBWhrAv-6Wq0L11Vccnvw2USvSaI6IWjWRFEN3EriKQ2xNfFgV2ju9h08r8.; SUB=_2A251R4RnDeRxGeVP4lMQ8SrNwz6IHXVWNPKvrDV8PUNbmtBeLRmkkW969b1_MEPZtDonRzvimnhMg8aK8g..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5B6JSLT7GMcxB7iP-Z.QyU5JpX5KMhUgL.Foep1K2peKBp1hz2dJLoI7LSMoe_Hc8X9Pzt; SUHB=0z1AM5gV7IS_Mf; ALF=1512384439; UOR=,,www.baidu.com";
    private static String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36";
    private static String search_cookie = "login_sid_t=9d70050cbcefc980f4dac3bb724aca7f; _s_tentry=-; Apache=9869863894752.172.1480736532240; SINAGLOBAL=9869863894752.172.1480736532240; ULV=1480736532247:1:1:1:9869863894752.172.1480736532240:; SWB=usrmdinst_22; UOR=,,www.baidu.com; SCF=AsgibHDoXqjT_r1qlCKJD9H9QJb8ZBWhrAv-6Wq0L11VHfICkwbMWnJ92hTImesogpUa6h8IFaAbR58b1Zo89yc.; SUB=_2A251RjBWDeRxGeVP4lMQ8SrNwz6IHXVWMiaerDV8PUNbmtBeLWPxkW-WrKMBANBL9AZ39steSifTe2ognA..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5B6JSLT7GMcxB7iP-Z.QyU5JpX5K2hUgL.Foep1K2peKBp1hz2dJLoI7LSMoe_Hc8X9Pzt; SUHB=0Ryqf-jjEaHdBb; ALF=1512272773; SSOLoginState=1480736775; un=15820310498; wvr=6";
        private static String referer = "http://s.weibo.com/weibo/%25E8%2582%25A1%25E7%25A5%25A8&Refer=STopic_box";
//    private static String accept = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    public static void main(String[] args) {
        testOkHttp(profileUrl);
//        testHtmlUtil(profileUrl);
    }

    public static String testOkHttp(String url) {
        try {
            String html = null;
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Cookie", cookie)
                    .addHeader("Host", Constants.RequestHeaders.HOST_WEIBO)
                    .addHeader("User-Agent", Constants.RequestHeaders.USER_AGENT)
//                    .addHeader("Referer",referer)
//                    .addHeader("Accept",accept)
                    .build();
            Response response = httpClient.newCall(request).execute();

            if (response.isSuccessful()) {
                System.out.println(response.code());
                html = response.body().string().replace("\\", "");
                System.out.println(html);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void testHtmlUtil(String url) {
        try {
            WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
            //设置webClient的相关参数
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            //webClient.getOptions().setTimeout(50000);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            //模拟浏览器打开一个目标网址
            HtmlPage rootPage = webClient.getPage(url);
            System.out.println("为了获取js执行的数据 线程开始沉睡等待");
            Thread.sleep(3000);//主要是这个线程的等待 因为js加载也是需要时间的
            System.out.println("线程结束沉睡");
            String html = rootPage.asText();
            System.out.println(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
