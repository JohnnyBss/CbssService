package com.johnny.store.manager;

import com.johnny.store.dto.*;
import com.johnny.store.entity.*;
import com.johnny.store.vo.*;

import java.util.ArrayList;
import java.util.List;

public class ConvertManager {
    public static BankVO convertEntityToVO(BankEntity entity){
        BankVO model = new BankVO();
        if(entity == null){
            return null;
        }
        model.setBankID(entity.getBankID());
        model.setBankName(entity.getBankName());
        model.setInDate(entity.getInDate());
        model.setInUser(entity.getInUser());
        model.setLastEditDate(entity.getLastEditDate());
        model.setLastEditUser(entity.getLastEditUser());
        return model;
    }

    public static BranchVO convertEntityToVO(BranchEntity entity, BankEntity bankEntity){
        BranchVO branchVO = new BranchVO();
        BankVO bankVO = convertEntityToVO(bankEntity);
        if(entity == null){
            return null;
        }
        branchVO.setBranchID(entity.getBranchID());
        branchVO.setBranchName(entity.getBranchName());
        branchVO.setBankID(entity.getBankID());
        branchVO.setBankVO(bankVO);
        branchVO.setInDate(entity.getInDate());
        branchVO.setInUser(entity.getInUser());
        branchVO.setLastEditDate(entity.getLastEditDate());
        branchVO.setLastEditUser(entity.getLastEditUser());
        return branchVO;
    }

    public static ModuleVO convertEntityToVO(ModuleEntity entity){
        ModuleVO model = new ModuleVO();
        if(entity == null){
            return null;
        }
        model.setModuleID(entity.getModuleID());
        model.setModuleName(entity.getModuleName());
        model.setInDate(entity.getInDate());
        model.setInUser(entity.getInUser());
        model.setLastEditDate(entity.getLastEditDate());
        model.setLastEditUser(entity.getLastEditUser());
        return model;
    }

    public static BlockVO convertEntityToVO(BlockEntity entity, ModuleEntity moduleEntity){
        BlockVO model = new BlockVO();
        ModuleVO moduleVO = convertEntityToVO(moduleEntity);
        if(entity == null){
            return null;
        }
        model.setBlockID(entity.getBlockID());
        model.setBlockName(entity.getBlockName());
        model.setModuleID(entity.getModuleID());
        model.setModuleVO(moduleVO);
        model.setInDate(entity.getInDate());
        model.setInUser(entity.getInUser());
        model.setLastEditDate(entity.getLastEditDate());
        model.setLastEditUser(entity.getLastEditUser());
        return model;
    }

    public static ItemVO convertEntityToVO(ItemEntity entity, BankEntity bankEntity, BranchEntity branchEntity) {
        if(entity == null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BankVO bankVO = convertEntityToVO(bankEntity);
        BranchVO branchVO = convertEntityToVO(branchEntity, bankEntity);
        itemVO.setItemID(entity.getItemID());
        itemVO.setItemName(entity.getItemName());
        itemVO.setBankID(entity.getBankID());
        itemVO.setBankVO(bankVO);
        itemVO.setBranchID(entity.getBranchID());
        itemVO.setBranchVO(branchVO);
        itemVO.setParentItemID(entity.getParentItemID());
        itemVO.setItemType(entity.getItemType());
        itemVO.setInDate(entity.getInDate());
        itemVO.setInUser(entity.getInUser());
        itemVO.setLastEditDate(entity.getLastEditDate());
        itemVO.setLastEditUser(entity.getLastEditUser());
        return itemVO;
    }

    public static DetailVO convertEntityToVO(DetailEntity entity,
                                             BankEntity bankEntity,
                                             BranchEntity branchEntity,
                                             ItemEntity itemEntity){
        if(entity == null){
            return null;
        }
        DetailVO detailVO = new DetailVO();
        BankVO bankVO = convertEntityToVO(bankEntity);
        BranchVO branchVO = convertEntityToVO(branchEntity, bankEntity);
        ItemVO itemVO = convertEntityToVO(itemEntity, bankEntity, branchEntity);

        detailVO.setDetailID(entity.getDetailID());
        detailVO.setBankID(entity.getBankID());
        detailVO.setBankVO(bankVO);
        detailVO.setBranchID(entity.getBranchID());
        detailVO.setBranchVO(branchVO);
        detailVO.setItemID(entity.getItemID());
        detailVO.setItemVO(itemVO);
        detailVO.setSequence(entity.getSequence());
        detailVO.setAnimation(entity.getAnimation());
        detailVO.setContentType(entity.getContentType());
        detailVO.setContent(entity.getContent());
        detailVO.setTextMapDetail(entity.getTextMapDetail());
        detailVO.setYear(entity.getYear());
        detailVO.setQuarter(entity.getQuarter());
        detailVO.setInDate(entity.getInDate());
        detailVO.setInUser(entity.getInUser());
        detailVO.setLastEditDate(entity.getLastEditDate());
        detailVO.setLastEditUser(entity.getLastEditUser());
        return detailVO;
    }

    public static LogoVO convertEntityToVO(LogoEntity entity,
                                           BankEntity bankEntity,
                                           BranchEntity branchEntity){
        if(entity == null){
            return null;
        }
        LogoVO logoVO = new LogoVO();
        BankVO bankVO = convertEntityToVO(bankEntity);
        BranchVO branchVO = convertEntityToVO(branchEntity, bankEntity);
        logoVO.setLogoID(entity.getLogoID());
        logoVO.setBankID(entity.getBankID());
        logoVO.setBankVO(bankVO);
        logoVO.setBranchID(entity.getBranchID());
        logoVO.setBranchVO(branchVO);
        logoVO.setLogoUrl(entity.getLogoUrl());
        logoVO.setStatus(entity.getStatus());
        logoVO.setInDate(entity.getInDate());
        logoVO.setInUser(entity.getInUser());
        logoVO.setLastEditDate(entity.getLastEditDate());
        logoVO.setLastEditUser(entity.getLastEditUser());
        return logoVO;
    }

    public static NewsVO convertEntityToVO(NewsEntity newsEntity,
                                            List<NewsContentEntity> contentEntityList,
                                            BankEntity bankEntity,
                                            BranchEntity branchEntity){
        if(newsEntity == null){
            return null;
        }
        NewsVO newsVO = new NewsVO();
        BankVO bankVO = convertEntityToVO(bankEntity);
        BranchVO branchVO = convertEntityToVO(branchEntity, bankEntity);
        List<NewsContentVO> newsContentVOList = convertEntityToVO(contentEntityList);
        newsVO.setNewsID(newsEntity.getNewsID());
        newsVO.setBankID(newsEntity.getBankID());
        newsVO.setBankVO(bankVO);
        newsVO.setBranchID(newsEntity.getBranchID());
        newsVO.setBranchVO(branchVO);
        newsVO.setThumbnailUrl(newsEntity.getThumbnailUrl());
        newsVO.setNewsTitle(newsEntity.getNewsTitle());
        newsVO.setNewsDate(newsEntity.getNewsDate());
        newsVO.setNewsContentList(newsContentVOList);
        newsVO.setStatus(newsEntity.getStatus());
        newsVO.setInDate(newsEntity.getInDate());
        newsVO.setInUser(newsEntity.getInUser());
        newsVO.setLastEditDate(newsEntity.getLastEditDate());
        newsVO.setLastEditUser(newsEntity.getLastEditUser());
        return newsVO;
    }

    public static UserVO convertEntityToVO(UserEntity entity){
        if(entity == null){
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setBankID(entity.getBankID());
        userVO.setBranchID(entity.getBranchID());
        userVO.setUserID(entity.getUserID());
        userVO.setUserName(entity.getUserName());
        userVO.setCellphone(entity.getCellphone());
        userVO.setInUser(entity.getInUser());
        userVO.setInDate(entity.getInDate());
        userVO.setLastEditUser(entity.getLastEditUser());
        userVO.setLastEditDate(entity.getLastEditDate());

        return userVO;
    }

    public static SystemNameVO convertEntityToVO(SystemNameEntity entity){
        if(entity == null){
            return null;
        }
        SystemNameVO systemNameVO = new SystemNameVO();
        systemNameVO.setBankID(entity.getBankID());
        systemNameVO.setBranchID(entity.getBranchID());
        systemNameVO.setSysNameID(entity.getSysNameID());
        systemNameVO.setSysName(entity.getSysName());
        systemNameVO.setInUser(entity.getInUser());
        systemNameVO.setInDate(entity.getInDate());
        systemNameVO.setLastEditUser(entity.getLastEditUser());
        systemNameVO.setLastEditDate(entity.getLastEditDate());
        return systemNameVO;
    }

    private static List<NewsContentVO> convertEntityToVO(List<NewsContentEntity> entityList){
        if(entityList.isEmpty()){
            return null;
        }
        List<NewsContentVO> newsContentList = new ArrayList<>();
        for (NewsContentEntity contentEntity : entityList) {
            NewsContentVO newsContentVO = new NewsContentVO();
            newsContentVO.setNewsContentID(contentEntity.getNewsContentID());
            newsContentVO.setNewsID(contentEntity.getNewsID());
            newsContentVO.setNewsContentType(contentEntity.getNewsContentType());
            newsContentVO.setNewsContent(contentEntity.getNewsContent());
            newsContentVO.setInDate(contentEntity.getInDate());
            newsContentVO.setInUser(contentEntity.getInUser());
            newsContentVO.setLastEditDate(contentEntity.getLastEditDate());
            newsContentVO.setLastEditUser(contentEntity.getLastEditUser());
            newsContentList.add(newsContentVO);
        }
        return newsContentList;
    }


    public static BankEntity convertDtoToEntity(BankDTO dto){
        BankEntity entity = new BankEntity();
        entity.setBankID(dto.getBankID());
        entity.setBankName(dto.getBankName());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static BranchEntity convertDtoToEntity(BranchDTO dto){
        BranchEntity entity = new BranchEntity();
        entity.setBranchID(dto.getBranchID());
        entity.setBranchName(dto.getBranchName());
        entity.setBankID(dto.getBankID());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static ModuleEntity convertDtoToEntity(ModuleDTO dto){
        ModuleEntity entity = new ModuleEntity();
        entity.setModuleID(dto.getModuleID());
        entity.setModuleName(dto.getModuleName());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static BlockEntity convertDtoToEntity(BlockDTO dto){
        BlockEntity entity = new BlockEntity();
        entity.setBlockID(dto.getBlockID());
        entity.setBlockName(dto.getBlockName());
        entity.setModuleID(dto.getModuleID());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static ItemEntity convertDtoToEntity(ItemDTO dto){
        ItemEntity entity = new ItemEntity();
        entity.setItemID(dto.getItemID());
        entity.setItemName(dto.getItemName());
        entity.setBankID(dto.getBankID());
        entity.setBranchID(dto.getBranchID());
        entity.setParentItemID(dto.getParentItemID());
        entity.setItemType(dto.getItemType());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static DetailEntity convertDtoToEntity(DetailDTO dto){
        DetailEntity entity = new DetailEntity();
        entity.setDetailID(dto.getDetailID());
        entity.setBankID(dto.getBankID());
        entity.setBranchID(dto.getBranchID());
        entity.setItemID(dto.getItemID());
        entity.setSequence(dto.getSequence());
        entity.setAnimation(dto.getAnimation());
        entity.setContentType(dto.getContentType());
        entity.setContent(dto.getContent());
        entity.setTextMapDetail(dto.getTextMapDetail());
        entity.setYear(dto.getYear());
        entity.setQuarter(dto.getQuarter());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static LogoEntity convertDtoToEntity(LogoDTO dto){
        LogoEntity entity = new LogoEntity();
        entity.setLogoID(dto.getLogoID());
        entity.setBankID(dto.getBankID());
        entity.setBranchID(dto.getBranchID());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setStatus(dto.getStatus());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static NewsEntity convertDtoToEntity(NewsDTO dto){
        NewsEntity entity = new NewsEntity();
        entity.setNewsID(dto.getNewsID());
        entity.setBankID(dto.getBankID());
        entity.setBranchID(dto.getBranchID());
        entity.setThumbnailUrl(dto.getThumbnailUrl());
        entity.setNewsTitle(dto.getNewsTitle());
        entity.setNewsDate(dto.getNewsDate());
        entity.setStatus(dto.getStatus());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static NewsContentEntity convertDtoToEntity(NewsContentDTO dto, int newsID){
        NewsContentEntity entity = new NewsContentEntity();
        entity.setNewsContentID(dto.getNewsContentID());
        entity.setNewsID(newsID);
        entity.setNewsContentType(dto.getNewsContentType());
        entity.setNewsContent(dto.getNewsContent());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    public static UserEntity convertDtoToEntity(UserDTO dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setBankID(dto.getBankID());
        userEntity.setBranchID(dto.getBranchID());
        userEntity.setUserID(dto.getUserID());
        userEntity.setUserName(dto.getUserName());
        userEntity.setPassword(dto.getPassword());
        userEntity.setCellphone(dto.getCellphone());
        userEntity.setInUser(dto.getLoginUser());
        userEntity.setLastEditUser(dto.getLoginUser());
        return userEntity;
    }

    public static SystemNameEntity convertDtoToEntity(SystemNameDTO dto){
        SystemNameEntity systemNameEntity = new SystemNameEntity();
        systemNameEntity.setBankID(dto.getBankID());
        systemNameEntity.setBranchID(dto.getBranchID());
        systemNameEntity.setSysNameID(dto.getSysNameID());
        systemNameEntity.setSysName(dto.getSysName());
        systemNameEntity.setInUser(dto.getLoginUser());
        systemNameEntity.setLastEditUser(dto.getLoginUser());
        return systemNameEntity;
    }
}
