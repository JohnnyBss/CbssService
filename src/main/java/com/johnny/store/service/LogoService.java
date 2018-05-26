package com.johnny.store.service;

import com.johnny.store.dto.LogoDTO;
import com.johnny.store.entity.LogoEntity;
import com.johnny.store.vo.LogoVO;
import com.johnny.store.vo.UnifiedResponse;

public interface LogoService extends BaseService<LogoDTO, LogoVO, LogoEntity> {
    UnifiedResponse findList4Branch(int bankID, int branchID);
}
