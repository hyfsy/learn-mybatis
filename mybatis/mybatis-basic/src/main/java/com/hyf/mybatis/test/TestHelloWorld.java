package com.hyf.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.mapper.UserMapperAnnotation;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;

public class TestHelloWorld
{

    /**
     * 老编程
     */
    @Test
    public void test1() throws IOException {
        // 从resources文件夹开始的根目录中获取资源文件
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过mybatis配置文件中获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象，相当于JDBC的Connection对象，默认不会自动提交事务，用完一定要关闭
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // statement字符串为命名空间+id
            User user = sqlSession.selectOne("com.hyf.mybatis.mapper.UserMapper.selectUserById", 1);
            System.out.println(user);
        }
    }

    /**
     * 接口式编程
     */
    @Test
    public void test2() {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserById(1);
            System.out.println(user);
            // 代理对象
            System.out.println(mapper);
        }
    }

    /**
     * 基于接口注解（不推荐）
     */
    @Test
    public void test3() {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapperAnnotation mapper = sqlSession.getMapper(UserMapperAnnotation.class);
            User user = mapper.selectUserById(1);
            System.out.println(user);
            // 代理对象
            System.out.println(mapper);
        }
    }
}
