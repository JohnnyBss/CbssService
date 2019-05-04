package com.johnny.store.controller;


import com.johnny.store.dto.BusinessFlowDTO;
import com.johnny.store.service.BusinessFlowService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangqiang
 */
@RestController
public class BusinessFlowController {
    @Autowired
    private BusinessFlowService serviceImpl;

    @RequestMapping(value = "/api/business/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/business/{pageNumber}/{pageSize}/{receiveUserID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize, @PathVariable("receiveUserID") int receiveUserID){
        return serviceImpl.findBusinessFlow4Receiver(pageNumber, pageSize, receiveUserID);
    }

    @RequestMapping(value = "/api/business/{businessID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("businessID") int businessID){
        return serviceImpl.find(businessID);
    }

    @RequestMapping(value="/api/business/status", method = RequestMethod.PUT)
    public UnifiedResponse changeStatus(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.changeStatus(dto);
    }

    @RequestMapping(value="/api/business/complete", method = RequestMethod.PUT)
    public UnifiedResponse changeToComplete(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.changeToComplete(dto);
    }

    @RequestMapping(value="/api/business", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.add(dto);
    }
}
