package com.johnny.store.controller;

import com.johnny.store.dto.ClockStatusDTO;
import com.johnny.store.service.ClockStatusService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClockController {
    @Autowired
    private ClockStatusService serviceImpl;

//    @RequestMapping(value = "/api/clock/{pageNumber}/{pageSize}", method = RequestMethod.GET)
//    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
//        return serviceImpl.findList(pageNumber, pageSize);
//    }

    @RequestMapping(value = "/api/clock/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int userID){
        return serviceImpl.find(userID);
    }

    @RequestMapping(value = "/api/clock/financial", method = RequestMethod.GET)
    public UnifiedResponse get(){
        return serviceImpl.findFinancialCurrentClock();
    }

    @RequestMapping(value="/api/clock", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody ClockStatusDTO dto){
        return serviceImpl.add(dto);
    }

}
