package com.johnny.store.mapper;

import com.johnny.store.entity.ClockStatusEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClockStatusMapper extends BaseMapper<ClockStatusEntity> {
    List<ClockStatusEntity> searchCurrentClockStatus(int startIndex, int pageSize);
}
