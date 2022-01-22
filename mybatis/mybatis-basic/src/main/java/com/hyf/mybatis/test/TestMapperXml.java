package com.hyf.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyf.mybatis.mapper.TeacherMapper;
import com.hyf.mybatis.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.pojo.UserTo;
import com.hyf.mybatis.util.MyBatisUtil;

public class TestMapperXml
{

    /**
     * 测试多个参数
     */
    @Test
    public void testManyParameter() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 1 sql参数直接就是 param1、param2.....
            User user = mapper.selectUserWithManyParam1(1, 18);
            System.out.println(user);

            // 2 sql参数用 @Param 注解指定
            user = mapper.selectUserWithManyParam2(1, 18);
            System.out.println(user);

            // 3 sql参数封装在一个map中
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put("id", 1);
            paramsMap.put("age", 18);
            user = mapper.selectUserWithManyParam3(paramsMap);
            System.out.println(user);

            // 4 sql参数放入到一个TO对象中
            user = mapper.selectUserWithManyParam4(new UserTo(1, 18));
            System.out.println(user);
        }
    }

    /**
     * 测试不同的返回值
     */
    @Test
    public void testReturnValue() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 1 将返回数据放入集合
            List<User> userList = mapper.selectUserReturnList("%测试%");
            System.out.println(userList);

            // 2 将一条数据的字段名与值映射
            Map<String, Object> userMap = mapper.selectUserReturnMap(1);
            System.out.println(userMap);

            // 3 指定key，将多条数据与其对应key映射
            Map<String, User> assignMap = mapper.selectUserReturnAssignMap("%测试%");
            System.out.println(assignMap);
        }
    }

    /**
     * 简单测试 resultMap
     */
    @Test
    public void testResultMap () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectUserUseResultMap(1);
            System.out.println(users);
        }
    }

    /**
     * 使用 . 获取级联对象的属性
     */
    @Test
    public void testResultMapPointSymbol () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserUseResultMapByPointSymbol(1);
            System.out.println(user);
        }
    }

    /**
     * 分布查询结果放入对象属性 + 测试延迟加载
     */
    @Test
    public void testResultMapAssociation () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserUseResultMapAssociation(1);
            // 看日志
            System.out.println(user.getId());
            // 中间会执行关联sql
            System.out.println(user.getTeacher());
        }
    }

    /**
     * 测试一对多查询结果注入
     */
    @Test
    public void testTeacherCollection () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.selectTeacherTestCollection(1);
            System.out.println(teacher);
        }
    }

    /**
     * 测试一对多分布查询 + 测试延迟加载
     */
    @Test
    public void testTeacherCollectionStep () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.selectTeacherCollectionStep(1);
            System.out.println(teacher.gettName());
            System.out.println(teacher.getUserList());
        }
    }

    /**
     * 测试 鉴别器
     * id为1，查询出其教师信息
     * id为2，将age值设置为其id值
     */
    @Test
    public void testResultMapDiscriminator () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 查看效果
            User user = mapper.testResultMapDiscriminator(1);
            System.out.println(user);
            user = mapper.testResultMapDiscriminator(2);
            System.out.println(user);
        }
    }

}
