package com.zjut.azhen.ncov.controllers;

import com.alibaba.fastjson.JSON;
import com.zjut.azhen.ncov.bean.Region;
import com.zjut.azhen.ncov.service.RegionService;

import com.zjut.azhen.ncov.utils.MyFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testBoot")
public class RegionController {

    private RegionService regionService;

    public RegionController(RegionService service){regionService=service;}
    @RequestMapping("/getRegion/{id}")
    public String getRegion(@PathVariable int id){

        return JSON.toJSONString(regionService.getRegionRealtimeById(id));
    }
    @RequestMapping(value = "/getRegions" ,produces = "application/json;charset=UTF-8")
    public String getRegions(){
        Map<String, List<Region>> map=new HashMap<>(2);
        map.put("china_data",regionService.getRegions());
        map.put("world_data",regionService.getWorld());
        return JSON.toJSONString(map);
    }

//    @RequestMapping(value = "/getWorld" ,produces = "application/json;charset=UTF-8")
//    public String getWorld(){
//        Map<String, List<Region>> map=new HashMap<>(2);
//        //map.put("china_data",regionService.getRegions());
//        map.put("world_data",regionService.getWorld());
//        return JSON.toJSONString(map);
//    }

    /*
    *  get image by id
    * @param id  path parameter
    * request pattern:http://{host}:8081/getImage/{your id}
    * @return byte of file
    * */

    @GetMapping(value = "/getChina/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody

    public byte[] getChina(@PathVariable long id) throws Exception{
        return MyFileUtil.getFile("/root/chinaImg/"+id+".png");
        //return MyFileUtil.getFile("D:\\images\\"+id+".png");
    }

    @GetMapping(value = "/getWorld/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody

    public byte[] getWolrd(@PathVariable long id) throws Exception{
        return MyFileUtil.getFile("/root/worldImg/"+id+".png");
        //return MyFileUtil.getFile("D:\\images\\"+id+".png");
    }

}
