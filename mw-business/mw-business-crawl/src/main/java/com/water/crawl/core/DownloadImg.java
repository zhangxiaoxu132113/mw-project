package com.water.crawl.core;

import com.water.crawl.utils.StringUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mrwater on 16/5/25.
 */
public class DownloadImg {

    public static void main(String[]args){
        String hostName = null;
        try {
//            hostName = new URL("http://bbs.csdn.net/topics/390082054").toString();
//            String topDomainUrl = getTopDomainWithoutSubdomain(hostName);
//            System.out.println(topDomainUrl);
              String picName = "haha.jpg";
              picName = picName.substring(0,picName.lastIndexOf(".jpg") + ".jpg".length());
            System.out.println("picName : " + picName);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /***
     *
     * @param imgSrc       图片资源的uri路径
     * @param filePath     保存到本地的路径
     */
    public static void loadImg(String requestUrl, String imgSrc,String filePath) {
        URL url = null;
        InputStream is = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            //创建目录
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }

            //创建正则表达式,判断imgSrc路径是否包含了http请求协议
            Pattern pattern = Pattern.compile("^http\\:\\/\\/.+$");
            Matcher matcher = pattern.matcher(imgSrc);
            if (matcher.find()){
                url = new URL(imgSrc);
                System.out.println("imgSrc = "+imgSrc);
            } else {
                //获取网站的一级域名
                String hostName = StringUtil.getTopDomainWithoutSubdomain(requestUrl);
                url = new URL("http://"+ hostName+imgSrc);
            }

            //链接网络图片地址
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //设置请求超时为5s
            urlConnection.setConnectTimeout(5*1000);
            //设置读取的超时时间为1min
            urlConnection.setReadTimeout(60 * 1000);

            System.out.println("获取图片的响应吗 = " + urlConnection.getResponseCode());
            //判断服务器响应是否成功
            if (urlConnection.getResponseCode() == 200 || urlConnection.getResponseCode() == 304) {
                //获取图片的输入流
                is = urlConnection.getInputStream();

                //获取文件的正确的名字
                imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/")).toLowerCase();
                if (imgSrc.contains(".jpg") || imgSrc.contains(".jpeg")) {
                    imgSrc = imgSrc.substring(0,imgSrc.lastIndexOf(".jpg") + ".jpg".length());
                } else if (imgSrc.contains(".png")) {
                    imgSrc = imgSrc.substring(0,imgSrc.lastIndexOf(".png") + ".png".length());
                } else if (imgSrc.contains(".gif")) {
                    imgSrc = imgSrc.substring(0,imgSrc.lastIndexOf(".gif") + ".gif".length());
                }
                //创建文件
                System.out.println("下载的文件名 = " +imgSrc);
                File saveFile = new File(filePath + imgSrc);
                //输入到文件
                fos = new FileOutputStream(saveFile);
//                bos = new BufferedOutputStream(fos);
                int line = -1;
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                while ((line = is.read(bs)) != -1) {
                    fos.write(bs,0,line);
                }
                fos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//释放资源
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null)
                        is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    /*判断url是否包含图片*/
    public boolean find(String regex,String url){
        //匹配以文件形式结尾的url
        if (regex == null) {
            regex = ".*\\.(rar|png|jpg|bmp|gif|doc|zip|xls|zip|ZIP|PDF|DOC|JPG|JPEG|PNG|GIF)";
        }
        //regex : ".*\\.(rar|png|jpg|bmp|gif|doc|zip|xls|zip|ZIP|PDF|DOC|JPG|JPEG|PNG|GIF)"
        //url : http://news.twt.edu.cn//default2010B/twt1/img/resourceIcon5.png
        Pattern pattern = Pattern.compile(regex);
        //Pattern类即为正则表达式
        Matcher matcher = pattern.matcher(url);
        //对传入的url进行字符提取和匹配，matches()为匹配，group()则为提取
        if(matcher.matches())
            return true;//如果匹配成功
        else
            return false;
    }
}
