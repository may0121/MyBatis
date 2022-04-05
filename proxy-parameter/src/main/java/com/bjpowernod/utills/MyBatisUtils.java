package com.bjpowernod.utills;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author may
 * @date 2022/4/4 15:06
 */
public class MyBatisUtils {

   private static SqlSessionFactory factory=null;
static {
    String config = "mybatis.xml";
    try {
        InputStream inputStream = Resources.getResourceAsStream(config);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    //创建方法获取SqlSession 对象
    public  static SqlSession getSqlSession(){
    SqlSession session = null;
    if (factory!=null){
        session = factory.openSession();
    }
    return session;
    }
}
