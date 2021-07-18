package com.example.demo.controller;

import com.example.demo.service.Test3Service;
import com.example.demo.structs.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test3Controller {
    @Autowired
    private Test3Service test3Service;
    @RequestMapping("/queryTest3")
    private List<Judge> queryTest3(){
        List<Judge> test3List = test3Service.judge();
        return test3List;
    }
    @RequestMapping("/queryByIdTest3")
    private Judge queryByIdTest(Integer id){
        Judge test3List = test3Service.judgeById(id);
        return test3List;
    }
    @RequestMapping("/addTest3")
    public boolean judgeAdd(Judge judge){
        int count = test3Service.judgeAdd(judge);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/query_wTest3")
    private List<Judge> query_wTest3(){
        List<Judge> test3List = test3Service.judge_w();
        return test3List;
    }
    @RequestMapping("/query_wByIdTest3")
    private Judge query_wByIdTest(Integer id){
        Judge test3List = test3Service.judge_wById(id);
        if(test3List == null){
            test3List = query_wByIdTest(id+1);
        }else{
            return test3List;
        }
        return test3List;
    }
    @RequestMapping("/deleteTest3")
    private boolean judgeDelete(Integer id){
        int count = test3Service.judgeDelete(id);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/wrongCount3")
    private int j_w_count(){
        return test3Service.j_w_count();
    }
    @RequestMapping("/query_cByIdTest3")
    private Judge query_cByIdTest(Integer id){
        Judge test3List = test3Service.judge_cById(id);
        if(test3List == null){
            test3List = query_cByIdTest(id+1);
        }else{
            return test3List;
        }
        return test3List;
    }
    @RequestMapping("/delete_cTest3")
    private boolean judge_cDelete(Integer id){
        int count = test3Service.judge_cDelete(id);
        if(count>0)
            return true;
        else
            return false;
    }
    @RequestMapping("/add_cTest3")
    public boolean judge_cAdd(Judge judge){
        int count = test3Service.judge_cAdd(judge);
        if(count>0)
            return true;
        else
            return false;
    }
}