package com.johnny.store.vo;

import java.util.List;

public class NewsVO extends BaseVO {
    private int newsID;
    private int bankID;
    private BankVO bankVO;
    private int branchID;
    private BranchVO branchVO;
    private String thumbnailUrl;
    private String newsTitle;
    private String newsDate;
    private String status;
    private List<NewsContentVO> newsContentList;

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }

    public BranchVO getBranchVO() {
        return branchVO;
    }

    public void setBranchVO(BranchVO branchVO) {
        this.branchVO = branchVO;
    }

    public List<NewsContentVO> getNewsContentList() {
        return newsContentList;
    }

    public void setNewsContentList(List<NewsContentVO> newsContentList) {
        this.newsContentList = newsContentList;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }
}
