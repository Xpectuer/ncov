package com.zjut.azhen.ncov.controllers;


import com.alibaba.fastjson.JSON;
import com.zjut.azhen.ncov.bean.Record;
import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.service.RecordService;
import com.zjut.azhen.ncov.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/history")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService){
        this.recordService=recordService;
    }
    @RequestMapping(value = "/getById/{type}/{id}/{gran}",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getById(@PathVariable String type, @PathVariable Integer id, @PathVariable Integer gran){
        //6.7解决反转、粒度问题
        //粒度 gran
       if(gran<0 || gran >10) {
           return "invalid granularity!";
       }
        Map<String,Object> map=new HashMap<>(2);
        List<Object> list=new ArrayList<>(),list1=new ArrayList<>();
        List<Record> list2;
        if("world".equals(type)) {
           list2 = recordService.getWorldById(id);
        }
        else if("china".equals(type)){
            list2=recordService.getChinaById(id);

        }
        else {
            return "invalid request";
        }
        Collections.reverse(list2);
        String toParsed;

        for(Record record : list2){
            if(list2.size()<=gran){
                return "invalid query size!";
                }

            else if(list2.indexOf(record)%gran==0) {
                toParsed = DateUtil.parseDateFormat(record.getDateId());
                list.add(toParsed);
                list1.add(record.getConfirmedCount());
            }

        }

        map.put("x_data",list);
        map.put("y_data",list1);

        return JSON.toJSONString(map);

    }
    @RequestMapping(value = "/getDashBoard",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getDashBoard(){

        return JSON.toJSONString(recordService.getDashBoard());
    }


//    @RequestMapping(value = "/getChina/{id}",produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String getChinaById(@PathVariable Integer id){
//
//        Map<String,Object> map=new HashMap<>(2);
//        List<Object> list=new ArrayList<>(),list1=new ArrayList<>();
//
//
//        List<Record> list2=recordService.getChinaById(id);
//
//        String toParsed;
//        for(Record record : list2){
//            toParsed = DateUtil.parseDateFormat(record.getDateId());
//            list.add(toParsed);
//            list1.add(record.getConfirmedCount());
//        }
//
//        map.put("x_data",list);
//        map.put("y_data",list1);
//
//        return JSON.toJSONString(map);
//
//    }
}
