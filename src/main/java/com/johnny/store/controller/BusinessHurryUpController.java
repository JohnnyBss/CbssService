package com.johnny.store.controller;

import com.johnny.store.dto.BusinessHurryUpDTO;
import com.johnny.store.service.BusinessHurryUpService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangqiang
 */
@RestController
public class BusinessHurryUpController {
    @Autowired
    private BusinessHurryUpService serviceImpl;

    @RequestMapping(value = "/api/hurryUp/{receiverID}", method = RequestMethod.GET)
    public UnifiedResponse getReceiveBusiness(@PathVariable("receiverID") int receiverID){
        return serviceImpl.findOfReceiver(receiverID);
    }

    @RequestMapping(value="/api/hurryUp", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody BusinessHurryUpDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/hurryUp", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody BusinessHurryUpDTO dto){
        return serviceImpl.change(dto);
    }
}
