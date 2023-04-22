package com.anydoortrip.anydoortrip.apps.hotel.mapper;


import com.anydoortrip.anydoortrip.apps.hotel.responseData.BrandData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.GroupData;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HotelMapper {

//    @Select("SELECT\n" +
//            "  g.group_id,\n" +
//            "  g.group_name,\n" +
//            "  g.group_desc,\n" +
//            "  b.brand_id,\n" +
//            "  b.brand_chain,\n" +
//            "  b.brand_name,\n" +
//            "  b.brand_display_name,\n" +
//            "  b.brand_logo_url,\n" +
//            "  b.brand_desc,\n" +
//            "  b.brand_display_desc\n" +
//            "FROM\n" +
//            "  hotel_group g\n" +
//            "  LEFT JOIN hotel_brand b ON g.group_id = b.group_id")
    List<BrandData> getBrand( );
}
