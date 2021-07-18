package com.example.demo.controller;
import com.example.demo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyUser {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/mapv")
    public Map<String ,String > mapv(){
        Map<String ,String > map = new HashMap<>();
        map.put("value1","1");
        map.put("value2","2");
        return map;
    }
}

