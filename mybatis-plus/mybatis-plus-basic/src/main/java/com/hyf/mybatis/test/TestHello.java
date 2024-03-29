package com.hyf.mybatis.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hyf.mybatis.mapper.LogicUserMapper;
import com.hyf.mybatis.mapper.OracleUserMapper;
import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.LogicUser;
import com.hyf.mybatis.pojo.OracleUser;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.util.MPGeneratorUtil;
import com.hyf.mybatis.util.MybatisPlusUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestHello {

    static {
        // 注册需要使用的mapper
        MybatisPlusUtil.addMapper(UserMapper.class);
        MybatisPlusUtil.addMapper(LogicUserMapper.class);
        MybatisPlusUtil.addMapper(OracleUserMapper.class);
    }

    @Test
    public void testHelloWorld() {
        try (SqlSession sqlSession = MybatisPlusUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectList(null);
            System.out.println(users);
        }
    }

    @Test
    public void testPhysicsPage() {
        try (SqlSession sqlSession = MybatisPlusUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 物理分页，先查询出所有数据，再进行分页
            List<User> users = mapper.selectPage(new Page<>(2, 1), null);
            System.out.println(users);
        }
    }

    @Test
    public void testEntityWrapper() {
        // 查询 名称有"张"字并且年龄大于13 或者 名称有"王"字并且年龄小于15
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.like("name", "张").ge("age", 13);
        // or -> ( or )
        // orNew -> () or ()
        wrapper.orNew();
        wrapper.like("name", "王").le("age", 15);

        try (SqlSession sqlSession = MybatisPlusUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectList(wrapper);
            System.out.println(users);
        }
    }

    @Test
    public void testCondition() {
        Wrapper condition = Condition.create()
                .like("name", "张").ge("age", 13)
                .orNew()
                .like("name", "王").le("age", 15);
        try (SqlSession sqlSession = MybatisPlusUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectList(condition);
            System.out.println(users);
        }
    }

    @Test
    public void testAR() {
        User user = new User();
        // 直接使用对象调用方法即可
        List<User> users = user.selectAll();
        System.out.println(users);
        // user.deleteById(); // 此处没有该id也会返回true
    }

    /**
     * AR模式selectPage会返回一个Page对象
     */
    @Test
    public void testARPage() {
        User user = new User();
        Page<User> userPage = user.selectPage(new Page<>(2, 1), null);
        System.out.println(userPage);
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        long total = userPage.getTotal();
        int size = userPage.getSize();
        System.out.println(limit);
        System.out.println(offset);
        System.out.println(total);
        System.out.println(size);
        List<User> records = userPage.getRecords();
        System.out.println(records);
    }

    @Test
    public void testMBG() {
        MPGeneratorUtil.addTable("mp_class");
        MPGeneratorUtil.generate();
    }

    @Test
    public void testSqlExplain() {
        User user = new User();
        // user.delete(null);
    }
    
    @Test
    public void testOptimisticLock() {
        User user = new User(1,"测试修改名称",null,1);
        boolean b = user.updateById();
        System.out.println(b);
    }

    @Test
    public void testAutoSqlInjector() {
        try (SqlSession sqlSession = MybatisPlusUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            long effect = mapper.deleteAll();
            System.out.println(effect);
        }
    }

    @Test
    public void testLogicDelete() {
        LogicUser user = new LogicUser();
        user.deleteById(2);
    }
    
    @Test
    public void testMyMetaObjectHandler() {
        User user = new User();
        user.insert();
    }

    @Test
    public void testOracleSequence() {
        OracleUser oracleUser = new OracleUser(null, "测试oracle自增主键");
        oracleUser.insert();
    }

    @Test
    public void testMySqlInsertAfterSequence() {
        User user = new User(null,"测试还能插入",33);
        user.insert();
    }
}
