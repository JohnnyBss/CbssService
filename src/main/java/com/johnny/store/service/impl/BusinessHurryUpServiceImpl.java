package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BusinessHurryUpDTO;
import com.johnny.store.entity.BusinessHurryUpEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BusinessHurryUpMapper;
import com.johnny.store.service.BusinessHurryUpService;
import com.johnny.store.vo.BusinessHurryUpVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessHurryUpServiceImpl implements BusinessHurryUpService {
    @Autowired
    private BusinessHurryUpMapper myMapper;

    @Override
    public UnifiedResponse findOfReceiver(int receiveUserID) {
        try {
            BusinessHurryUpVO model;
            BusinessHurryUpEntity entity =  myMapper.searchOfReceiver(receiveUserID);
            if(entity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(1, model);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse find(int id) {
        return null;
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(BusinessHurryUpDTO dto) {
        try {
            BusinessHurryUpEntity entity = convertDtoToEntity(dto);
            int affectRow = myMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(BusinessHurryUpDTO dto) {
        try {
            BusinessHurryUpEntity entity = convertDtoToEntity(dto);
            int affectRow = myMapper.update(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }

    @Override
    public BusinessHurryUpVO convertEntityToVo(BusinessHurryUpEntity entity) {
        BusinessHurryUpVO myVO = new BusinessHurryUpVO();
        myVO.setHurryUpID(entity.getHurryUpID());
        myVO.setSendUserID(entity.getSendUserID());
        myVO.setSendUserName(entity.getSendUserName());
        myVO.setSendUserPhoto(entity.getSendUserPhoto());
        myVO.setReceiveUserID(entity.getReceiveUserID());
        myVO.setReceiveUserName(entity.getReceiveUserName());
        myVO.setBusinessID(entity.getBusinessID());
        myVO.setHurryUpStatus(entity.getHurryUpStatus());
        myVO.setCreateUser(entity.getCreateUser());
        myVO.setCreateTime(entity.getCreateTime());
        myVO.setEditUser(entity.getEditUser());
        myVO.setEditTime(entity.getEditTime());
        return myVO;
    }

    @Override
    public BusinessHurryUpEntity convertDtoToEntity(BusinessHurryUpDTO dto) {
        BusinessHurryUpEntity myEntity = new BusinessHurryUpEntity();
        if(null != dto.getHurryUpID()){
            myEntity.setHurryUpID(dto.getHurryUpID());
        }
        if(null != dto.getSendUserID()){
            myEntity.setSendUserID(dto.getSendUserID());
        }
        if(null != dto.getReceiveUserID()){
            myEntity.setReceiveUserID(dto.getReceiveUserID());
        }
        if(null != dto.getBusinessID()){
            myEntity.setBusinessID(dto.getBusinessID());
        }
        myEntity.setHurryUpStatus(dto.getHurryUpStatus());
        myEntity.setCreateUser(dto.getLoginUser());
        myEntity.setEditUser(dto.getLoginUser());
        return myEntity;
    }
}
