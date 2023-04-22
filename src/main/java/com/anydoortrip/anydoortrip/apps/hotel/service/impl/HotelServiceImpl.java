package com.anydoortrip.anydoortrip.apps.hotel.service.impl;

import com.anydoortrip.anydoortrip.apps.hotel.mapper.HotelMapper;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.BrandData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.GroupData;
import com.anydoortrip.anydoortrip.apps.hotel.service.HotelService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    @DS("anydoor")
    public List<BrandData> getBrand() {
        return hotelMapper.getBrand();
    }


//    public ArrayList<GroupData> getBrand() {
//        ArrayList<GroupData>  brand = hotelMapper.getBrand();
//        if (brand == null){
//
//        }
//     return brand;
//    }
}
