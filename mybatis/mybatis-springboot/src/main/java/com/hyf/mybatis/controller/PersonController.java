package com.hyf.mybatis.controller;

import com.hyf.mybatis.pojo.Person;
import com.hyf.mybatis.service.IPersonService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2020/05/14
 */
@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    // 默认注入一个可全局使用的安全的SqlSession对象
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @GetMapping(value = "hello/{personId}")
    public Person helloPerson(@PathVariable("personId") Integer personId) {
        return personService.getPersonById(personId);
    }

    @GetMapping(value = "hello")
    public Person helloPerson2ByTemplate(@RequestParam("personId") Integer personId) {
        String statement = "com.hyf.mybatis.mapper.PersonMapper.getPersonById";
        return sqlSessionTemplate.selectOne(statement, personId);
    }
}
