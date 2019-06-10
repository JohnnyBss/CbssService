package com.johnny.store.service.impl;

import com.johnny.store.common.JsonUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.AdvertiseDTO;
import com.johnny.store.entity.AdvertiseModuleEntity;
import com.johnny.store.entity.AdvertiseDetailEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.AdvertiseDetailMapper;
import com.johnny.store.mapper.AdvertiseModuleMapper;
import com.johnny.store.service.AdvertiseService;
import com.johnny.store.vo.AdvertiseDetailVO;
import com.johnny.store.vo.AdvertiseVO;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 宣传广告业务实现
 * @author zhangqiang
 */
@Service
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    private AdvertiseModuleMapper advertiseModuleMapper;

    @Autowired
    private AdvertiseDetailMapper advertiseDetailMapper;

    private Logger logger = LogManager.getLogger(AdvertiseServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<AdvertiseVO> modelList = new ArrayList<>();
            int totalCount = advertiseModuleMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<AdvertiseModuleEntity> entityList =  advertiseModuleMapper.searchList(startIndex, pageSize);
            for (AdvertiseModuleEntity entity : entityList) {
                AdvertiseVO advertiseVO = new AdvertiseVO();
                advertiseVO.setModuleID(entity.getModuleID());
                advertiseVO.setModuleName(entity.getModuleName());
                advertiseVO.setCreateUser(entity.getCreateUser());
                advertiseVO.setCreateTime(entity.getCreateTime());
                advertiseVO.setEditUser(entity.getEditUser());
                advertiseVO.setEditTime(entity.getEditTime());
                modelList.add(advertiseVO);
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int moduleID) {
        try {
            AdvertiseVO advertiseVO = new AdvertiseVO();
            List<AdvertiseDetailVO> advertiseDetailList4Text = new ArrayList<>();
            List<AdvertiseDetailVO> advertiseDetailList4Image = new ArrayList<>();
            List<AdvertiseDetailVO> advertiseDetailList4Video = new ArrayList<>();
            List<AdvertiseDetailVO> advertiseDetailList4Audio = new ArrayList<>();

            AdvertiseModuleEntity moduleEntity =  advertiseModuleMapper.search(moduleID);
            if(moduleEntity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<AdvertiseDetailEntity> detailEntityList = advertiseDetailMapper.searchList4Module(moduleID);
            advertiseVO.setModuleID(moduleEntity.getModuleID());
            advertiseVO.setModuleName(moduleEntity.getModuleName());

            if(detailEntityList != null && detailEntityList.size() > 0){
                for (AdvertiseDetailEntity detailEntity : detailEntityList) {
                    switch (detailEntity.getDetailType()){
                        case "T":
                            AdvertiseDetailVO advertiseDetailVO4Text = new AdvertiseDetailVO();
                            advertiseDetailVO4Text.setDetailID(detailEntity.getDetailID());
                            advertiseDetailVO4Text.setModuleID(detailEntity.getModuleID());
                            advertiseDetailVO4Text.setDetailType(detailEntity.getDetailType());
                            advertiseDetailVO4Text.setDetailContent(detailEntity.getDetailContent());
                            advertiseDetailVO4Text.setCreateUser(detailEntity.getCreateUser());
                            advertiseDetailVO4Text.setCreateTime(detailEntity.getCreateTime());
                            advertiseDetailVO4Text.setEditUser(detailEntity.getEditUser());
                            advertiseDetailVO4Text.setEditTime(detailEntity.getEditTime());
                            advertiseDetailList4Text.add(advertiseDetailVO4Text);
                            break;
                        case "I":
                            AdvertiseDetailVO advertiseDetailVO4Image = new AdvertiseDetailVO();
                            advertiseDetailVO4Image.setDetailID(detailEntity.getDetailID());
                            advertiseDetailVO4Image.setModuleID(detailEntity.getModuleID());
                            advertiseDetailVO4Image.setDetailType(detailEntity.getDetailType());
                            advertiseDetailVO4Image.setDetailContent(detailEntity.getDetailContent());
                            advertiseDetailVO4Image.setCreateUser(detailEntity.getCreateUser());
                            advertiseDetailVO4Image.setCreateTime(detailEntity.getCreateTime());
                            advertiseDetailVO4Image.setEditUser(detailEntity.getEditUser());
                            advertiseDetailVO4Image.setEditTime(detailEntity.getEditTime());
                            advertiseDetailList4Image.add(advertiseDetailVO4Image);
                            break;
                        case "A":
                            AdvertiseDetailVO advertiseDetailVO4Audio = new AdvertiseDetailVO();
                            advertiseDetailVO4Audio.setDetailID(detailEntity.getDetailID());
                            advertiseDetailVO4Audio.setModuleID(detailEntity.getModuleID());
                            advertiseDetailVO4Audio.setDetailType(detailEntity.getDetailType());
                            advertiseDetailVO4Audio.setDetailContent(detailEntity.getDetailContent());
                            advertiseDetailVO4Audio.setCreateUser(detailEntity.getCreateUser());
                            advertiseDetailVO4Audio.setCreateTime(detailEntity.getCreateTime());
                            advertiseDetailVO4Audio.setEditUser(detailEntity.getEditUser());
                            advertiseDetailVO4Audio.setEditTime(detailEntity.getEditTime());
                            advertiseDetailList4Audio.add(advertiseDetailVO4Audio);
                            break;
                        case "V":
                            AdvertiseDetailVO advertiseDetailVO4Video = new AdvertiseDetailVO();
                            advertiseDetailVO4Video.setDetailID(detailEntity.getDetailID());
                            advertiseDetailVO4Video.setModuleID(detailEntity.getModuleID());
                            advertiseDetailVO4Video.setDetailType(detailEntity.getDetailType());
                            advertiseDetailVO4Video.setDetailContent(detailEntity.getDetailContent());
                            advertiseDetailVO4Video.setCreateUser(detailEntity.getCreateUser());
                            advertiseDetailVO4Video.setCreateTime(detailEntity.getCreateTime());
                            advertiseDetailVO4Video.setEditUser(detailEntity.getEditUser());
                            advertiseDetailVO4Video.setEditTime(detailEntity.getEditTime());
                            advertiseDetailList4Video.add(advertiseDetailVO4Video);
                            break;
                        default:
                            break;
                    }
                }
            }
            advertiseVO.setAdvertiseDetailList4Text(advertiseDetailList4Text);
            advertiseVO.setAdvertiseDetailList4Image(advertiseDetailList4Image);
            advertiseVO.setAdvertiseDetailList4Audio(advertiseDetailList4Audio);
            advertiseVO.setAdvertiseDetailList4Video(advertiseDetailList4Video);
            advertiseVO.setCreateUser(moduleEntity.getCreateUser());
            advertiseVO.setCreateTime(moduleEntity.getCreateTime());
            advertiseVO.setEditUser(moduleEntity.getEditUser());
            advertiseVO.setEditTime(moduleEntity.getEditTime());
            return UnifiedResponseManager.buildSuccessResponse(advertiseVO);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(AdvertiseDTO dto) {
        try {
            AdvertiseModuleEntity advertiseModuleEntity = new AdvertiseModuleEntity();
            advertiseModuleEntity.setModuleName(dto.getModuleName());
            advertiseModuleEntity.setCreateUser(dto.getLoginUser());
            advertiseModuleEntity.setEditUser(dto.getLoginUser());

            List<AdvertiseDetailEntity> advertiseDetailEntityList = JsonUtils.deserializationToObject(dto.getDetailJson(), AdvertiseDetailEntity.class);

            int affectRow = advertiseModuleMapper.insert(advertiseModuleEntity);
            for (AdvertiseDetailEntity advertiseDetailEntity: advertiseDetailEntityList) {
                advertiseDetailEntity.setModuleID(advertiseModuleEntity.getModuleID());
                advertiseDetailEntity.setCreateUser(dto.getLoginUser());
                advertiseDetailEntity.setEditUser(dto.getLoginUser());
                affectRow += advertiseDetailMapper.insert(advertiseDetailEntity);
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(AdvertiseDTO dto) {
        try {
            AdvertiseModuleEntity advertiseModuleEntity = new AdvertiseModuleEntity();
            advertiseModuleEntity.setModuleID(dto.getModuleID());
            advertiseModuleEntity.setModuleName(dto.getModuleName());
            advertiseModuleEntity.setCreateUser(dto.getLoginUser());
            advertiseModuleEntity.setEditUser(dto.getLoginUser());

            List<AdvertiseDetailEntity> advertiseDetailEntityList = JsonUtils.deserializationToObject(dto.getDetailJson(), AdvertiseDetailEntity.class);

            int affectRow = advertiseModuleMapper.update(advertiseModuleEntity);
            advertiseDetailMapper.delete(dto.getModuleID());
            for (AdvertiseDetailEntity advertiseDetailEntity: advertiseDetailEntityList) {
                advertiseDetailEntity.setModuleID(advertiseModuleEntity.getModuleID());
                advertiseDetailEntity.setCreateUser(dto.getLoginUser());
                advertiseDetailEntity.setEditUser(dto.getLoginUser());
                affectRow += advertiseDetailMapper.insert(advertiseDetailEntity);
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int moduleID) {
        try {
            int affectRow = advertiseModuleMapper.delete(moduleID);
            affectRow += advertiseDetailMapper.delete(moduleID);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
