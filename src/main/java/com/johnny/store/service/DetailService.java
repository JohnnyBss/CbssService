package com.johnny.store.service;

import com.johnny.store.dto.DetailDTO;
import com.johnny.store.dto.ReverseSequenceDTO;
import com.johnny.store.entity.DetailEntity;
import com.johnny.store.vo.DetailVO;
import com.johnny.store.vo.UnifiedResponse;

public interface DetailService extends BaseService<DetailDTO, DetailVO, DetailEntity> {
    UnifiedResponse findList4Item(int bankID, int branchID, int itemID);

    UnifiedResponse findFileList(int bankID, int branchID, String fileName);

    UnifiedResponse deleteAll(int bankID, int branchID, int itemID);

    UnifiedResponse deleteImage(int bankID, int branchID, int itemID, int detailID);

    UnifiedResponse findImageMemo(int bankID, int branchID, int itemID, int textMapDetail);

    UnifiedResponse reverseSequence(ReverseSequenceDTO dto);
}
