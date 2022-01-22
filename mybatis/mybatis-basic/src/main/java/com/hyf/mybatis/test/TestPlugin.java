package com.hyf.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPlugin {

    @Test
    public void testPageHelper() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //只会作用于下方任意一条查询语句
            // 第三页开始，每页两条
            PageHelper.startPage(3, 2);
            mapper.insertUser(new User(null, "测试PageHelper", 23));
            // 查询出两条
            List<User> users = mapper.selectAllUser();
            users.forEach(System.out::println);
            // 此处的输出很有意思，输出一个Page对象，包含查询数据，该对象继承了 ArrayList，重写了 toString() 方法
            System.out.println(users);

            // 查询出所有
            List<User> user2 = mapper.selectAllUser();
            user2.forEach(System.out::println);
        }
    }
}
