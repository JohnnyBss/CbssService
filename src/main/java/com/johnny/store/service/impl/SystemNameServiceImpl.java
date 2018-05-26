package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.SystemNameDTO;
import com.johnny.store.entity.SystemNameEntity;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.SystemNameMapper;
import com.johnny.store.service.SystemNameService;
import com.johnny.store.vo.SystemNameVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemNameServiceImpl implements SystemNameService {
    @Autowired
    private SystemNameMapper systemNameMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            SystemNameEntity entity =  systemNameMapper.search(id);
            SystemNameVO model = convertEntityToVo(entity);
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
    public UnifiedResponse add(SystemNameDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse change(SystemNameDTO dto) {
        try {
            SystemNameEntity entity = convertDtoToEntity(dto);
            int affectRow = systemNameMapper.update(entity);
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
    public SystemNameVO convertEntityToVo(SystemNameEntity entity) {
        return ConvertManager.convertEntityToVO(entity);
    }

    @Override
    public SystemNameEntity convertDtoToEntity(SystemNameDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
