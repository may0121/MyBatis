package com.bjpowernod.dao;

import com.bjpowernod.entity.Student;
import com.bjpowernod.vo.ObjectParam;
import com.bjpowernod.vo.TestObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectIf(Student student);

    List<Student> selectWhere(Student student);


    //foreach 简单类型
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach 对象类型
    List<Student> selectForeachTwo(List<Student> studentList);

}
