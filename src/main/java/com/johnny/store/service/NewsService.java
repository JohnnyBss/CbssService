package com.johnny.store.service;

import com.johnny.store.dto.NewsContentDTO;
import com.johnny.store.dto.NewsDTO;
import com.johnny.store.entity.NewsContentEntity;
import com.johnny.store.entity.NewsEntity;
import com.johnny.store.vo.NewsContentVO;
import com.johnny.store.vo.NewsVO;
import com.johnny.store.vo.UnifiedResponse;

public interface NewsService extends BaseService<NewsDTO, NewsVO, NewsEntity> {
    UnifiedResponse findList4Bank(int startIndex, int pageSize, int bankID, int branchID);

    NewsContentEntity convertDtoToEntity(NewsContentDTO dto, int newsID);
}
