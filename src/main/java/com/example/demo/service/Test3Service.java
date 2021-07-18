package com.example.demo.service;

import com.example.demo.dao.Test3Dao;
import com.example.demo.structs.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test3Service implements Test3Dao {
    @Autowired
    private Test3Dao test3Dao;

    @Autowired
    public void setTest3Dao(Test3Dao test3Dao){
        this.test3Dao = test3Dao;
    }

    @Override
    public Judge judgeById(Integer id) {
        return test3Dao.judgeById(id);
    }

    @Override
    public List<Judge> judge() {
        return test3Dao.judge();
    }

    @Override
    public int judgeAdd(Judge judge) {
        return test3Dao.judgeAdd(judge);
    }

    @Override
    public Judge judge_wById(Integer id) {
        return test3Dao.judge_wById(id);
    }

    @Override
    public List<Judge> judge_w() {
        return test3Dao.judge_w();
    }

    @Override
    public int judgeDelete(Integer id) {
        return test3Dao.judgeDelete(id);
    }

    @Override
    public int j_w_count() {
        return test3Dao.j_w_count();
    }
    @Override
    public Judge judge_cById(Integer id) {
        return test3Dao.judge_cById(id);
    }

    @Override
    public int judge_cDelete(Integer id) {
        return test3Dao.judge_cDelete(id);
    }
    @Override
    public int judge_cAdd(Judge judge) {
        return test3Dao.judge_cAdd(judge);
    }

}

