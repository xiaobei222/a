package com.anydoortrip.anydoortrip.apps.hotel.responseData;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomPrice {


    private int id;
    private int localCurrency;
    private int localMinPrice;
    private int isAvailable;
    private int isDraft;
    private int attr;
    private List<pagingPojo> pagingPojo;
}
