package com.hyf.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;

/**
 * 测试 CRUD
 */
public class TestCRUD
{

    @Test
    public void getUserById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 传入映射接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(2);
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void getAllUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 传入映射接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAllUser();
        sqlSession.close();
        System.out.println(userList);
    }

    @Test
    public void insertUser() {
        User user = new User(null, "理工大", 29);
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            // 传入映射接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.insertUser(user);
            System.out.println(i);
        }
    }

    @Test
    public void updateUser() {
        User user = new User(1, "撒非旦个法", 18);
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            // 传入映射接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            long l = mapper.updateUser(user);
            System.out.println(l);
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            // 传入映射接口
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            boolean result = mapper.deleteUserById(3);
            System.out.println(result);
        }
    }
}
