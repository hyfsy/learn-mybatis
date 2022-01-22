package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.UserCacheMapper;
import com.hyf.mybatis.pojo.UserCache;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestCache {

    /**
     * 测试一级缓存
     */
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

    /**
     * 测试二级缓存 + ehcache缓存
     */
    @Test
    public void testTwoCache () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession();
             SqlSession sqlSession2 = MyBatisUtil.getSqlSession()) {
            UserCacheMapper mapper = sqlSession.getMapper(UserCacheMapper.class);
            UserCache user = mapper.testOneCache(1);
            System.out.println(user);

            sqlSession.close();
            mapper = sqlSession2.getMapper(UserCacheMapper.class);

            // 日志输出缓存命中率
            user = mapper.testOneCache(1);
            System.out.println(user);
        }
    }

    @Test
    public void testEhCacheDefaultDir () {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

}
