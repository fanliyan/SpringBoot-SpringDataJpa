package com.fanliyan.SpringDataTest.SpringData.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello World!";
    }
}
