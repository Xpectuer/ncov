package com.zjut.azhen.ncov.service;

import com.zjut.azhen.ncov.bean.Record;
import com.zjut.azhen.ncov.mapping.RecordMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alex
 */
@Service
public class RecordService {
    private final RecordMapper recordMapper;


    public RecordService(RecordMapper recordMapper){
        this.recordMapper=recordMapper;
    }

    @Cacheable(key = "#root.methodName" ,value = "getWorldById#3600",sync = true)
    public List<Record> getWorldById(Integer id){
        return recordMapper.getWorldById(id,0,120);
    }

    @Cacheable(key = "#root.methodName" ,value = "getChinaById#3600",sync = true)

    public List<Record> getChinaById(Integer id){
        return recordMapper.getChinaById(id,0,120);
    }

    //写缓存map

    /**TODO: robustness to be improved
     * @author alex
     * @return Map
     */
    @Cacheable(key = "#root.methodName" ,value = "DashBoard#3600",sync = true)

    public Map<String,Integer> getDashBoard(){
        Map<String,Integer> map=new HashMap<>(6);
        List<Record> list=recordMapper.getWorldById(143,0,2);
        List<Record> list1=recordMapper.getWorldTotal(0,2);
        map.put("cn_total" ,list.get(0).getConfirmedCount());
        map.put("cn_growth",Math.abs(list.get(1).getConfirmedCount()-list.get(0).getConfirmedCount()));
        map.put("cn_today",list.get(0).getCurrentCount());
        map.put("wd_total",list1.get(0).getConfirmedCount());
        map.put("wd_growth",Math.abs(list1.get(1).getConfirmedCount()-list1.get(0).getConfirmedCount()));
        map.put("wd_today",list1.get(0).getCurrentCount());

        return map;
    }


}
