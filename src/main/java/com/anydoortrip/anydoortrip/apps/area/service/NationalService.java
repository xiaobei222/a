package com.anydoortrip.anydoortrip.apps.area.service;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;


import java.util.LinkedHashMap;
import java.util.List;


public interface NationalService {

    List<LinkedHashMap<Integer, Object>> NationalById(Integer id);

    List<CountryPojo> getList();

    List<LinkedHashMap<Integer,Object>> queryCountry(Integer id);

    List<LinkedHashMap<Integer, Object>> queryCityByIdMap(Integer id);
}
