package com.johnny.store.controller;

import com.johnny.store.dto.NewsDTO;
import com.johnny.store.service.NewsService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {
    @Autowired
    private NewsService serviceImpl;

    @RequestMapping(value = "/api/news/{pageNumber}/{pageSize}/{bankID}/{branchID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber,
                               @PathVariable("pageSize") int pageSize,
                               @PathVariable("bankID") int bankID,
                               @PathVariable("branchID") int branchID){
        return serviceImpl.findList4Bank(pageNumber, pageSize, bankID, branchID);
    }

    @RequestMapping(value = "/api/news/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }


    @RequestMapping(value="/api/news", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody NewsDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/news", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody NewsDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/news/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
