package com.johnny.store.controller;

import com.johnny.store.service.AnalyseService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 业务数据统计分析接口
 * @author zhangqiang
 */
@RestController
public class AnalyseController {
    @Autowired
    private AnalyseService serviceImpl;

    @RequestMapping(value = "/api/analyse/financial/{fromDate}/{toDate}", method = RequestMethod.GET)
    public UnifiedResponse getFinancialBusinessAnalyse(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
        return serviceImpl.analyseFinancialBusiness(fromDate, toDate);
    }

    @RequestMapping(value = "/api/analyse/lobby/{fromDate}/{toDate}", method = RequestMethod.GET)
    public UnifiedResponse getLobbyBusinessAnalyse(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
        return serviceImpl.analyseLobbyBusiness(fromDate, toDate);
    }
}
