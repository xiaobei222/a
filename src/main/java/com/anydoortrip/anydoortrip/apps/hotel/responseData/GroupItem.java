package com.anydoortrip.anydoortrip.apps.hotel.responseData;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupItem {
    // 集团id
    private Integer id;
    // 集团名字
    private String name;
    // 集团描述
    private String desc;

    private HashMap<Object, ArrayList<BrandItem>> data;

    public GroupItem(Integer id, String name, String desc, HashMap<Object, ArrayList<BrandItem>> data) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.data = data;
    }

    public GroupItem(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public GroupItem() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
