package com.bjpowernode;

import com.bjpowernod.dao.StudentDao;
import com.bjpowernod.entity.Student;
import com.bjpowernod.utills.MyBatisUtils;
import com.bjpowernod.vo.ObjectParam;
import com.bjpowernod.vo.TestObject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author may
 * @date 2022/4/4 15:19
 */
public class MyTest {
    @Test
    public void selectIf(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(25);
        student.setName("张三");
        List<Student> students = dao.selectIf(student);
        students.forEach(student1 -> System.out.println("学生信息="+student1));
        session.close();
    }

    @Test
    public void selectWhere(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(0);
        student.setName("张三");
//        student.setName("张三");
        List<Student> students = dao.selectIf(student);
        students.forEach(student1 -> System.out.println("学生信息="+student1));
        session.close();
    }


    //foreach 简单类型
    @Test
    public void selectForeachOne(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Integer> id = new ArrayList();
        id.add(1);
        id.add(2);
        id.add(3);
        List<Student> students = dao.selectForeachOne(id);
        students.forEach(student -> System.out.println(student));
        session.close();
    }

//    foreach  对象类型
    @Test
    public void selectForeachTwo(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(2);
       Student student2 = new Student();
        student2.setId(5);
       list.add(student1);
       list.add(student2);
        List<Student> students = dao.selectForeachTwo(list);
        students.forEach(student -> System.out.println(student));
    }
}