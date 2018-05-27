package com.johnny.store.controller;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.service.ItemService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService serviceImpl;

//    @RequestMapping(value = "/api/item/{pageNumber}/{pageSize}", method = RequestMethod.GET)
//    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
//        return serviceImpl.findList(pageNumber, pageSize);
//    }
//
//    @RequestMapping(value = "/api/item/{id}", method = RequestMethod.GET)
//    public UnifiedResponse get(@PathVariable("id") int id){
//        return serviceImpl.find(id);
//    }

    @RequestMapping(value = "/api/item/{bankID}/{branchID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("bankID") int bankID, @PathVariable("branchID") int branchID){
        return serviceImpl.findListItems(bankID, branchID);
    }

    @RequestMapping(value = "/api/item/{bankID}/{branchID}/{parentItemID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("bankID") int bankID,
                               @PathVariable("branchID") int branchID,
                               @PathVariable("parentItemID") int parentItemID){
        return serviceImpl.findItemsOfParent(bankID, branchID, parentItemID);
    }

    @RequestMapping(value = "/api/item/exist/{name}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("name") String name){
        return serviceImpl.existCheck(name);
    }

    @RequestMapping(value="/api/item", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody ItemDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/detailItem", method = RequestMethod.POST)
    public UnifiedResponse saveDetailItem(@RequestBody ItemDTO dto){
        return serviceImpl.saveDetailItem(dto);
    }

    @RequestMapping(value="/api/item", method = RequestMethod.PUT)
    public UnifiedResponse put(@RequestBody ItemDTO dto){
        return serviceImpl.change(dto);
    }

    @RequestMapping(value="/api/item/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return serviceImpl.delete(id);
    }
}
