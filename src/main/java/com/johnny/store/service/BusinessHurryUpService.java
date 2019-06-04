package com.johnny.store.service;

import com.johnny.store.dto.BusinessHurryUpDTO;
import com.johnny.store.entity.BusinessHurryUpEntity;
import com.johnny.store.vo.BusinessHurryUpVO;
import com.johnny.store.vo.UnifiedResponse;

public interface BusinessHurryUpService extends BaseService<BusinessHurryUpDTO, BusinessHurryUpVO, BusinessHurryUpEntity>{
    UnifiedResponse findOfReceiver(int businessID);
}
