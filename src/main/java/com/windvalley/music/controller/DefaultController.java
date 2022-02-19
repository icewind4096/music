package com.windvalley.music.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DefaultController {

    @GetMapping("sayHello")
    public String sayHello(){
        return "你好，你看到我就说明部署好了!";
    }
}
