package com.hyf.mybatis.service.impl;

import com.hyf.mybatis.service.IPersonService;
import com.hyf.mybatis.mapper.PersonMapper;
import com.hyf.mybatis.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baB_hyf
 * @date 2020/05/14
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person getPersonById(Integer id) {
        return personMapper.getPersonById(id);
    }
}
