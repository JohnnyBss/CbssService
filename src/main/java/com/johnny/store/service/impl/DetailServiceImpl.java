package com.johnny.store.service.impl;

import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.DetailDTO;
import com.johnny.store.entity.*;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.*;
import com.johnny.store.service.DetailService;
import com.johnny.store.vo.DetailVO;
import com.johnny.store.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private DetailMapper detailMapper;

    private Logger logger = LogManager.getLogger(DetailServiceImpl.class);

    @Override
    public UnifiedResponse findList4Item(int bankID, int branchID, int itemID) {
        try {
            List<DetailVO> modelList = new ArrayList<>();
            List<DetailEntity> entityList =  detailMapper.searchList4Item(bankID, branchID, itemID);
            if(entityList == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (DetailEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findFileList(int bankID, int branchID, String fileName) {
        try {
            List<DetailVO> modelList = new ArrayList<>();
            List<DetailEntity> entityList =  detailMapper.searchFileList(bankID, branchID, "%" + fileName + "%");
            if(entityList == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (DetailEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse deleteAll(int bankID, int branchID, int itemID) {
        try {
            int affectRow = detailMapper.deleteAll(bankID, branchID, itemID);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse deleteImage(int bankID, int branchID, int itemID, int detailID) {
        try {
            int affectRow = detailMapper.deleteImage(bankID, branchID, itemID, detailID);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findImageMemo(int bankID, int branchID, int itemID, int textMapDetail) {
        try {
            DetailEntity entity =  detailMapper.searchImageMemo(bankID, branchID, itemID, textMapDetail);
            DetailVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<DetailVO> modelList = new ArrayList<>();
            int totalCount = detailMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<DetailEntity> entityList =  detailMapper.searchList(startIndex, pageSize);
            for (DetailEntity entity : entityList) {
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
            DetailEntity entity =  detailMapper.search(id);
            DetailVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            DetailEntity entity =  detailMapper.searchByName(name);
            return UnifiedResponseManager.buildSuccessResponse(entity != null);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(DetailDTO dto) {
        try {
            DetailEntity entity = convertDtoToEntity(dto);
            int affectRow = detailMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponseWithID(affectRow, entity.getDetailID());
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(DetailDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }

    @Override
    public DetailVO convertEntityToVo(DetailEntity entity) {
        if(entity == null){
            return null;
        }
        BankEntity bankEntity = bankMapper.search(entity.getBankID());
        BranchEntity branchEntity = branchMapper.search(entity.getBranchID());
        ItemEntity itemEntity = itemMapper.searchOfBranch(entity.getBankID(), entity.getBranchID(), entity.getItemID());
        return ConvertManager.convertEntityToVO(entity, bankEntity, branchEntity, itemEntity);
    }

    @Override
    public DetailEntity convertDtoToEntity(DetailDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
