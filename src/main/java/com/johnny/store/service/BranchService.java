package com.johnny.store.service;

import com.johnny.store.dto.BranchDTO;
import com.johnny.store.entity.BranchEntity;
import com.johnny.store.vo.BranchVO;
import com.johnny.store.vo.UnifiedResponse;

public interface BranchService extends BaseService<BranchDTO, BranchVO, BranchEntity> {
    UnifiedResponse findList4Bank(int bankID);
}
