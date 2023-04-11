package com.anydoortrip.anydoortrip.apps.area.controller;

import ch.qos.logback.classic.turbo.TurboFilter;
import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.pojo.GetCountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;

import com.anydoortrip.anydoortrip.apps.area.utlis.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Writer;
import java.util.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private NationalService nationalService;

    @GetMapping("{id}")
    @ResponseBody
    public ResUtils<List<GetCountryPojo>> getById(@PathVariable Integer id) {
        List<GetCountryPojo> getCountryPojos = nationalService.NationalById(id);

        return new ResUtils<>(0,"success",getCountryPojos);
    }
}

/**
 * 响应体
 *
 * @param <T> 响应内容泛型
 */
