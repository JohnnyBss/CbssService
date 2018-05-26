package com.johnny.store.mapper;

import com.johnny.store.entity.BlockEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockMapper extends BaseMapper<BlockEntity> {
    int searchTotalCountOfModule(int moduleID);

    List<BlockEntity> searchListOfModule(int startIndex, int pageSize, int moduleID);
}
