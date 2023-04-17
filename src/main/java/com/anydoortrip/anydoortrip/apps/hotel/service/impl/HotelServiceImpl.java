package com.anydoortrip.anydoortrip.apps.hotel.service.impl;

import com.anydoortrip.anydoortrip.apps.hotel.mapper.HotelMapper;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.BrandData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.GroupData;
import com.anydoortrip.anydoortrip.apps.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;
    @Override
    public List<Map<String,Object>> getBrand() {
        return hotelMapper.getBrand();
    }
}
