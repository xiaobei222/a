package com.anydoortrip.anydoortrip.apps.hotel.service;

import com.anydoortrip.anydoortrip.apps.hotel.responseData.BrandData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.GroupData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface HotelService {


    List<Map<String,Object>> getBrand();
}
