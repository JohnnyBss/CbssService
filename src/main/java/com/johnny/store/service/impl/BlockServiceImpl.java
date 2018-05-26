package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BlockDTO;
import com.johnny.store.entity.BlockEntity;
import com.johnny.store.entity.ModuleEntity;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BlockMapper;
import com.johnny.store.mapper.ModuleMapper;
import com.johnny.store.service.BlockService;
import com.johnny.store.vo.BlockVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper dataMapper;
    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public UnifiedResponse findList4Module(int pageNumber, int pageSize, int moduleID) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BlockVO> modelList = new ArrayList<>();
            int totalCount = dataMapper.searchTotalCountOfModule(moduleID);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<BlockEntity> entityList =  dataMapper.searchListOfModule(startIndex, pageSize, moduleID);
            for (BlockEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BlockVO> modelList = new ArrayList<>();
            int totalCount = dataMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<BlockEntity> entityList =  dataMapper.searchList(startIndex, pageSize);
            for (BlockEntity entity : entityList) {
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
            BlockEntity entity =  dataMapper.search(id);
            BlockVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            BlockEntity entity =  dataMapper.searchByName(name);
            return UnifiedResponseManager.buildSuccessResponse(entity != null);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(BlockDTO dto) {
        try {
            BlockEntity entity = convertDtoToEntity(dto);
            int affectRow = dataMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(BlockDTO dto) {
        try {
            BlockEntity entity = convertDtoToEntity(dto);
            int affectRow = dataMapper.update(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = dataMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public BlockVO convertEntityToVo(BlockEntity entity) {
        ModuleEntity moduleEntity = moduleMapper.search(entity.getModuleID());
        return ConvertManager.convertEntityToVO(entity, moduleEntity);
    }

    @Override
    public BlockEntity convertDtoToEntity(BlockDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
