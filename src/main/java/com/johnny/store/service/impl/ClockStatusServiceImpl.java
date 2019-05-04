package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ClockStatusDTO;
import com.johnny.store.entity.ClockStatusEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ClockStatusMapper;
import com.johnny.store.service.ClockStatusService;
import com.johnny.store.vo.ClockStatusVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 */
@Service
public class ClockStatusServiceImpl implements ClockStatusService {

    @Autowired
    private ClockStatusMapper clockStatusMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ClockStatusVO> modelList = new ArrayList<>();
            List<ClockStatusEntity> entityList =  clockStatusMapper.searchCurrentClockStatus(startIndex, pageSize);
            if(entityList == null || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (ClockStatusEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int userID) {
        try {
            ClockStatusEntity entity =  clockStatusMapper.search(userID);
            ClockStatusVO model = convertEntityToVo(entity);
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
    public UnifiedResponse add(ClockStatusDTO dto) {
        try {
            ClockStatusEntity entity = convertDtoToEntity(dto);
            int affectRow = clockStatusMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(ClockStatusDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int clockStatusID) {
        try {
            int affectRow = clockStatusMapper.delete(clockStatusID);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public ClockStatusVO convertEntityToVo(ClockStatusEntity entity) {
        ClockStatusVO clockStatusVO = new ClockStatusVO();
        clockStatusVO.setClockStatusID(entity.getClockStatusID());
        clockStatusVO.setClockUserID(entity.getClockUserID());
        clockStatusVO.setUserName(entity.getUserName());
        clockStatusVO.setCellphone(entity.getCellphone());
        clockStatusVO.setUserRole(entity.getUserRole());
        clockStatusVO.setUserRoleText(entity.getUserRoleText());
        clockStatusVO.setUserPhoto(entity.getUserPhoto());
        clockStatusVO.setClockUserStatus(entity.getClockUserStatus());
        clockStatusVO.setClockUserStatusText(entity.getClockUserStatusText());
        clockStatusVO.setCreateUser(entity.getCreateUser());
        clockStatusVO.setCreateTime(entity.getCreateTime());
        clockStatusVO.setEditUser(entity.getEditUser());
        clockStatusVO.setEditTime(entity.getEditTime());
        return clockStatusVO;
    }

    @Override
    public ClockStatusEntity convertDtoToEntity(ClockStatusDTO dto) {
        ClockStatusEntity clockStatusEntity = new ClockStatusEntity();
        if(null != dto.getClockStatusID()){
            clockStatusEntity.setClockStatusID(dto.getClockStatusID());
        }
        clockStatusEntity.setClockUserID(dto.getClockUserID());
        clockStatusEntity.setClockUserStatus(dto.getClockUserStatus());
        clockStatusEntity.setCreateUser(dto.getLoginUser());
        clockStatusEntity.setEditUser(dto.getLoginUser());
        return clockStatusEntity;
    }
}
