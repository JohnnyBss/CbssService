package com.johnny.store.mapper;

import com.johnny.store.entity.BranchEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BranchMapper extends BaseMapper<BranchEntity> {
    List<BranchEntity> searchList4Bank(int bankID);
}
