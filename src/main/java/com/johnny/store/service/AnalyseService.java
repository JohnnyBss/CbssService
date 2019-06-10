package com.johnny.store.service;

import com.johnny.store.common.DataDifference;
import com.johnny.store.vo.UnifiedResponse;

import java.text.ParseException;

/**
 * 业务分析接口
 * @author zhangqiang
 */
public interface AnalyseService {
    /**
     * 理财经理业务数据分析
     * @param fromDate 开始时间
     * @param toDate 截止时间
     * @return 分析结果
     */
    UnifiedResponse analyseFinancialBusiness(String fromDate, String toDate);

    /**
     * 大堂经理业务数据分析
     * @param fromDate 开始时间
     * @param toDate 截止时间
     * @return 分析结果
     */
    UnifiedResponse analyseLobbyBusiness(String fromDate, String toDate);
}
