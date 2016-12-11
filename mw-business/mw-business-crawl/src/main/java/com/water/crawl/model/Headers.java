package com.water.crawl.model;

import java.util.ArrayList;

/**
 * Created by mrwater on 2016/12/11.
 */
public class Headers extends ArrayList {

    private static Headers headerList = new Headers();

    public static class Header {
        private String name;
        private String value;
        private static Header header;
        public Header() {
        }

        public Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static Header newInstance() {
            if (header == null) {
                header = new Header();
            }
            return header;
        }

        public Header add(String name, String value) {
            headerList.add(new Header(name, value));
            return this;
        }

        public Headers builder() {
            return headerList;
        }
    }
}
