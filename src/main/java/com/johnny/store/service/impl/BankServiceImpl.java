package com.johnny.store.service.impl;

import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BankDTO;
import com.johnny.store.entity.BankEntity;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BaseMapper;
import com.johnny.store.service.BankService;
import com.johnny.store.vo.BankVO;
import com.johnny.store.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BaseMapper<BankEntity> baseMapper;
    private Logger logger = LogManager.getLogger(BankServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BankVO> modelList = new ArrayList<>();
            int totalCount = baseMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<BankEntity> entityList =  baseMapper.searchList(startIndex, pageSize);
            for (BankEntity entity : entityList) {
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
        try {
            BankEntity entity =  baseMapper.search(id);
            BankVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            BankEntity entity =  baseMapper.searchByName(name);
            return UnifiedResponseManager.buildSuccessResponse(entity != null);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(BankDTO dto) {
        try {
            BankEntity entity = convertDtoToEntity(dto);
            int affectRow = baseMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(BankDTO dto) {
        try {
            BankEntity entity = convertDtoToEntity(dto);
            int affectRow = baseMapper.update(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = baseMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public BankVO convertEntityToVo(BankEntity entity) {
        return ConvertManager.convertEntityToVO(entity);
    }

    @Override
    public BankEntity convertDtoToEntity(BankDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
