package com.anydoortrip.anydoortrip.apps.hotel.utils;


import com.anydoortrip.anydoortrip.apps.hotel.responseData.CondiTionPojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class Wota {
    @Value("${wota.token:#{null}}")
    private String token;


    /**
     * @param url     请求地址
     * @param method  请求方式
     * @param headers 请求头
     * @param data    请求内容
     * @param lang    语言
     * @return 响应体
     */
    private String request(String url, HttpMethod method, HttpHeaders headers, HashMap<String, Object> data, String lang) {
        // 拼接请求头


        HttpHeaders _headers = new HttpHeaders();
        _headers.add("accept", "application/json");
        _headers.add("Lang", lang);
        _headers.add("Authorization", this.token);
        // 合并传入的请求头
        _headers.putAll(headers == null ? new HttpHeaders() : headers);
        // 创建请求内容
        HttpEntity<HashMap<String, Object>> hashMapHttpEntity = new HttpEntity<>(data, _headers);
        // Http 组件客户端 http 请求工厂
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        // 设置请求超时时间
        requestFactory.setConnectTimeout(60000);
        // 设置读取超时时间
        requestFactory.setReadTimeout(60000);
        // 请求客户端
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        // 发起请求
        ResponseEntity<String> res = restTemplate.exchange(url, method, hashMapHttpEntity, String.class, data);
        // 返回结果
        return res.getBody();
    }

    /**
     * 获取城市列表
     *
     * @param keyword 关键字
     * @param lang    语系
     * @return 城市列表
     */
    public String getCity(String keyword, String lang) {
        // 请求地址
        String url = "https://api-adt.wotaluxe.com/v1/tp/meta/locations?q={q}";
        // 参数容器
        HashMap<String, Object> params = new HashMap<>();
        // 添加参数
        params.put("q", keyword);
        // 请求
        return this.request(url, HttpMethod.GET, null, params, lang);
    }

    /**
     * 获取酒店列表数据
     *
     * @param code            区域代码
     * @param locationType    区域类型
     * @param number_per_page 每页数量
     * @param page_number     页码
     * @param groups          品牌数组
     * @param lang            语系
     * @return 结果字符串
     */
    public String getHotelList(String code, String locationType, Integer number_per_page, Integer page_number, ArrayList<Integer> groups, String lang) {
        // 请求地址
        String url = "https://api-adt.wotaluxe.com/v1/tp/hotel/search";
        // 参数容器
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Integer> paging = new HashMap<>();
        // 添加参数
        paging.put("numberPerPage", number_per_page);
        paging.put("pageNumber", page_number);
        params.put("code", code);
        params.put("groups", groups);
        params.put("isDraft", false);
        params.put("locationType", locationType);
        params.put("paging", paging);
        // 发起请求

        return this.request(url, HttpMethod.POST, null, params, lang);
    }
    public String getHotelPrice(CondiTionPojo condiTionPojo , String lang ) {
        // 请求地址
        String url = "https://api-adt.wotaluxe.com/v1/tp/hotel/availability/search";
        // 参数容器
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> paging = new HashMap<>();
        // 添加参数
        paging.put("pageNumber",condiTionPojo.getPageNumber());
        paging.put("numberPerPage", condiTionPojo.getNumberPerPage());
        params.put("code", condiTionPojo.getCode());
        params.put("checkIn", condiTionPojo.getCheckIn());
        params.put("checkOut", condiTionPojo.getCheckOut());
        params.put("currency", condiTionPojo.getCurrency());
        params.put("locationType", condiTionPojo.getLocationType());
        params.put("groups", condiTionPojo.getGroups());
        params.put("numberOfAdults", condiTionPojo.getNumberOfAdults());
        params.put("numberOfRooms", condiTionPojo.getNumberOfRooms());
        params.put("availableOnly", condiTionPojo.isAvailableOnly());



        params.put("paging", paging);
        // 发起请求
        return this.request(url, HttpMethod.POST, null, params,lang);
    }


}

