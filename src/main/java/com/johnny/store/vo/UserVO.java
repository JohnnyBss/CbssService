package com.johnny.store.vo;

public class UserVO extends BaseVO {
    private int userID;
    private int bankID;
    private int branchID;
    private String userName;
    private String userRole;
    private String userRoleText;
    private String cellphone;
    private String userPhoto;
    private String userResume;
    private String password;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserRoleText() {
        return userRoleText;
    }

    public void setUserRoleText(String userRoleText) {
        this.userRoleText = userRoleText;
    }

    public String getUserResume() {
        return userResume;
    }

    public void setUserResume(String userResume) {
        this.userResume = userResume;
    }
}
