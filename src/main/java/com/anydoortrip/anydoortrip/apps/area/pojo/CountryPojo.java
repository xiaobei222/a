package com.anydoortrip.anydoortrip.apps.area.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryPojo {

    private Long id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private NationalPojo nationalPojo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProvincePojo province;
}
