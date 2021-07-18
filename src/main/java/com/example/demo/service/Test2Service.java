package com.example.demo.service;

import com.example.demo.dao.Test2Dao;
import com.example.demo.structs.Multiple_Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test2Service implements Test2Dao {
    @Autowired
    private Test2Dao test2Dao;

    @Autowired
    public void setTest2Dao(Test2Dao test2Dao){
        this.test2Dao = test2Dao;
    }

    @Override
    public Multiple_Choice multiple_choiceById(Integer id) {
        return test2Dao.multiple_choiceById(id);
    }

    @Override
    public List<Multiple_Choice> multiple_choice() {
        return test2Dao.multiple_choice();
    }

    @Override
    public int multiple_choiceAdd(Multiple_Choice multiple_choice) {
        return test2Dao.multiple_choiceAdd(multiple_choice);
    }

    @Override
    public Multiple_Choice multiple_choice_wById(Integer id) {
        return test2Dao.multiple_choice_wById(id);
    }

    @Override
    public List<Multiple_Choice> multiple_choice_w() {
        return test2Dao.multiple_choice_w();
    }

    @Override
    public int multiple_choiceDelete(Integer id) {
        return test2Dao.multiple_choiceDelete(id);
    }

    @Override
    public int m_w_count() {
        return test2Dao.m_w_count();

    }

    @Override
    public Multiple_Choice multiple_choice_cById(Integer id) {
        return test2Dao.multiple_choice_cById(id);
    }

    @Override
    public int multiple_choice_cDelete(Integer id) {
        return test2Dao.multiple_choice_cDelete(id);
    }

    @Override
    public int multiple_choice_cAdd(Multiple_Choice multiple_choice) {
        return test2Dao.multiple_choice_cAdd(multiple_choice);
    }
}

