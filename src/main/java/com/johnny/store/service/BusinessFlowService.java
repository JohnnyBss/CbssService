package com.johnny.store.service;

import com.johnny.store.dto.BusinessFlowDTO;
import com.johnny.store.entity.BusinessFlowEntity;
import com.johnny.store.vo.BusinessFlowVO;
import com.johnny.store.vo.UnifiedResponse;

public interface BusinessFlowService extends BaseService<BusinessFlowDTO, BusinessFlowVO, BusinessFlowEntity> {

    UnifiedResponse findLatestBusiness(int userID);

    UnifiedResponse findReceiveBusiness(int userID);

    UnifiedResponse findWaitBusiness4Receive(int userID);

    UnifiedResponse findSendBusiness(int userID);

    UnifiedResponse changeStatus(BusinessFlowDTO dto);

    UnifiedResponse changeCallBack(BusinessFlowDTO dto);

    UnifiedResponse changeToComplete(BusinessFlowDTO dto);
}
