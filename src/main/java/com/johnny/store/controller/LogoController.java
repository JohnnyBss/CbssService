package com.johnny.store.controller;

import com.johnny.store.dto.LogoDTO;
import com.johnny.store.service.LogoService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogoController {
    @Autowired
    private LogoService serviceImpl;

    @RequestMapping(value = "/api/logo/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/logo/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/logo/branch/{bankID}/{branchID}", method = RequestMethod.GET)
    public UnifiedResponse get4Branch(@PathVariable("bankID") int bankID,
                                     @PathVariable("branchID") int branchID){
        return serviceImpl.findList4Branch(bankID, branchID);
    }

    @RequestMapping(value="/api/logo", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody LogoDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/logo", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody LogoDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/logo/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
