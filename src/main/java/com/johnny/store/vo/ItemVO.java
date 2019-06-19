package com.johnny.store.vo;

public class ItemVO extends BaseVO {
    private int itemID;
    private String itemName;
    private int bankID;
    private BankVO bankVO;
    private int branchID;
    private BranchVO branchVO;
    private int parentItemID;
    private int itemOrder;
    private String itemType;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public int getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(int parentItemID) {
        this.parentItemID = parentItemID;
    }

    public BankVO getBankVO() {
        return bankVO;
    }

    public void setBankVO(BankVO bankVO) {
        this.bankVO = bankVO;
    }

    public BranchVO getBranchVO() {
        return branchVO;
    }

    public void setBranchVO(BranchVO branchVO) {
        this.branchVO = branchVO;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
    }
}
