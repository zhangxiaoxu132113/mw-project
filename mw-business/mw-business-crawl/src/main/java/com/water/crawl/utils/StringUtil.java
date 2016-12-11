package com.water.crawl.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mrwater on 2016/11/27.
 */
public class StringUtil {

    /**
     * 获取网站的一级域名
     *
     * @param url
     * @return
     * @throws MalformedURLException
     */
    public static String getTopDomainWithoutSubdomain(String url) throws MalformedURLException {
        String host = new URL(url).getHost().toLowerCase();// 此处获取值转换为小写
        Pattern pattern = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
        Matcher matcher = pattern.matcher(host);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * unicode编码
     *
     * @param str
     * @return
     */
    public static String decodeUnicode(String str) {
        Charset set = Charset.forName("UTF-16");
        Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
        Matcher m = p.matcher( str );
        int start = 0 ;
        int start2 = 0 ;
        StringBuffer sb = new StringBuffer();
        while( m.find( start ) ) {
            start2 = m.start() ;
            if( start2 > start ){
                String seg = str.substring(start, start2) ;
                sb.append( seg );
            }
            String code = m.group( 1 );
            int i = Integer.valueOf( code , 16 );
            byte[] bb = new byte[ 4 ] ;
            bb[ 0 ] = (byte) ((i >> 8) & 0xFF );
            bb[ 1 ] = (byte) ( i & 0xFF ) ;
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append( String.valueOf( set.decode(b) ).trim() );
            start = m.end() ;
        }
        start2 = str.length() ;
        if( start2 > start ){
            String seg = str.substring(start, start2) ;
            sb.append( seg );
        }
        return sb.toString() ;
    }


    public static void main(String[] args) {
        String url = "http://localhost:8080";
        Pattern p = Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        System.out.println(matcher.group());
    }
}
