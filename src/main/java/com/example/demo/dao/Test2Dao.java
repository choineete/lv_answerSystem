package com.example.demo.dao;

import com.example.demo.structs.Multiple_Choice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Test2Dao {
    Multiple_Choice multiple_choiceById(@Param("id") Integer id);
    List<Multiple_Choice> multiple_choice();
    int multiple_choiceAdd(Multiple_Choice multiple_choice);
    Multiple_Choice multiple_choice_wById(@Param("id") Integer id);
    List<Multiple_Choice> multiple_choice_w();
    int multiple_choiceDelete(@Param("id") Integer id);
    int m_w_count();
    int multiple_choice_cDelete(@Param("id") Integer id);
    Multiple_Choice multiple_choice_cById(@Param("id") Integer id);
    int multiple_choice_cAdd(Multiple_Choice multiple_choice);
}