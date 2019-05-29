package com.johnny.store.mapper;

import com.johnny.store.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity searchByCellphone(String cellphone);

    UserEntity search4Login(String cellphone, String password);

    /**
     * 取得理财经理和运营主管的用户信息
     * @param maxCount 最大数量
     * @return 用户信息
     */
    List<UserEntity> searchListByRole(int maxCount);

    int changePassword(UserEntity entity);
}
