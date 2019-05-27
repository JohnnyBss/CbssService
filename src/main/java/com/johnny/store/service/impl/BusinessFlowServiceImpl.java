package com.johnny.store.service.impl;

import com.johnny.store.common.DateUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BusinessFlowDTO;
import com.johnny.store.entity.BusinessFlowEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BusinessFlowMapper;
import com.johnny.store.service.BusinessFlowService;
import com.johnny.store.vo.BusinessFlowVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 */
@Service
public class BusinessFlowServiceImpl implements BusinessFlowService {
    @Autowired
    private BusinessFlowMapper businessFlowMapper;

    @Override
    public UnifiedResponse findLatestBusiness(int userID) {
        try {
            List<BusinessFlowVO> modelList = new ArrayList<>();
            String currentDate = DateUtils.getCurrentDateTime().substring(0, 10);
            String fromDate = currentDate + " 00:00:00";
            String toDate = currentDate + " 23:59:59";
            List<BusinessFlowEntity> entityList =  businessFlowMapper.searchLatestBusiness(userID, fromDate, toDate);
            if(entityList == null || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (BusinessFlowEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findReceiveBusiness(int userID) {
        try {
            List<BusinessFlowVO> modelList = new ArrayList<>();
            String currentDate = DateUtils.getCurrentDateTime().substring(0, 10);
            String fromDate = currentDate + " 00:00:00";
            String toDate = currentDate + " 23:59:59";
            List<BusinessFlowEntity> entityList =  businessFlowMapper.search4ReceiveUser(userID, fromDate, toDate);
            if(entityList == null || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (BusinessFlowEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findWaitBusiness4Receive(int userID) {
        try {
            String currentDate = DateUtils.getCurrentDateTime().substring(0, 10);
            String fromDate = currentDate + " 00:00:00";
            String toDate = currentDate + " 23:59:59";
            BusinessFlowEntity entity =  businessFlowMapper.searchWaitBusiness4Receive(userID, fromDate, toDate);
            if(entity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, false);
            }

            return UnifiedResponseManager.buildSuccessResponse(1, true);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findSendBusiness(int userID) {
        try {
            List<BusinessFlowVO> modelList = new ArrayList<>();
            String currentDate = DateUtils.getCurrentDateTime().substring(0, 10);
            String fromDate = currentDate + " 00:00:00";
            String toDate = currentDate + " 23:59:59";
            List<BusinessFlowEntity> entityList =  businessFlowMapper.search4SendUser(userID, fromDate, toDate);
            if(entityList == null || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (BusinessFlowEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse changeStatus(BusinessFlowDTO dto) {
        try {
            BusinessFlowEntity entity = convertDtoToEntity(dto);
            String receiveTime = DateUtils.getCurrentDateTime();
            entity.setReceiveTime(receiveTime);
            int affectRow = businessFlowMapper.updateStatus(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse changeCallBack(BusinessFlowDTO dto) {
        try {
            BusinessFlowEntity entity = convertDtoToEntity(dto);
            int affectRow = businessFlowMapper.updateCallBack(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse changeToComplete(BusinessFlowDTO dto) {
        try {
            String currentDate = DateUtils.getCurrentDateTime();
            BusinessFlowEntity entity = convertDtoToEntity(dto);
            entity.setCompleteTime(currentDate);
            int affectRow = businessFlowMapper.updateToComplete(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BusinessFlowVO> modelList = new ArrayList<>();
            List<BusinessFlowEntity> entityList =  businessFlowMapper.searchList(startIndex, pageSize);
            if(entityList == null || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (BusinessFlowEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int businessID) {
        try {
            BusinessFlowEntity entity =  businessFlowMapper.search(businessID);
            BusinessFlowVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(BusinessFlowDTO dto) {
        try {
            String currentDate = DateUtils.getCurrentDateTime();
            BusinessFlowEntity entity = convertDtoToEntity(dto);
            entity.setSendTime(currentDate);
            entity.setBusinessStatus("0");
            int affectRow = businessFlowMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(BusinessFlowDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }

    @Override
    public BusinessFlowVO convertEntityToVo(BusinessFlowEntity entity) {
        BusinessFlowVO businessFlowVO = new BusinessFlowVO();
        businessFlowVO.setBusinessID(entity.getBusinessID());
        businessFlowVO.setSendUserID(entity.getSendUserID());
        businessFlowVO.setSendUserName(entity.getSendUserName());
        businessFlowVO.setSendUserCellphone(entity.getSendUserCellphone());
        businessFlowVO.setSendUserRole(entity.getSendUserRole());
        businessFlowVO.setSendUserRoleText(entity.getSendUserRoleText());
        businessFlowVO.setSendUserPhoto(entity.getSendUserPhoto());
        businessFlowVO.setSendTime(entity.getSendTime());
        businessFlowVO.setReceiveUserID(entity.getReceiveUserID());
        businessFlowVO.setReceiveUserName(entity.getReceiveUserName());
        businessFlowVO.setReceiveUserCellphone(entity.getReceiveUserCellphone());
        businessFlowVO.setReceiveUserRole(entity.getReceiveUserRole());
        businessFlowVO.setReceiveUserRoleText(entity.getReceiveUserRoleText());
        businessFlowVO.setReceiveUserPhoto(entity.getReceiveUserPhoto());
        businessFlowVO.setReceiveTime(entity.getReceiveTime());
        businessFlowVO.setBusinessStatus(entity.getBusinessStatus());
        businessFlowVO.setBusinessStatusText(entity.getBusinessStatusText());
        businessFlowVO.setCallBackMessage(entity.getCallBackMessage());
        businessFlowVO.setCompleteTime(entity.getCompleteTime());
        businessFlowVO.setCreateUser(entity.getCreateUser());
        businessFlowVO.setCreateTime(entity.getCreateTime());
        businessFlowVO.setEditUser(entity.getEditUser());
        businessFlowVO.setEditTime(entity.getEditTime());
        return businessFlowVO;
    }

    @Override
    public BusinessFlowEntity convertDtoToEntity(BusinessFlowDTO dto) {
        BusinessFlowEntity entity = new BusinessFlowEntity();
        if(null != dto.getBusinessID()){
            entity.setBusinessID(dto.getBusinessID());
        }
        if(null != dto.getSendUserID()){
            entity.setSendUserID(dto.getSendUserID());
        }
        if(null != dto.getReceiveUserID()){
            entity.setReceiveUserID(dto.getReceiveUserID());
        }
        entity.setSendTime(dto.getSendTime());
        entity.setBusinessStatus(dto.getBusinessStatus());
        entity.setReceiveTime(DateUtils.getCurrentDateTime());
        entity.setCallBackMessage(dto.getCallBackMessage());
        entity.setCompleteTime(DateUtils.getCurrentDateTime());
        entity.setCreateUser(dto.getLoginUser());
        entity.setEditUser(dto.getLoginUser());
        return entity;
    }
}
