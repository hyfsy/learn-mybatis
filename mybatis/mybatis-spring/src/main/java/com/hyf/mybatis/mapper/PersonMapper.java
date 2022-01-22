package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    Person getPersonById(Integer id);
}