package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestBatch {

    @Test
    public void testBatchInsert() {
        long start = System.currentTimeMillis();
        // 可通过openSession传入ExecutorType指定创建的Executor类型
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (int i = 1; i < 100; i++) {
                mapper.insertUser(new User(null, "batch1_" + i, i));
            }
            // 创建SqlSession时，默认AutoCommit为false，所以此处要手动提交
            sqlSession.commit();
        }

        long mid = System.currentTimeMillis();
        System.out.println("批处理执行时间：" + (mid - start));

        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (int i = 1; i < 100; i++) {
                mapper.insertUser(new User(null, "batch2_" + i, i));
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("普通执行时间：" + (end - mid));
    }
}
