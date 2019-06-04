package com.johnny.store.dto;

public class BusinessHurryUpDTO extends BaseDTO {
    private Integer hurryUpID;
    private Integer sendUserID;
    private Integer receiveUserID;
    private Integer businessID;
    private String hurryUpStatus;

    public Integer getHurryUpID() {
        return hurryUpID;
    }

    public void setHurryUpID(Integer hurryUpID) {
        this.hurryUpID = hurryUpID;
    }

    public Integer getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Integer businessID) {
        this.businessID = businessID;
    }

    public String getHurryUpStatus() {
        return hurryUpStatus;
    }

    public void setHurryUpStatus(String hurryUpStatus) {
        this.hurryUpStatus = hurryUpStatus;
    }

    public Integer getSendUserID() {
        return sendUserID;
    }

    public void setSendUserID(Integer sendUserID) {
        this.sendUserID = sendUserID;
    }

    public Integer getReceiveUserID() {
        return receiveUserID;
    }

    public void setReceiveUserID(Integer receiveUserID) {
        this.receiveUserID = receiveUserID;
    }
}
