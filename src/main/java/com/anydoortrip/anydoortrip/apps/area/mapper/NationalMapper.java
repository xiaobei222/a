package com.anydoortrip.anydoortrip.apps.area.mapper;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper //加载bean类
public interface NationalMapper {
    List<CountryPojo> selectCountryById(Integer id);


}
