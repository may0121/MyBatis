package com.bjpowernode;

import com.bjpowernod.dao.StudentDao;
import com.bjpowernod.entity.Student;
import com.bjpowernod.utills.MyBatisUtils;
import com.bjpowernod.vo.ObjectParam;
import com.bjpowernod.vo.TestObject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author may
 * @date 2022/4/4 15:19
 */
public class MyTest {
    @Test
    public void selectStudentbyId() {
        //获取SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectStudentbyId(1);
        System.out.println("学生信息=" + student);
        session.close();
    }

    @Test
    public void select() {
        //获取SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
         TestObject object = dao.select(1);
        System.out.println("学生信息=" + object);
        session.close();
    }

    @Test
    public void countStudent() {
        //获取SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        long result = dao.countStudent();
        System.out.println("学生信息=" + result);
        session.close();
    }

//    map

    @Test
    public void selectAsMap() {
        //获取SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectAsMap(3);
        System.out.println("学生信息=" + map);
        session.close();
    }
//    模糊查询like第一种方式
    @Test
    public void selectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
//        String name = "%李%";
        List<Student> students = dao.selectLikeOne("%李%");
        students.forEach(student -> System.out.println("学生信息="+student));
        sqlSession.close();
    }

    @Test
    public void selectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
//        String name = "%李%";
        List<Student> students = dao.selectLikeTwo("张");
        students.forEach(student -> System.out.println("学生信息="+student));
        sqlSession.close();
    }
}