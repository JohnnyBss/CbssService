package com.johnny.store.mapper;

import com.johnny.store.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<NewsEntity> {
    int searchTotalCount4Bank(int bankID, int branchID);

    List<NewsEntity> searchList4Bank(int startIndex, int pageSize, int bankID, int branchID);
}
