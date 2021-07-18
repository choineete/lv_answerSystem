package com.example.demo.controller;

import com.example.demo.service.Test2Service;
import com.example.demo.structs.Multiple_Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test2Controller {
    @Autowired
    private Test2Service test2Service;
    @RequestMapping("/queryTest2")
    private List<Multiple_Choice> queryTest2(){
        List<Multiple_Choice> test2List = test2Service.multiple_choice();
        return test2List;
    }
    @RequestMapping("/queryByIdTest2")
    private Multiple_Choice queryByIdTest(Integer id){
        Multiple_Choice test2List = test2Service.multiple_choiceById(id);
        return test2List;
    }
    @RequestMapping("/addTest2")
    public boolean multiple_choiceAdd(Multiple_Choice multiple_choice){
        int count = test2Service.multiple_choiceAdd(multiple_choice);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/query_wTest2")
    private List<Multiple_Choice> query_wTest2(){
        List<Multiple_Choice> test2List = test2Service.multiple_choice_w();
        return test2List;
    }
    @RequestMapping("/query_wByIdTest2")
    private Multiple_Choice query_wByIdTest(Integer id){
        Multiple_Choice test2List = test2Service.multiple_choice_wById(id);
        if(test2List == null){
            test2List = query_wByIdTest(id+1);
        }else{
            return test2List;
        }
        return test2List;
    }
    @RequestMapping("/deleteTest2")
    private boolean multiple_choiceDelete(Integer id){
        int count = test2Service.multiple_choiceDelete(id);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/wrongCount2")
    private int m_w_count(){
        return test2Service.m_w_count();
    }
    @RequestMapping("/query_cByIdTest2")
    private Multiple_Choice query_cByIdTest(Integer id){
        Multiple_Choice test2List = test2Service.multiple_choice_cById(id);
        if(test2List == null){
            test2List = query_cByIdTest(id+1);
        }else{
            return test2List;
        }
        return test2List;
    }
    @RequestMapping("/delete_cTest2")
    private boolean multiple_choice_cDelete(Integer id){
        int count = test2Service.multiple_choice_cDelete(id);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/add_cTest2")
    public boolean multiple_choice_cAdd(Multiple_Choice multiple_choice){
        int count = test2Service.multiple_choice_cAdd(multiple_choice);
        if(count>0)
            return true;
        else
            return false;
    }
}