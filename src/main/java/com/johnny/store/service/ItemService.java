package com.johnny.store.service;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.vo.ItemVO;
import com.johnny.store.vo.UnifiedResponse;

public interface ItemService extends BaseService<ItemDTO, ItemVO, ItemEntity> {
    UnifiedResponse findListItems(int bankID, int branchID);

    UnifiedResponse findItemsOfParent(int bankID, int branchID,  int parentItemID);

    UnifiedResponse saveDetailItem(ItemDTO dto);


}
