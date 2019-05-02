package com.johnny.store.service;

import com.johnny.store.dto.AdvertiseDTO;
import com.johnny.store.vo.UnifiedResponse;

/**
 * 宣传广告业务接口
 * @author zhangqiang
 */
public interface AdvertiseService {
    /**
     * 查询广告宣传列表
     * @param pageNumber 页码
     * @param pageSize 每一页大小
     * @return 广告宣传列表
     */
    UnifiedResponse findList(int pageNumber, int pageSize);

    /**
     * 查询某个宣传广告的详细内容
     * @param moduleID 广告编号
     * @return 该广告的详细内容
     */
    UnifiedResponse find(int moduleID);

    /**
     * 添加一条新的宣传广告
     * @param dto 详细内容
     * @return 添加结果
     */
    UnifiedResponse add(AdvertiseDTO dto);

    /**
     * 修改一条新的宣传广告
     * @param dto 详细内容
     * @return 修改结果
     */
    UnifiedResponse change(AdvertiseDTO dto);

    /**
     * 删除一条宣传广告
     * @param moduleID 广告编号
     * @return 删除结果
     */
    UnifiedResponse delete(int moduleID);
}
