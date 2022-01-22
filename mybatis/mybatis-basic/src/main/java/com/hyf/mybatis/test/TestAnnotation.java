package com.hyf.mybatis.test;

import com.hyf.mybatis.anno.TeacherAnn;
import com.hyf.mybatis.anno.TeacherAnnMapper;
import com.hyf.mybatis.anno.UserAnn;
import com.hyf.mybatis.anno.UserAnnMapper;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestAnnotation {

    private SqlSession sqlSession = null;
    private SqlSessionFactory factory = null;

    @BeforeEach
    public void init() {
        sqlSession = MyBatisUtil.getSqlSession();
        factory = MyBatisUtil.getSqlSessionFactory();
    }

    @AfterEach
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void testSelect() {
        UserAnnMapper mapper = sqlSession.getMapper(UserAnnMapper.class);

        // like查询
        List<UserAnn> userLike = mapper.selectUserAnnByName("测试");
        userLike.forEach(System.out::print);
        System.out.println();

        // 使用 like查询中的ResultMap 映射字段
        List<UserAnn> userAll = mapper.selectAllUser();
        userAll.forEach(System.out::print);
        System.out.println();

        // 一对一查询 一个学生对应一个老师
        UserAnn userAnn = mapper.selectUserWithOneTeacher(100);
        System.out.println(userAnn);
        System.out.println();

        //一对多查询 一个老师对应多个学生
        TeacherAnnMapper mapperT = sqlSession.getMapper(TeacherAnnMapper.class);
        TeacherAnn teacherAnn = mapperT.selectTeacherWithManyUser(201);
        System.out.println(teacherAnn);
    }

    @Test
    public void testAnnotationSecondCache () {
        UserAnnMapper mapper = sqlSession.getMapper(UserAnnMapper.class);
        UserAnn userAnn = mapper.selectUserWithOneTeacher(100);
        System.out.println(userAnn);
        sqlSession.close();

        SqlSession sqlSession = factory.openSession(true);
        UserAnnMapper mapper2 = sqlSession.getMapper(UserAnnMapper.class);
        UserAnn userAnn2 = mapper2.selectUserWithOneTeacher(100);
        System.out.println(userAnn2);
    }
}
