package com.johnny.store.mapper;
import com.johnny.store.entity.BusinessFlowEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessFlowMapper extends BaseMapper<BusinessFlowEntity> {
    /**
     * 取得业务承接者（理财经理）当前最新的业务请求
     * @param userID 业务承接者
     * @param fromDate 业务日期起始时间
     * @param toDate 业务日期结束时间
     * @return 业务承接者最新的业务请求
     */
    List<BusinessFlowEntity> searchLatestBusiness(int userID, String fromDate, String toDate);

    /**
     * 取得业务承接者（理财经理）所有的业务流数据
     * @param userID 业务承接者
     * @param fromDate 业务日期起始时间
     * @param toDate 业务日期结束时间
     * @return 业务承接者所有的业务数据
     */
    List<BusinessFlowEntity> search4ReceiveUser(int userID, String fromDate, String toDate);

    /**
     * 取得当前理财经理处于等待回复状态的业务
     * @param receiveID 理财经理编号
     * @param fromDate 业务日期起始时间
     * @param toDate 业务日期结束时间
     * @return 当前处于等待回复状态的业务
     */
    BusinessFlowEntity searchWaitBusiness4Receive(int receiveID, String fromDate, String toDate);
    /**
     * 取得业务承接者（理财经理）所有的业务流数据
     * @param userID 业务承接者
     * @param fromDate 业务日期起始时间
     * @param toDate 业务日期结束时间
     * @return 业务承接者所有的业务数据
     */
    List<BusinessFlowEntity> search4SendUser(int userID, String fromDate, String toDate);

    /**
     * 更新业务流状态
     * @param entity 业务流实体类
     * @return 影响行数
     */
    int updateStatus(BusinessFlowEntity entity);

    /**
     * 更新业务回呼
     * @param entity 业务流实体类
     * @return 影响行数
     */
    int updateCallBack(BusinessFlowEntity entity);

    /**
     * 更新业务流状态为完成
     * @param entity 业务流实体类
     * @return 影响行数
     */
    int updateToComplete(BusinessFlowEntity entity);
}
