package com.anydoortrip.anydoortrip.apps.area.pojo;


import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
