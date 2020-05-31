package com.zjut.azhen.ncov.service;


import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.mapping.RegionMapper;
import org.springframework.stereotype.Service;
import java.util.List;
/*
*
*   Region Service
* @author  Alex
* */
@Service
public class RegionService {

    private RegionMapper regionMapper;

    public RegionService(RegionMapper mapper){
        regionMapper=mapper;
    }

    public Region getRegionRealtimeById(int id){
        Region region=regionMapper.getRegionRealtimeById(id);
       System.out.println(region.getConfirmed());
        return region;
    }
    public List<Region>  getRegions(){
        return regionMapper.getRegions();
    }
    public List<Region>  getWorld(){return regionMapper.getWorld();}
}
