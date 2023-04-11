package com.anydoortrip.anydoortrip.apps.area.service.impl;

import com.anydoortrip.anydoortrip.apps.area.mapper.NationalMapper;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NationalServiceImpl implements NationalService {
    @Autowired
    private NationalMapper nationalMapper;
    @Override
    public List<GetCountryPojo> NationalById(Integer id) {
        ArrayList<GetCountryPojo> arrayList = new ArrayList<>();
        nationalMapper.selectCountryById(id).forEach(item->arrayList.add(new GetCountryPojo(item)));
        return arrayList;
    }
}
