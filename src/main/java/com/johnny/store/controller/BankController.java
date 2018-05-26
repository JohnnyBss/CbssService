package com.johnny.store.controller;

import com.johnny.store.dto.BankDTO;
import com.johnny.store.service.BankService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {
    @Autowired
    private BankService serviceImpl;

    @RequestMapping(value = "/api/bank/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/bank/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/bank/exist/{name}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("name") String name){
        return serviceImpl.existCheck(name);
    }

    @RequestMapping(value="/api/bank", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody BankDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/bank", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody BankDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/bank/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
