package com.johnny.store.entity;


public class AnalyseProcessedEntity {
    private int receiveUserID;
    private String receiveUserName;
    private int totalCount;

    public int getReceiveUserID() {
        return receiveUserID;
    }

    public void setReceiveUserID(int receiveUserID) {
        this.receiveUserID = receiveUserID;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
