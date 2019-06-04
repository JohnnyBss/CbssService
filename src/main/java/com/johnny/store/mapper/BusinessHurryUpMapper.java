package com.johnny.store.mapper;

import com.johnny.store.entity.BusinessHurryUpEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessHurryUpMapper extends BaseMapper<BusinessHurryUpEntity>{
    BusinessHurryUpEntity searchOfReceiver(int receiveUserID);
}
