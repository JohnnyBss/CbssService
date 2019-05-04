package com.johnny.store.vo;

public class ClockStatusVO extends NewBaseVO {
    private Integer clockStatusID;
    private Integer clockUserID;
    private String userName;
    private String cellphone;
    private String userRole;
    private String userRoleText;
    private String userPhoto;
    private String clockUserStatus;
    private String clockUserStatusText;

    public Integer getClockStatusID() {
        return clockStatusID;
    }

    public void setClockStatusID(Integer clockStatusID) {
        this.clockStatusID = clockStatusID;
    }

    public Integer getClockUserID() {
        return clockUserID;
    }

    public void setClockUserID(Integer clockUserID) {
        this.clockUserID = clockUserID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRoleText() {
        return userRoleText;
    }

    public void setUserRoleText(String userRoleText) {
        this.userRoleText = userRoleText;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getClockUserStatus() {
        return clockUserStatus;
    }

    public void setClockUserStatus(String clockUserStatus) {
        this.clockUserStatus = clockUserStatus;
    }

    public String getClockUserStatusText() {
        return clockUserStatusText;
    }

    public void setClockUserStatusText(String clockUserStatusText) {
        this.clockUserStatusText = clockUserStatusText;
    }
}
