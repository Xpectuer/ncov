package com.zjut.azhen.ncov.controllers;

import com.alibaba.fastjson.JSON;
import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testBoot")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @RequestMapping("/getRegion/{id}")
    public String GetRegion(@PathVariable int id){

        return JSON.toJSONString(regionService.getRegionRealtimeById(id));
    }
    @RequestMapping(value = "/getRegions" ,produces = "application/json;charset=UTF-8")
    public String GetRegions(){
        Map<String, List<Region>> map=new HashMap<>(1);
        map.put("china_data",regionService.getRegions());

        return JSON.toJSONString(map);
    }
}
