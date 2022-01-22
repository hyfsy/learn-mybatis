package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.GeneratorUserMapper;
import com.hyf.mybatis.pojo.GeneratorUser;
import com.hyf.mybatis.pojo.GeneratorUserExample;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class TestGenerator {

    @Test
    public void testGeneratedSelect () {
        GeneratorUserExample example = new GeneratorUserExample();
        // GeneratedCriteria -> 条件list中没有条件时，会添加到list，当做第一个条件，否则不会添加
        GeneratorUserExample.Criteria criteria = example.createCriteria();
        // 将新生成的条件添加到 条件list中
        GeneratorUserExample.Criteria or = example.or();

        // 生日小于当前时间
        criteria.andUserBirthdayLessThan(new Date());

        // 或者 此处为另一组条件
        // id 大于 1
        or.andUserIdGreaterThan(1);

        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            GeneratorUserMapper mapper = sqlSession.getMapper(GeneratorUserMapper.class);
            List<GeneratorUser> users = mapper.selectByExample(example);
            System.out.println(users);
        }
    }
}
