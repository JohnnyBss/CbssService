package com.johnny.store.vo;

public class CallBackMappingVO extends NewBaseVO {
    private Integer callBackID;
    private String callBackMessage;

    public Integer getCallBackID() {
        return callBackID;
    }

    public void setCallBackID(Integer callBackID) {
        this.callBackID = callBackID;
    }

    public String getCallBackMessage() {
        return callBackMessage;
    }

    public void setCallBackMessage(String callBackMessage) {
        this.callBackMessage = callBackMessage;
    }
}
