package com.johnny.store.controller;

import com.johnny.store.dto.CountryDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryServiceImpl;

    @RequestMapping(value = "api/country/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public UnifiedResponse getAllCountry(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return countryServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "api/country/{countryID}",method = RequestMethod.GET)
    public UnifiedResponse getCountry(@PathVariable("countryID") int countryID){
        return countryServiceImpl.find(countryID);
    }

    @RequestMapping(value = "api/country/exist/{countryName}",method = RequestMethod.GET)
    public UnifiedResponse checkCountryExist(@PathVariable("countryName") String countryName){
        return countryServiceImpl.existCheck(countryName);
    }

    @RequestMapping(value = "api/country",method = RequestMethod.POST)
    public UnifiedResponse addCountry(@RequestBody CountryDTO countryDTO){
        return countryServiceImpl.add(countryDTO);
    }

    @RequestMapping(value = "api/country",method = RequestMethod.PUT)
    public UnifiedResponse changeCountry(@RequestBody CountryDTO countryDTO){
        return countryServiceImpl.change(countryDTO);
    }

    @RequestMapping(value = "api/country/{countryID}",method = RequestMethod.DELETE)
    public UnifiedResponse deleteCountry(@PathVariable int countryID){
        return countryServiceImpl.delete(countryID);
    }

}
