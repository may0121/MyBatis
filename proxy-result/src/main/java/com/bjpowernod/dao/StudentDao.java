package com.bjpowernod.dao;

import com.bjpowernod.entity.Student;
import com.bjpowernod.vo.ObjectParam;
import com.bjpowernod.vo.TestObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //查看学生信息
    Student selectStudentbyId (Integer id);

    TestObject select(Integer id);

    //查询学会总数（一个数值）
    long countStudent();

//    用map作为查询结果返回类型
    Map<Object,Object> selectAsMap(@Param("id") Integer id);

//    模糊查询like
    List<Student> selectLikeOne(@Param("name") String name);

    List<Student> selectLikeTwo(@Param("name") String name);


}
