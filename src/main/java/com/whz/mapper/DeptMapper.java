package com.whz.mapper;

import com.whz.Dept;

import java.util.List;

public interface DeptMapper {
    /*
    1、Mapper接口方法名和mapper.xml中定义sql的id值相同
    2、Mapper接口方法接收的参数类型和mapper.xml中定义的sql 的parameterType的类型相同
    3、Mapper接口方法的返回值类型和mapper.xml中定义的sql的resultType的类型相同
    */
    //添加数据
    int addDeptInfo(Dept dept);
    int deleteDept(Integer id);
    int changeDeptById(Dept id);
    List<Dept> selectDepts();
}
