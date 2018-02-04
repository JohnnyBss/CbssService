package com.johnny.store.vo;

public class ItemPromotionVO {
    private int itemPromotionID;
    private int itemID;
    private String itemCode;
    private String itemShortDescriptionEN;
    private String itemShortDescriptionCN;
    private Double unitPrice4RMB;
    private Double promotionPrice4RMB;
    private Double unitPrice4USD;
    private Double promotionPrice4USD;
    private String itemImageUrl;
    private String startDate;
    private String endDate;
    private String status;
    private String statusText;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getItemPromotionID() {
        return itemPromotionID;
    }

    public void setItemPromotionID(int itemPromotionID) {
        this.itemPromotionID = itemPromotionID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemShortDescriptionCN() {
        return itemShortDescriptionCN;
    }

    public void setItemShortDescriptionCN(String itemShortDescriptionCN) {
        this.itemShortDescriptionCN = itemShortDescriptionCN;
    }

    public String getItemShortDescriptionEN() {
        return itemShortDescriptionEN;
    }

    public void setItemShortDescriptionEN(String itemShortDescriptionEN) {
        this.itemShortDescriptionEN = itemShortDescriptionEN;
    }

    public Double getUnitPrice4RMB() {
        return unitPrice4RMB;
    }

    public void setUnitPrice4RMB(Double unitPrice4RMB) {
        this.unitPrice4RMB = unitPrice4RMB;
    }

    public Double getPromotionPrice4RMB() {
        return promotionPrice4RMB;
    }

    public void setPromotionPrice4RMB(Double promotionPrice4RMB) {
        this.promotionPrice4RMB = promotionPrice4RMB;
    }

    public Double getUnitPrice4USD() {
        return unitPrice4USD;
    }

    public void setUnitPrice4USD(Double unitPrice4USD) {
        this.unitPrice4USD = unitPrice4USD;
    }

    public Double getPromotionPrice4USD() {
        return promotionPrice4USD;
    }

    public void setPromotionPrice4USD(Double promotionPrice4USD) {
        this.promotionPrice4USD = promotionPrice4USD;
    }
}
