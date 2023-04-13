package com.anydoortrip.anydoortrip.apps.hotel.contorller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.anydoortrip.anydoortrip.apps.hotel.requestData.CitySearchReqData;
import com.anydoortrip.anydoortrip.apps.hotel.requestData.GetHotelListReqData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.CityRepData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.HotelListRepData;
import com.anydoortrip.anydoortrip.apps.hotel.utils.Wota;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
     * @param citySearchReqData 城市搜索数据
     * @return 城市列表
     */
    @GetMapping("/city_search")
    public Response<List<CityRepData>> get_city(@RequestHeader(value = "lang", defaultValue = "en") String lang, @Valid CitySearchReqData citySearchReqData) {
        // 获取到城市列表字符串
        String cityString = wota.getCity(citySearchReqData.getKeyword(), lang);
        // 将字符串转换成json对象
        JSONObject jsonObject = JSON.parseObject(cityString);
        // 如果查询失败
        if (!jsonObject.getBoolean("success")) {
            return new Response<>(0, "success");
        }
        // 如果查询成功,获取数组
        JSONArray dataList = jsonObject.getJSONArray("data");
        // 如果数组长度为零
        if (dataList.size() == 0) {
            return new Response<>(0, "success");
        }
        // 定义响应内容
        ArrayList<CityRepData> list = new ArrayList<>();
        // 提取内容
        dataList.forEach(data -> list.add(new CityRepData((JSONObject) data)));
        return new Response<>(0, "success", list);
    }

    @PostMapping("/get_hotel_list")
    public Response<HotelListRepData> get_hotel_list(@RequestHeader(value = "lang", defaultValue = "en") String lang, @RequestBody @Valid GetHotelListReqData getHotelListReqData) {
        // 获取酒店列表字符串
        String hotel_list_string = wota.getHotelList(getHotelListReqData.getCode(), getHotelListReqData.getLocationType(), getHotelListReqData.getNumber_per_page(), getHotelListReqData.getPage_number(), getHotelListReqData.getGroups(), lang);
        // 将字符串转换成json对象
        JSONObject jsonObject = JSON.parseObject(hotel_list_string);
        // 如果查询失败
        if (!jsonObject.getBoolean("success")) {
            return new Response<>(0, "success");
        }
        // 获取结果对象
        HotelListRepData hotelListRepData = new HotelListRepData(jsonObject);
        // 返回响应内容
        return new Response<>(0, "success", hotelListRepData);
    }
}

/**
 * 响应体
 *
 * @param <T> 响应内容泛型
 */
class Response<T> {
    // 响应码
    private Integer code;
    // 响应描述
    private String message;
    // 响应数据
    private T data;

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Response(Integer code) {
        this.code = code;
        this.message = "OK";
        this.data = null;
    }

    public Response() {
        this.code = 0;
        this.message = "OK";
        this.data = null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}