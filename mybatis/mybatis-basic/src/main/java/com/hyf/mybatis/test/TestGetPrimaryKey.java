package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.EmpMapper;
import com.hyf.mybatis.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;

/**
 * 获取自增主键
 */
public class TestGetPrimaryKey
{

    @Test
    public void testMySql() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "测试自增主键获取", 18);
            mapper.insertUser(user);
            System.out.println(user);
        }
    }

    @Test
    public void testOracle() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = new Emp(null, "测试oracle无自增主键获取序列插入主键", "职业讨债");
            mapper.insertEmpNoPK(emp);
            System.out.println(emp);
        }
    }
}
