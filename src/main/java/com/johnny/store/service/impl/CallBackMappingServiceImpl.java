package com.johnny.store.service.impl;

import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CallBackMappingDTO;
import com.johnny.store.entity.CallBackMappingEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CallBackMappingMapper;
import com.johnny.store.service.CallBackMappingService;
import com.johnny.store.vo.CallBackMappingVO;
import com.johnny.store.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallBackMappingServiceImpl implements CallBackMappingService {
    @Autowired
    private CallBackMappingMapper myMapper;
    private Logger logger = LogManager.getLogger(CallBackMappingServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<CallBackMappingVO> modelList = new ArrayList<>();
            int totalCount = myMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<CallBackMappingEntity> entityList =  myMapper.searchList(startIndex, pageSize);
            for (CallBackMappingEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
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
    public UnifiedResponse add(CallBackMappingDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse change(CallBackMappingDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }

    @Override
    public CallBackMappingVO convertEntityToVo(CallBackMappingEntity entity) {
        CallBackMappingVO myVo = new CallBackMappingVO();
        myVo.setCallBackID(entity.getCallBackID());
        myVo.setCallBackMessage(entity.getCallBackMessage());
        myVo.setCreateUser(entity.getCreateUser());
        myVo.setCreateTime(entity.getCreateTime());
        myVo.setEditUser(entity.getEditUser());
        myVo.setEditTime(entity.getEditTime());
        return myVo;
    }

    @Override
    public CallBackMappingEntity convertDtoToEntity(CallBackMappingDTO dto) {
        return null;
    }
}
