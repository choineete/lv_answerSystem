package com.example.demo.controller;

import com.example.demo.service.TestService;
import com.example.demo.structs.Single_Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/queryTest")
    private List<Single_Choice> queryTest(){
        List<Single_Choice> testList = testService.single_choice();
        return testList;
    }
    @RequestMapping("/queryByIdTest")
    private  Single_Choice queryByIdTest(Integer id){
        Single_Choice testList = testService.single_choiceById(id);
        return testList;
    }
    @RequestMapping("/addTest")
    public boolean single_choiceAdd(Single_Choice single_choice){
        int count = testService.single_choiceAdd(single_choice);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/query_wTest")
    private List<Single_Choice> query_wTest(){
        List<Single_Choice> testList = testService.single_choice_w();
        return testList;
    }
    @RequestMapping("/query_wByIdTest")
    private  Single_Choice query_wByIdTest(Integer id){
        Single_Choice testList = testService.single_choice_wById(id);
        if(testList == null){
            testList = query_wByIdTest(id+1);
        }else{
            return testList;
        }
        return testList;
    }
    @RequestMapping("/deleteTest")
    private boolean single_choiceDelete(Integer id){
        int count = testService.single_choiceDelete(id);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/wrongCount")
    private int s_w_count(){
        int count = testService.s_w_count();
        return count;
    }
    @RequestMapping("/query_cByIdTest")
    private  Single_Choice query_cByIdTest(Integer id){
        Single_Choice testList = testService.single_choice_cById(id);
        if(testList == null){
            testList = query_cByIdTest(id+1);
        }else{
            return testList;
        }
        return testList;
    }
    @RequestMapping("/delete_cTest")
    private boolean single_choice_cDelete(Integer id){
        int count = testService.single_choice_cDelete(id);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/add_cTest")
    public boolean single_choice_cAdd(Single_Choice single_choice){
        int count = testService.single_choice_cAdd(single_choice);
        if(count>0)
            return true;
        else
            return false;
    }
}
