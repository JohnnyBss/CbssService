package com.johnny.store.vo;

import com.johnny.store.common.DataDifference;

import java.util.List;

public class Analyse4FinancialVO {
    private Integer financialID;
    private String financialName;
    private String fromDate;
    private String toDate;
    private Integer orderCount;
    private DataDifference freeTime;
    private DataDifference busyTime;
    private DataDifference leaveTime;
    private DataDifference offDutyTime;
    private List<AnalyseCallBack4FinancialVO> callBackAnalyse;

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public DataDifference getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(DataDifference freeTime) {
        this.freeTime = freeTime;
    }

    public DataDifference getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(DataDifference busyTime) {
        this.busyTime = busyTime;
    }

    public DataDifference getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(DataDifference leaveTime) {
        this.leaveTime = leaveTime;
    }

    public DataDifference getOffDutyTime() {
        return offDutyTime;
    }

    public void setOffDutyTime(DataDifference offDutyTime) {
        this.offDutyTime = offDutyTime;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public List<AnalyseCallBack4FinancialVO> getCallBackAnalyse() {
        return callBackAnalyse;
    }

    public void setCallBackAnalyse(List<AnalyseCallBack4FinancialVO> callBackAnalyse) {
        this.callBackAnalyse = callBackAnalyse;
    }

    public Integer getFinancialID() {
        return financialID;
    }

    public void setFinancialID(Integer financialID) {
        this.financialID = financialID;
    }

    public String getFinancialName() {
        return financialName;
    }

    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }
}
