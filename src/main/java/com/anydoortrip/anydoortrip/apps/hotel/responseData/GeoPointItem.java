package com.anydoortrip.anydoortrip.apps.hotel.response;

class GeoPointItem {
    // 纬度
    private Float lat;
    // 经度
    private Float lng;

    public GeoPointItem(Float lat, Float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public GeoPointItem() {
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }
}