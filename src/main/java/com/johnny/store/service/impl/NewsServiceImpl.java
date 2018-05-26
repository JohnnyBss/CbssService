package com.johnny.store.service.impl;

import com.johnny.store.common.JsonUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.NewsContentDTO;
import com.johnny.store.dto.NewsDTO;
import com.johnny.store.entity.BankEntity;
import com.johnny.store.entity.BranchEntity;
import com.johnny.store.entity.NewsContentEntity;
import com.johnny.store.entity.NewsEntity;
import com.johnny.store.manager.ConvertManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BankMapper;
import com.johnny.store.mapper.BranchMapper;
import com.johnny.store.mapper.NewsContentMapper;
import com.johnny.store.mapper.NewsMapper;
import com.johnny.store.service.NewsService;
import com.johnny.store.vo.NewsVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsContentMapper newsContentMapper;

    @Override
    public UnifiedResponse findList4Bank(int pageNumber, int pageSize, int bankID, int branchID) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<NewsVO> modelList = new ArrayList<>();
            int totalCount = newsMapper.searchTotalCount4Bank(bankID, branchID);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<NewsEntity> entityList =  newsMapper.searchList4Bank(startIndex, pageSize, bankID, branchID);
            for (NewsEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<NewsVO> modelList = new ArrayList<>();
            int totalCount = newsMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<NewsEntity> entityList =  newsMapper.searchList(startIndex, pageSize);
            for (NewsEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            NewsEntity entity =  newsMapper.search(id);
            NewsVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(NewsDTO dto) {
        try {
            NewsEntity entity = convertDtoToEntity(dto);
            NewsContentEntity contentEntity;
            List<NewsContentDTO> newsContentList = JsonUtils.deserializationToObject(dto.getNewsContentJson(), NewsContentDTO.class);
            int affectRow = newsMapper.insert(entity);
            for (NewsContentDTO contentDTO : newsContentList) {
                contentEntity = convertDtoToEntity(contentDTO, entity.getNewsID());
                int affectRow4Content = newsContentMapper.insert(contentEntity);
                affectRow += affectRow4Content;
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(NewsDTO dto) {
        try {
            NewsEntity entity = convertDtoToEntity(dto);
            NewsContentEntity contentEntity;
            List<NewsContentDTO> newsContentList = JsonUtils.deserializationToObject(dto.getNewsContentJson(), NewsContentDTO.class);
            int affectRow = newsMapper.update(entity);
            int affectDeleteRow = newsContentMapper.delete(dto.getNewsID());
            affectRow += affectDeleteRow;
            for (NewsContentDTO contentDTO : newsContentList) {
                contentEntity = convertDtoToEntity(contentDTO, entity.getNewsID());
                int affectRow4Content = newsContentMapper.insert(contentEntity);
                affectRow += affectRow4Content;
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int newsID) {
        try {
            int affectRow = newsMapper.delete(newsID);
            int affect4ContentRow = newsContentMapper.delete(newsID);
            affectRow += affect4ContentRow;
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public NewsVO convertEntityToVo(NewsEntity entity) {
        BankEntity bankEntity = bankMapper.search(entity.getBankID());
        BranchEntity branchEntity = branchMapper.search(entity.getBranchID());
        List<NewsContentEntity> newsContentEntityList = newsContentMapper.searchList4News(entity.getNewsID());

        return ConvertManager.convertEntityToVO(entity, newsContentEntityList, bankEntity, branchEntity);
    }

    @Override
    public NewsEntity convertDtoToEntity(NewsDTO dto) {
        return ConvertManager.convertDtoToEntity(dto);
    }

    @Override
    public NewsContentEntity convertDtoToEntity(NewsContentDTO dto, int newsID) {
        return ConvertManager.convertDtoToEntity(dto, newsID);
    }
}
