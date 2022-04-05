package com.bjpowernod.dao;

import com.bjpowernod.entity.Student;
import com.bjpowernod.vo.ObjectParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查看学生信息
    Student selectStudent (Integer id);

    //简单参数(java基本类型和String)
    Student selectOne (String email);

    /*多个简单参数
    使用@param命名参数，在形参的定义前面
    属性：value自定义参数名称
    */
    List<Student> selectByNameOrAge (@Param("myname") String name,
                                     @Param("myage") Integer age);
    //用一个java对象做形参
    List<Student> selectObject(Student student);
    //可以用任意java对象做形参不一定是实体类
    List<Student>VoParam(ObjectParam objectParam);

    //添加学生信息
    int insertStudent (Student student);

    //修改学生信息
    int updateStudent(@Param("name") String name,
                      @Param("id") Integer id);
}
