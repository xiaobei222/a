package com.anydoortrip.anydoortrip.apps.area.service.impl;

import com.anydoortrip.anydoortrip.apps.area.mapper.NationalMapper;


import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.TreeMap;

@Service
public class NationalServiceImpl implements NationalService {
    @Autowired
    private NationalMapper nationalMapper;
    @Override
    @DS("anydoor")
    public List<LinkedHashMap<Integer, Object>> NationalById(Integer id) {
//        ArrayList<GetCountryPojo> arrayList = new ArrayList<>();
//        nationalMapper.selectCountryById(id).forEach(item->arrayList.add(new GetCountryPojo(item)));
//        return arrayList;
        List<LinkedHashMap<Integer, Object>> linkedHashMaps = nationalMapper.selectCountryById(id);
        return linkedHashMaps;
    }

    @Override
    public List<CountryPojo> getList() {
        return nationalMapper.queryList();
    }

    @Override
    public List<LinkedHashMap<Integer, Object>> queryCountry(Integer id) {
        return nationalMapper.queryByIdMap(id);
    }

    @Override
    public List<LinkedHashMap<Integer, Object>> queryCityByIdMap(Integer id) {
        return nationalMapper.queryCityByIdMap(id);
    }
}
