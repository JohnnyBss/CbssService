package com.johnny.store.controller;

import com.johnny.store.dto.DetailDTO;
import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.ReverseSequenceDTO;
import com.johnny.store.service.DetailService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailController {
    @Autowired
    private DetailService serviceImpl;

    @RequestMapping(value = "/api/detail/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return serviceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/detail/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return serviceImpl.find(id);
    }

    @RequestMapping(value = "/api/detail/exist/{name}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("name") String name){
        return serviceImpl.existCheck(name);
    }

    @RequestMapping(value = "/api/detail/imageMemo/{bankID}/{branchID}/{itemID}/{textMapDetail}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("bankID") int bankID,
                               @PathVariable("branchID") int branchID,
                               @PathVariable("itemID") int itemID,
                               @PathVariable("textMapDetail") int textMapDetail){
        return serviceImpl.findImageMemo(bankID, branchID, itemID, textMapDetail);
    }

    @RequestMapping(value = "/api/detail/item/{bankID}/{branchID}/{itemID}", method = RequestMethod.GET)
    public UnifiedResponse get4Item(@PathVariable("bankID") int bankID,
                                     @PathVariable("branchID") int branchID,
                                     @PathVariable("itemID") int itemID){
        return serviceImpl.findList4Item(bankID, branchID, itemID);
    }

    @RequestMapping(value = "/api/detail/file/{bankID}/{branchID}/{fileName}", method = RequestMethod.GET)
    public UnifiedResponse get4Item(@PathVariable("bankID") int bankID,
                                    @PathVariable("branchID") int branchID,
                                    @PathVariable("fileName") String fileName){
        return serviceImpl.findFileList(bankID, branchID, fileName);
    }

    @RequestMapping(value="/api/detail", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody DetailDTO dto){
        return serviceImpl.add(dto);
    }

    @RequestMapping(value="/api/detail/reverseSequence", method = RequestMethod.PUT)
    public UnifiedResponse reverseSequence(@RequestBody ReverseSequenceDTO dto){
        return serviceImpl.reverseSequence(dto);
    }

    @RequestMapping(value="/api/detail/deleteOfItem/{bankID}/{branchID}/{itemID}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("bankID") int bankID,
                                  @PathVariable("branchID") int branchID,
                                  @PathVariable("itemID") int itemID){
        return serviceImpl.deleteAll(bankID, branchID, itemID);
    }

    @RequestMapping(value="/api/detail/deleteImage/{bankID}/{branchID}/{itemID}/{detailID}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("bankID") int bankID,
                                  @PathVariable("branchID") int branchID,
                                  @PathVariable("itemID") int itemID,
                                  @PathVariable("detailID") int detailID){
        return serviceImpl.deleteImage(bankID, branchID, itemID, detailID);
    }
}
