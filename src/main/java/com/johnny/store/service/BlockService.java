package com.johnny.store.service;

import com.johnny.store.dto.BlockDTO;
import com.johnny.store.entity.BlockEntity;
import com.johnny.store.vo.BlockVO;
import com.johnny.store.vo.UnifiedResponse;

public interface BlockService extends BaseService<BlockDTO, BlockVO, BlockEntity> {
    UnifiedResponse findList4Module(int pageNumber, int pageSize, int moduleID);
}
