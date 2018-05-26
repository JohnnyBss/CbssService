package com.johnny.store.dto;

public class LogoDTO extends BaseDTO {
    private int logoID;
    private int bankID;
    private int branchID;
    private String logoUrl;
    private String status;

    public int getLogoID() {
        return logoID;
    }

    public void setLogoID(int logoID) {
        this.logoID = logoID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
