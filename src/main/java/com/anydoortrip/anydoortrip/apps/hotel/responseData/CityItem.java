package com.anydoortrip.anydoortrip.apps.hotel.response;

public class CityItem {
    // 城市id
    private Integer id;
    // 城市名字
    private String name;
    // 用于展示的城市名字
    private String displayName;
    // 全名
    private String fullName;
    // 用于展示的全名
    private String displayFullName;
    // 城市代码
    private String code;

    public CityItem(Integer id, String name, String displayName, String fullName, String displayFullName, String code) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.fullName = fullName;
        this.displayFullName = displayFullName;
        this.code = code;
    }

    public CityItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}