package com.johnny.store.entity;

public class SystemNameEntity extends BaseEntity {
    private int sysNameID;
    private int bankID;
    private int branchID;
    private String sysName;

    public int getSysNameID() {
        return sysNameID;
    }

    public void setSysNameID(int sysNameID) {
        this.sysNameID = sysNameID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }
}
