package com.ricky.clothes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseAppController{

    @RequestMapping("/")
    public String index(){

        return "index";
    }
}
