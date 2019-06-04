package com.johnny.store.entity;

public class CallBackMappingEntity extends NewBaseEntity {
    private int callBackID;
    private String callBackMessage;

    public int getCallBackID() {
        return callBackID;
    }

    public void setCallBackID(int callBackID) {
        this.callBackID = callBackID;
    }

    public String getCallBackMessage() {
        return callBackMessage;
    }

    public void setCallBackMessage(String callBackMessage) {
        this.callBackMessage = callBackMessage;
    }
}
