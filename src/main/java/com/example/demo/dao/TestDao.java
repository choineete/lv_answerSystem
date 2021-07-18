package com.example.demo.dao;

import com.example.demo.structs.Single_Choice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestDao {
    Single_Choice single_choiceById(@Param("id") Integer id);

    List<Single_Choice> single_choice();

    int single_choiceAdd(Single_Choice single_choice);

    Single_Choice single_choice_wById(@Param("id") Integer id);

    List<Single_Choice> single_choice_w();

    int single_choiceDelete(@Param("id") Integer id);

    int s_w_count();

    Single_Choice single_choice_cById(@Param("id") Integer id);

    int single_choice_cDelete(@Param("id") Integer id);

    int single_choice_cAdd(Single_Choice single_choice);
}
