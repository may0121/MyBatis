package com.bjpowernode;

import com.bjpowernod.dao.StudentDao;
import com.bjpowernod.entity.Student;
import com.bjpowernod.utills.MyBatisUtils;
import com.bjpowernod.vo.ObjectParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author may
 * @date 2022/4/4 15:19
 */
public class MyTest {
    @Test
    public void selectStudent() {
        //获取SqlSession 对象
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectStudent(1);
        System.out.println("学生信息=" + student);
        session.close();
    }

    @Test
    public void selectOne() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectOne("zhangsan@qq.com");
        System.out.println("student=" + student);
        session.close();
    }

    @Test
    public void selectByNameOrAge() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectByNameOrAge("张三", 22);
        students.forEach(student -> System.out.println("student=" + student));
        session.close();
    }

    @Test
    public void selectObject() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student1 = new Student();
        student1.setName("李四");
        student1.setAge(22);
        List<Student> students = dao.selectObject(student1);
        students.forEach(student -> System.out.println("student=" + student));
        session.close();
    }
//    使用任意对象作形参
    @Test
    public void Params(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        ObjectParam param = new ObjectParam();
        param.setParam1("张三");
        param.setParam2(22);
        List<Student> students = dao.VoParam(param);

        students.forEach(student -> System.out.println("student="+student));
        session.close();
    }
    @Test
    public void insertStudent(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(6);
        student.setName("明明");
        student.setEmail("mingming@qq.com");
        student.setAge(23);
        int i = dao.insertStudent(student);

        session.commit();
        session.close();
    }

    //修改学生信息
    @Test
    public void updateStudent(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        int student = dao.updateStudent("小明", 6);
        session.commit();
        session.close();

    }
}