package com.zjut.azhen.ncov.service;


import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.mapping.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    RegionMapper regionMapper;
    public Region getRegionRealtimeById(int id){
        Region region=regionMapper.getRegionRealtimeById(id);
       System.out.println(region.getConfirmed());
        return region;
    }
    public List<Region>  getRegions(){
        return regionMapper.getRegions();
    }
}
