package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.GeneratorUser;
import com.hyf.mybatis.pojo.GeneratorUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GeneratorUserMapper {
    long countByExample(GeneratorUserExample example);

    int deleteByExample(GeneratorUserExample example);

    int insert(GeneratorUser record);

    int insertSelective(GeneratorUser record);

    List<GeneratorUser> selectByExample(GeneratorUserExample example);

    int updateByExampleSelective(@Param("record") GeneratorUser record, @Param("example") GeneratorUserExample example);

    int updateByExample(@Param("record") GeneratorUser record, @Param("example") GeneratorUserExample example);
}