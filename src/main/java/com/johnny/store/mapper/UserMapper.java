package com.johnny.store.mapper;

import com.johnny.store.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity searchByCellphone(String cellphone);

    int changePassword(UserEntity entity);
}
