package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.Teacher;

/**
 * 一对一测试
 */
public interface TeacherMapper {

    Teacher selectTeacherById(Integer tid);

    Teacher selectTeacherTestCollection(Integer tid);

    Teacher selectTeacherCollectionStep(Integer tid);

}
