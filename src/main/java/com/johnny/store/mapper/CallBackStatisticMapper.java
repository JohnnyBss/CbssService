package com.johnny.store.mapper;

import com.johnny.store.entity.CallBackStatisticEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CallBackStatisticMapper {
    /**
     * 查询理财经理发送回呼的业务总数
     * @param financialID 理财经理编号
     * @param fromDate 业务日期起始时间
     * @param toDate 业务日期结束时间
     * @return 业务总数
     */
    List<CallBackStatisticEntity> searchSendCallBack(int financialID, String fromDate, String toDate);

    /**
     * 查询大堂经理处理回呼的业务总数
     * @param lobbyID 大堂经理编号
     * @param fromDate 业务日期起始时间
     * @param toDate 业务日期结束时间
     * @return 业务总数
     */
    List<CallBackStatisticEntity> searchProcessedCallBack(int lobbyID, String fromDate, String toDate);
}
