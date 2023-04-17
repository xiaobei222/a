package com.anydoortrip.anydoortrip.apps.area.mapper;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;

import java.util.TreeMap;

@Mapper //加载bean类
public interface NationalMapper {
    @Select("SELECT c.id, c.name, nf.flag_image, nf.area_image \n" +
            "FROM national_flag nf \n" +
            "LEFT JOIN country c ON nf.country_id = c.id\n" +
            "ORDER BY c.id;")
    List<LinkedHashMap<Integer, Object>> selectCountryById();

    @Select("SELECT `id` ,`name` FROM country")
    List<CountryPojo> queryList();

    @Select("SELECT province.id, province.name\n" +
            "FROM province\n" +
            "JOIN country ON province.country_id = country.id\n" +
            "WHERE country.id = #{id}")
    List<LinkedHashMap<Integer, Object>> queryByIdMap(Integer id);
    @Select("SELECT city.id, city.name\n" +
            "FROM city\n" +
            "INNER JOIN province ON city.province_id = province.id\n" +
            "WHERE province.id = #{id}")
    List<LinkedHashMap<Integer, Object>> queryCityByIdMap(Integer id);

}
