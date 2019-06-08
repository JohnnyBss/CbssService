package com.johnny.store.service.impl;

import com.johnny.store.common.DataDifference;
import com.johnny.store.common.DateUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.entity.AnalyseProcessedEntity;
import com.johnny.store.entity.AnalyseSendEntity;
import com.johnny.store.entity.CallBackStatisticEntity;
import com.johnny.store.entity.ClockStatusEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BusinessFlowMapper;
import com.johnny.store.mapper.CallBackStatisticMapper;
import com.johnny.store.mapper.ClockStatusMapper;
import com.johnny.store.service.AnalyseService;
import com.johnny.store.vo.Analyse4FinancialVO;
import com.johnny.store.vo.Analyse4LobbyVO;
import com.johnny.store.vo.AnalyseCallBack4FinancialVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 */
@Service
public class AnalyseServiceImpl implements AnalyseService {
    @Autowired
    private ClockStatusMapper clockStatusMapper;
    @Autowired
    private CallBackStatisticMapper callBackStatisticMapper;
    @Autowired
    private BusinessFlowMapper businessFlowMapper;

    @Override
    public UnifiedResponse analyseFinancialBusiness(String fromDate, String toDate) {
        try {
            List<Analyse4FinancialVO> modelList = new ArrayList<>();

            //取得处理的业务总量
            List<AnalyseProcessedEntity> entityList = businessFlowMapper.analyseProcessedBusiness(fromDate, toDate);
            if(null == entityList || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }

            for (AnalyseProcessedEntity entity : entityList) {
                Analyse4FinancialVO model = new Analyse4FinancialVO();
                model.setFinancialID(entity.getReceiveUserID());
                model.setFinancialName(entity.getReceiveUserName());
                model.setFromDate(fromDate);
                model.setToDate(toDate);
                model.setOrderCount(entity.getTotalCount());
                model.setCallBackAnalyse(getCallBackStatisticList(entity.getReceiveUserID(), "2", fromDate, toDate));
                model.setFreeTime(getClockStatusTime(entity.getReceiveUserID(), "1", fromDate, toDate));
                model.setBusyTime(getClockStatusTime(entity.getReceiveUserID(), "2", fromDate, toDate));
                model.setLeaveTime(getClockStatusTime(entity.getReceiveUserID(), "3", fromDate, toDate));
                model.setOffDutyTime(getClockStatusTime(entity.getReceiveUserID(), "4", fromDate, toDate));
                modelList.add(model);
            }

            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse analyseLobbyBusiness(String fromDate, String toDate) {
        try{
            List<Analyse4LobbyVO> modelList = new ArrayList<>();

            //取得处理的业务总量
            List<AnalyseSendEntity> entityList = businessFlowMapper.analyseSendBusiness(fromDate, toDate);
            if(null == entityList || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }

            for (AnalyseSendEntity entity : entityList) {
                Analyse4LobbyVO model = new Analyse4LobbyVO();
                model.setLobbyID(entity.getSendUserID());
                model.setLobbyName(entity.getSendUserName());
                model.setSendTotalCount(entity.getSendTotalCount());
                model.setCallbackTotalCount(entity.getCallbackTotalCount());
                model.setOffDutyTime(getClockStatusTime(entity.getSendUserID(), "4", fromDate, toDate));
                model.setCallBackAnalyse(getCallBackStatisticList(entity.getSendUserID(), "3", fromDate, toDate));
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        }catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public DataDifference getClockStatusTime(int userID, String clockStatus, String fromDate, String toDate) throws ParseException {
        DataDifference statusTotalTime = new DataDifference();
        List<ClockStatusEntity> waitAnalyseClockEntityList = new ArrayList<>();

        //取得该人员指定时间范围内所有的打卡数据
        List<ClockStatusEntity> allClockEntityList =  clockStatusMapper.searchByContent(userID, fromDate, toDate);
        if(allClockEntityList == null || allClockEntityList.size() == 0){
            return null;
        }

        //从所有打卡数据中取得指定状态的打卡数据
        for (ClockStatusEntity clockStatusEntity : allClockEntityList) {
            if(clockStatusEntity.getClockUserStatus().equals(clockStatus)){
                waitAnalyseClockEntityList.add(clockStatusEntity);
            }
        }

        //计算待分析打卡状态的总计时间
        for (ClockStatusEntity currentWaitClockEntity : waitAnalyseClockEntityList) {
            int currentClockID = currentWaitClockEntity.getClockStatusID();
            String currentClockTime = currentWaitClockEntity.getCreateTime();
            String nextClockTime = null;

            for (int i = 0; i < allClockEntityList.size(); i++) {
                if(allClockEntityList.get(i).getClockStatusID() == currentClockID){
                    if(i + 1 >= allClockEntityList.size()){
                        break;
                    }
                    nextClockTime = allClockEntityList.get(i+1).getCreateTime();
                    break;
                }
            }

            if(nextClockTime != null){
                DataDifference dataDifference = DateUtils.difference(currentClockTime, nextClockTime);
                statusTotalTime.setDay(statusTotalTime.getDay() + dataDifference.getDay());
                statusTotalTime.setHour(statusTotalTime.getHour() + dataDifference.getHour());
                statusTotalTime.setMin(statusTotalTime.getMin() + dataDifference.getMin());
                statusTotalTime.setSeconds(statusTotalTime.getSeconds() + dataDifference.getSeconds());
            }

        }

        return DateUtils.convertToStandard(statusTotalTime.getDay(), statusTotalTime.getHour(), statusTotalTime.getMin(), statusTotalTime.getSeconds());
    }

    private List<AnalyseCallBack4FinancialVO> getCallBackStatisticList(int userID, String userRole, String fromDate, String toDate){
        List<AnalyseCallBack4FinancialVO> modelList = new ArrayList<>();
        List<CallBackStatisticEntity> callBackBusinessEntityList;

        if("3".equals(userRole)){
            callBackBusinessEntityList = callBackStatisticMapper.searchProcessedCallBack(userID, fromDate, toDate);
        }else{
            callBackBusinessEntityList = callBackStatisticMapper.searchSendCallBack(userID, fromDate, toDate);
        }

        if (callBackBusinessEntityList == null || callBackBusinessEntityList.size() == 0) {
            return null;
        }

        for (CallBackStatisticEntity callBackStatisticEntity : callBackBusinessEntityList) {
            AnalyseCallBack4FinancialVO model = new AnalyseCallBack4FinancialVO();
            model.setCallBackID(callBackStatisticEntity.getCallbackID());
            model.setCallBackMessage(callBackStatisticEntity.getCallbackMessage());
            model.setTotalCount(callBackStatisticEntity.getTotalCount());
            modelList.add(model);
        }
        return modelList;
    }
}
