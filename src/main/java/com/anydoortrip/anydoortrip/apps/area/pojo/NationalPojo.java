package com.anydoortrip.anydoortrip.apps.area.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NationalPojo {


    private Long id;


    private Date createdAt;


    private Date updatedAt;

    private Integer  countryId;

    private String flagImage;


    private String areaImage;


    // getters and setters, constructors, toString()
}