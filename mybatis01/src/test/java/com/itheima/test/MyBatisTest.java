package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.IUserDao2;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testFindAll() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //使用构建着创建工厂对象SqlSessionFactory
        SqlSessionFactory factory = builder.build(is);
        //使用SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession();
        //使用SqlSession创建dao的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //使用代理对象执行查询所有的方法
        List<User> users = userDao.findAll();
        //遍历
        for (User user : users) {
            System.out.println(user);
        }

        //释放资源
        session.close();
        is.close();
    }

    @Test
    public void testFindAll2() throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //使用构建着创建工厂对象SqlSessionFactory
        SqlSessionFactory factory = builder.build(is);
        //使用SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession();
        //使用SqlSession创建dao的代理对象
        IUserDao2 userDao = session.getMapper(IUserDao2.class);
        //使用代理对象执行查询所有的方法
        List<User> users = userDao.findAll2();
        //遍历
        for (User user : users) {
            System.out.println(user);
        }

        //释放资源
        session.close();
        is.close();
    }

}
