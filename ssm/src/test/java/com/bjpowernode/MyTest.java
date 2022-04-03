package com.bjpowernode;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author may
 * @date 2022/4/3 17:10
 */
public class MyTest {
    //测试mybatis 执行SQL语句
    @Test
    public void testSelectStudentById() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件的sql语句

        //定义mybatis住配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //使用mybatis的resources类 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //使用SqlSessionFactoryBuilder类，创建factory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //指定要执行的sql语句的id
        //sql语句的id =namespace+"."+增删改查的id属性值
        String sqlId = "com.bjpowernode.dao.StudentDao"+"."+"selectStudentById";
        //通过SqlSession方法执行sql语句
        Student student = session.selectOne(sqlId,1);
        System.out.println("使用mybatis查询一个学生："+student);

        //关闭sqlsession对象
        session.close();


    }
    @Test
    public void testSelectStudentById2() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件的sql语句

        //定义mybatis住配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //使用mybatis的resources类 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //使用SqlSessionFactoryBuilder类，创建factory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //指定要执行的sql语句的id
        //sql语句的id =namespace+"."+增删改查的id属性值
        String sqlId = "com.bjpowernode.dao.StudentDao"+"."+"selectStudentById";
        //通过SqlSession方法执行sql语句
      Student student = session.selectOne(sqlId,2);
        System.out.println("使用mybatis查询一个学生："+student);

        //关闭sqlsession对象
        session.close();


    }

    @Test
//插入一个学生
    public void testInsertStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件的sql语句

        //定义mybatis住配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //使用mybatis的resources类 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //使用SqlSessionFactoryBuilder类，创建factory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //指定要执行的sql语句的id
        //sql语句的id =namespace+"."+增删改查的id属性值
        String sqlId = "com.bjpowernode.dao.StudentDao"+"."+"insertStudent";


        //通过SqlSession方法执行sql语句

        Student student = new Student();
        student.setId(5);
        student.setName("春梅");
        student.setEmail("chunmei@qq.com");
        student.setAge(20);

        int rows = session.insert(sqlId,student);
        System.out.println("使用mybatis插入一个学生,rows="+rows);

        //mybatis 默认执行sql语句 手工提交，在执行update，insert delete 要提交事务
        session.commit();


        //关闭sqlsession对象
        session.close();


    }


    //修改student信息
    @Test
    public void testUpdateStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件的sql语句

        //定义mybatis住配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //使用mybatis的resources类 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //使用SqlSessionFactoryBuilder类，创建factory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //指定要执行的sql语句的id
        //sql语句的id =namespace+"."+增删改查的id属性值
        String sqlId = "com.bjpowernode.dao.StudentDao"+"."+"updateStudent";


        //通过SqlSession方法执行sql语句

        Student student = new Student();
        student.setId(5);
        student.setName("chunmei");
        student.setEmail("chunmei@qq.com");
        student.setAge(20);

        int rows = session.update(sqlId,student);
        System.out.println("使用mybatis修改一个学生信息："+rows);

        //手动提交
        session.commit();

        //关闭sqlsession对象
        session.close();
    }

    //删除一个学生信息
    @Test
    public void testDeleteStudent() throws IOException {
        //调用mybatis某个对象的方法，执行mapper文件的sql语句

        //定义mybatis住配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //使用mybatis的resources类 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //使用SqlSessionFactoryBuilder类，创建factory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //指定要执行的sql语句的id
        //sql语句的id =namespace+"."+增删改查的id属性值
        String sqlId = "com.bjpowernode.dao.StudentDao"+"."+"deleteStudent";


        //通过SqlSession方法执行sql语句
        int rows = session.update(sqlId,5);
        System.out.println("使用mybatis修改一个学生信息："+rows);

        //手动提交
        session.commit();

        //关闭sqlsession对象
        session.close();
    }
}
