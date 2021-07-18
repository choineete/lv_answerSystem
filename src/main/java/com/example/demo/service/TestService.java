package com.example.demo.service;

import com.example.demo.dao.TestDao;
import com.example.demo.structs.Single_Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements TestDao {
    @Autowired
    private TestDao testDao;

    @Autowired
    public void setTestDao(TestDao testDao){
        this.testDao = testDao;
    }

    @Override
    public Single_Choice single_choiceById(Integer id) {
        return testDao.single_choiceById(id);
    }

    @Override
    public List<Single_Choice> single_choice() {
        return testDao.single_choice();
    }

    @Override
    public int single_choiceAdd(Single_Choice single_choice){
        return testDao.single_choiceAdd(single_choice);
    }

    @Override
    public Single_Choice single_choice_wById(Integer id) {
        return testDao.single_choice_wById(id);
    }

    @Override
    public List<Single_Choice> single_choice_w() {
        return testDao.single_choice_w();
    }

    @Override
    public int single_choiceDelete(Integer id) {
        return testDao.single_choiceDelete(id);
    }

    @Override
    public int s_w_count() {
        return testDao.s_w_count();
    }

    @Override
    public Single_Choice single_choice_cById(Integer id) {
        return testDao.single_choice_cById(id);
    }

    @Override
    public int single_choice_cDelete(Integer id) {
        return testDao.single_choice_cDelete(id);
    }

    @Override
    public int single_choice_cAdd(Single_Choice single_choice){
        return testDao.single_choice_cAdd(single_choice);
    }
}
