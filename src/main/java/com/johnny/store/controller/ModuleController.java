package com.johnny.store.controller;
import com.johnny.store.dto.ModuleDTO;
import com.johnny.store.service.ModuleService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModuleController {
    @Autowired
    private ModuleService serviceImpl;

    @RequestMapping(value = "/api/module/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/module/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/module/exist/{name}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("name") String name){
        return serviceImpl.existCheck(name);
    }

    @RequestMapping(value="/api/module", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody ModuleDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/module", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody ModuleDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/module/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
