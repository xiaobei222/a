package com.anydoortrip.anydoortrip.apps.area.controller;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;

import com.anydoortrip.anydoortrip.apps.utlis.AppException;
import com.anydoortrip.anydoortrip.apps.utlis.AppExceptionCodeMsg;
import com.anydoortrip.anydoortrip.apps.utlis.ResUtils;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

import static com.mysql.cj.conf.PropertyKey.logger;

@RestController
@RequestMapping("/country")
@Slf4j
public class CountryController {

    @Autowired
    private NationalService nationalService;

    /**
     * @param id 根据国家id查询国旗
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public Resp<List<LinkedHashMap<Integer, Object>>> getById(@PathVariable Integer id) {
        try {
            List<LinkedHashMap<Integer, Object>> hashMaps = nationalService.NationalById(id);
            if (hashMaps.size() == 0) {
                // 查询结果为空
                System.out.println(123);
                throw new AppException(AppExceptionCodeMsg.COUNTRY_CREDIT_NOT_ENOUTH);
            }
            return Resp.success(hashMaps);
        } catch (AppException e) {
            // 捕获自定义异常AppException
            log.error("查询出错", e);
            return Resp.error(AppExceptionCodeMsg.COUNTRY_CREDIT_NOT_ENOUTH);
        } catch (Exception e) {
            // 捕获其他异常
            log.error("查询出错", e);
        return Resp.error(AppExceptionCodeMsg.USER_CREDIT_NOT_ENOUTH);
        }
    }
    /**
     * 获取所有国家列表
     *
     * @return
     */
    @GetMapping()
    public ResUtils<List<CountryPojo>> getCountry() {
        List<CountryPojo> list = nationalService.getList();

        return new ResUtils<>(0, "success", list);
    }

    /**
     * @param id 根据国家id查询省份
     * @return
     */
    @GetMapping("province/{id}")
    @ResponseBody
    public ResUtils<List<LinkedHashMap<Integer, Object>>> queryProvince(@PathVariable Integer id) {
        List<LinkedHashMap<Integer, Object>> maps = nationalService.queryCountry(id);

        return new ResUtils<>(0, "success", maps);
    }

    /**
     * @param id 根据城市id查询省份
     * @return
     */
    @ResponseBody
    @GetMapping("city/{id}")
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
