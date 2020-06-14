package com.zjut.azhen.ncov.service;


import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.mapping.RegionMapper;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author alex
 */
@Service
public class RegionService {

    private final RegionMapper regionMapper;



    public RegionService(RegionMapper mapper){
        regionMapper=mapper;
    }

    @Cacheable(key="#id",value = "RegionById#3600",sync = true)
    public Region getRegionRealtimeById(int id){

        Region region=regionMapper.getRegionRealtimeById(id);
       System.out.println(region.getConfirmed());
        return region;
    }
    @Cacheable(key="#root.methodName",value = "Regions#3600",sync = true)
    public List<Region>  getRegions(){
        return regionMapper.getRegions();
    }

    @Cacheable(key = "#root.methodName" ,value = "World#3600",sync = true)
    public List<Region>  getWorld(){

        return regionMapper.getWorld();

    }

    /**TODO:可以改成heap的方法获取前三名
     *
     * @param num
     * @return List<Region>
     */
    @Cacheable(key = "#num" ,value = "WorldRank#3600",sync = true)
    public List<Region> getWorldRank(Integer num){
        return regionMapper.getWorldRank(0,num);

    }
    @Cacheable(key = "#num" ,value = "ChinaRank#3600",sync = true)
    public List<Region> getChinaRank(Integer num){
        return  regionMapper.getChinaRank(0,num);
    }
    //中国累计确诊
    public int getChinaTotal(){
        return regionMapper.getWorldById(143).getConfirmed();
    }
}
