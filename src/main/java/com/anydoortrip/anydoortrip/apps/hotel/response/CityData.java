package com.anydoortrip.anydoortrip.apps.hotel.response;

import com.alibaba.fastjson2.JSONObject;

/**
 * 城市信息
 */
public class CityData {
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

    public CityData(String locationType, String code, String name, String displayName, String fullName, String displayFullName, String address, String displayAddress, String city, String country) {
        this.locationType = locationType;
        this.code = code;
        this.name = name;
        this.displayName = displayName;
        this.fullName = fullName;
        this.displayFullName = displayFullName;
        this.address = address;
        this.displayAddress = displayAddress;
        this.city = city;
        this.country = country;
    }

    public CityData(JSONObject data){
        this.locationType = data.getString("locationType");
        this.code = data.getString("code");
        this.name = data.getString("name");
        this.displayName = data.getString("displayName");
        this.fullName = data.getString("fullName");
        this.displayFullName = data.getString("displayFullName");
        this.address = data.getString("address");
        this.displayAddress = data.getString("displayAddress");
        this.city = data.getString("city");
        this.country = data.getString("country");
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDisplayFullName() {
        return displayFullName;
    }

    public void setDisplayFullName(String displayFullName) {
        this.displayFullName = displayFullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(String displayAddress) {
        this.displayAddress = displayAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}