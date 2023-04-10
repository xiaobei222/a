package com.anydoortrip.anydoortrip.apps.hotel.requestData;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.ArrayList;

/**
 * 获取酒店列表数据参数验证
 */
@Data
public class GetHotelListReqData {
    @NotNull(message = "地区代码不可为空")
    private String code;
    @NotNull(message = "地区类型不可为空")
    private String locationType;
    @Positive(message = "请填写正数")
    private Integer number_per_page;
    @Positive(message = "请填写正数")
    private Integer page_number;
    private ArrayList<Integer> groups;

    public Integer getNumber_per_page() {
        return this.number_per_page == null ? 10 : this.number_per_page;
    }

    public Integer getPage_number() {
        return this.page_number == null ? 1 : this.page_number;
    }

    public ArrayList<Integer> getGroups() {
        return this.groups == null ? new ArrayList<>() : this.groups;
    }
}
