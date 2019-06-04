package com.johnny.store.vo;

public class BusinessFlowVO extends NewBaseVO {
    private Integer businessID;
    private Integer sendUserID;
    private String sendUserName;
    private String sendUserCellphone;
    private String sendUserRole;
    private String sendUserRoleText;
    private String sendUserPhoto;
    private String sendTime;

    private Integer receiveUserID;
    private String receiveUserName;
    private String receiveUserCellphone;
    private String receiveUserRole;
    private String receiveUserRoleText;
    private String receiveUserPhoto;
    private String receiveTime;

    private String businessStatus;
    private String businessStatusText;
    private Integer callBackID;
    private String callBackMsg;
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

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getSendUserCellphone() {
        return sendUserCellphone;
    }

    public void setSendUserCellphone(String sendUserCellphone) {
        this.sendUserCellphone = sendUserCellphone;
    }

    public String getSendUserRole() {
        return sendUserRole;
    }

    public void setSendUserRole(String sendUserRole) {
        this.sendUserRole = sendUserRole;
    }

    public String getSendUserRoleText() {
        return sendUserRoleText;
    }

    public void setSendUserRoleText(String sendUserRoleText) {
        this.sendUserRoleText = sendUserRoleText;
    }

    public String getSendUserPhoto() {
        return sendUserPhoto;
    }

    public void setSendUserPhoto(String sendUserPhoto) {
        this.sendUserPhoto = sendUserPhoto;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public String getReceiveUserCellphone() {
        return receiveUserCellphone;
    }

    public void setReceiveUserCellphone(String receiveUserCellphone) {
        this.receiveUserCellphone = receiveUserCellphone;
    }

    public String getReceiveUserRole() {
        return receiveUserRole;
    }

    public void setReceiveUserRole(String receiveUserRole) {
        this.receiveUserRole = receiveUserRole;
    }

    public String getReceiveUserRoleText() {
        return receiveUserRoleText;
    }

    public void setReceiveUserRoleText(String receiveUserRoleText) {
        this.receiveUserRoleText = receiveUserRoleText;
    }

    public String getReceiveUserPhoto() {
        return receiveUserPhoto;
    }

    public void setReceiveUserPhoto(String receiveUserPhoto) {
        this.receiveUserPhoto = receiveUserPhoto;
    }

    public String getBusinessStatusText() {
        return businessStatusText;
    }

    public void setBusinessStatusText(String businessStatusText) {
        this.businessStatusText = businessStatusText;
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

    public String getCallBackMsg() {
        return callBackMsg;
    }

    public void setCallBackMsg(String callBackMsg) {
        this.callBackMsg = callBackMsg;
    }
}
