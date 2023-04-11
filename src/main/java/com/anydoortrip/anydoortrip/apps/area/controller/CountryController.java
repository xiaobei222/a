package com.anydoortrip.anydoortrip.apps.area.controller;

import com.anydoortrip.anydoortrip.apps.area.service.NationalService;
import com.anydoortrip.anydoortrip.apps.area.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private NationalService nationalService;

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){

        return new R(true,nationalService.NationalById(id));
    }
}
