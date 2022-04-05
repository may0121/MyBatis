package com.bjpowernode;

import com.bjpowernod.entity.Student;
import com.bjpowernod.utills.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author may
 * @date 2022/4/4 15:19
 */
public class MyTest {
@Test
    public void selectStudent (){
    //获取SqlSession 对象
    SqlSession session = MyBatisUtils.getSqlSession();
    //指定sqlId
    String sqlId = "com.bjpowernod.dao.StudentDao.selectStudent";
    //执行sqlSession的方法
    Student student = session.selectOne(sqlId,2);
    //查看学生的信息
    System.out.println("查询的学生信息="+student);
    //关闭 session
    session.close();
}

//查询多个学生信息
    @Test
    public void selectStudents (){
        //获取SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        //指定sqlId
        String sqlId = "com.bjpowernod.dao.StudentDao.selectStudents";
        //执行sqlSession的方法
        List<Student> students = session.selectList(sqlId);
        //查看学生的信息
        for (Student student:students) {
            System.out.println(student);
        }
        //关闭 session
        session.close();
    }

    //插入学生信息
    @Test
    public void insertStudent(){
        SqlSession session = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernod.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setId(5);
        student.setName("xx");
        student.setEmail("xx@qq.com");
        student.setAge(21);
        int rows = session.insert(sqlId,student);
        System.out.println("受影响的行数："+rows);

        session.commit();
        session.close();

    }

}
