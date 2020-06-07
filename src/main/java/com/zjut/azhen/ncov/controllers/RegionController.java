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
import java.util.*;

@RestController
@RequestMapping("/testBoot")
public class RegionController {

    private final RegionService regionService;

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

    @GetMapping(value = "/getRank/{type}/{num}",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getRank(@PathVariable String type,@PathVariable Integer num){

        if(num<0 ||num>20){
            return "invalid num!";
        }
        Map<String,Object> map=new HashMap<>(2);
        List<Object> list=new ArrayList<>(),list1=new ArrayList<>();
        List<Region> list2;
        if("world".equals(type)){
        list2=regionService.getWorldRank(num);
        }
        else if("china".equals(type)){
            list2=regionService.getChinaRank(num);
        }
        else {
            //打成404
            return "invalid request";
        }
        Collections.reverse(list2);
        for(Region region : list2){
            list.add(region.getName());
            list1.add(region.getConfirmed());
        }

        map.put("x_data",list);
        map.put("y_data",list1);

        return JSON.toJSONString(map);
    }




}
