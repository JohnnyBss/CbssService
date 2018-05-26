package com.johnny.store.controller;

import com.johnny.store.dto.UserDTO;
import com.johnny.store.service.UserService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService serviceImpl;

    @RequestMapping(value = "/api/user/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/user/cellphone/{cellphone}", method = RequestMethod.GET)
    public UnifiedResponse get4Module(@PathVariable("cellphone") String cellphone){
        return serviceImpl.findByCellphone(cellphone);
    }

    @RequestMapping(value = "/api/user/login/{cellphone}/{password}", method = RequestMethod.GET)
    public UnifiedResponse get4Module(@PathVariable("cellphone") String cellphone, @PathVariable("password") String password){
        return serviceImpl.find4Login(cellphone, password);
    }

    @RequestMapping(value="/api/user", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody UserDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/user", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody UserDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/user/changePassword", method = RequestMethod.PUT)
    public UnifiedResponse changePassword(@RequestBody UserDTO dto){
        return serviceImpl.changePassword(dto);
    }

    @RequestMapping(value="/api/user/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
