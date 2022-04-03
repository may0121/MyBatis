package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询一个学生
    Student selectStudentById(Integer id);

    //添加一个学生 返回值代表影响的行数
    //大于0
    int insertStudent(Student student);

    //修改一个学生信息
    int updateStudent(Student student);
    //删除一个学生信息
    int deleteStudent(Student student);
}
