package com.zjut.azhen.ncov.service;


import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.mapping.RegionMapper;

import com.zjut.azhen.ncov.utils.RedisUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.data.redis.core.ValueOperations;



/**
 * @author alex
 */
@Service
public class RegionService {

    private final RegionMapper regionMapper;
    private RedisUtil redisTemplate;

    public RegionService(RegionMapper mapper){
        regionMapper=mapper;
    }

    public Region getRegionRealtimeById(int id){
//        String key = "User" + id;
//
//        ValueOperations<String, Region> operations = null;
//        //cache
//        boolean hasKey = redisTemplate.hasKey(key);
//
//        if(hasKey){
//            Region region = operations.get(key);
//            return region;
//        }else{
//            Region region=regionMapper.getRegionRealtimeById(id);
//            operations.set(key, region, 5);
//        }
        Region region=regionMapper.getRegionRealtimeById(id);
       System.out.println(region.getConfirmed());
        return region;
    }
    public List<Region>  getRegions(){
        return regionMapper.getRegions();
    }
    public List<Region>  getWorld(){

        return regionMapper.getWorld();

    }

    /**TODO:可以改成heap的方法获取前三名
     *
     * @param num
     * @return List<Region>
     */
    public List<Region> getWorldRank(Integer num){
        return regionMapper.getWorldRank(0,num);

    }
    public List<Region> getChinaRank(Integer num){
        return  regionMapper.getChinaRank(0,num);
    }
    //中国累计确诊
    public int getChinaTotal(){
        return regionMapper.getWorldById(143).getConfirmed();
    }
}
