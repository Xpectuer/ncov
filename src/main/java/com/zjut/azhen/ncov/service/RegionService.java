package com.zjut.azhen.ncov.service;


import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.mapping.RegionMapper;
import com.zjut.azhen.ncov.redisConfig.redisUtil;
import com.zjut.azhen.ncov.redisConfig.redisConfig;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;



/*
*
*   Region Service
* @author  Alex
* */
@Service
public class RegionService {

    private RegionMapper regionMapper;
    private redisUtil redisTemplate;

    public RegionService(RegionMapper mapper){
        regionMapper=mapper;
    }

    public Region getRegionRealtimeById(int id){
        String key = "User" + id;

        ValueOperations<String, Region> operations = null;

        boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey){
            Region region = operations.get(key);
            return region;
        }else{
            Region region=regionMapper.getRegionRealtimeById(id);
            operations.set(key, region, 5);
        }
        Region region=regionMapper.getRegionRealtimeById(id);
       System.out.println(region.getConfirmed());
        return region;
    }
    public List<Region>  getRegions(){
        return regionMapper.getRegions();
    }
    public List<Region>  getWorld(){return regionMapper.getWorld();}
}
