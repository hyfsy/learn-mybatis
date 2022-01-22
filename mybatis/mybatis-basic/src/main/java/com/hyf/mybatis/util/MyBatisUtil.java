package com.hyf.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {

    private static final String JDBC_MAIN_PROP = "conf/mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(JDBC_MAIN_PROP);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动提交事务
     *
     * @return SqlSession对象
     */
    public static SqlSession getSqlSession() {
        return getSqlSession(true);
    }

    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return sqlSessionFactory.openSession(isAutoCommit);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
