package com.bawie.zk.bean;

import java.util.ArrayList;

public class MyBeans {

    public int status;
    public String info;
    public ArrayList<DataEns> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<DataEns> getData() {
        return data;
    }

    public void setData(ArrayList<DataEns> data) {
        this.data = data;
    }

    public static class DataEns{
         /*  "news_id": "13786",
                   "news_summary": "“视野、品质、融合是中国展览工程走向国际化的必由路径。”北京逸格天骄国际展览有限公司副总经理李益日前在第二十二届国际(常",
                   "news_title": "李益：视野、品质、融合是展览工程国际化的必由路径",
                   "pic_url": "*/

        private String news_id;
        private String news_summary;
        private String news_title;
        private String pic_url;

        public String getNews_id() {
            return news_id;
        }

        public void setNews_id(String news_id) {
            this.news_id = news_id;
        }

        public String getNews_summary() {
            return news_summary;
        }

        public void setNews_summary(String news_summary) {
            this.news_summary = news_summary;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public DataEns(String news_id, String news_summary, String news_title, String pic_url) {
            this.news_id = news_id;
            this.news_summary = news_summary;
            this.news_title = news_title;
            this.pic_url = pic_url;
        }

        @Override
        public String toString() {
            return "DataEns{" +
                    "news_id='" + news_id + '\'' +
                    ", news_summary='" + news_summary + '\'' +
                    ", news_title='" + news_title + '\'' +
                    ", pic_url='" + pic_url + '\'' +
                    '}';
        }
    }
}
