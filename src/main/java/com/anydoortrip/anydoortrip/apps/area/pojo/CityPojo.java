package com.anydoortrip.anydoortrip.apps.area.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityPojo {
    private int id;
    private String name;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private int province_id;

}
