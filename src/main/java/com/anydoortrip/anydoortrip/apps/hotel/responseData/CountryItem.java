package com.anydoortrip.anydoortrip.apps.hotel.responseData;

public class CountryItem {
    // 国家id
    private Integer id;
    // 国家名字
    private String name;
    // 用于展示的国家名字
    private String displayName;
    // 国旗图标
    private String flagIconUrl;
    // 国家代码
    private String code;

    public CountryItem(Integer id, String name, String displayName, String flagIconUrl, String code) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.flagIconUrl = flagIconUrl;
        this.code = code;
    }

    public CountryItem() {
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

    public String getFlagIconUrl() {
        return flagIconUrl;
    }

    public void setFlagIconUrl(String flagIconUrl) {
        this.flagIconUrl = flagIconUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

