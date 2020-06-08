package com.zjut.azhen.ncov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Arrays;
import java.util.Map;


@Controller
public class ChartController {
    @RequestMapping("/chart")
    public String showChart(){
        return "chart";
    }

}
