package com.johnny.store.dto;

public class ReverseSequenceDTO extends BaseDTO {
    private int firstDetailID;
    private int secondDetailID;

    public int getFirstDetailID() {
        return firstDetailID;
    }

    public void setFirstDetailID(int firstDetailID) {
        this.firstDetailID = firstDetailID;
    }

    public int getSecondDetailID() {
        return secondDetailID;
    }

    public void setSecondDetailID(int secondDetailID) {
        this.secondDetailID = secondDetailID;
    }
}
