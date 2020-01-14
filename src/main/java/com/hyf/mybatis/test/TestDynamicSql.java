package com.hyf.mybatis.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.hyf.mybatis.mapper.EmpMapper;
import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.Emp;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;

public class TestDynamicSql
{

    @Test
    public void testWhere_If() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 此处的where 只有id和name条件
            User user = mapper.selectUserTestWhere_If(new User(2, "李四", 0));
            System.out.println(user);
        }
    }

    @Test
    public void testTrim() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 此处的where 只有id和name条件
            User user = mapper.selectUserTestTrim(new User(2, null, 18));
            System.out.println(user);
        }
    }

    @Test
    public void testChoose_When_Otherwise() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 此处会使用id的when判断语句
            User user = mapper.selectUserTestChoose_When_Otherwise(new User(1, null, 18));
            System.out.println(user);
        }
    }

    @Test
    public void testSet() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 此处会使用id的when判断语句
            boolean success = mapper.updateUserTestSet(new User(1, "测试动态sql set", 99));
            System.out.println(success);
        }
    }

    @Test
    public void testForEach() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 遍历 in 条件的查询
            List<User> users = mapper.selectUserListTestForEach(Arrays.asList(1, 2, 3));
            System.out.println(users);
        }
    }

    @Test
    public void testForeachBetchInsertUseMysql() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 第一种mysql插入方式
            List<User> userList = new ArrayList<>();
            for (int i = 21; i < 24; i++) {
                userList.add(new User(i, "多插名称" + i, i));
            }
            int size = mapper.insertBetchTestMysql(userList);
            System.out.println(size);

            // 第二种mysql插入方式
            userList.clear();
            for (int i = 24; i < 28; i++) {
                userList.add(new User(i, "多插名称" + i, i));
            }
            size = mapper.insertBetchTestMysqlTwo(userList);
            System.out.println(size);
        }
    }

    @Test
    public void testForeachBetchInsertUseMysqlTwo() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 第二种mysql插入方式
            List<User> userList = new ArrayList<>();
            for (int i = 28; i < 30; i++) {
                userList.add(new User(i, "多插名称" + i, i));
            }
            int size = mapper.insertBetchTestMysqlTwo(userList);
            System.out.println(size);
        }
    }

    @Test
    public void testForeachBetchInsertUseOracle() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // oracle批量插入方式
            List<Emp> userList = new ArrayList<>();
            for (int i = 28; i < 30; i++) {
                userList.add(new Emp(i, "oracle多插名称" + i, i + ""));
            }
            int size = mapper.insertBetchTestOracle(userList);
            System.out.println(size);
        }
    }
}
