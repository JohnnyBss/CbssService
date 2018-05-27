package com.johnny.store.mapper;

import com.johnny.store.entity.LogoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogoMapper extends BaseMapper<LogoEntity> {
    LogoEntity searchList4Branch(int bankID, int branchID);

    int delete4Branch(int bankID, int branchID);
}
