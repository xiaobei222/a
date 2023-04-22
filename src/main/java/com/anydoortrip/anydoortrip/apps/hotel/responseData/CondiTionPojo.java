package com.anydoortrip.anydoortrip.apps.hotel.responseData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondiTionPojo {

    private  boolean availableOnly = false;
    private String code;
    private Date checkIn;

    private Date checkOut;

    private String  currency;

    private int numberOfAdults;

    private int numberOfRooms;
   private   ArrayList<Integer> groups;
    private String locationType;
    private int numberPerPage;
    private int pageNumber;

    private List<RoomPrice> roomPrices;


}