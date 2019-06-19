package com.johnny.store.service;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.ItemOrderDTO;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.vo.ItemVO;
import com.johnny.store.vo.UnifiedResponse;

/**
 * @author zhangqiang
 */
public interface ItemService extends BaseService<ItemDTO, ItemVO, ItemEntity> {
    UnifiedResponse findListItems(int bankID, int branchID);

    UnifiedResponse findItem(int bankID, int branchID, int itemID);

    UnifiedResponse findItemsOfParent(int bankID, int branchID, int parentItemID);

    UnifiedResponse saveDetailItem(ItemDTO dto);

    /**
     * 删除节点内容
     * @param bankID 银行编号
     * @param branchID 分行编号
     * @param itemID 节点编号
     * @param itemType 节点类型
     * @return 删除结果
     */
    UnifiedResponse delete(int bankID, int branchID, int itemID, String itemType);

    UnifiedResponse move(ItemDTO dto);

    UnifiedResponse changeItemOrder(ItemOrderDTO dto);
}
