package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {

    @Select("select * from person where id = #{id}")
    Person getPersonById(@Param("id") Integer id);
}