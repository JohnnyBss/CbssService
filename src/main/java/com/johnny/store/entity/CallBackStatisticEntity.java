package com.johnny.store.entity;

public class CallBackStatisticEntity {
    private int callbackID;
    private String callbackMessage;
    private int totalCount;

    public int getCallbackID() {
        return callbackID;
    }

    public void setCallbackID(int callbackID) {
        this.callbackID = callbackID;
    }

    public String getCallbackMessage() {
        return callbackMessage;
    }

    public void setCallbackMessage(String callbackMessage) {
        this.callbackMessage = callbackMessage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
