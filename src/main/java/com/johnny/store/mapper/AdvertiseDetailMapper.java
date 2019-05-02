package com.johnny.store.mapper;

import com.johnny.store.entity.AdvertiseDetailEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdvertiseDetailMapper extends BaseMapper<AdvertiseDetailEntity> {
    List<AdvertiseDetailEntity> searchList4Module(int moduleID);
}
