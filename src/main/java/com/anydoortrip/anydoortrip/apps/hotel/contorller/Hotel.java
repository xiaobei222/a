package com.anydoortrip.anydoortrip.apps.hotel.contorller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.anydoortrip.anydoortrip.apps.hotel.requestData.CitySearchReqData;
import com.anydoortrip.anydoortrip.apps.hotel.requestData.GetHotelListReqData;
import com.anydoortrip.anydoortrip.apps.hotel.responseData.*;
import com.anydoortrip.anydoortrip.apps.hotel.service.HotelService;
import com.anydoortrip.anydoortrip.apps.hotel.utils.Wota;
import com.anydoortrip.anydoortrip.apps.utlis.AppExceptionCodeMsg;
import com.anydoortrip.anydoortrip.apps.utlis.ResUtils;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.anydoortrip.anydoortrip.apps.utlis.AppExceptionCodeMsg.USER_CREDIT_NOT_JING;

@Validated
@RestController
@RequestMapping("/hotel")
public class Hotel {

    private final Wota wota;


    public Hotel(Wota wota) {
        this.wota = wota;
    }

    @Autowired
    private HotelService hotelService;

    /**
     * 获取城市列表
     *
     * @param citySearchReqData 城市搜索数据
     * @return 城市列表
     */
    @GetMapping("/city_search")
    public ResUtils<List<CityRepData>> get_city(@RequestHeader(value = "lang", defaultValue = "en") String lang, @Valid CitySearchReqData citySearchReqData) {
        // 获取到城市列表字符串
        String cityString = wota.getCity(citySearchReqData.getKeyword(), lang);
        // 将字符串转换成json对象
        JSONObject jsonObject = JSON.parseObject(cityString);
        // 如果查询失败
        if (!jsonObject.getBoolean("success")) {
            return new ResUtils<>(0, "success");
        }
        // 如果查询成功,获取数组
        JSONArray dataList = jsonObject.getJSONArray("data");
        // 如果数组长度为零
        if (dataList.size() == 0) {
            return new ResUtils<>(0, "success");
        }
        // 定义响应内容
        ArrayList<CityRepData> list = new ArrayList<>();
        // 提取内容
        dataList.forEach(data -> list.add(new CityRepData((JSONObject) data)));
        return new ResUtils<>(0, "success", list);
    }

    @PostMapping("/get_hotel_list")
    public ResUtils<HotelListRepData> get_hotel_list(@RequestHeader(value = "lang", defaultValue = "en") String lang, @RequestBody @Valid GetHotelListReqData getHotelListReqData) {
        // 获取酒店列表字符串
        String hotel_list_string = wota.getHotelList(getHotelListReqData.getCode(), getHotelListReqData.getLocationType(), getHotelListReqData.getNumber_per_page(), getHotelListReqData.getPage_number(), getHotelListReqData.getGroups(), lang);
        // 将字符串转换成json对象
        JSONObject jsonObject = JSON.parseObject(hotel_list_string);
        // 如果查询失败
        if (!jsonObject.getBoolean("success")) {
            return new ResUtils<>(0, "success");
        }
        // 获取结果对象
        HotelListRepData hotelListRepData = new HotelListRepData(jsonObject);
        // 返回响应内容
        return new ResUtils<>(0, "success", hotelListRepData);
    }

    @GetMapping("/get_chain_list")
    public Resp<BrandData > selectBrand() {
        try {
            List<BrandData> brand = hotelService.getBrand();
            if (brand != null){
                return Resp.success(brand);
            }

        }catch (Exception e){
            Resp.error(AppExceptionCodeMsg.USER_CREDIT_NOT_JING);
        }
        return null;
    }
    @PostMapping("/get_availability")
    public ResUtils<List<pagingPojo>> getHotelPrice(@RequestHeader(value = "lang", defaultValue = "en") String lang, @RequestBody @Valid CondiTionPojo condiTionPojo) {
        System.out.println(condiTionPojo);
        // 获取酒店列表字符串
        String hotelPrice = wota.getHotelPrice(condiTionPojo,lang);
        // 将字符串转换成json对象
        JSONObject jsonObject = JSON.parseObject(hotelPrice);
        // 如果查询失败
        if (!jsonObject.getBoolean("success")) {
            return new ResUtils<>(0, "success");
        }
        // 获取结果对象
        ArrayList<pagingPojo> objects = new ArrayList<>();

        System.out.println(objects.addAll(objects));
        // 返回响应内容
        return new ResUtils<>(0, "success", objects);
    }

}


