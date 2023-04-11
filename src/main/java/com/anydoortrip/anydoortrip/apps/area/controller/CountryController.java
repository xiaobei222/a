package com.anydoortrip.anydoortrip.apps.area.controller;

import com.anydoortrip.anydoortrip.apps.area.pojo.CountryPojo;
import com.anydoortrip.anydoortrip.apps.area.service.NationalService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Writer;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private NationalService nationalService;

    @GetMapping("{id}")
    @ResponseBody
    public String getById(@PathVariable Integer id) throws JsonProcessingException {
        List<CountryPojo> list = nationalService.NationalById(id);
        ObjectMapper objectMapper = new ObjectMapper((JsonFactory) list);
        return objectMapper.writeValueAsString(objectMapper);
    }
}
