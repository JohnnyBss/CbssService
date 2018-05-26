package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.LogoDTO;
import com.johnny.store.entity.BankEntity;
import com.johnny.store.entity.BranchEntity;
import com.johnny.store.entity.LogoEntity;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BankMapper;
import com.johnny.store.mapper.BranchMapper;
import com.johnny.store.mapper.LogoMapper;
import com.johnny.store.service.LogoService;
import com.johnny.store.vo.LogoVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogoServiceImpl implements LogoService {
    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private LogoMapper logoMapper;

    @Override
    public UnifiedResponse findList4Branch(int bankID, int branchID) {
        try {
            LogoEntity entity =  logoMapper.searchList4Branch(bankID, branchID);
            if(entity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            LogoVO logoVO = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(1, logoVO);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<LogoVO> modelList = new ArrayList<>();
            int totalCount = logoMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<LogoEntity> entityList =  logoMapper.searchList(startIndex, pageSize);
            for (LogoEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            LogoEntity entity =  logoMapper.search(id);
            LogoVO model = convertEntityToVo(entity);
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
    public UnifiedResponse add(LogoDTO dto) {
        try {
            LogoEntity entity = convertDtoToEntity(dto);
            int affectRow = logoMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(LogoDTO dto) {
        try {
            LogoEntity entity = convertDtoToEntity(dto);
            int affectRow = logoMapper.update(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = logoMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public LogoVO convertEntityToVo(LogoEntity entity) {
        BankEntity bankEntity = bankMapper.search(entity.getBankID());
        BranchEntity branchEntity = branchMapper.search(entity.getBranchID());
        return ConvertManager.convertEntityToVO(entity, bankEntity, branchEntity);
    }

    @Override
    public LogoEntity convertDtoToEntity(LogoDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
