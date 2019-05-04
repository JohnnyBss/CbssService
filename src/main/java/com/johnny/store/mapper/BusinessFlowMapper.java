package com.johnny.store.mapper;
import com.johnny.store.entity.BusinessFlowEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessFlowMapper extends BaseMapper<BusinessFlowEntity> {
    /**
     * 取得业务承接者（理财经理）所有的业务流数据
     * @param receiveUserID 业务承接者
     * @return 业务承接者所有的业务数据
     */
    List<BusinessFlowEntity> search4ReceiveUser(int startIndex, int pageSize, int receiveUserID);

    /**
     * 更新业务流状态
     * @param entity 业务流实体类
     * @return 影响行数
     */
    int updateStatus(BusinessFlowEntity entity);

    /**
     * 更新业务流状态为完成
     * @param entity 业务流实体类
     * @return 影响行数
     */
    int updateToComplete(BusinessFlowEntity entity);
}
