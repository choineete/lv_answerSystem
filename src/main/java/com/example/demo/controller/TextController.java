package com.example.demo.controller;

import com.example.demo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/fly")
public class TextController{
    @Autowired
    TextService textService;
    @RequestMapping(value = "/textGetList",method = RequestMethod.POST)
    @ResponseBody
    public int geta(){
        return textService.geta();
    }

}
