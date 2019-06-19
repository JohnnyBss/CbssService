package com.johnny.store.dto;

public class ItemOrderDTO extends BaseDTO  {
    private Integer bankID;
    private Integer branchID;
    private Integer parentItemID;
    private String itemsOrder;

    public Integer getBankID() {
        return bankID;
    }

    public void setBankID(Integer bankID) {
        this.bankID = bankID;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public Integer getParentItemID() {
        return parentItemID;
    }

    public void setParentItemID(Integer parentItemID) {
        this.parentItemID = parentItemID;
    }

    public String getItemsOrder() {
        return itemsOrder;
    }

    public void setItemsOrder(String itemsOrder) {
        this.itemsOrder = itemsOrder;
    }
}
