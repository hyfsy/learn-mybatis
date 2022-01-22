package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.EmpMapper;
import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.Emp;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDynamicSql {

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

    /**
     * mysql批量插入
     * <p>
     * 插入几条就返回几条
     */
    @Test
    public void testForeachBatchInsertUseMysql() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 第一种mysql插入方式
            List<User> userList = new ArrayList<>();
            for (int i = 21; i < 24; i++) {
                userList.add(new User(i, "多插名称" + i, i));
            }
            int size = mapper.insertBatchTestMysql(userList);
            System.out.println(size);
        }
    }

    /**
     * 第二种mysql插入方式
     * <p>
     * 只会返回 [1] 条修改
     */
    @Test
    public void testForeachBatchInsertUseMysqlTwo() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 第二种mysql插入方式
            List<User> userList = new ArrayList<>();
            for (int i = 45; i < 47; i++) {
                userList.add(new User(i, "多插名称" + i, i));
            }
            int size = mapper.insertBatchTestMysqlTwo(userList);
            System.out.println(size);
        }
    }

    /**
     * 第一种oracle批量插入
     * <p>
     * 插入几条就返回几条
     */
    @Test
    public void testForeachBatchInsertUseOracleTwo() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 第二种oracle批量插入方式
            List<Emp> empList = new ArrayList<>();
            for (int i = 1; i < 4; i++) {
                empList.add(new Emp(i, "第二种oracle多插名称" + i, i + ""));
            }
            int size = mapper.insertBatchTestOracleTwo(empList);
            System.out.println(size);
        }
    }

    /**
     * 第二种oracle批量插入
     * <p>
     * 返回 [-1] 条修改
     */
    @Test
    public void testForeachBatchInsertUseOracle() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // oracle批量插入方式
            List<Emp> userList = new ArrayList<>();
            for (int i = 34; i < 36; i++) {
                userList.add(new Emp(i, "oracle多插名称" + i, i + ""));
            }
            int size = mapper.insertBatchTestOracle(userList);
            System.out.println(size);
        }
    }

    /**
     * 如果为mysql环境，就获取到数据
     * <p>
     * 如果为oracle环境，就会返回null，因为我们mapper中的resultType的实体类字段与oracle的数据不匹配
     */
    @Test
    public void testInnerParams() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.testInnerParams(1);
            System.out.println(user);
        }
    }

    /**
     * 测试like绑定
     *
     * mapper 只能传入对象，并且绑定的属性要有 get set
     */
    @Test
    public void testLikeBind() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> user = mapper.testLikeBind(new User(100, "测", 100));
            System.out.println(user);
        }
    }

    @Test
    public void testRefSql() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> user = mapper.testRefSql();
            System.out.println(user);
        }
    }
}
