package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    // oracle获取序列主键
    boolean insertEmpNoPK(Emp emp);

    // oracle批量插入
    int insertBatchTestOracleTwo(@Param("empList") List<Emp> empList);

    int insertBatchTestOracle(List<Emp> empList);
}
