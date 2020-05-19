package com.zjut.azhen.ncov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.Map;


@Controller
public class HelloController {
    @GetMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello","<h1>LeiHo!</h1>");
        map.put("user", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }




}
