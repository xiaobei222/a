package com.anydoortrip.anydoortrip.apps.area.pojo;


import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryPojo {

    private Long id;

    private String name;


    private Date createdAt;


    private Date updatedAt;


    private NationalPojo nationalPojo;

}
