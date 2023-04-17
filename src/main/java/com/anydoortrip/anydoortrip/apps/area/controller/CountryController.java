package com.anydoortrip.anydoortrip.apps.area.controller;

import com.alibaba.fastjson2.JSON;
import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;

import com.anydoortrip.anydoortrip.apps.utlis.AppException;
import com.anydoortrip.anydoortrip.apps.utlis.AppExceptionCodeMsg;
import com.anydoortrip.anydoortrip.apps.utlis.ResUtils;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.IndicesRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchAction;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

import static com.mysql.cj.conf.PropertyKey.logger;

@RestController
@RequestMapping("/area")
@Slf4j
public class CountryController {

    @Autowired
    private NationalService nationalService;

    /**
     * @param
     * @return
     */
    @GetMapping("national_flag")
    @ResponseBody
    public Resp<List<LinkedHashMap<Integer, Object>>> getById() {


            List<LinkedHashMap<Integer, Object>> hashMaps = nationalService.NationalById();
            if (hashMaps.size()==0){
                return Resp.error(AppExceptionCodeMsg.USER_CREDIT_NOT_LU);
            }
            return Resp.success(hashMaps);

    }
    /**
     * 获取所有国家列表
     *
     * @return
     */
    @GetMapping("/country_list")
    public ResUtils<List<CountryPojo>> getCountry() {
        List<CountryPojo> list = nationalService.getList();
        BulkRequest bulkRequest = new BulkRequest("anydoor_trip");
        for (CountryPojo countryPojo : list){
            IndexRequest indexRequest =  new IndexRequest().id(countryPojo.toString()).source(JSON.toJSONString(countryPojo), XContentType.JSON);

            bulkRequest.add(indexRequest);
        }
        return new ResUtils<>(0, "success", list);

    }

    /**
     * @param id 根据国家id查询省份
     * @return
     */
    @GetMapping("province_list/{id}")
    @ResponseBody
    public ResUtils<List<LinkedHashMap<Integer, Object>>> queryProvince(@PathVariable Integer id) {
        List<LinkedHashMap<Integer, Object>> maps = nationalService.queryCountry(id);

        return new ResUtils<>(0, "success", maps);
    }

    /**
     * @param id 根据省份id查询城市
     * @return
     */
    @ResponseBody
    @GetMapping("city_list/{id}")
    public ResUtils<List<LinkedHashMap<Integer, Object>>> queryCity(@PathVariable Integer id) {
        List<LinkedHashMap<Integer, Object>> cityById = nationalService.queryCityByIdMap(id);

        return new ResUtils<>(0, "success", cityById);
    }

}

/**
 * 响应体
 *
 * @param <T> 响应内容泛型
 */
