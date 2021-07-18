package com.example.demo.service;

import com.example.demo.dao.TextDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextService {
    @Autowired  //自动装配
    TextDao textDao;
    public int geta(){
        return textDao.test1();
    }
}