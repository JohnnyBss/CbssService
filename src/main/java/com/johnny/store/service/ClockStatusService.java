package com.johnny.store.service;

import com.johnny.store.dto.ClockStatusDTO;
import com.johnny.store.entity.ClockStatusEntity;
import com.johnny.store.vo.ClockStatusVO;
import com.johnny.store.vo.UnifiedResponse;

public interface ClockStatusService extends BaseService<ClockStatusDTO, ClockStatusVO, ClockStatusEntity> {
    /**
     * 查找理财经理最新的打卡状态
     * @return 所有理财经理最新的打卡状态
     */
    UnifiedResponse findFinancialCurrentClock();
}
