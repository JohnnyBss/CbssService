package com.johnny.store.controller;

import com.johnny.store.dto.AdvertiseDTO;
import com.johnny.store.service.AdvertiseService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangqiang
 */
@RestController
public class AdvertiseServiceController {
    @Autowired
    private AdvertiseService myService;

    @RequestMapping(value = "/api/advertise/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return myService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/advertise/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(value="/api/advertise", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody AdvertiseDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(value="/api/advertise", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody AdvertiseDTO dto){
        return myService.change(dto);
    }


    @RequestMapping(value="/api/advertise/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }
}
