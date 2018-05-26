package com.johnny.store.service;

import com.johnny.store.dto.UserDTO;
import com.johnny.store.entity.UserEntity;
import com.johnny.store.vo.UnifiedResponse;
import com.johnny.store.vo.UserVO;

public interface UserService extends BaseService<UserDTO, UserVO, UserEntity> {
    UnifiedResponse findByCellphone(String cellphone);

    UnifiedResponse changePassword(UserDTO dto);
}
