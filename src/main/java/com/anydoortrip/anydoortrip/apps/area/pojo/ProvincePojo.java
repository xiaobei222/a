package com.anydoortrip.anydoortrip.apps.area.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvincePojo {

    private int id;
    private String name;
    private int countryId;
    private Date create_at;
    private Date update_at;

    private CityPojo cityPojo;



}
