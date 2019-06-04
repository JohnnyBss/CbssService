package com.johnny.store.entity;

public class BusinessHurryUpEntity extends NewBaseEntity{
    private int hurryUpID;
    private int sendUserID;
    private String sendUserName;
    private String sendUserPhoto;
    private int receiveUserID;
    private String receiveUserName;
    private int businessID;
    private String hurryUpStatus;

    public int getHurryUpID() {
        return hurryUpID;
    }

    public void setHurryUpID(int hurryUpID) {
        this.hurryUpID = hurryUpID;
    }

    public int getBusinessID() {
        return businessID;
    }

    public void setBusinessID(int businessID) {
        this.businessID = businessID;
    }

    public String getHurryUpStatus() {
        return hurryUpStatus;
    }

    public void setHurryUpStatus(String hurryUpStatus) {
        this.hurryUpStatus = hurryUpStatus;
    }

    public int getSendUserID() {
        return sendUserID;
    }

    public void setSendUserID(int sendUserID) {
        this.sendUserID = sendUserID;
    }

    public int getReceiveUserID() {
        return receiveUserID;
    }

    public void setReceiveUserID(int receiveUserID) {
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
