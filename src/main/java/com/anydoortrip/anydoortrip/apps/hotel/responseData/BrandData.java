package com.anydoortrip.anydoortrip.apps.hotel.responseData;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandData {

     private int id;
     private String brandId;
     private String brandChain;
     private String brandName;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private String brandDisplayName;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private String brandLogoUrl;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private String brandDesc;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private String brandDisplayDesc;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private int groupId;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private Date createAt;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     private Date updateAt;
}
