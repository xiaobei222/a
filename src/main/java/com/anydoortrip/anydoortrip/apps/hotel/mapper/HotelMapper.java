package com.anydoortrip.anydoortrip.apps.hotel.mapper;

import com.anydoortrip.anydoortrip.apps.hotel.responseData.BrandData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.GroupData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HotelMapper {

    List<Map<String,Object>> getBrand( );
}
