package com.anydoortrip.anydoortrip.apps.area.service;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.NationalPojo;

import java.util.List;

public interface NationalService {

     List<CountryPojo>NationalById(Integer id);
}
