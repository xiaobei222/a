package com.anydoortrip.anydoortrip.apps.hotel.response;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelListRepData {
    // 页码数据
    private PageItem paging;
    // 酒店数据
    private HashMap<String, ArrayList<HotelItem>> data;

    public HotelListRepData(PageItem paging, HashMap<String, ArrayList<HotelItem>> data) {
        this.paging = paging;
        this.data = data;
    }

    public HotelListRepData(JSONObject jsonObject) {
        // 获取页码
        JSONObject _paging = jsonObject.getJSONObject("paging");

        // 实例化页码对象
        this.paging = new PageItem(_paging.getInteger("numberPerPage"), _paging.getInteger("pageNumber"), _paging.getInteger("totalPageSize"), _paging.getInteger("totalSize"), _paging.getBoolean("isLastPage"));
        // 获取数据信息
        JSONObject _data = jsonObject.getJSONObject("data");

        // 获取酒店数据信息
        JSONArray hotel_list = _data.getJSONArray("hotels");
        // 实例化一个map
        this.data = new HashMap<>();
        // 实例化一个数组
        ArrayList<HotelItem> hotelItemArrayList = new ArrayList<>();
        // 将数组添加进map
        this.data.put("hotels", hotelItemArrayList);
        // 循环遍历json酒店数据
        hotel_list.forEach(item -> {
            // 类型强转
            JSONObject item_obj = (JSONObject) item;

            // 获取酒店id
            Long hotel_id = item_obj.getLong("id");
            // 获取酒店地址
            String hotel_address = item_obj.getString("address");
            // 获取酒店用户展示的地址
            String hotel_displayAddress = item_obj.getString("displayAddress");
            // 获取酒店名字
            String hotel_name = item_obj.getString("name");
            // 获取酒店用户展示的名字
            String hotel_displayName = item_obj.getString("displayName");
            // 获取酒店描述
            String hotel_desc = item_obj.getString("desc");
            // 获取酒店用户展示的描述
            String hotel_displayDesc = item_obj.getString("displayDesc");

            // 获取酒店所属城市信息
            JSONObject _city = item_obj.getJSONObject("city");
            // 实例化城市对象
            CityItem cityItem = new CityItem(_city.getInteger("id"), _city.getString("name"), _city.getString("displayName"), _city.getString("fullName"), _city.getString("displayFullName"), _city.getString("code"));

            // 获取酒店所属国家信息
            JSONObject _country = item_obj.getJSONObject("country");
            // 实例化国家对象
            CountryItem countryItem = new CountryItem(_country.getInteger("id"), _country.getString("name"), _country.getString("displayName"), _country.getString("flagIconUrl"), _country.getString("code"));

            // 获取酒店品牌信息
            JSONObject _brand = item_obj.getJSONObject("brand");
            // 获取酒店集团信息
            JSONObject _group = _brand.getJSONObject("group");
            // 实例化集团对象
            GroupItem groupItem = new GroupItem(_group.getInteger("id"), _group.getString("name"), _group.getString("desc"));
            // 实例化品牌对象
            BrandItem brandItem = new BrandItem(_brand.getInteger("id"), _brand.getString("chain"), _brand.getString("name"), _brand.getString("displayName"), _brand.getString("logoUrl"), _brand.getString("desc"), _brand.getString("displayDesc"), groupItem);

            // 获取酒店坐标
            JSONObject _geoPoint = item_obj.getJSONObject("geoPoint");
            // 实例化坐标对象
            GeoPointItem geoPointItem = new GeoPointItem(_geoPoint.getFloat("lat"), _geoPoint.getFloat("lng"));

            // 获取酒店特惠资讯
            JSONArray _attr = item_obj.getJSONArray("attr");
            // 创建容器
            ArrayList<AttrItem> attrItemArrayList = new ArrayList<>();
            // 遍历酒店特惠资讯
            _attr.forEach(attr_item ->{
                JSONObject _attr_item = (JSONObject) attr_item ;
                attrItemArrayList.add(new AttrItem(_attr_item.getString("attrId"), _attr_item.getString("kind"), _attr_item.getString("name"), _attr_item.getString("lang"), _attr_item.getInteger("sort"), _attr_item.getString("icon")));
            });

            // 获取酒店图片
            JSONArray _media = item_obj.getJSONArray("media");
            // 创建容器
            ArrayList<MediaItem> mediaItemArrayList = new ArrayList<>();
            // 遍历酒店图片
            _media.forEach(media_item ->{
                JSONObject _media_item = (JSONObject) media_item ;
                mediaItemArrayList.add(new MediaItem(_media_item.getString("id"), _media_item.getString("urlFormat"), _media_item.getJSONArray("sizeCodes"), _media_item.getInteger("sort")));
            });

            // 拼接酒店数据
            hotelItemArrayList.add(new HotelItem(hotel_id, cityItem, countryItem, brandItem, groupItem, attrItemArrayList, geoPointItem, mediaItemArrayList, hotel_address, hotel_displayAddress, hotel_name, hotel_displayName, hotel_desc, hotel_displayDesc));
        });
    }

    public PageItem getPaging() {
        return paging;
    }

    public void setPaging(PageItem paging) {
        this.paging = paging;
    }

    public HashMap<String, ArrayList<HotelItem>> getData() {
        return data;
    }

    public void setData(HashMap<String, ArrayList<HotelItem>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HotelListRepData{" +
                "paging=" + paging +
                ", data=" + data +
                '}';
    }
}

/**
 * 页码
 */
class PageItem {
    // 每页显示的数量
    private Integer numberPerPage;
    // 页码
    private Integer pageNumber;
    // 总页数
    private Integer totalPageSize;
    // 总数量
    private Integer totalSize;
    // 是否最后一页
    private Boolean isLastPage;

    public PageItem(Integer numberPerPage, Integer pageNumber, Integer totalPageSize, Integer totalSize, Boolean isLastPage) {
        this.numberPerPage = numberPerPage;
        this.pageNumber = pageNumber;
        this.totalPageSize = totalPageSize;
        this.totalSize = totalSize;
        this.isLastPage = isLastPage;
    }

    public PageItem() {
    }

    public Integer getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(Integer numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(Integer totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Boolean getLastPage() {
        return isLastPage;
    }

    public void setLastPage(Boolean lastPage) {
        isLastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PageItem{" +
                "numberPerPage=" + numberPerPage +
                ", pageNumber=" + pageNumber +
                ", totalPageSize=" + totalPageSize +
                ", totalSize=" + totalSize +
                ", isLastPage=" + isLastPage +
                '}';
    }
}

/**
 * 酒店数据
 */
class HotelItem {
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

/**
 * 城市数据
 */
class CityItem {
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

/**
 * 国家数据
 */
class CountryItem {
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

/**
 * 酒店集团数据
 */
class BrandItem {
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

/**
 * 酒店品牌数据
 */
class GroupItem {
    // 集团id
    private Integer id;
    // 集团名字
    private String name;
    // 集团描述
    private String desc;

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

/**
 * 酒店图片
 */
class MediaItem {
    // 图片id
    private String id;
    // 图片拼接地址
    private String urlFormat;
    // 图片尺寸数组
    private ArrayList<String> sizeCodes;
    // 图片类型
    private Integer sort;

    public MediaItem(String id, String urlFormat, JSONArray sizeCodes, Integer sort) {
        this.id = id;
        this.urlFormat = urlFormat;
        this.sizeCodes = new ArrayList<>(sort);
        sizeCodes.forEach(item->this.sizeCodes.add((String) item));
        this.sort = sort;
    }

    public MediaItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFormat() {
        return urlFormat;
    }

    public void setUrlFormat(String urlFormat) {
        this.urlFormat = urlFormat;
    }

    public ArrayList<String> getSizeCodes() {
        return sizeCodes;
    }

    public void setSizeCodes(ArrayList<String> sizeCodes) {
        this.sizeCodes = sizeCodes;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "id='" + id + '\'' +
                ", urlFormat='" + urlFormat + '\'' +
                ", sizeCodes=" + sizeCodes +
                ", sort=" + sort +
                '}';
    }
}

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

class AttrItem {
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