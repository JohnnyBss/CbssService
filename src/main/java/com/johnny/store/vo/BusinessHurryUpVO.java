package com.johnny.store.vo;

public class BusinessHurryUpVO extends NewBaseVO {
    private Integer hurryUpID;
    private Integer sendUserID;
    private Integer receiveUserID;
    private String sendUserName;
    private String sendUserPhoto;
    private String receiveUserName;
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

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public String getSendUserPhoto() {
        return sendUserPhoto;
    }

    public void setSendUserPhoto(String sendUserPhoto) {
        this.sendUserPhoto = sendUserPhoto;
    }
}
