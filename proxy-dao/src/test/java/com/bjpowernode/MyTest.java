package com.bjpowernode;

import com.bjpowernod.dao.StudentDao;
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
    StudentDao dao = session.getMapper(StudentDao.class);
    Student student = dao.selectStudent(1);
    System.out.println("学生信息="+student);
    session.close();
}
@Test
    public void selectStudents(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        //dao==com.sun.proxy
    System.out.println("dao=="+dao.getClass().getName());
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println("student="+student));
        session.close();
    }


}
