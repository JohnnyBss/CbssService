package com.johnny.store.vo;

public class DetailVO extends BaseVO {
    private int detailID;
    private int bankID;
    private BankVO bankVO;
    private int branchID;
    private BranchVO branchVO;
    private int itemID;
    private ItemVO itemVO;
    private int sequence;
    private String animation;
    private String contentType;
    private String content;
    private int textMapDetail;
    private int year;
    private int quarter;

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }

    public int getTextMapDetail() {
        return textMapDetail;
    }

    public void setTextMapDetail(int textMapDetail) {
        this.textMapDetail = textMapDetail;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public ItemVO getItemVO() {
        return itemVO;
    }

    public void setItemVO(ItemVO itemVO) {
        this.itemVO = itemVO;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public BranchVO getBranchVO() {
        return branchVO;
    }

    public void setBranchVO(BranchVO branchVO) {
        this.branchVO = branchVO;
    }
}
