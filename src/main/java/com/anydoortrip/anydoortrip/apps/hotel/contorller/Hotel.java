package com.anydoortrip.anydoortrip.apps.hotel.contorller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.anydoortrip.anydoortrip.apps.hotel.response.CityData;
import com.anydoortrip.anydoortrip.apps.hotel.utils.Wota;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param keyword 关键字
     * @return 城市列表
     */
    @GetMapping("/city_search")
    public Response<List<CityData>> get_city(@NotNull(message = "关键字不可为空") String keyword) {
        // 获取到城市列表字符串
        String cityString = wota.getCity(keyword);
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
        ArrayList<CityData> list = new ArrayList<>();
        // 提取内容
        dataList.forEach(data -> {
            list.add(new CityData((JSONObject) data));
        });
        return new Response<>(0, "success", list);
    }
}

/**
 * 响应体
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