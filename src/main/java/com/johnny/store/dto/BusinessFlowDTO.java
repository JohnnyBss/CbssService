package com.johnny.store.dto;

public class BusinessFlowDTO extends BaseDTO {
    private Integer businessID;
    private Integer sendUserID;
    private String sendTime;
    private Integer receiveUserID;
    private String receiveTime;
    private String businessStatus;
    private Integer callBackID;
    private String otherCallBackMsg;
    private String completeTime;
    public Integer getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Integer businessID) {
        this.businessID = businessID;
    }

    public Integer getSendUserID() {
        return sendUserID;
    }

    public void setSendUserID(Integer sendUserID) {
        this.sendUserID = sendUserID;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getReceiveUserID() {
        return receiveUserID;
    }

    public void setReceiveUserID(Integer receiveUserID) {
        this.receiveUserID = receiveUserID;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getOtherCallBackMsg() {
        return otherCallBackMsg;
    }

    public void setOtherCallBackMsg(String otherCallBackMsg) {
        this.otherCallBackMsg = otherCallBackMsg;
    }

    public Integer getCallBackID() {
        return callBackID;
    }

    public void setCallBackID(Integer callBackID) {
        this.callBackID = callBackID;
    }
}
