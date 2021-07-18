package com.whz;

import com.whz.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//测试MyBatis
public class MyBatisTest {
    @Test
    public void t1() throws IOException {
        //加载核心配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建一个SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象,SqlSession对象执行sql语句
        SqlSession session = build.openSession(true);
        //第一个参数 定位sql
        /*
        * 对于增删改操作，返回的是数据库表数据的受影响行数
        * 查询有可能返回一个对象，也有可能返回一个装着对象的集合
        *
        * 事务：
        * MyBatis是不支持自动事务处理
        * 什么时候要用到事务？
        * 对于增删改操作的时候，需要手动提交事务
        * 两种方式：
        *session.commit();
        *
        * */
        int row = session.insert("user.addUser");
        //手动提交事务
        //session.commit();
        if (row!=1){
            System.out.println("添加失败");
        }else {
            System.out.println("添加成功"+row);
        }
        //关闭会话对象
        session.close();
    }

    //测试
    @Test
    public void t2() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //准备参数
        User user = new User();
        user.setUserName("李白");
        user.setPwd("134113");
        user.setTel("6868");
        user.setAddress("广东");
        //定位sql
        int row=session.insert("user.insertUser",user);
        //执行
        if (row!=1){
            System.out.println("添加失败");
        }else {
            System.out.println("添加成功");
        }
        //关闭session
        session.close();
    }

    //根据id 删除数据
    @Test
    public void t3() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //准备参数
        Integer id=2;
        //定位到sql
        int row = session.delete("user.deleteByUid", id);
        System.out.println("row:"+row);
        //关闭
        session.close();
    }

    //根据id 修改数据
    @Test
    public void t4() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //准备参数
        User user = new User();
        user.setUid(3);
        user.setUserName("张三");
        user.setPwd("123456");
        user.setTel("0916123");
        user.setAddress("上海");
        //定位到sql
        int row = session.update("user.updateUserByUid", user);
        System.out.println("row:"+row);
        //关闭
        session.close();
    }

    //查询数据
    @Test
    public void t5() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //定位到sql
        List<User> list = session.selectList("user.findAllUsers");
        //遍历集合
        for (User u:list){
            System.out.println(u);
        }
        //关闭
        session.close();
    }

    //根据uid查询数据
    @Test
    public void t6() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //准备参数
        Integer uid=4;
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //定位到sql
        List<Object> objects = session.selectList("user.findUsers", uid);
        for (Object u:objects){
            System.out.println(u);
        }
        //关闭
        session.close();
    }

    @Test
    public void t7() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //相当于获取DeptMapper代理实现类
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //封装参数
        Dept dept=new Dept();
        dept.setDeptName("人事部");
        dept.setDeptLoc("上海");
        int row=mapper.addDeptInfo(dept);
        System.out.println(row);
        session.close();
    }

    @Test
    public void t8() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //相当于获取DeptMapper代理实现类
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //封装参数
        int id=2;
        int row=mapper.deleteDept(id);
        System.out.println(row);
        session.close();
    }

    @Test
    public void t9() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        //相当于获取DeptMapper代理实现类
        DeptMapper mapper =
                session.getMapper(DeptMapper.class);
        //封装参数
        Dept dept=new Dept();
        dept.setId(3);
        dept.setDeptName("法务部");
        dept.setDeptLoc("北京");
        int row=mapper.changeDeptById(dept);
        System.out.println(row);
        session.close();
    }

    @Test
    public void t10() throws IOException {
        //加载配置文件
        InputStream in =
                Resources.getResourceAsStream("mybatis.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = build.openSession(true);
        List<Dept> list=session.selectList("com.whz.mapper.DeptMapper.selectDepts");
        for (Dept u:list){
            System.out.println(u);
        }
        session.close();
    }
}
