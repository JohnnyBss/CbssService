package com.johnny.store.vo;

import com.johnny.store.common.DataDifference;
import java.util.List;

public class Analyse4LobbyVO {
    private Integer lobbyID;
    private String lobbyName;
    private Integer sendTotalCount;
    private Integer callbackTotalCount;
    private DataDifference offDutyTime;
    private List<AnalyseCallBack4FinancialVO> callBackAnalyse;

    public Integer getLobbyID() {
        return lobbyID;
    }

    public void setLobbyID(Integer lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public Integer getSendTotalCount() {
        return sendTotalCount;
    }

    public void setSendTotalCount(Integer sendTotalCount) {
        this.sendTotalCount = sendTotalCount;
    }

    public Integer getCallbackTotalCount() {
        return callbackTotalCount;
    }

    public void setCallbackTotalCount(Integer callbackTotalCount) {
        this.callbackTotalCount = callbackTotalCount;
    }

    public DataDifference getOffDutyTime() {
        return offDutyTime;
    }

    public void setOffDutyTime(DataDifference offDutyTime) {
        this.offDutyTime = offDutyTime;
    }

    public List<AnalyseCallBack4FinancialVO> getCallBackAnalyse() {
        return callBackAnalyse;
    }

    public void setCallBackAnalyse(List<AnalyseCallBack4FinancialVO> callBackAnalyse) {
        this.callBackAnalyse = callBackAnalyse;
    }
}
