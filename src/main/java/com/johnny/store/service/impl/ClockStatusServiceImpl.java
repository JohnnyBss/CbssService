package com.johnny.store.service.impl;

import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ClockStatusDTO;
import com.johnny.store.entity.ClockStatusEntity;
import com.johnny.store.entity.UserEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ClockStatusMapper;
import com.johnny.store.mapper.UserMapper;
import com.johnny.store.service.ClockStatusService;
import com.johnny.store.vo.ClockStatusVO;
import com.johnny.store.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqiang
 */
@Service
public class ClockStatusServiceImpl implements ClockStatusService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClockStatusMapper clockStatusMapper;

    private Logger logger = LogManager.getLogger(ClockStatusServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ClockStatusVO> modelList = new ArrayList<>();
            List<ClockStatusEntity> entityList =  clockStatusMapper.searchCurrentClockStatus(startIndex, pageSize);
            if(entityList == null || entityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (ClockStatusEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findFinancialCurrentClock() {
        try {
            List<ClockStatusVO> modelList = new ArrayList<>();

            //取得理财经理人员信息
            List<UserEntity> userEntityList = userMapper.searchListByRole(6);
            if(userEntityList == null || userEntityList.size() == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }

            //取得每位理财经理当前最新的打卡信息
            for (UserEntity userEntity : userEntityList) {
                ClockStatusEntity clockStatusEntity = clockStatusMapper.searchFinancialCurrentClock(userEntity.getUserID());
                if(clockStatusEntity == null){
                    //当前理财经理没有打卡数据，则默认当前理财经理的打卡状态为离岗
                    ClockStatusEntity tempClockStatusEntity = new ClockStatusEntity();
                    tempClockStatusEntity.setClockUserID(userEntity.getUserID());
                    tempClockStatusEntity.setUserName(userEntity.getUserName());
                    tempClockStatusEntity.setCellphone(userEntity.getCellphone());
                    tempClockStatusEntity.setUserRole(userEntity.getUserRole());
                    tempClockStatusEntity.setUserRoleText(userEntity.getUserRoleText());
                    tempClockStatusEntity.setUserPhoto(userEntity.getUserPhoto());
                    tempClockStatusEntity.setUserResume(userEntity.getUserResume());
                    tempClockStatusEntity.setClockUserStatus("4");
                    tempClockStatusEntity.setClockUserStatusText("离岗");
                    modelList.add(convertEntityToVo(tempClockStatusEntity));
                }else{
                    //当前理财经理存在打卡数据
                    clockStatusEntity.setUserName(userEntity.getUserName());
                    clockStatusEntity.setCellphone(userEntity.getCellphone());
                    clockStatusEntity.setUserRole(userEntity.getUserRole());
                    clockStatusEntity.setUserRoleText(userEntity.getUserRoleText());
                    clockStatusEntity.setUserPhoto(userEntity.getUserPhoto());
                    clockStatusEntity.setUserResume(userEntity.getUserResume());
                    modelList.add(convertEntityToVo(clockStatusEntity));
                }
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int userID) {
        try {
            ClockStatusEntity entity =  clockStatusMapper.search(userID);
            ClockStatusVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(ClockStatusDTO dto) {
        try {
            ClockStatusEntity entity = convertDtoToEntity(dto);
            int affectRow = clockStatusMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(ClockStatusDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int clockStatusID) {
        try {
            int affectRow = clockStatusMapper.delete(clockStatusID);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public ClockStatusVO convertEntityToVo(ClockStatusEntity entity) {
        if(entity == null){
            return null;
        }
        ClockStatusVO clockStatusVO = new ClockStatusVO();
        clockStatusVO.setClockStatusID(entity.getClockStatusID());
        clockStatusVO.setClockUserID(entity.getClockUserID());
        clockStatusVO.setUserName(entity.getUserName());
        clockStatusVO.setCellphone(entity.getCellphone());
        clockStatusVO.setUserRole(entity.getUserRole());
        clockStatusVO.setUserRoleText(entity.getUserRoleText());
        clockStatusVO.setUserPhoto(entity.getUserPhoto());
        clockStatusVO.setUserResume(entity.getUserResume());
        clockStatusVO.setClockUserStatus(entity.getClockUserStatus());
        clockStatusVO.setClockUserStatusText(entity.getClockUserStatusText());
        clockStatusVO.setCreateUser(entity.getCreateUser());
        clockStatusVO.setCreateTime(entity.getCreateTime());
        clockStatusVO.setEditUser(entity.getEditUser());
        clockStatusVO.setEditTime(entity.getEditTime());
        return clockStatusVO;
    }

    @Override
    public ClockStatusEntity convertDtoToEntity(ClockStatusDTO dto) {
        ClockStatusEntity clockStatusEntity = new ClockStatusEntity();
        if(null != dto.getClockStatusID()){
            clockStatusEntity.setClockStatusID(dto.getClockStatusID());
        }
        clockStatusEntity.setClockUserID(dto.getClockUserID());
        clockStatusEntity.setClockUserStatus(dto.getClockUserStatus());
        clockStatusEntity.setCreateUser(dto.getLoginUser());
        clockStatusEntity.setEditUser(dto.getLoginUser());
        return clockStatusEntity;
    }
}
