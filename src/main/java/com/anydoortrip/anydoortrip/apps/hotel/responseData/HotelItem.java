package com.anydoortrip.anydoortrip.apps.hotel.responseData;

import java.util.ArrayList;


public class HotelItem {
    // 酒店id
    private Long id;
    // 酒店所在城市信息
    private CityItem city;
    // 酒店所在国家信息
    private CountryItem country;
    // 酒店所在品牌信息
    private BrandItem brand;
    // 酒店所在集团信息
    private GroupItem group;
    // 酒店属性
    private ArrayList<AttrItem> attr;
    // 酒店坐标
    private GeoPointItem geoPoint;
    // 酒店图片
    private ArrayList<MediaItem> media;
    // 地址
    private String address;
    // 用于展示的地址
    private String displayAddress;
    // 名字
    private String name;
    // 用于展示的名字
    private String displayName;
    // 描述
    private String desc;
    // 用于展示的描述
    private String displayDesc;

    public HotelItem(Long id, CityItem city, CountryItem country, BrandItem brand, GroupItem group, ArrayList<AttrItem> attr, GeoPointItem geoPoint, ArrayList<MediaItem> media, String address, String displayAddress, String name, String displayName, String desc, String displayDesc) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.brand = brand;
        this.group = group;
        this.attr = attr;
        this.geoPoint = geoPoint;
        this.media = media;
        this.address = address;
        this.displayAddress = displayAddress;
        this.name = name;
        this.displayName = displayName;
        this.desc = desc;
        this.displayDesc = displayDesc;
    }

    public HotelItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityItem getCity() {
        return city;
    }

    public void setCity(CityItem city) {
        this.city = city;
    }

    public CountryItem getCountry() {
        return country;
    }

    public void setCountry(CountryItem country) {
        this.country = country;
    }

    public BrandItem getBrand() {
        return brand;
    }

    public void setBrand(BrandItem brand) {
        this.brand = brand;
    }

    public GroupItem getGroup() {
        return group;
    }

    public void setGroup(GroupItem group) {
        this.group = group;
    }

    public ArrayList<AttrItem> getAttr() {
        return attr;
    }

    public void setAttr(ArrayList<AttrItem> attr) {
        this.attr = attr;
    }

    public GeoPointItem getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPointItem geoPoint) {
        this.geoPoint = geoPoint;
    }

    public ArrayList<MediaItem> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<MediaItem> media) {
        this.media = media;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDisplayDesc() {
        return displayDesc;
    }

    public void setDisplayDesc(String displayDesc) {
        this.displayDesc = displayDesc;
    }
}