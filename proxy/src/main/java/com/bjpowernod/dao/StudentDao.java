package com.bjpowernod.dao;

import com.bjpowernod.entity.Student;

import java.util.List;

public interface StudentDao {
    //查看学生信息
    Student selectStudent (Integer id);
    //查看多个学生信息
    List <Student> selectStudents();
    //插入学生信息
    int insertStudent ();
}
