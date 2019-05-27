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

    @RequestMapping(value = "/api/business/receive/latest/{userID}", method = RequestMethod.GET)
    public UnifiedResponse getLatestBusiness(@PathVariable("userID") int userID){
        return serviceImpl.findLatestBusiness(userID);
    }

    @RequestMapping(value = "/api/business/receive/{userID}", method = RequestMethod.GET)
    public UnifiedResponse getReceiveBusiness(@PathVariable("userID") int userID){
        return serviceImpl.findReceiveBusiness(userID);
    }

    @RequestMapping(value = "/api/business/wait/{userID}", method = RequestMethod.GET)
    public UnifiedResponse hasWaitBusiness(@PathVariable("userID") int userID){
        return serviceImpl.findWaitBusiness4Receive(userID);
    }

    @RequestMapping(value = "/api/business/send/{userID}", method = RequestMethod.GET)
    public UnifiedResponse getSendBusiness(@PathVariable("userID") int userID){
        return serviceImpl.findSendBusiness(userID);
    }

    @RequestMapping(value = "/api/business/{businessID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("businessID") int businessID){
        return serviceImpl.find(businessID);
    }

    @RequestMapping(value="/api/business/status", method = RequestMethod.PUT)
    public UnifiedResponse changeStatus(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.changeStatus(dto);
    }

    @RequestMapping(value="/api/business/callback", method = RequestMethod.PUT)
    public UnifiedResponse changeCallBack(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.changeCallBack(dto);
    }

    @RequestMapping(value="/api/business/complete", method = RequestMethod.PUT)
    public UnifiedResponse changeToComplete(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.changeToComplete(dto);
    }

    @RequestMapping(value="/api/business/send", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody BusinessFlowDTO dto){
        return serviceImpl.add(dto);
    }
}
