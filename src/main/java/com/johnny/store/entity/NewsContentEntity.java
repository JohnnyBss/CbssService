package com.johnny.store.entity;

public class NewsContentEntity extends BaseEntity {
    private int newsContentID;
    private int newsID;
    private String newsContentType;
    private String newsContent;

    public int getNewsContentID() {
        return newsContentID;
    }

    public void setNewsContentID(int newsContentID) {
        this.newsContentID = newsContentID;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getNewsContentType() {
        return newsContentType;
    }

    public void setNewsContentType(String newsContentType) {
        this.newsContentType = newsContentType;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
