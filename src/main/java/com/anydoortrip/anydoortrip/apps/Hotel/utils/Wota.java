package com.anydoortrip.anydoortrip.apps.Hotel.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Configuration
public class Wota {
    @Value("${wota.token:#{null}}")
    private String token;

    /**
     *
     * @param url 请求地址
     * @param method 请求方式
     * @param headers 请求头
     * @param data 请求内容
     * @param lang 语言
     * @return 响应体
     */
    private String request(String url, HttpMethod method, HttpHeaders headers, HashMap<String, Object> data, String lang) {
        // 拼接请求头
        HttpHeaders _headers = new HttpHeaders();
        _headers.add("accept", "application/json");
        _headers.add("Lang", lang);
        _headers.add("Authorization", this.token);
        // 合并传入的请求头
        _headers.putAll(headers);
        // 创建请求内容
        HttpEntity<HashMap<String, Object>> hashMapHttpEntity = new HttpEntity<>(data, _headers);
        // Http 组件客户端 http 请求工厂
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        // 设置超时时间
        requestFactory.setConnectTimeout(60000);
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
     * @param keyword 关键字
     * @return 城市列表
     */
    public String getCity(String keyword) {
        String url = "https://api-adt.wotaluxe.com/v1/tp/meta/locations?q={q}";
        HashMap<String, Object> params = new HashMap<>();
        params.put("q", keyword);
        return this.request(url, HttpMethod.GET, new HttpHeaders(), params, "zh-CN");
    }
}

