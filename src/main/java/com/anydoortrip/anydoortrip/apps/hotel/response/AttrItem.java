package com.anydoortrip.anydoortrip.apps.hotel.response;

public class AttrItem {


        // 特惠资讯id
        private String attrId;
        // 特惠资讯种类
        private String kind;
        // 特惠资讯名字
        private String name;
        // 特惠资讯语言
        private String lang;
        // 特惠资讯种类
        private Integer sort;
        // 特惠资讯图标
        private String icon;

        public AttrItem(String attrId, String kind, String name, String lang, Integer sort, String icon) {
            this.attrId = attrId;
            this.kind = kind;
            this.name = name;
            this.lang = lang;
            this.sort = sort;
            this.icon = icon;
        }

        public AttrItem() {
        }

        public String getAttrId() {
            return attrId;
        }

        public void setAttrId(String attrId) {
            this.attrId = attrId;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

