package com.anydoortrip.anydoortrip.apps.Hotel.contorller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.anydoortrip.anydoortrip.apps.Hotel.utils.Wota;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/hotel")
public class Hotel {

    private final Wota wota;

    public Hotel(Wota wota) {
        this.wota = wota;
    }

    /**
     * 获取城市列表
     *
     * @param keyword 关键字
     * @return 城市列表
     */
    @GetMapping("/city_search")
    public List<CityData> get_city(@NotNull(message = "关键字不可为空") String keyword) {
        // 获取到城市列表字符串
        String data = wota.getCity(keyword);
        // 将字符串转换成json对象
        JSONObject jsonObject = JSON.parseObject(data);
        // 如果查询失败
        if (!jsonObject.getBoolean("success")) {
            return new ArrayList<CityData>();
        }
        // 如果查询成功,获取数组
        JSONArray dataList = jsonObject.getJSONArray("data");
        System.out.println(jsonObject.get("data"));
        return null;
    }
}


/**
 * 城市信息
 */
class CityData {
    // 地点类型
    private String locationType;
    // 城市或酒店code
    private String code;
    // 名字
    private String name;
    // 用来显示的名字
    private String displayName;
    // 地区全名
    private String fullName;
    // 用来显示的地区全名
    private String displayFullName;
    // 地址
    private String address;
    // 用来显示的地址
    private String displayAddress;
    // 城市
    private String city;
    // 国家
    private String country;
}