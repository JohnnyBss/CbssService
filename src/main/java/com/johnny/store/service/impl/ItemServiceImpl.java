package com.johnny.store.service.impl;

import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemDTO;
import com.johnny.store.entity.*;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.*;
import com.johnny.store.service.ItemService;
import com.johnny.store.vo.ItemVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public UnifiedResponse findListItems(int bankID, int branchID) {
        try {
            List<ItemVO> modelList = new ArrayList<>();
            List<ItemEntity> entityList =  itemMapper.searchListOfBranch(bankID, branchID);
            for (ItemEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findItem(int bankID, int branchID, int itemID) {
        try {
            ItemEntity entity =  itemMapper.searchOfBranch(bankID, branchID, itemID);
            if(entity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            ItemVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(1, model);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findItemsOfParent(int bankID, int branchID, int parentItemID) {
        try {
            List<ItemVO> modelList = new ArrayList<>();
            List<ItemEntity> entityList =  itemMapper.searchItemOfParent(bankID, branchID, parentItemID);
            for (ItemEntity entity : entityList) {
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
        return null;
    }

    @Override
    public UnifiedResponse find(int id) {
        return null;
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            ItemEntity entity =  itemMapper.searchByName(name);
            return UnifiedResponseManager.buildSuccessResponse(entity != null);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(ItemDTO dto) {
        try {
            int affectRow = 0;
            ItemEntity entity = convertDtoToEntity(dto);
            if(dto.getItemType().equals("D")){
                ItemEntity detailItem =  itemMapper.searchDetail4Branch(dto.getBankID(), dto.getBranchID(), dto.getParentItemID(), dto.getItemName());
                if(detailItem == null){
                    affectRow = itemMapper.insert(entity);
                }
            }else{
                affectRow = itemMapper.insert(entity);
            }

            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse saveDetailItem(ItemDTO dto) {
        try {
            ItemEntity entity = convertDtoToEntity(dto);
            int affectDeleteRow = itemMapper.deleteDetailOfItem(entity.getBankID(), entity.getBranchID(), entity.getParentItemID(), entity.getItemName());
            int affectAddRow = itemMapper.insert(entity);
            int affectRow = affectDeleteRow + affectAddRow;
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }



    @Override
    public UnifiedResponse change(ItemDTO dto) {
        try {
            ItemEntity entity = convertDtoToEntity(dto);
            int affectRow = itemMapper.update(entity);
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
    public UnifiedResponse delete(int bankID, int branchID, int itemID, String itemType) {
        try {
            int affectRow = itemMapper.delete(itemID);
            if("D".equals(itemType)){
                detailMapper.deleteAll(bankID, branchID, itemID);
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse move(ItemDTO dto) {
        try {
            ItemEntity entity = convertDtoToEntity(dto);
            int affectRow = itemMapper.moveItem(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public ItemVO convertEntityToVo(ItemEntity entity) {
        BankEntity bankEntity = bankMapper.search(entity.getBankID());
        BranchEntity branchEntity = branchMapper.search(entity.getBranchID());
        return ConvertManager.convertEntityToVO(entity, bankEntity, branchEntity);
    }

    @Override
    public ItemEntity convertDtoToEntity(ItemDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }
}
