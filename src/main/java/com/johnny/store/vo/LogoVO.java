package com.johnny.store.vo;

public class LogoVO extends BaseVO {
    private int logoID;
    private int bankID;
    private BankVO bankVO;
    private int branchID;
    private String logoUrl;
    private BranchVO branchVO;
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

    public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public BranchVO getBranchVO() {
        return branchVO;
    }

    public void setBranchVO(BranchVO branchVO) {
        this.branchVO = branchVO;
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
