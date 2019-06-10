package com.johnny.store.service.impl;

import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BranchDTO;
import com.johnny.store.entity.BankEntity;
import com.johnny.store.entity.BranchEntity;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BaseMapper;
import com.johnny.store.mapper.BranchMapper;
import com.johnny.store.service.BranchService;
import com.johnny.store.vo.BranchVO;
import com.johnny.store.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchMapper baseMapper;

    @Autowired
    private BaseMapper<BankEntity> bankMapper;
    private Logger logger = LogManager.getLogger(BranchServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BranchVO> modelList = new ArrayList<>();
            int totalCount = baseMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<BranchEntity> entityList =  baseMapper.searchList(startIndex, pageSize);
            for (BranchEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList4Bank(int bankID) {
        try {
            List<BranchVO> modelList = new ArrayList<>();
            List<BranchEntity> entityList =  baseMapper.searchList4Bank(bankID);
            if(entityList == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (BranchEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            BranchEntity entity =  baseMapper.search(id);
            BranchVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            BranchEntity entity =  baseMapper.searchByName(name);
            return UnifiedResponseManager.buildSuccessResponse(entity != null);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(BranchDTO dto) {
        try {
            BranchEntity entity = convertDtoToEntity(dto);
            int affectRow = baseMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(BranchDTO dto) {
        try {
            BranchEntity entity = convertDtoToEntity(dto);
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
    public BranchVO convertEntityToVo(BranchEntity entity) {
        BankEntity bankEntity = bankMapper.search(entity.getBankID());
        return ConvertManager.convertEntityToVO(entity, bankEntity);
    }

    @Override
    public BranchEntity convertDtoToEntity(BranchDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
