package com.anydoortrip.anydoortrip.apps.hotel.response;

public   class BrandItem {
    // 品牌id
    private Integer id;
    // 品牌代号
    private String chain;
    // 品牌名字
    private String name;
    // 用于展示的品牌名字
    private String displayName;
    // logo地址
    private String logoUrl;
    // 品牌描述
    private String desc;
    // 用于展示的品牌描述
    private String displayDesc;
    // 集团信息
    private GroupItem group;

    public BrandItem(Integer id, String chain, String name, String displayName, String logoUrl, String desc, String displayDesc, GroupItem group) {
        this.id = id;
        this.chain = chain;
        this.name = name;
        this.displayName = displayName;
        this.logoUrl = logoUrl;
        this.desc = desc;
        this.displayDesc = displayDesc;
        this.group = group;
    }

    public BrandItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public GroupItem getGroup() {
        return group;
    }

    public void setGroup(GroupItem group) {
        this.group = group;
    }
}