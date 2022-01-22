package com.hyf.mybatis.service;

import com.hyf.mybatis.pojo.Person;

/**
 * @author baB_hyf
 * @date 2020/05/14
 */
public interface IPersonService {

    Person getPersonById(Integer id);
}
