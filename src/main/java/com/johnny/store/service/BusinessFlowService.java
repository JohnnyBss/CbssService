package com.johnny.store.service;

import com.johnny.store.dto.BusinessFlowDTO;
import com.johnny.store.entity.BusinessFlowEntity;
import com.johnny.store.vo.BusinessFlowVO;
import com.johnny.store.vo.UnifiedResponse;

public interface BusinessFlowService extends BaseService<BusinessFlowDTO, BusinessFlowVO, BusinessFlowEntity> {

    UnifiedResponse findBusinessFlow4Receiver(int pageNumber, int pageSize, int receiveUserID);

    UnifiedResponse changeStatus(BusinessFlowDTO dto);

    UnifiedResponse changeToComplete(BusinessFlowDTO dto);
}
