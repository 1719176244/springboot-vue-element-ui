package com.wfs.springvue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wfs")
public class WfsController {

    @RequestMapping("test1")
    public String test1(){
        return  "wfs test1";
    }
}
