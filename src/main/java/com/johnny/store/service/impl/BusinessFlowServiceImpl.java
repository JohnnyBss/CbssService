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
    public UnifiedResponse findBusinessFlow4Receiver(int pageNumber, int pageSize, int receiveUserID) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BusinessFlowVO> modelList = new ArrayList<>();
            List<BusinessFlowEntity> entityList =  businessFlowMapper.search4ReceiveUser(startIndex, pageSize, receiveUserID);
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
            int affectRow = businessFlowMapper.updateStatus(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse changeToComplete(BusinessFlowDTO dto) {
        try {
            BusinessFlowEntity entity = convertDtoToEntity(dto);
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
            BusinessFlowEntity entity = convertDtoToEntity(dto);
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
        entity.setCompleteTime(DateUtils.getCurrentDateTime());
        entity.setCreateUser(dto.getLoginUser());
        entity.setEditUser(dto.getLoginUser());
        return entity;
    }
}
