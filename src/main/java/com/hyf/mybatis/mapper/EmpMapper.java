package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    boolean insertEmpNoPK(Emp emp);

    int insertBetchTestOracle(List<Emp> empList);

}
