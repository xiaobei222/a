package com.anydoortrip.anydoortrip.apps.area.service.impl;

import com.anydoortrip.anydoortrip.apps.area.mapper.NationalMapper;
import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NationalServiceImpl implements NationalService {
    @Autowired
    private NationalMapper nationalMapper;
    @Override
    public List<CountryPojo> NationalById(Integer id) {
        return nationalMapper.selectCountryById(id);
    }
}
