package com.johnny.store.dto;

public class ClockStatusDTO extends BaseDTO {
    private Integer clockStatusID;
    private Integer clockUserID;
    private String clockUserStatus;

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

    public String getClockUserStatus() {
        return clockUserStatus;
    }

    public void setClockUserStatus(String clockUserStatus) {
        this.clockUserStatus = clockUserStatus;
    }
}
