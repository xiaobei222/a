package com.anydoortrip.anydoortrip.apps.area.pojo;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class GetCountryPojo{


    private Long id;
    private String name;
    private String flagImage;
    private String areaImage;

    public GetCountryPojo(CountryPojo countryPojo) {
        id = countryPojo.getId();
        name = countryPojo.getName();
        flagImage = countryPojo.getNationalPojo().getFlagImage();
        areaImage = countryPojo.getNationalPojo().getAreaImage();
    }
}
