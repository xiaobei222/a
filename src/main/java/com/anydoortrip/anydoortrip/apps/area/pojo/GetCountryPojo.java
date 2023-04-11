package com.anydoortrip.anydoortrip.apps.area.pojo;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCountryPojo  {


    private Long id;
    private String name;
    private CountryPojo countryPojo;

    private String flagImage;
    private String areaImage;


    private NationalPojo nationalPojo;

}
