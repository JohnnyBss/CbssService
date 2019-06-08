package com.johnny.store.entity;

public class AnalyseSendEntity {
    private int sendUserID;
    private String sendUserName;
    private int sendTotalCount;
    private int callbackTotalCount;

    public int getSendUserID() {
        return sendUserID;
    }

    public void setSendUserID(int sendUserID) {
        this.sendUserID = sendUserID;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public int getSendTotalCount() {
        return sendTotalCount;
    }

    public void setSendTotalCount(int sendTotalCount) {
        this.sendTotalCount = sendTotalCount;
    }

    public int getCallbackTotalCount() {
        return callbackTotalCount;
    }

    public void setCallbackTotalCount(int callbackTotalCount) {
        this.callbackTotalCount = callbackTotalCount;
    }
}
