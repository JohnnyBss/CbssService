package com.johnny.store.controller;

import com.johnny.store.dto.BranchDTO;
import com.johnny.store.service.BranchService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchController {
    @Autowired
    private BranchService serviceImpl;

    @RequestMapping(value = "/api/branch/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/branch/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/branch/exist/{name}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("name") String name){
        return serviceImpl.existCheck(name);
    }

    @RequestMapping(value = "/api/branch/bank/{id}", method = RequestMethod.GET)
    public UnifiedResponse get4Bank(@PathVariable("id") int id){
        return serviceImpl.findList4Bank(id);
    }

    @RequestMapping(value="/api/branch", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody BranchDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/branch", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody BranchDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/branch/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
