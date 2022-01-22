package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.EmpMapper;
import com.hyf.mybatis.pojo.PageEmp;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestProcedure {

    @Test
    public void testOracleRownumProcedure() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            // 查询第二条到第四条的数据
            PageEmp pageEmp = new PageEmp(2, 4);
            System.out.println(pageEmp);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            mapper.callProcedureSelectEmpListUsePage3(pageEmp);
            System.out.println(pageEmp);
        }
    }
}
