package com.anydoortrip.anydoortrip.apps.area.controller;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;

import com.anydoortrip.anydoortrip.apps.area.utlis.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Writer;
import java.util.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private NationalService nationalService;

    @GetMapping("{id}")
    @ResponseBody
    public ResUtils<List<GetCountryPojo>> getById(@PathVariable Integer id) {
        List<GetCountryPojo> getCountryPojos = nationalService.NationalById(id);

        return new ResUtils<>(0,"success",getCountryPojos);
    }
    @GetMapping()
    public ResUtils<List<CountryPojo>> getCountry(){
        List<CountryPojo> list = nationalService.getList();

        return new ResUtils<>(0,"success",list) ;
    }
    @GetMapping("province/{id}")
    @ResponseBody
    public ResUtils<List<LinkedHashMap <Integer, Object>>> queryProvince( @PathVariable Integer id){
        List<LinkedHashMap <Integer, Object>> maps = nationalService.queryCountry(id);

        return new ResUtils<>(0,"success",maps);
    }
    @ResponseBody
    @GetMapping("city/{id}")
    public ResUtils<List<LinkedHashMap <Integer, Object>>> queryCity(@PathVariable Integer id){
        List<LinkedHashMap<Integer, Object>> cityById = nationalService.queryCityByIdMap(id);

        return new ResUtils<>(0,"success",cityById);
    }

}

/**
 * 响应体
 *
 * @param <T> 响应内容泛型
 */
