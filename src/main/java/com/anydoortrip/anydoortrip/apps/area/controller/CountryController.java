package com.anydoortrip.anydoortrip.apps.area.controller;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;

import com.anydoortrip.anydoortrip.apps.utlis.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private NationalService nationalService;

    /**
     *
     * @param id 根据国家id查询国旗
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public ResUtils<List<LinkedHashMap <Integer, Object>>> getById(@PathVariable Integer id) {
        List<LinkedHashMap<Integer, Object>> hashMaps = nationalService.NationalById(id);


        return  new ResUtils<>(0,"success",hashMaps);
    }

    /**
     * 获取所有国家列表
     * @return
     */
    @GetMapping()
    public ResUtils<List<CountryPojo>> getCountry(){
        List<CountryPojo> list = nationalService.getList();

        return new ResUtils<>(0,"success",list) ;
    }

    /**
     *
     * @param id 根据国家id查询省份
     * @return
     */
    @GetMapping("province/{id}")
    @ResponseBody
    public ResUtils<List<LinkedHashMap <Integer, Object>>> queryProvince( @PathVariable Integer id){
        List<LinkedHashMap <Integer, Object>> maps = nationalService.queryCountry(id);

        return new ResUtils<>(0,"success",maps);
    }

    /**
     *
     * @param id 根据城市id查询省份
     * @return
     */
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
