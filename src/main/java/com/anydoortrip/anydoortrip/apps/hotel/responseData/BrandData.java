package com.anydoortrip.anydoortrip.apps.hotel.responseData;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BrandData {

     private int id;
     private String brandId;
     private String brandChain;
     private String brandName;

     private String brandDisplayName;

     private String brandLogoUrl;

     private String brandDesc;

     private String brandDisplayDesc;

     private int groupId;

     private Date createAt;

     private Date updateAt;
     private GroupData groupData;

}
