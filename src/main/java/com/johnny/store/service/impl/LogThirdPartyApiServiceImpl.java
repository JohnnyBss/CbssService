package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.LogThirdPartyApiDTO;
import com.johnny.store.entity.LogThirdPartyApiEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.LogThirdPartyApiMapper;
import com.johnny.store.service.LogThirdPartyApiService;
import com.johnny.store.vo.LogThirdPartyApiVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogThirdPartyApiServiceImpl implements LogThirdPartyApiService {
    @Autowired
    private LogThirdPartyApiMapper myMapper;

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
    public UnifiedResponse add(LogThirdPartyApiDTO dto) {
        try {
            LogThirdPartyApiEntity entity = convertDtoToEntity(dto);
            int affectRow = myMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(LogThirdPartyApiDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }

    @Override
    public LogThirdPartyApiVO convertEntityToVo(LogThirdPartyApiEntity entity) {
        return null;
    }

    @Override
    public LogThirdPartyApiEntity convertDtoToEntity(LogThirdPartyApiDTO dto) {
        LogThirdPartyApiEntity entity = new LogThirdPartyApiEntity();
        entity.setThirdParty(dto.getThirdParty());
        entity.setRequestContent(dto.getRequestContent());
        entity.setResponseContent(dto.getResponseContent());
        entity.setRequestResult(dto.getRequestResult());
        entity.setResponseText(dto.getResponseText());
        entity.setCellphone(dto.getCellphone());
        entity.setCreateUser(dto.getLoginUser());
        entity.setEditUser(dto.getLoginUser());
        return entity;
    }
}
