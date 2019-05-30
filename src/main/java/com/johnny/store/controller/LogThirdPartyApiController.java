package com.johnny.store.controller;

import com.johnny.store.dto.LogThirdPartyApiDTO;
import com.johnny.store.service.LogThirdPartyApiService;
import com.johnny.store.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogThirdPartyApiController {
    @Autowired
    private LogThirdPartyApiService serviceImpl;

    @RequestMapping(value="/api/thirdParty", method = RequestMethod.POST)
    public UnifiedResponse post(@RequestBody LogThirdPartyApiDTO dto){
        return serviceImpl.add(dto);
    }
}

