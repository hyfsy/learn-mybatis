package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.UserCacheMapper;
import com.hyf.mybatis.pojo.UserCache;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestCache {

    @Test
    public void testOneCache () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserCacheMapper mapper = sqlSession.getMapper(UserCacheMapper.class);
            UserCache user = mapper.testOneCache(1);
            System.out.println(user);

            sqlSession.clearCache();

            // 会再去执行sql
            user = mapper.testOneCache(1);
            System.out.println(user);
        }
    }
}
