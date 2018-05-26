package com.johnny.store.controller;

import com.johnny.store.dto.BlockDTO;
import com.johnny.store.service.BlockService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlockController {
    @Autowired
    private BlockService serviceImpl;

    @RequestMapping(value = "/api/block/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/block/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/block/module/{pageNumber}/{pageSize}/{moduleId}", method = RequestMethod.GET)
    public UnifiedResponse get4Module(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize, @PathVariable("moduleId") int moduleId){
        return serviceImpl.findList4Module(pageNumber, pageSize, moduleId);
    }

    @RequestMapping(value = "/api/block/exist/{name}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("name") String name){
        return serviceImpl.existCheck(name);
    }

    @RequestMapping(value="/api/block", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody BlockDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/block", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody BlockDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/block/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
