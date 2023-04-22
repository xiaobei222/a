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

public class GroupData {

      private int id;
      private int groupId;

      private String groupName;
      private String groupDesc;
      private int apiId;
      private Date createAt;
      private Date updateAt;

      private List<BrandData> brandData;






}
