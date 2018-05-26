package com.johnny.store.controller;

import com.johnny.store.dto.SystemNameDTO;
import com.johnny.store.service.SystemNameService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SystemNameController {
    @Autowired
    private SystemNameService serviceImpl;

    @RequestMapping(value = "/api/systemName/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value="/api/systemName", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody SystemNameDTO dto){
        return serviceImpl.change(dto);
    }
}
