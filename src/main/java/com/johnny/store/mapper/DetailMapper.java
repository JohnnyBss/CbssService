package com.johnny.store.mapper;

import com.johnny.store.entity.DetailEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper extends BaseMapper<DetailEntity>{
    List<DetailEntity> searchList4Item(int bankID, int branchID, int itemID);

    List<DetailEntity> searchFileList(int bankID, int branchID, String fileName);

    int deleteAll(int bankID, int branchID, int itemID);

    int deleteImageMemo(int bankID, int branchID, int itemID, int textMapDetail);

    int deleteImage(int bankID, int branchID, int itemID, int detailID);

    DetailEntity searchImageMemo(int bankID, int branchID, int itemID, int textMapDetail);

    int updateSequence(DetailEntity entity);
}
