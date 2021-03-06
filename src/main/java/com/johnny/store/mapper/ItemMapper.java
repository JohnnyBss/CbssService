package com.johnny.store.mapper;

import com.johnny.store.entity.ItemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<ItemEntity> {

    List<ItemEntity> searchListOfBranch(int bankID, int branchID);

    ItemEntity searchOfBranch(int bankID, int branchID, int itemID);

    ItemEntity searchDetail4Branch(int bankID, int branchID, int parentItemID, String itemName);

    List<ItemEntity> searchItemOfParent(int bankID, int branchID, int parentItemID);

    int deleteDetailOfItem(int bankID, int branchID, int parentItemID, String itemName);

    int moveItem(ItemEntity itemEntity);

    int searchChildItemMaxOrder(int bankID, int branchID, int parentItemID);

    int updateItemOrder(ItemEntity itemEntity);
}
