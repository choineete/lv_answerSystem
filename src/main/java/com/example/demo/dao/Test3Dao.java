package com.example.demo.dao;

import com.example.demo.structs.Judge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Test3Dao {
    Judge judgeById(@Param("id") Integer id);
    List<Judge> judge();
    int judgeAdd(Judge judge);
    Judge judge_wById(@Param("id") Integer id);
    List<Judge> judge_w();
    int judgeDelete(@Param("id") Integer id);
    int j_w_count();
    Judge judge_cById(@Param("id") Integer id);
    int judge_cDelete(@Param("id") Integer id);
    int judge_cAdd(Judge judge);
}