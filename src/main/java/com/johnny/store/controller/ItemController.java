package com.johnny.store.controller;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.ItemOrderDTO;
import com.johnny.store.service.ItemService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService serviceImpl;

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

    @RequestMapping(value = "/api/item/current/{bankID}/{branchID}/{itemID}", method = RequestMethod.GET)
    public UnifiedResponse getById(@PathVariable("bankID") int bankID,
                               @PathVariable("branchID") int branchID,
                               @PathVariable("itemID") int itemID){
        return serviceImpl.findItem(bankID, branchID, itemID);
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

    @RequestMapping(value="/api/item/changeNodeOrder", method = RequestMethod.PUT)
    public UnifiedResponse changeItemOrder(@RequestBody ItemOrderDTO dto){
        return serviceImpl.changeItemOrder(dto);
    }

    @RequestMapping(value="/api/item/move", method = RequestMethod.PUT)
    public UnifiedResponse move(@RequestBody ItemDTO dto){
        return serviceImpl.move(dto);
    }

    @RequestMapping(value="/api/item/{bankID}/{branchID}/{itemID}/{itemType}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("bankID") int bankID,
                                  @PathVariable("branchID") int branchID,
                                  @PathVariable("itemID") int itemID,
                                  @PathVariable("itemType") String itemType
                                  ){
        return serviceImpl.delete(bankID, branchID, itemID, itemType);
    }
}
