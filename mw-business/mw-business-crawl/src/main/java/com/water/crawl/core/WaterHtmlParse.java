package com.water.crawl.core;


import org.apache.commons.lang3.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrwater on 16/5/25.
 */
public class WaterHtmlParse {

    /**
     * @param httpBody
     * @return
     * @descriptino 获取页面的img标签的src属性对应的值
     */
    public static List<String> getImgSrc(String httpBody) {
        if (httpBody == null && "".equals(httpBody)) return null;
        List<String> imageSrcList = new ArrayList<String>();
        try {
            Parser parser = new Parser(httpBody);
            NodeFilter nodeFilter = new TagNameFilter("img");
            NodeList nodeImgList = parser.extractAllNodesThatMatch(nodeFilter);
            Node eachNode = null;
            ImageTag imageTag = null;

            //遍历存在的img标签
            if (nodeImgList != null && nodeImgList.size() > 0) {
                for (int i = 0; i < nodeImgList.size(); i++) {
                    eachNode = nodeImgList.elementAt(i);
                    if (eachNode instanceof ImageTag) {
                        imageTag = (ImageTag) eachNode;
                        String imageSrc = imageTag.getAttribute("src");
                        if (imageSrc != null && !imageSrc.equals("")) {
                            imageSrcList.add(imageSrc);
                        }
                    }
                }
            }

            return imageSrcList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param htmlBody
     * @return
     * @descriptino 获取页面的a标签的href属性对应的值
     */
    public static List<String> getHrefWithA(String htmlBody) {
        List<String> hrefLists = new ArrayList<String>();

        try {
            Parser parser = new Parser(htmlBody);
            NodeFilter nodeFilter = new TagNameFilter("a");
            NodeList nodeList = parser.extractAllNodesThatMatch(nodeFilter);

            Node eachNode = null;
            LinkTag linkTag = null;

            if (nodeList != null && nodeList.size() > 0) {
                for (int i = 0; i < nodeList.size(); i++) {
                    eachNode = nodeList.elementAt(i);
                    if (eachNode instanceof LinkTag) {
                        linkTag = (LinkTag) eachNode;
                        String href = linkTag.getAttribute("href");
                        if (StringUtils.isNotBlank(href)) { //如果href标签为空，则不添加到集合中
                            System.out.println("href = " + href);
                            hrefLists.add(href);
                        }
                    }
                }
            }
            return hrefLists;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hrefLists;
    }
}
